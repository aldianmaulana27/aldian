package com.batch200_2.controller;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch200_2.model.product;
import com.batch200_2.model.supplier;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.service.loginService;
import com.batch200_2.service.productService;
import com.batch200_2.service.supplierService;

@Controller
public class loginController {
	@Autowired
	private loginService logn;
	@RequestMapping("/login")
	public String login() {

		return "login";
	}
	
	
	@RequestMapping(value="/signin" , method=RequestMethod.POST)
	public String login(@RequestParam(value="nama", required=false) String nama,
						@RequestParam(value="password", required=false) String pass,
						Model model,HttpSession httpSession,HttpServletRequest request) {
		
		String stsreturn="test";
		String loglist=""; 
		loglist = logn.ceklogin(nama, pass);// cekLogin(nama,pass).toString();
		
		if (loglist == "" || loglist == null) {
			//pass salah
			
			stsreturn="redirect:/login";
		} else {
			//pass benar
			
			request.getSession().setAttribute("logsesUser", nama);
			
			stsreturn="redirect:/";
		}
		model.addAttribute("nama",loglist);
		return stsreturn;
	}
	
	
	//logout atau destroy
	@RequestMapping(value="/invalidate", method=RequestMethod.POST)
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
}
