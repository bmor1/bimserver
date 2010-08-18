package org.bimserver.database.berkeley;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.BimTransaction;
import org.bimserver.database.ColumnDatabase;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.SearchingRecordIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DeadlockException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;

public class BerkeleyColumnDatabase implements ColumnDatabase {

	private Environment environment;
	private int writes;
	private int reads;
	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleyColumnDatabase.class);
	private final DatabaseConfig dbConfig;
	private final Map<String, Database> tables = new HashMap<String, Database>();
	private boolean isNew;
	private boolean transactional = true;
	private TransactionConfig transactionConfig;
	private CursorConfig cursorConfig;

	public BerkeleyColumnDatabase(File dataDir) throws DatabaseInitException {
		if (dataDir.isDirectory()) {
			if (dataDir.listFiles().length > 0) {
				LOGGER.info("Non-empty database directory found \"" + dataDir.getAbsolutePath() + "\"");
				isNew = false;
			} else {
				LOGGER.info("Empty database directory found \"" + dataDir.getAbsolutePath() + "\"");
				isNew = true;
			}
		} else {
			isNew = true;
			LOGGER.info("No database directory found, creating \"" + dataDir.getAbsolutePath() + "\"");
			if (dataDir.mkdir()) {
				LOGGER.info("Succesfully created database dir \"" + dataDir.getAbsolutePath() + "\"");
			} else {
				LOGGER.error("Error creating database dir \"" + dataDir.getAbsolutePath() + "\"");
			}
		}
		long s = System.nanoTime();
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setCachePercent(25);
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(transactional);
		envConfig.setTxnTimeout(500000);
		envConfig.setLockTimeout(500000);
		dbConfig = new DatabaseConfig();
		try {
			environment = new Environment(dataDir, envConfig);
		} catch (EnvironmentLockedException e) {
			String message = "Environment locked exception. Another process is using the same database, or the current user has no write access (database location: " + dataDir.getAbsolutePath() + ")";
			LOGGER.error(message);
			LOGGER.error("", e);
			throw new DatabaseInitException(message);
		} catch (DatabaseException e) {
			String message = "A database initialisation error has occured (" + e.getMessage() + ")";
			LOGGER.error(message);
			LOGGER.error("", e);
			throw new DatabaseInitException(message);
		}
		dbConfig.setAllowCreate(true);
		dbConfig.setDeferredWrite(false);
		dbConfig.setTransactional(transactional);
		dbConfig.setSortedDuplicates(false);
		long e = System.nanoTime();

		transactionConfig = new TransactionConfig();
		transactionConfig.setReadCommitted(true);

		cursorConfig = new CursorConfig();
		cursorConfig.setReadCommitted(true);

		LOGGER.info("Berkeley Database Init done " + ((e - s) / 1000000) + " ms");
	}

	public boolean isNew() {
		return isNew;
	}

	public BimTransaction startTransaction() {
		try {
			return new BerkeleyTransaction(environment.beginTransaction(null, transactionConfig));
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Database getDatabase(String tableName, DatabaseSession databaseSession, boolean canCreate) {
		if (canCreate) {
			if (!tables.containsKey(tableName)) {
				try {
					if (transactional) {
						tables.put(tableName, environment.openDatabase(((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction(), tableName,
								dbConfig));
					} else {
						tables.put(tableName, environment.openDatabase(null, tableName, dbConfig));
					}
				} catch (DatabaseException e) {
					e.printStackTrace();
				}
			}
		}
		return tables.get(tableName);
	}

	public void close() {
		for (Database database : tables.values()) {
			try {
				database.close();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
		if (environment != null) {
			try {
				environment.close();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public byte[] get(String tableName, byte[] keyBytes, DatabaseSession databaseSession) {
		DatabaseEntry key = new DatabaseEntry(keyBytes);
		DatabaseEntry value = new DatabaseEntry();
		try {
			OperationStatus operationStatus = getDatabase(tableName, databaseSession, false).get(
					transactional ? ((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction() : null, key, value, LockMode.READ_COMMITTED);
			if (operationStatus == OperationStatus.SUCCESS) {
				increaseReads();
				return value.getData();
			}
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getTotalWrites() {
		return writes;
	}

	public void sync() {
		try {
			environment.sync();
			environment.evictMemory();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean containsTable(String tableName) {
		try {
			return environment.getDatabaseNames().contains(tableName);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createTableIfNotExists(String tableName, DatabaseSession databaseSession) {
		if (containsTable(tableName) && tables.containsKey(tableName)) {
			return false;
		}
		getDatabase(tableName, databaseSession, true);
		return true;
	}

	@Override
	public RecordIterator getRecordIterator(String tableName, DatabaseSession databaseSession) {
		Cursor cursor = null;
		try {
			cursor = getDatabase(tableName, databaseSession, false).openCursor(
					transactional ? ((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction() : null, cursorConfig);
			return new BerkeleyRecordIterator(cursor);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, DatabaseSession databaseSession)
			throws BimDeadlockException {
		Cursor cursor = null;
		try {
			cursor = getDatabase(tableName, databaseSession, false).openCursor(
					transactional ? ((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction() : null, cursorConfig);
			return new BerkeleySearchingRecordIterator(cursor, mustStartWith, startSearchingAt);
		} catch (BimDeadlockException e) {
			try {
				cursor.close();
				throw e;
			} catch (DatabaseException e1) {
				e1.printStackTrace();
			}
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public long count(String tableName) {
		try {
			return getDatabase(tableName, null, false).count();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public byte[] getFirstStartingWith(String tableName, byte[] key, DatabaseSession databaseSession) throws BimDeadlockException {
		SearchingRecordIterator recordIterator = getRecordIterator(tableName, key, key, databaseSession);
		try {
			Record record = recordIterator.next(key);
			if (record == null) {
				return null;
			}
			increaseReads();
			return record.getValue();
		} finally {
			recordIterator.close();
		}
	}

	private synchronized void increaseReads() {
		reads++;
		if (reads % 100000 == 0) {
			LOGGER.info("reads: " + reads);
		}
	}

	public void delete(String tableName, byte[] key, DatabaseSession databaseSession) throws BimDeadlockException {
		DatabaseEntry entry = new DatabaseEntry(key);
		try {
			getDatabase(tableName, databaseSession, false).delete(
					transactional ? ((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction() : null, entry);
			increaseWrites();
		} catch (DeadlockException e) {
			throw new BimDeadlockException(e);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	private synchronized void increaseWrites() {
		writes++;
		if (writes % 100000 == 0) {
			LOGGER.info("writes: " + writes);
		}
	}

	@Override
	public String getLocation() {
		try {
			return environment.getHome().getAbsolutePath();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return "unknown";
	}

	@Override
	public String getStats() {
		try {
			return environment.getStats(null).toString();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void commit(DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException {
		Transaction bdbTransaction = ((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction();
		try {
			bdbTransaction.commit();
		} catch (DeadlockException e) {
			e.printStackTrace();
			throw new BimDeadlockException(e);
		} catch (DatabaseException e) {
			throw new BimDatabaseException("", e);
		}
	}

	@Override
	public void store(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimDatabaseException, BimDeadlockException {
		DatabaseEntry data = new DatabaseEntry(value);
		DatabaseEntry dbKey = new DatabaseEntry(key);
		try {
			if (transactional) {
				getDatabase(tableName, databaseSession, false).put(((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction(), dbKey, data);
			} else {
				getDatabase(tableName, databaseSession, false).put(null, dbKey, data);
			}
			increaseWrites();
		} catch (DeadlockException e) {
			throw new BimDeadlockException(e);
		} catch (DatabaseException e) {
			throw new BimDatabaseException("", e);
		}
	}

	@Override
	public String getType() {
		return "Berkeley DB Java Edition " + JEVersion.CURRENT_VERSION.toString();
	}

	@Override
	public long getDatabaseSizeInBytes() {
		long size = 0;
		try {
			File home = environment.getHome();
			for (File file : home.listFiles()) {
				size += file.length();
			}
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return size;
	}
}