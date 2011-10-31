package org.bimserver.longaction;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.bimserver.models.store.StoreFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class LongActionManager {

	private final BiMap<Integer, LongAction<?>> actions = HashBiMap.create();

	private volatile boolean running = true;

	private int actionNumberCounter = 0;

	public synchronized void start(final LongAction<?> longAction) throws CannotBeScheduledException {
		if (running) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					longAction.execute();
				}
			});
			longAction.setId(actionNumberCounter++);
			longAction.init();
			thread.setDaemon(true);
			thread.setName(longAction.getDescription());
			actions.put(longAction.getId(), longAction);
			thread.start();
		} else {
			throw new CannotBeScheduledException();
		}
	}

	public synchronized void shutdown() {
		running = false;
	}

	public synchronized List<org.bimserver.models.store.LongAction> getActiveLongActions() {
		List<org.bimserver.models.store.LongAction> result = new ArrayList<org.bimserver.models.store.LongAction>();
		for (LongAction<?> longAction : actions.values()) {
			org.bimserver.models.store.LongAction storeLongAction = null;
//			if (longAction instanceof LongCheckinAction) {
//				LongCheckinAction longCheckinAction = (LongCheckinAction)longAction;
//				org.bimserver.models.store.LongCheckinAction storeLongCheckinAction = StoreFactory.eINSTANCE.createLongCheckinAction();
//				storeLongCheckinAction.getRevisions().addAll(longCheckinAction.getCreateCheckinAction().getCroid());
//			} else {
				storeLongAction = StoreFactory.eINSTANCE.createLongAction();
//			}
			storeLongAction.setIdentification(longAction.getDescription());
			storeLongAction.setUser(longAction.getUser());
			storeLongAction.setStart(longAction.getStart());
			storeLongAction.setUsername(longAction.getUser().getUsername());
			storeLongAction.setName(longAction.getUser().getName());
			result.add(storeLongAction);
		}
		Collections.sort(result, new Comparator<org.bimserver.models.store.LongAction>() {
			@Override
			public int compare(org.bimserver.models.store.LongAction o1, org.bimserver.models.store.LongAction o2) {
				return o1.getStart().compareTo(o2.getStart());
			}
		});
		return result;
	}

	public synchronized LongAction<?> getLongAction(int id) {
		return actions.get(id);
	}

	@SuppressWarnings("unchecked")
	public synchronized <T extends LongAction<?>> T getLongAction(Class<T> clazz, LongActionKey key) {
		for (LongAction<?> longAction : actions.values()) {
			if (clazz.isInstance(longAction)) {
				LongActionKey longActionKey = longAction.getKey();
				if (longActionKey.equals(key)) {
					return (T) longAction;
				}
			}
		}
		return null;
	}

	public synchronized void cleanup() {
		Iterator<Integer> iterator = actions.keySet().iterator();
		GregorianCalendar now = new GregorianCalendar();
		while (iterator.hasNext()) {
			int id = iterator.next();
			LongAction<?> longAction = actions.get(id);
			Date start = longAction.getStart();
			if (now.getTimeInMillis() - start.getTime() > 60 * 60 * 1000) {
				iterator.remove();
			}
		}
	}
	
	/*
	 * Untested method
	 */
	public synchronized void shutdownGracefully() {
		running = false;
		Iterator<LongAction<?>> iterator = actions.values().iterator();
		while (iterator.hasNext()) {
			LongAction<?> longAction = iterator.next();
			longAction.waitForCompletion();
		}
	}

	public synchronized void remove(Integer actionId) {
		actions.remove(actionId);
	}

	public void remove(LongAction<?> action) {
		actions.inverse().remove(action);
	}
}