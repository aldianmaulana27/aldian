package com.batch200_2.controller;

import java.util.List;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch200_2.model.supplier;
import com.batch200_2.service.productService;
import com.batch200_2.service.supplierService;

@Controller
public class supplierController {
	@Autowired
	private supplierService splr;
	@Autowired
	private productService prod;
	
	@RequestMapping("/supplier")
	public String awal(HttpSession session, Model model) {

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
			stsreturn = "supplier/supplier";
		} else {
			stsreturn = "redirect:/login";
		}

		return stsreturn;
	}

	@RequestMapping("/listsply")
	public String listsply(Model model) {
		List<supplier> listSupplier = splr.listAll();
		model.addAttribute("listSupplier", listSupplier);
		return "/supplier/supplierlist";

	}

	@RequestMapping("/suppliernew")
	public String suppliernew() {

		return "/supplier/suppliernew";

	}

	@ResponseBody
	@RequestMapping(value = "/savesply")
	public String savesply(@ModelAttribute("supplier2") supplier supplier, Model model) {
		String savests="0";
		String cekEmail=splr.cekIdEmailDiSply(supplier.getEmail());
		System.out.println(cekEmail);
		if (cekEmail=="" || cekEmail==null) {
			splr.save(supplier);
			savests = "1";
		}else {
			savests = "0";
		}

		return savests;
	}
		

	@RequestMapping("/splyedit/{id}")
	public String supplieredit(@PathVariable(name = "id") long id, Model model) {
		supplier supplier = splr.get(id);
		model.addAttribute("supplier", supplier);
		return "supplier/supplieredit";
	}

	@RequestMapping("/splyeditdel/{id}")
	public String supplierdelete(@PathVariable(name = "id") long id, Model model) {
		supplier supplier = splr.get(id);
		model.addAttribute("supplier", supplier);
		return "supplier/supplierdelete";
	}

	@ResponseBody
	@RequestMapping("/deletesply/{id}")
	public String deleteSply(@PathVariable(name = "id") int id) {
		String delsts="0";
		String cekID=prod.cekIdSplyDiProd(id);
		System.out.println(cekID);
		if (cekID=="" || cekID==null) {
			splr.delete(id);
			delsts = "1";
		}else {
			delsts = "0";
		}
		//splr.delete(id);
		return delsts;
	}
	
}
