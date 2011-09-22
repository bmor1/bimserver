package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SRevision implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("Revision");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("id", int.class));
		sClass.addField(new SField("userId", long.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("comment", java.lang.String.class));
		sClass.addField(new SField("size", long.class));
		sClass.addField(new SField("concreteRevisions", Long.class, true));
		sClass.addField(new SField("lastConcreteRevisionId", long.class));
		sClass.addField(new SField("checkouts", Long.class, true));
		sClass.addField(new SField("projectId", long.class));
		sClass.addField(new SField("state", SCheckinState.class));
		sClass.addField(new SField("lastClashes", Long.class, true));
		sClass.addField(new SField("tag", java.lang.String.class));
		sClass.addField(new SField("lastError", java.lang.String.class));
		sClass.addField(new SField("bmi", int.class));
		sClass.addField(new SField("nrClashes", int.class));
		sClass.addField(new SField("laid", long.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("id")) {
			return getId();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("comment")) {
			return getComment();
		}
		if (sField.getName().equals("size")) {
			return getSize();
		}
		if (sField.getName().equals("concreteRevisions")) {
			return getConcreteRevisions();
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			return getLastConcreteRevisionId();
		}
		if (sField.getName().equals("checkouts")) {
			return getCheckouts();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("lastClashes")) {
			return getLastClashes();
		}
		if (sField.getName().equals("tag")) {
			return getTag();
		}
		if (sField.getName().equals("lastError")) {
			return getLastError();
		}
		if (sField.getName().equals("bmi")) {
			return getBmi();
		}
		if (sField.getName().equals("nrClashes")) {
			return getNrClashes();
		}
		if (sField.getName().equals("laid")) {
			return getLaid();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private int id;
	private long userId;
	private java.util.Date date;
	private java.lang.String comment;
	private long size;
	private List<Long> concreteRevisions = new ArrayList<Long>();
	private long lastConcreteRevisionId;
	private List<Long> checkouts = new ArrayList<Long>();
	private long projectId;
	private SCheckinState state;
	private List<Long> lastClashes = new ArrayList<Long>();
	private java.lang.String tag;
	private java.lang.String lastError;
	private int bmi;
	private int nrClashes;
	private long laid;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public java.lang.String getComment() {
		return comment;
	}

	public void setComment(java.lang.String comment) {
		this.comment = comment;
	}
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	public List<Long> getConcreteRevisions() {
		return concreteRevisions;
	}

	public void setConcreteRevisions(List<Long> concreteRevisions) {
		this.concreteRevisions = concreteRevisions;
	}
	public long getLastConcreteRevisionId() {
		return lastConcreteRevisionId;
	}

	public void setLastConcreteRevisionId(long lastConcreteRevisionId) {
		this.lastConcreteRevisionId = lastConcreteRevisionId;
	}
	
	public List<Long> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Long> checkouts) {
		this.checkouts = checkouts;
	}
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public SCheckinState getState() {
		return state;
	}

	public void setState(SCheckinState state) {
		this.state = state;
	}
	public List<Long> getLastClashes() {
		return lastClashes;
	}

	public void setLastClashes(List<Long> lastClashes) {
		this.lastClashes = lastClashes;
	}
	public java.lang.String getTag() {
		return tag;
	}

	public void setTag(java.lang.String tag) {
		this.tag = tag;
	}
	public java.lang.String getLastError() {
		return lastError;
	}

	public void setLastError(java.lang.String lastError) {
		this.lastError = lastError;
	}
	public int getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}
	public int getNrClashes() {
		return nrClashes;
	}

	public void setNrClashes(int nrClashes) {
		this.nrClashes = nrClashes;
	}
	public long getLaid() {
		return laid;
	}

	public void setLaid(long laid) {
		this.laid = laid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SRevision other = (SRevision) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}