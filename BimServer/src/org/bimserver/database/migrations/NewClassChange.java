package org.bimserver.database.migrations;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewClassChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewClassChange.class);
	private final EClass eClass;

	public NewClassChange(EClass eClass) {
		this.eClass = eClass;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) {
		LOGGER.info("Creating table: " + getEClass().getName());
		try {
			database.createTable(getEClass());
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		}
	}

	public EClass getEClass() {
		return eClass;
	}
}