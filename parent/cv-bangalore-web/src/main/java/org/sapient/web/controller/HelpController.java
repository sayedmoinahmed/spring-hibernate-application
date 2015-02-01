/**
 * 
 */
package org.sapient.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ProfileSummaryInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.ProfileSummaryValidator;
import org.sapient.web.form.ProfileSummaryForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author komar
 * 
 */

@Controller
@RequestMapping("/help.html")
public class HelpController {
	private static Log log = LogFactory
			.getLog(ProfileSummaryInformationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(method = RequestMethod.GET)
	public String renderHelp(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		UserInfo userInfo = null;
		userInfo = (UserInfo) request.getSession().getAttribute("userInfo");

		if (userInfo != null) {
			return "helpInformation";
		} else {
			return "invalidSession";
		}
	}

}
