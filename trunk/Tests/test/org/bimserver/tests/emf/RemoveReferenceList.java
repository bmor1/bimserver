package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class RemoveReferenceList extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			bimServerClient.getSettingsInterface().setGenerateGeometryOnCheckin(false);

			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			ClientIfcModel model = bimServerClient.newModel(newProject);
			
			IfcFurnishingElement furnishingElement = model.create(IfcFurnishingElement.class);
			furnishingElement.setName("Furnishing 1");
			
			IfcRelContainedInSpatialStructure link1 = model.create(IfcRelContainedInSpatialStructure.class);
			link1.setName("link1");
			IfcRelContainedInSpatialStructure link2 = model.create(IfcRelContainedInSpatialStructure.class);
			link2.setName("link2");
			IfcRelContainedInSpatialStructure link3 = model.create(IfcRelContainedInSpatialStructure.class);
			link3.setName("link3");

			furnishingElement.getContainedInStructure().add(link1);
			furnishingElement.getContainedInStructure().add(link2);
			furnishingElement.getContainedInStructure().add(link3);
			
			model.commit("initial");
			
			// refresh
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			
			model = bimServerClient.getModel(newProject.getOid(), newProject.getLastRevisionId(), true);
			for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
				if (ifcFurnishingElement.getContainedInStructure().size() != 3) {
					fail("Size should be 3, is " + ifcFurnishingElement.getContainedInStructure().size());
				}
				// Remove the middle one
				ifcFurnishingElement.getContainedInStructure().remove(1);
			}
			model.commit("removed middle link");
			
			// refresh
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
				if (ifcFurnishingElement.getContainedInStructure().size() != 2) {
					fail("Size should be 2");
				}
				if (!ifcFurnishingElement.getContainedInStructure().get(0).getName().equals("link1")) {
					fail("First one should be link 1");
				}
				if (!ifcFurnishingElement.getContainedInStructure().get(1).getName().equals("link3")) {
					fail("Second one should be link 3");
				}
			}
			model = bimServerClient.getModel(newProject.getOid(), newProject.getLastRevisionId(), true);
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}