package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class IndexBuffer extends SceneJsonObject {

	public IndexBuffer(int id, int fieldId) throws JSONException {
		super(id);
		JSONObject indexProperties = new JSONObject();
		put("properties", indexProperties);
		indexProperties.put("name", "blablabla");
		JSONObject custom = new JSONObject();
		put("custom", custom);
		JSONArray fields = new JSONArray();
		JSONArray binaryRange = new JSONArray();
		custom.put("fields", fields);
		custom.put("binaryRange", binaryRange);
		fields.put(fieldId);
	}
	
	public void addBinaryRange(int from, int to) throws JSONException {
		getJSONObject("custom").getJSONArray("binaryRange").put(from);
		getJSONObject("custom").getJSONArray("binaryRange").put(to);
	}
}