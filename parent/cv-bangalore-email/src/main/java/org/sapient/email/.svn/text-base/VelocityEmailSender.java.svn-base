/*
 * Copyright 2007-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sapient.email;

import java.io.File;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Sends an e-mail message.
 * 
 * @author David Winterfeldt
 */
@Component
public class VelocityEmailSender implements Sender {

	private static final Logger logger = LoggerFactory
			.getLogger(VelocityEmailSender.class);

	private final VelocityEngine velocityEngine;
	private final JavaMailSender mailSender;

	/**
	 * Constructor
	 */
	@Autowired
	public VelocityEmailSender(VelocityEngine velocityEngine,
			JavaMailSender mailSender) {
		this.velocityEngine = velocityEngine;
		this.mailSender = mailSender;
	}

	/**
	 * Sends e-mail using Velocity template for the body and the properties
	 * passed in as Velocity variables.
	 * 
	 * @param msg
	 *            The e-mail message to be sent, except for the body.
	 * @param hTemplateVariables
	 *            Variables to use when processing the template.
	 */
	public void send(final SimpleMailMessage msg,
			final Map<Object, Object> hTemplateVariables) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(msg.getTo());
				message.setFrom(msg.getFrom());
				message.setSubject(msg.getSubject());

				String body = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "emailBody.vm", hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", msg.getTo());
	}

	/**
	 * Sends e-mail using Velocity template for the body and the properties
	 * passed in as Velocity variables.
	 * 
	 * @param msg
	 *            The e-mail message to be sent, except for the body.
	 * @param hTemplateVariables
	 *            Variables to use when processing the template.
	 */
	public void sendWithAttachement(final SimpleMailMessage msg,
			final Map<Object, Object> hTemplateVariables) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true);
				message.setTo(msg.getTo());
				message.setFrom(msg.getFrom());
				message.setSubject(msg.getSubject());

				FileSystemResource file1 = new FileSystemResource(new File(
						"/home/rms/Desktop/personalData.csv"));
				message.addAttachment("attachedfile.csv", file1);

				String body = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "emailBody.vm", hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", msg.getTo());
	}

	@Override
	public void notifyPasswordChange(final SimpleMailMessage msg,
			final Map<Object, Object> hTemplateVariables) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(msg.getTo());
				message.setFrom(msg.getFrom());
				message.setSubject(msg.getSubject());

				String body = VelocityEngineUtils
						.mergeTemplateIntoString(velocityEngine,
								"notifyPassword.vm", hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", msg.getTo());

	}

	@Override
	public void sendBatchPassword(final SimpleMailMessage msg,
			final Map<Object, Object> hTemplateVariables) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(msg.getTo());
				message.setFrom(msg.getFrom());
				message.setSubject(msg.getSubject());

				String body = VelocityEngineUtils
						.mergeTemplateIntoString(velocityEngine,
								"notifyPassword.vm", hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", msg.getTo());

	}

	@Override
	public void sendWelcomeEmail(final SimpleMailMessage msg,
			final Map<Object, Object> hTemplateVariables) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true);
				message.setTo(msg.getTo());
				message.setFrom(msg.getFrom());
				message.setSubject(msg.getSubject());

				ClassPathResource attachment = new ClassPathResource(
						"UserManual.doc");
				message.addAttachment("UserManual.doc", attachment);

				String body = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "welcomeMail.vm", hTemplateVariables);

				logger.info("body={}", body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		logger.info("Sent e-mail to '{}'.", msg.getTo());

	}
}