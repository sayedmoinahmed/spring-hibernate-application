/**
 * 
 */
package org.sapient.email;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author psiva2
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-email.xml" })
public class VelocityEmailSenderTest {

	@Autowired
	private Sender sender = null;

	@Autowired
	private SimpleMailMessage msg = null;

	@Test
	public void testSendWelcomeEmail() {
		BasicConfigurator.configure();
		assertNotNull("VelocityEmailSender is null.", sender);
		assertNotNull("SimpleMailMessage is null.", msg);

		Properties props = new Properties();
		props.put("firstName", "Prabu");
		props.put("lastName", "Varadharajalu Sivakumar");
		props.put("randomPassword", "jGsd56Da");

		msg = new SimpleMailMessage();
		msg.setTo("psivakumar2@sapient.com");
		msg.setFrom("spasha@sapient.com");
		msg.setSubject("Welcome to Resume Management System - Welcome Kit");

		sender.sendWelcomeEmail(msg, props);
	}

	@Test
	public void testMessage() {
		BasicConfigurator.configure();
		assertNotNull("VelocityEmailSender is null.", sender);
		assertNotNull("SimpleMailMessage is null.", msg);

		Properties props = new Properties();
		props.put("firstName", "Syed");
		props.put("lastName", "Pasha");
		props.put("generatedResumeLink", "http://www.sapient.com");

		msg = new SimpleMailMessage();
		msg.setTo("psivakumar2@sapient.com");
		msg.setFrom("spasha@sapient.com");
		msg.setSubject("Test Mail");

		sender.send(msg, props);
	}

}
