package org.bimserver.ifcengine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.GuidClash;
import org.bimserver.database.store.StoreFactory;

public class IfcEngineModel {
	private final int modelId;
	private final FailSafeIfcEngine failSafeIfcEngine;

	public IfcEngineModel(FailSafeIfcEngine failSafeIfcEngine, int modelId) {
		this.failSafeIfcEngine = failSafeIfcEngine;
		this.modelId = modelId;
	}

	public SurfaceProperties initializeModelling() throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.INITIALIZE_MODELLING);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.flush();
			int noIndices = failSafeIfcEngine.readInt();
			int noVertices = failSafeIfcEngine.readInt();
			return new SurfaceProperties(modelId, noVertices, noIndices, 0.0);
		}
	}

	public void setPostProcessing(boolean postProcessing) throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.SET_POSTPROCESSING);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeBoolean(postProcessing);
			failSafeIfcEngine.flush();
		}
	}

	public Geometry finalizeModelling(SurfaceProperties surfaceProperties) throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			if (surfaceProperties.getIndicesCount() == 0 || surfaceProperties.getVerticesCount() == 0) {
				return null;
			}
			failSafeIfcEngine.writeCommand(Command.FINALIZE_MODELLING);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeInt(surfaceProperties.getIndicesCount());
			failSafeIfcEngine.writeInt(surfaceProperties.getVerticesCount());
			failSafeIfcEngine.flush();
			int[] indices = new int[surfaceProperties.getIndicesCount()];
			float[] vertices = new float[surfaceProperties.getVerticesCount() * 3];
			float[] normals = new float[surfaceProperties.getVerticesCount() * 3];
			for (int i = 0; i < indices.length; i++) {
				indices[i] = failSafeIfcEngine.readInt();
			}
			for (int i = 0; i < vertices.length; i++) {
				vertices[i] = failSafeIfcEngine.readFloat();
			}
			for (int i = 0; i < normals.length; i++) {
				normals[i] = failSafeIfcEngine.readFloat();
			}
			return new Geometry(indices, vertices, normals);
		}
	}

	public List<Instance> getInstances(String name) throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.GET_INSTANCES);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeUTF(name);
			failSafeIfcEngine.flush();
			int nrInstances = failSafeIfcEngine.readInt();
			List<Instance> instances = new ArrayList<Instance>();
			for (int i = 0; i < nrInstances; i++) {
				instances.add(new Instance(failSafeIfcEngine, modelId, failSafeIfcEngine.readInt()));
			}
			return instances;
		}
	}

	public void close() throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.CLOSE_MODEL);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.flush();
		}
	}

	public Set<EidClash> findClashesByEid(double d) throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.FIND_CLASHES_BY_EID);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeDouble(d);
			failSafeIfcEngine.flush();
			int nrClashes = failSafeIfcEngine.readInt();
			Set<EidClash> clashes = new HashSet<EidClash>();
			for (int i = 0; i < nrClashes; i++) {
				EidClash clash = StoreFactory.eINSTANCE.createEidClash();
				clashes.add(clash);
				clash.setEid1(failSafeIfcEngine.readLong());
				clash.setEid2(failSafeIfcEngine.readLong());
			}
			return clashes;
		}
	}
	
	public Set<GuidClash> findClashesByGuid(double d) throws IfcEngineException {
		synchronized (failSafeIfcEngine) {
			failSafeIfcEngine.writeCommand(Command.FIND_CLASHES_BY_GUID);
			failSafeIfcEngine.writeInt(modelId);
			failSafeIfcEngine.writeDouble(d);
			failSafeIfcEngine.flush();
			int nrClashes = failSafeIfcEngine.readInt();
			Set<GuidClash> clashes = new HashSet<GuidClash>();
			for (int i = 0; i < nrClashes; i++) {
				GuidClash clash = StoreFactory.eINSTANCE.createGuidClash();
				clashes.add(clash);
				clash.setGuid1(failSafeIfcEngine.readString());
				clash.setGuid2(failSafeIfcEngine.readString());
			}
			return clashes;
		}
	}
}