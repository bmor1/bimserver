package org.bimserver.tests;

import java.io.File;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.IncrementingOidProvider;
import org.bimserver.Merger;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
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
//			File baseFolder = new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\IFCFiles");
//			IfcModel model1 = deserializer.read(new File(baseFolder, "Constructiedeel.ifc"));
//			IfcModel model2 = deserializer.read(new File(baseFolder, "Installatiedeel.ifc"));

			IfcModel model1 = deserializer.read(TestFile.EXPORT1.getFile());
			IfcModel model2 = deserializer.read(TestFile.EXPORT1.getFile());
//			IfcModel model3 = deserializer.read(TestFile.EXPORT3.getFile());

			model1.setObjectOids();
			model2.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			model1.checkDoubleOidsPlusReferences();
			model2.checkDoubleOidsPlusReferences();
			IfcModelSet ifcModelSet = new IfcModelSet(model1, model2);
			IfcModel merged = new Merger().merge(null, ifcModelSet, true);
			merged.checkDoubleOidsPlusReferences();
			IfcStepSerializer serializer = new IfcStepSerializer(null, null, "merged", merged, schema);
			serializer.writeToFile(new File("merged.ifc"));
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}