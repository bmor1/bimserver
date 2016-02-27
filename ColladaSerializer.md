# Configure #
When you login as administrator in your own BIMserver you will find a settings page.
Under the settings page there is a 'collada/kmz'-tab.
This is the place where you can download and upload an XML configuration file for the collada export.

In the XML file (open it with wordpad or some texteditor) you can add and delete ifc object types that will be exported in collada.

The objecttypes we support (that you can put in the xml) are ifcRoof, ifcSlab, ifcWindow, ifcDoor, ifcWall, ifcStair, ifcStairFlight, ifcFlowSegment, ifcFurnishingElement, ifcPlate, ifcMember, ifcWallStandardCase, ifcCurtainWall, ifcRailing, ifcColumn and ifcBuildingElementProxy.

Since the 1.1 release the export of transparency (and colors) is included in the export.

# Source #
When you look at the sourcecode you should look specificly at is ColladaSerializer.java (preview on: http://code.google.com/p/bimserver/source/browse/trunk/Collada/src/org/bimserver/collada/ColladaSerializer.java)