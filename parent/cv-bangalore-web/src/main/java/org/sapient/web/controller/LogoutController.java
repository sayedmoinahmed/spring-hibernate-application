package org.sapient.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout.html")
public class LogoutController {

	private static final Log log = LogFactory.getLog(LogoutController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String renderLogOut(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Entering LogoutController::renderLogOut()...");
		if (request.getSession() != null) {
			log.info("Invalidating the Session....");
			request.getSession().invalidate();
		}
		return "logout";
	}
}
