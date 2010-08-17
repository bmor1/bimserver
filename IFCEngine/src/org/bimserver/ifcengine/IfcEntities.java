/**
 * 
 */
package org.bimserver.ifcengine;

/**
 * @author Peter Willems
 * 
 */
public enum IfcEntities {
	WINDOW, ANNOTATION, BEAM, BUILDINGELEMENTCOMPONENT, STRUCTURALCURVEMEMBER, STRUCTURALSURFACEMEMBER, BUILDINGELEMENTPROXY, COLUMN, COVERING, CURTAINWALL, DOOR, ELEMENTASSEMBLY, FASTENER, FOOTING, MECHANICALFASTENER, MEMBER, PILE, PLATE, RAILING, RAMP, RAMPFLIGHT, ROOF, SLAB, STAIR, STAIRFLIGHT, SPACE, WALL, WALLSTANDARDCASE, AIRTERMINAL, DISTRIBUTIONELEMENT, ENERGYCONVERSIONDEVICE, FURNISHINGELEMENT, FLOWCONTROLLER, FLOWFITTING, FLOWMOVINGDEVICE, FLOWSEGMENT, FLOWSTORAGEDEVICE, FLOWTERMINAL, FLOWTREATMENTDEVICE, GRID;

	@Override
	public String toString() {
		return "IFC" + name();
	}

}
