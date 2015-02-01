/**
 * 
 */
package org.sapient.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.jfree.util.Log;
import org.sapient.email.Sender;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.web.form.PrintResumeForm;
import org.sapient.web.form.SearchEmployeeForm;
import org.sapient.web.form.util.DESedeEncryption;
import org.sapient.web.model.UserInfo;
import org.sapient.web.util.ResumeManagerPDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.DocumentException;

/**
 * @author psiva2
 * 
 */
@Controller("printResumeController")
@RequestMapping("/printResume")
public class PrintResumeController {

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	private Sender mailSender;

	@Autowired
	@Qualifier("resumeManagerPDFGenerator")
	private ResumeManagerPDFGenerator resumeManagerPDFGenerator;

	@Value(value = "${mail.recipient}")
	private String recipient;

	@Value(value = "${mail.subject}")
	private String mailSubject;
	

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient
	 *            the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}

	/**
	 * @param mailSubject
	 *            the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String renderPrintResumeDetails(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws DocumentException, IOException {
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		PrintResumeForm printResumeForm = new PrintResumeForm();

		model.put("printResumeForm", printResumeForm);

		return "printResumeDetails";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String printResumeDetails(@Valid PrintResumeForm printResumeForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws DocumentException, IOException {
		UserInfo userInfo = null;
		userInfo = (UserInfo) request.getSession().getAttribute("userInfo");

		if (userInfo != null) {
			Log.info("inside controller ::" + userInfo.getUserName());
			UserInfoVO userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(userInfo.getUserName());
			Properties props = new Properties();
			props.put("firstName", userInfoVO.getPersonalDetails()
					.getFirstName());
			props.put("lastName", userInfoVO.getPersonalDetails().getLastName());
			try {
				DESedeEncryption dESedeEncryption = new DESedeEncryption();
				String encryptedLoginName = dESedeEncryption.encrypt(userInfo
						.getUserName());

				String quickLink = "http://10.209.6.150:8080/CVBangaloreWeb/action/generateResume?ref="
						+ encryptedLoginName;
				props.put("generatedResumeLink", quickLink);
			} catch (Exception e) {
				System.out.println("inside catch");
			}
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(getRecipient());
			// changed to retrieve from users emailid
			msg.setFrom(userInfoVO.getPersonalDetails().getEmailAddress());

			msg.setSubject(getMailSubject());

			if (userInfoVO.getEducationDetails().size() != 0
					&& userInfoVO.getEmploymentDetails().size() != 0
					&& userInfoVO.getProfileSummaryDetails().size() != 0) {
				ByteArrayOutputStream baos = resumeManagerPDFGenerator
						.generatePDF(userInfoVO);
				response.getOutputStream().write(baos.toByteArray());
			}
			else
			{
				return "incompletePDF";
			}

			if (printResumeForm.isMailResume() == true) {
				mailSender.send(msg, props);
			}

		} else {
			return "invalidSession";
		}
		return "invalidSession";
	}
}
