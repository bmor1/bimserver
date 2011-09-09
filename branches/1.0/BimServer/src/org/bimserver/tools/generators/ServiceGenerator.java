package org.bimserver.tools.generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.generators.DataObjectGenerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class ServiceGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceGenerator.class);
	private File sourceFolder = new File("../Shared/src");
	private File packageFolder = new File(sourceFolder, "org" + File.separator + "bimserver" + File.separator + "interfaces" + File.separator + "objects");

	public static void main(String[] args) {
		Set<EPackage> ePackages = new HashSet<EPackage>();
		ePackages.add(StorePackage.eINSTANCE);
		ePackages.add(LogPackage.eINSTANCE);
		new ServiceGenerator().generate(ePackages);
	}

	private void generate(Set<EPackage> ePackages) {
		try {
			FileUtils.forceMkdir(packageFolder);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		DataObjectGenerator dataObjectGenerator = new DataObjectGenerator();
		for (EPackage ePackage : ePackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				String generated = dataObjectGenerator.generate(eClassifier);
				File file = new File(packageFolder, "S" + eClassifier.getName() + ".java");
				try {
					OutputStream fileOutputStream = new FileOutputStream(file);
					fileOutputStream.write(generated.getBytes(Charsets.UTF_8));
					fileOutputStream.close();
				} catch (FileNotFoundException e) {
					LOGGER.error("", e);
				} catch (UnsupportedEncodingException e) {
					LOGGER.error("", e);
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
}