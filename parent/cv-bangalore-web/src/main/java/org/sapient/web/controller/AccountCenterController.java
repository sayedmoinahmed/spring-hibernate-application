package org.sapient.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.PersonalInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.web.form.AccountCenterForm;
import org.sapient.web.form.CompletionTipsForm;
import org.sapient.web.form.util.DESedeEncryption;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "accountCenterForm", "isAdmin" })
public class AccountCenterController {
	private static final Log log = LogFactory
			.getLog(AccountCenterController.class);
	UserInfoVO userInfoVO = null;

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping("/home.html")
	public String renderAccountCenter(HttpServletRequest req,
			HttpServletResponse res, Map<String, Object> model) {
		log.info("Entering HomeController::renderHome()...");
		Boolean isAdmin = false;
		HttpSession httpSession = req.getSession();
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		AccountCenterForm accountCenterForm = (AccountCenterForm) httpSession
				.getAttribute("accountCenterForm");
		if (userInfo != null) {
			userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(userInfo.getUserName());
			String resumeStatus = userInfoVO.getResumeStatus();
			accountCenterForm = new AccountCenterForm();
			accountCenterForm.setFirstName(userInfo.getFirstName());
			accountCenterForm.setMiddleName(userInfoVO.getPersonalDetails()
					.getMiddleName());

			try {
				DESedeEncryption dESedeEncryption = new DESedeEncryption();
				String encryptedLoginName = dESedeEncryption.encrypt(userInfo
						.getUserName());
				accountCenterForm.setEncryptedLoginName(encryptedLoginName);
			} catch (Exception e) {
				System.out.println("inside catch");
			}
			accountCenterForm.setLoginName(userInfo.getUserName());
			accountCenterForm.setPersonType(userInfoVO.getPersonalDetails()
					.getPersonType());
			accountCenterForm.setDateOfJoining(userInfoVO.getPersonalDetails()
					.getDateOfJoining());
			accountCenterForm.setDesignation(userInfoVO.getPersonalDetails()
					.getDesignation());
			String designation = accountCenterForm.getDesignation();
			if ((designation.toLowerCase().contains("people strategy") || (designation
					.toLowerCase().contains("staffing")))) {
				log.info(String
						.format("designation is matched to people strategy or staffing: [%s]",
								designation));
				accountCenterForm.setIsAdmin(true);
			} else {
				log.info(String
						.format("designation is not matched to people strategy or staffing: [%s]",
								designation));
				accountCenterForm.setIsAdmin(false);
			}
			isAdmin = accountCenterForm.getIsAdmin();
			accountCenterForm.setLastName(userInfo.getLastName());
			accountCenterForm.setOracleId(userInfo.getOracleId());
			accountCenterForm.setResumeStatus(userInfoVO.getResumeStatus());
			String superVisorName = resumeManagementService
					.retriveSupervisorNameByID(userInfo.getOracleId());
			accountCenterForm.setSupervisorName(superVisorName);
			Calendar calendar = Calendar.getInstance();
			Date now = calendar.getTime();
			accountCenterForm.setLoginTimeStamp(now.toString());
			List<String> completionTips = userInfoVO.getCompletionTips();
			List<PersonalInfoVO> listOfSubordinates = resumeManagementService
					.retrieveUserDetailBySupervisorId(userInfo.getOracleId());
			if (listOfSubordinates.size() > 0) {
				model.put("haveSubordinate","Click here to see subordinate's Resume");
				accountCenterForm.setIsSubordinate(true);
			}else{
				model.put("haveSubordinate"," ");
				accountCenterForm.setIsSubordinate(false);
			}
		} else {
			return "invalidSession";
		}
		model.put("isAdmin", isAdmin);
		model.put("accountCenterForm", accountCenterForm);
		return "home";
	}

	@RequestMapping("/resumeStatus.html")
	public String renderResumeStatus(HttpServletRequest req,
			HttpServletResponse res, Map<String, Object> model) {
		UserInfo userInfo = (UserInfo) req.getSession()
				.getAttribute("userInfo");

		if (userInfo != null) {
			UserInfoVO userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(userInfo.getUserName());
			List<String> completionTips = userInfoVO.getCompletionTips();
			CompletionTipsForm completionTipsForm = new CompletionTipsForm();
			for (String completionTip : completionTips) {
				if (completionTip.contains("Education")) {
					completionTipsForm.setEducationDetails("Incomplete");
				} else if (completionTip.contains("Employment")) {
					completionTipsForm.setEmploymentDetails("Incomplete");
				} else if (completionTip.contains("Project")) {
					completionTipsForm.setProjectDetails("Incomplete");
				} else if (completionTip.contains("Skill")) {
					completionTipsForm.setSkillDetails("Incomplete");
				} else if (completionTip.contains("Profile")) {
					completionTipsForm.setProfileSummaryDetails("Incomplete");
				}
			}

			model.put("completionTipsForm", completionTipsForm);
		} else {
			return "invalidSession";
		}

		return "resumeStatus";
	}
}
