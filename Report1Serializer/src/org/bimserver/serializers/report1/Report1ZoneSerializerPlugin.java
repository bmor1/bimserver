package org.bimserver.serializers.report1;

import java.net.URL;

import org.bimserver.ifc.xsltserializer.XsltParameter;
import org.bimserver.ifc.xsltserializer.XsltSerializer;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class Report1ZoneSerializerPlugin implements SerializerPlugin {

	private boolean initialized;
	private URL url;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		url = pluginManager.getPluginContext(this).getResourceAsUrl("_Report1.xhtml.xsl");
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Report1Zone";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public EmfSerializer createSerializer() {
		XsltSerializer xsltSerializer = new XsltSerializer();
		xsltSerializer.setXsltUrl(url);
		xsltSerializer.addParameter(new XsltParameter("topic", "zone"));
		return xsltSerializer;
	}

	@Override
	public String getDefaultSerializerName() {
		return "Report1Zone";
	}

	@Override
	public String getDefaultExtension() {
		return "xhtml";
	}

	@Override
	public String getDefaultContentType() {
		return "text/html";
	}
}