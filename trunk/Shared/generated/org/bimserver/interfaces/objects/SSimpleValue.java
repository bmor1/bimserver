package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SSimpleValue extends SDataValue implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("SimpleValue");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("fieldName", java.lang.String.class));
		sClass.addField(new SField("stringValue", java.lang.String.class));
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
	private java.lang.String stringValue;

	public java.lang.String getStringValue() {
		return stringValue;
	}

	public void setStringValue(java.lang.String stringValue) {
		this.stringValue = stringValue;
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
		SSimpleValue other = (SSimpleValue) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}