package org.sapient.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.web.form.util.DESedeEncryption;
import org.sapient.web.model.UserInfo;
import org.sapient.web.util.ResumeManagerPDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;

@Controller("generateResumeController")
@RequestMapping("/generateResume")
public class GenerateResumeController {

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("resumeManagerPDFGenerator")
	private ResumeManagerPDFGenerator resumeManagerPDFGenerator;

	@RequestMapping(method = RequestMethod.GET)
	public String renderPrintResumeDetails(@RequestParam("ref") String ref,
			HttpServletRequest request, HttpServletResponse response)
			throws DocumentException, IOException {

		String decryptedLoginId = "defaultname";
		try {
			DESedeEncryption dESedeEncryption = new DESedeEncryption();
			decryptedLoginId = dESedeEncryption.decrypt(ref);

		} catch (Exception e) {
			System.out.println("inside catch");
		} finally {
			System.out.println("inside finally");
		}

		if (!(decryptedLoginId.equalsIgnoreCase("defaultname"))) {
			UserInfoVO userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(decryptedLoginId);
			ByteArrayOutputStream baos = resumeManagerPDFGenerator
					.generatePDF(userInfoVO);
			response.getOutputStream().write(baos.toByteArray());
		} else {
			return "invalidURLMsg";
		}
		return null;
	}
}
