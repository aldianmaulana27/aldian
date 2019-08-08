package com.batch200_2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class dasarController {

	@RequestMapping("/")
	public String awal(HttpSession session,Model model) {

		String stsreturn = "";
	
		@SuppressWarnings("unchecked")
		Object logses = session.getAttribute("logsesUser");

		if (logses == null) {
			logses = new String();
		}
		String lg1 = logses.toString();

		// penahan status login
		if (lg1 != null && !lg1.isEmpty()) {

			model.addAttribute("user", lg1);
			stsreturn = "awal";
		} else {
			stsreturn = "redirect:/login";
		}

		return stsreturn;
	}
	

}