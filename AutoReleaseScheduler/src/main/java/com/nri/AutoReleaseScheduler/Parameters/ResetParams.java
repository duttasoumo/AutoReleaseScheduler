package com.nri.AutoReleaseScheduler.Parameters;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ResetParams {

	public static void reset() throws ConfigurationException, IOException {
		PropertiesConfiguration conf = new PropertiesConfiguration(FetchParams.getPropertyFile());
		conf.setProperty("release.immediate", "n");
		conf.setProperty("release.ready", "n");
		conf.setProperty("release.date", "");
		conf.save();
	}

}
