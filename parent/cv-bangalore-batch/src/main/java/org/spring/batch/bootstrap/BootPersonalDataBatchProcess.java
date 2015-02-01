package org.spring.batch.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class BootPersonalDataBatchProcess {

	private static final Log LOG = LogFactory
			.getLog(BootPersonalDataBatchProcess.class);

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		BasicConfigurator.configure();
		try {
			new CommandLineJobRunner().main(new String[] { "jobContext.xml",
					"personalDataJob" });
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info(String.format(
				"The batch execution was completed in [%s] milliseconds.",
				(System.currentTimeMillis() - start)));
	}
}
