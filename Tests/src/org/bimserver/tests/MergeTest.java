package org.bimserver.tests;

import java.io.File;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.RevisionMerger;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.file.writer.IfcStepSerializer;

public class MergeTest {
	public static void main(String[] args) {
		new MergeTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer(schema);
		try {
			IfcModel model1 = deserializer.read(TestFile.EXPORT1.getFile());
			IfcModel model2 = deserializer.read(TestFile.EXPORT3.getFile());
			model1.setObjectOids();
			model2.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			IfcModel merged = new RevisionMerger().merge(model1, model2);
			IfcStepSerializer serializer = new IfcStepSerializer(null, null, "merged", merged, schema);
			serializer.writeToFile(new File("merged.ifc"));
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}