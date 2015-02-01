package org.sapient.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.PersonalInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.web.form.PersonalInformationForm;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonalInformationController {

	private static Log log = LogFactory
			.getLog(PersonalInformationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(value = "/personalInformation.html", method = RequestMethod.GET)
	public String renderPersonalInformation(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		log.info("Entering PersonalInformationController::renderPersonalInformation()...");
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		PersonalInformationForm personalInformationForm = new PersonalInformationForm();
		if (userInfo != null) {
			UserInfoVO result = resumeManagementService
					.retrieveUserInfoByLoginName(userInfo.getUserName());

			PersonalInfoVO personalInfoVO = result.getPersonalDetails();
			if (personalInfoVO != null) {
				personalInformationForm = new PersonalInformationForm();
				personalInformationForm.setId(personalInfoVO.getId());
				personalInformationForm.setOracleId(personalInfoVO
						.getOracleId());
				personalInformationForm.setLoginId(personalInfoVO.getLoginId());
				personalInformationForm.setFirstName(personalInfoVO
						.getFirstName());
				personalInformationForm.setMiddleName(personalInfoVO
						.getMiddleName());
				personalInformationForm.setPersonType(personalInfoVO
						.getPersonType());
				personalInformationForm.setLastName(personalInfoVO
						.getLastName());
				personalInformationForm.setFatherName(personalInfoVO
						.getFatherName());
				personalInformationForm.setMiddleName(personalInfoVO
						.getMiddleName());
				personalInformationForm
						.setDateOfBirth(new GregorianCalendarFields(
								personalInfoVO.getDateOfBirth()));
				personalInformationForm
						.setDateOfJoining(new GregorianCalendarFields(
								personalInfoVO.getDateOfJoining()));
				personalInformationForm.setDesignation(personalInfoVO
						.getDesignation());

				log.info(String
						.format("Rendering the Personal Information with the following details [%s]",
								personalInformationForm));
			} else {
				log.info("No Personal Information Retrieved...");
			}
		} else {
			log.info("Logged In user information is no longer available on the session...");
			return "invalidSession";
		}
		model.put("personalInformationForm", personalInformationForm);
		return "personalInformation";
	}

	@RequestMapping(value = "/submitPersonalInformation.html", method = RequestMethod.POST)
	public String submitPersonalInformation(
			@Valid PersonalInformationForm personalInformationForm,
			BindingResult result, Map<String, Object> model) {
		log.info("Entering PersonalInformationController::submitPersonalInformation()...");
		return "redirect:/action/educationSummary.html";
	}

}
