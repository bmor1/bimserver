package org.bimserver.tests;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.utils.CollectionUtils;

public class O3dTest {
	public static void main(String[] args) {
		new O3dTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();

		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		new FileFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), resourceFetcher);
		
		TestFile testFile = TestFile.MERGE_TEST_SOURCE_FILE;
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer(schema);
		try {
			fastIfcFileReader.read(testFile.getFile());
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		O3dJsonSerializer o3dJsonSerializer = new O3dJsonSerializer(fastIfcFileReader.getModel(), fieldIgnoreMap, IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
//		try {
//			System.out.print(new String(o3dJsonSerializer.writeJSON(null, null)));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
	}
}