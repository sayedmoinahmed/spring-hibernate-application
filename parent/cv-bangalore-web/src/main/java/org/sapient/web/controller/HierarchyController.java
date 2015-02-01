/**
 * 
 */
package org.sapient.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.sapient.web.model.UserInfo;
import org.sapient.web.util.ResumeManagerPDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;

/**
 * @author pdandi
 * 
 */
@Controller
public class HierarchyController {

	private static final Log log = LogFactory.getLog(HierarchyController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("resumeManagerPDFGenerator")
	private ResumeManagerPDFGenerator resumeManagerPDFGenerator;

	@RequestMapping("/hierarchy.html")
	public String hierarchyDisplay(HttpServletRequest req,
			HttpServletResponse res, Map<String, Object> model) {

		log.info("Entering HierarchyController::hierarchyDisplay()...");
		HttpSession httpSession = req.getSession();
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		    if (userInfo != null) {
			List<PersonalInfoVO> listOfSubordinates = resumeManagementService
					.retrieveUserDetailBySupervisorId(userInfo.getOracleId());
			AccountCenterForm accountCenterForm = (AccountCenterForm) httpSession
			.getAttribute("accountCenterForm");
			accountCenterForm.setFirstName(userInfo.getFirstName());
			accountCenterForm.setLastName(userInfo.getLastName());
			model.put("accountCenterForm",accountCenterForm);
			model.put("listOfSubordinates", listOfSubordinates);
			if (listOfSubordinates.size() > 0) {
				accountCenterForm.setSize(listOfSubordinates.size());
				log.info(String.format("Retriving subOridnate Information [%s]",
						accountCenterForm));
			    return "hierarchy";
			} else {
				log.info(String.format("no subordinate found [%s]",
						accountCenterForm));
				model.put("noSubordinate","You do not have any subordiante to manage.");
				return "home";
			}
		} else {
			return "invalidSession";
		}
	}

	@RequestMapping("/resumeOfSubordinate.html")
	public String printResumeDetails(@RequestParam("loginId") String loginId,
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

		log.info("inside HierarchyController::printResumeDetails" + loginId);

		UserInfoVO userInfoVO = resumeManagementService
				.retrieveUserInfoByLoginName(loginId);
		ByteArrayOutputStream baos = resumeManagerPDFGenerator
				.generatePDF(userInfoVO);
		response.getOutputStream().write(baos.toByteArray());

		return null;
	}
}
