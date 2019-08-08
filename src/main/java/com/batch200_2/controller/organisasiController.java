package com.batch200_2.controller;

import java.sql.Date;
import java.util.Calendar;
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
import com.batch200_2.model.organisasi;
import com.batch200_2.service.organisasiService;
import com.batch200_2.service.productService;
import com.batch200_2.service.religionService;
import com.batch200_2.service.supplierService;

@Controller
public class organisasiController {
	@Autowired
	private organisasiService org;


	@RequestMapping("/organisasi")
	public String organisasi() {
		return "organisasi/organisasi";
	}
	
	@RequestMapping("/listorg")
	public String listorg(Model model) {
	//	List<religion> listReligion = rlg.listAll();
		String nama="";
		
		List<organisasi> listOrganisasi = org.selectisDelete(nama);
		model.addAttribute("listOrganisasi", listOrganisasi);
		 
		List<organisasi> listOrganisasi1 = org.selectBiodata((long) 2);
		model.addAttribute("listOrganisasi1", listOrganisasi1);

		return "/organisasi/organisasilist";
	}

	@RequestMapping("/organisasinew")
	public String organisasinew(Model model) {
		organisasi organisasi = new organisasi();
		model.addAttribute("organisasi2", organisasi);
		List<organisasi> listOrganisasi= org.listAll();
		model.addAttribute("listOrganisasi", listOrganisasi);
		
		int yearnow = Calendar.getInstance().get(Calendar.YEAR);
		TreeMap<String, String> yearlist = new TreeMap<String, String>();
		Date date = new Date(System.currentTimeMillis());
		for (int i = 2000; i <= yearnow; i++) {
			yearlist.put(Integer.toString(i), Integer.toString(i));
		}
		model.addAttribute("yearItem", yearlist);
		
		return "/organisasi/organisasinew";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveorg")
	public String savesorg(@ModelAttribute("organisasi2") organisasi organisasi) {
			
		organisasi.setCreatedBy((long) 1);
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			organisasi.setCreatedOn(date);
			organisasi.setDeletedBy(null);
			organisasi.setDeletedOn(null);
			organisasi.setModifiedBy(null);
			organisasi.setModifiedOn(null);
			organisasi.setIsDelete(false);
			organisasi.setBiodataId((long) 1);
			String savests = "";
			org.save(organisasi);
			return savests;
	}
		
	@ResponseBody
	@RequestMapping(value = "/saveeditorg")
	public String saveseditorg(@ModelAttribute("organisasi2") organisasi organisasi) {
			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			organisasi.setDeletedBy(null);
			organisasi.setDeletedOn(null);
			organisasi.setModifiedBy(null);
			organisasi.setModifiedOn(date);
			organisasi.setIsDelete(false);
			organisasi.setBiodataId((long) 1);
			String savests = "";
			org.save(organisasi);
			return savests;
	}


	@RequestMapping("/orgedit/{id}")
	public String organisasiedit(@PathVariable(name = "id") long id, Model model) {
		organisasi organisasi = org.get(id);
		model.addAttribute("organisasi", organisasi);
	
		int yearnow = Calendar.getInstance().get(Calendar.YEAR);
		TreeMap<String, String> yearlist = new TreeMap<String, String>();
		Date date = new Date(System.currentTimeMillis());
		for (int i = 2000; i <= yearnow; i++) {
			yearlist.put(Integer.toString(i), Integer.toString(i));
		}
		model.addAttribute("yearItem", yearlist);

		return "organisasi/organisasiedit";
	}

	@RequestMapping("/orgeditdel/{id}")
	public String organisasidelete(@PathVariable(name = "id") long id, Model model) {
		organisasi organisasi = org.get(id);
		model.addAttribute("organisasi", organisasi);
		return "organisasi/organisasidelete";
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/deleteorg/{id}")
	public String deleteorg(@ModelAttribute("organisasi2") organisasi organisasi, @PathVariable(name = "id") long id, Model model) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		organisasi.setDeletedBy(null);
		organisasi.setDeletedOn(date);
		organisasi.setIsDelete(false);
		organisasi.setBiodataId((long) 1);
		org.save(organisasi);
		String deletests="";
		Long l= new Long(id);
			org.deletflag(l);
			return deletests;
	}
	
	
}