package com.batch200_2.controller;

import java.sql.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.service.productService;
import com.batch200_2.service.religionService;
import com.batch200_2.service.supplierService;

@Controller
public class religionController {
	@Autowired
	private religionService rlg;

	@RequestMapping("/religion")
	public String religion() {
		return "religion/religion";
	}

	@RequestMapping("/listrlg")
	public String listrlg(Model model) {
		// List<religion> listReligion = rlg.listAll();
		String nama = "";
		List<religion> listReligion = rlg.selectisDelete(nama);
		model.addAttribute("listReligion", listReligion);
	
		return "/religion/religionlist";
	}
	

	@ResponseBody
	@RequestMapping(value = "/searchrlg/{id}")
	public String listrlgsearch(@PathVariable(name = "id") long id, Model model) {
		// List<religion> listReligion = rlg.listAll();
		String searchsts="";
		Long l= new Long(id);
			rlg.getAll(l);
			return searchsts;
	}
	
	
	@RequestMapping("/religionnew")
	public String religionnew(Model model) {
		religion religion = new religion();
		model.addAttribute("religion2", religion);
		List<religion> listReligion = rlg.listAll();
		model.addAttribute("listReligion", listReligion);
		return "/religion/religionnew";
	}

	@ResponseBody
	@RequestMapping(value = "/saverlg")
	public void savesrlg(@ModelAttribute("religion2") religion religion) {

		religion.setCreatedBy((long) 2);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());

		religion.setCreatedOn(date);
		religion.setDeletedBy(null);
		religion.setDeletedOn(null);
		religion.setModifiedBy(null);
		religion.setModifiedOn(null);
		religion.setIsDelete(false);
		String savests = "";
		rlg.save(religion);
		
	}
	@ResponseBody
	@RequestMapping(value = "/saveeditrlg")
	public String saveseditrlg(@ModelAttribute("religion2") religion religion) {

		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());

		
		religion.setDeletedBy(null);
		religion.setDeletedOn(null);
		religion.setModifiedBy((long) 2);
		religion.setModifiedOn(date);
		religion.setIsDelete(false);
		String savests = "";
		rlg.save(religion);
		return savests;
	}

	@RequestMapping("/rlgedit/{id}")
	public String religionedit(@PathVariable(name = "id") long id, Model model) {
		religion religion = rlg.get(id);
		model.addAttribute("religion", religion);
		return "religion/religionedit";
	}

	@RequestMapping("/rlgeditdel/{id}")
	public String religiondelete(@PathVariable(name = "id") long id, Model model) {
		religion religion = rlg.get(id);
		model.addAttribute("religion", religion);
		return "religion/religiondelete";
	}

	@ResponseBody
	@RequestMapping(value = "/deleterlg/{id}")
	public String deleterlg(@ModelAttribute("religion2") religion religion, @PathVariable(name = "id") long id, Model model) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());

		
		religion.setDeletedBy((long) 2);
		religion.setDeletedOn(date);
		religion.setIsDelete(false);
		rlg.save(religion);
		String deletests = "";
		Long l = new Long(id);
		rlg.deletflag(id);
		return deletests;
	}
	
	
	
}