package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class VertexBuffer extends SceneJsonObject {

	public VertexBuffer(int id, int fieldId1, int fieldId2) throws JSONException {
		super(id);
		JSONObject indexProperties = new JSONObject();
		put("properties", indexProperties);
		indexProperties.put("name", "vertexbuffer");
		JSONObject custom = new JSONObject();
		put("custom", custom);
		JSONArray fields = new JSONArray();
		JSONArray binaryRange = new JSONArray();
		custom.put("fields", fields);
		custom.put("binaryRange", binaryRange);
		fields.put(fieldId1);
		fields.put(fieldId2);
		binaryRange.put(0);
	}

	public void addBinaryRange(int binaryRange) throws JSONException {
		getJSONObject("custom").getJSONArray("binaryRange").put(binaryRange);
	}
}