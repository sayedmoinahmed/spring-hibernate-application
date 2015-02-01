package org.sapient.batch;

import org.apache.log4j.BasicConfigurator;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class PersonalDataClient {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		BasicConfigurator.configure();
		try {
			new CommandLineJobRunner().main(new String[] { "jobContext.xml",
					"personalDataJob" });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
