package com.batch200_2.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
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
import com.batch200_2.model.educationLevelId;
import com.batch200_2.model.familyRelationId;
import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.keluarga;
import com.batch200_2.service.educationLevelIdService;
import com.batch200_2.service.familyRelationIdService;
import com.batch200_2.service.familyTreeTypeIdService;
import com.batch200_2.service.keluargaService;
import com.batch200_2.service.productService;
import com.batch200_2.service.religionService;
import com.batch200_2.service.supplierService;

@Controller
public class keluargaController {
	@Autowired
	private keluargaService klg;
	@Autowired
	private familyTreeTypeIdService type;
	@Autowired
	private familyRelationIdService relat;
	@Autowired
	private educationLevelIdService edu;

	@RequestMapping("/keluarga")
	public String keluarga() {
	return "keluarga/keluarga";
	}
	
	@RequestMapping("/listklg")
	public String listklg(Model model) {
	//	List<religion> listReligion = rlg.listAll();
		String nama="";
		List<keluarga> listKeluarga = klg.selectisDelete(nama);
		model.addAttribute("listKeluarga", listKeluarga);
		return "/keluarga/keluargalist";
	}

	@RequestMapping("/keluarganew")
	public String keluarganew(Model model) {
		keluarga keluarga = new keluarga();
		model.addAttribute("keluarga2", keluarga);
		
		List<familyTreeTypeId> listFamilyTreeTypeId = type.listAll();
		model.addAttribute("listFamilyTreeTypeId", listFamilyTreeTypeId);
		List<familyRelationId> listFamilyRelationId= relat.listAll();
		model.addAttribute("listFamilyRelationId", listFamilyRelationId);
		List<familyRelationId> listFamilyRelationId1= relat.findById((long) 1);
		model.addAttribute("listFamilyRelationId1", listFamilyRelationId1);
		List<familyRelationId> listFamilyRelationId2= relat.findById((long) 2);
		model.addAttribute("listFamilyRelationId2", listFamilyRelationId2);
		
		List<educationLevelId> listEducationLevelId= edu.listAll();
		model.addAttribute("listEducationLevelId", listEducationLevelId);
		
	
		TreeMap<Boolean, String> gender = new TreeMap<Boolean, String>();
		gender.put(true, "pria");
		gender.put(false, "wanita");
		model.addAttribute("listGender", gender);
//		List<keluarga> listKeluarga = klg.selectisDelete(nama);
//		model.addAttribute("listKeluarga", listKeluarga);
		return "/keluarga/keluarganew";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveklg")
	public String savesklg(@ModelAttribute("keluarga2") keluarga keluarga) {
			
		keluarga.setCreatedBy((long) 1);
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			keluarga.setCreatedOn(date);	
			keluarga.setDeletedBy(null);
			keluarga.setDeletedOn(null);
			keluarga.setModifiedBy(null);
			keluarga.setModifiedOn(null);
			keluarga.setIsDelete(false);
			keluarga.setBiodataId((long) 1);
			String savests = "";
			klg.save(keluarga);
			return savests;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveeditklg")
	public String saveseditklg(@ModelAttribute("keluarga2") keluarga keluarga) {
			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			keluarga.setDeletedBy(null);
			keluarga.setDeletedOn(null);
			keluarga.setModifiedBy(null);
			keluarga.setModifiedOn(date);
			keluarga.setIsDelete(false);
			keluarga.setBiodataId((long) 1);
			String savests = "";
			klg.save(keluarga);
			return savests;
	}
		



	@RequestMapping("/klgedit/{id}")
	public String keluargaedit(@PathVariable(name = "id") long id, Model model) {
		keluarga keluarga = klg.get(id);
		model.addAttribute("keluarga", keluarga);
		
		List<familyTreeTypeId> listFamilyTreeTypeId = type.listAll();
		model.addAttribute("listFamilyTreeTypeId", listFamilyTreeTypeId);
		List<familyRelationId> listFamilyRelationId= relat.listAll();
		model.addAttribute("listFamilyRelationId", listFamilyRelationId);
		List<educationLevelId> listEducationLevelId= edu.listAll();
		model.addAttribute("listEducationLevelId", listEducationLevelId);
		
	
		TreeMap<Boolean, String> gender = new TreeMap<Boolean, String>();
		gender.put(true, "pria");
		gender.put(false, "wanita");
		model.addAttribute("listGender", gender);
		return "keluarga/keluargaedit";
	}

	@RequestMapping("/klgeditdel/{id}")
	public String keluargadelete(@PathVariable(name = "id") long id, Model model) {
		keluarga keluarga = klg.get(id);
		model.addAttribute("keluarga", keluarga);
		return "keluarga/keluargadelete";
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/deleteklg/{id}")
	public String deleteklg(@ModelAttribute("keluarga2") keluarga keluarga, @PathVariable(name = "id") long id, Model model) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date(System.currentTimeMillis());
	
	keluarga.setDeletedBy(null);
	keluarga.setDeletedOn(date);
	keluarga.setIsDelete(false);
	keluarga.setBiodataId((long) 1);
	klg.save(keluarga);

		String deletests="";
		Long l= new Long(id);
			klg.deletflag(l);
			return deletests;
	}
}