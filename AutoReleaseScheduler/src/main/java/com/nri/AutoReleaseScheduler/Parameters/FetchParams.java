package com.nri.AutoReleaseScheduler.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.nri.AutoReleaseScheduler.Constants;

public class FetchParams {
	static Logger log = Logger.getLogger(FetchParams.class);

	public static void fetchParameters(Parameters params) throws IOException {
		Map<String, String> paramMap = extractParams();
		Class clazz = Parameters.class;
		Class annotationClazz = InfoParameter.class;
		for (Method m : clazz.getMethods()) {
			try {
				if (m.isAnnotationPresent(annotationClazz)) {
					String key = ((InfoParameter) m.getAnnotation(annotationClazz)).key();
					m.invoke(params, paramMap.get(key));
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				log.debug("Idealy Unreachable Code",e);
			}
		}
	}

	private static Map<String, String> extractParams() throws IOException {
		Map<String, String> paramMap = new HashMap<String, String>();
		FileInputStream fileInput = new FileInputStream(getPropertyFile());
		Properties properties = new Properties();
		properties.load(fileInput);
		fileInput.close();

		Enumeration enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);
			paramMap.put(key, value);
		}
		return paramMap;
	}
	
	protected static File getPropertyFile() {
		return new File(Constants.DIR + Constants.FILE_NAME);
	}
}
