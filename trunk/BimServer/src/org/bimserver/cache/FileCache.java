package org.bimserver.cache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.SerializerException;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCheckoutResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCache {
	private File cacheDir = new File("cache");
	private static final Logger LOGGER = LoggerFactory.getLogger(FileCache.class);
	
	public void store(int pid, int rid, ResultType resultType, SCheckoutResult checkoutResult) {
		try {
			String fileName = pid + "." + rid + "." + resultType.getExtension();
			File file = new File(cacheDir, fileName);
			EmfSerializer emfSerializer = (EmfSerializer) checkoutResult.getFile().getDataSource();
			FileOutputStream out = new FileOutputStream(file);
			emfSerializer.writeToOutputStream(out);
			out.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
	}

	public SCheckoutResult get(int pid, int rid, ResultType resultType) {
		String fileName = pid + "." + rid + "." + resultType.getExtension();
		File file = new File(cacheDir, fileName);
		SCheckoutResult checkoutResult = new SCheckoutResult();
		checkoutResult.setProjectName("" + pid);
		checkoutResult.setRevisionNr(rid);
		checkoutResult.setFile(new DataHandler(new FileDataSource(file)));
		return checkoutResult;
	}

	public boolean contains(int pid, int rid, ResultType resultType) {
		String fileName = pid + "." + rid + "." + resultType.getExtension();
		File file = new File(cacheDir, fileName);
		return file.exists() && file.isFile();
	}
}