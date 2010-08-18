package org.bimserver.ifcengine;

import org.bimserver.ifcengine.IfcEngine.InstanceVisualisationProperties;

public class Instance {
	private final FailSafeIfcEngine failSafeIfcEngine;
	private final int instanceId;
	private final int modelId;
	
	public Instance(FailSafeIfcEngine failSafeIfcEngine, int modelId, int instanceId) {
		this.failSafeIfcEngine = failSafeIfcEngine;
		this.modelId = modelId;
		this.instanceId = instanceId;
	}

	public InstanceVisualisationProperties getVisualisationProperties() throws IfcEngineException {
		failSafeIfcEngine.writeCommand(Command.GET_VISUALISATION_PROPERTIES);
		failSafeIfcEngine.writeInt(modelId);
		failSafeIfcEngine.writeInt(instanceId);
		failSafeIfcEngine.flush();
		return new InstanceVisualisationProperties(failSafeIfcEngine.readInt(), failSafeIfcEngine.readInt(), failSafeIfcEngine.readInt());
	}
}