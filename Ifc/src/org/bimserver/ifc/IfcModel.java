package org.bimserver.ifc;

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

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class IfcModel {

	private BiMap<Long, IdEObject> objects;
	private Map<String, IfcRoot> guidIndexed;
	private byte[] checksum;
	private IdEObject eObject;
	private int revisionNr;
	private String authorizedUser;
	private Date date;

	public IfcModel(BiMap<Long, IdEObject> objects) {
		this.objects = objects;
	}
	
	public IfcModel() {
		this.objects = HashBiMap.create();
	}

	public IfcModel(int size) {
		this.objects = HashBiMap.create(size);
	}
	
	public long size() {
		return objects.size();
	}

	public Set<Long> keySet() {
		return objects.keySet();
	}

	public IdEObject get(Long key) {
		return objects.get(key);
	}

	public Collection<IdEObject> getValues() {
		return objects.values();
	}

	public void add(Long key, IdEObject eObject) {
		add(key, eObject, false);
	}
	
	public void add(Long key, IdEObject eObject, boolean ignoreDuplicateOids) {
		if (objects.containsKey(key)) {
			if (!ignoreDuplicateOids) {
				throw new RuntimeException("Oid already stored: " + key + " " + eObject + " (old: " + objects.get(key));
			}
		} else {
			objects.put(key, eObject);
			if (guidIndexed != null) {
				indexGuid(eObject);
			}
		}
	}
	
	public Map<Long, IdEObject> getObjects() {
		return objects;
	}

	public BiMap<Long, ? extends IdEObject> getMap() {
		return (BiMap<Long, ? extends IdEObject>) objects;
	}

	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}

	public boolean containsKey(Long key) {
		return objects.containsKey(key);
	}

	public IdEObject getMainObject() {
		return eObject;
	}

	public void setMainObject(IdEObject eObject) {
		this.eObject = eObject;
	}

	public int getSize() {
		return objects.size();
	}

	public boolean contains(IdEObject eObject) {
		return objects.inverse().containsKey(eObject);
	}

	public Long get(IdEObject eObject) {
		return objects.inverse().get(eObject);
	}

	public void indexGuids() {
		guidIndexed = new HashMap<String, IfcRoot>();
		for (IdEObject idEObject : objects.values()) {
			indexGuid(idEObject);
		}
	}

	private void indexGuid(IdEObject idEObject) {
		if (idEObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot)idEObject;
			if (ifcRoot.getGlobalId() != null) {
				guidIndexed.put(ifcRoot.getGlobalId().getWrappedValue(), ifcRoot);
			}
		}
	}

	public String getAuthorizedUser() {
		return authorizedUser;
	}

	public int getRevisionNr() {
		return revisionNr;
	}

	public boolean isValid() {
		return true;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}
	
	public void setRevisionNr(int revisionNr) {
		this.revisionNr = revisionNr;
	}

	public void dump() {
		System.out.println("Dumping IFC Model");
		for (Long key : objects.keySet()) {
			System.out.println(key + ": " + objects.get(key).eClass().getName());
		}
	}

	public void remove(IdEObject idEObject) {
		objects.remove(idEObject.getOid());
	}

	public void setOid(IdEObject mainObject, Long long1) {
		objects.forcePut(long1, mainObject);
	}

	public void fixOids(OidProvider oidProvider) {
		BiMap<Long, IdEObject> temp = HashBiMap.create();
		for (long oid : objects.keySet()) {
			IdEObject idEObject = objects.get(oid);
			idEObject.setOid(oidProvider.newOid());
			temp.put(idEObject.getOid(), idEObject);
		}
		objects = temp;
	}
	
	public void setObjectOids() {
		for (long oid : objects.keySet()) {
			objects.get(oid).setOid(oid);
		}
	}

	public long getHighestOid() {
		long max = 0;
		for (long oid : objects.keySet()) {
			if (oid > max) {
				max = oid;
			}
		}
		return max;
	}

	public IfcRoot get(String guid) {
		if (guidIndexed == null) {
			throw new RuntimeException("Not indexed on guids");
		}
		return guidIndexed.get(guid);
	}

	public boolean containsGuid(String guid) {
		if (guidIndexed == null) {
			throw new RuntimeException("Not indexed on guids");
		}
		return guidIndexed.containsKey(guid);
	}
}