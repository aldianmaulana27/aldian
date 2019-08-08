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
import com.batch200_2.model.educationLevelId;
import com.batch200_2.model.familyRelationId;
import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.keluarga;
import com.batch200_2.model.onlineTest;
import com.batch200_2.model.testType;
import com.batch200_2.service.educationLevelIdService;
import com.batch200_2.service.familyRelationIdService;
import com.batch200_2.service.familyTreeTypeIdService;
import com.batch200_2.service.keluargaService;
import com.batch200_2.service.onlineTestService;
import com.batch200_2.service.productService;
import com.batch200_2.service.religionService;
import com.batch200_2.service.supplierService;
import com.batch200_2.service.testTypeService;

@Controller
public class onlineTestController {
	@Autowired
	private onlineTestService oln;
	@Autowired
	private testTypeService test;
	
	@RequestMapping("/onlineTest")
	public String testType() {
		return "onlineTest/onlineTest";
	}
	
	@RequestMapping("/listoln")
	public String listoln(Model model) {
	//	List<religion> listReligion = rlg.listAll();
		String nama="";
		List<onlineTest> listOnlineTest = oln.selectisDelete(nama);
		model.addAttribute("listOnlineTest", listOnlineTest);
		return "/onlineTest/onlineTestlist";
	}

	@RequestMapping("/onlineTestnew")
	public String nlineTestnew(Model model) {
		onlineTest onlineTest = new onlineTest();
		model.addAttribute("onlineTest2", onlineTest);
		List<testType> listTestType= test.listAll();
		model.addAttribute("listTestType", listTestType);
		
//	
//		TreeMap<Boolean, String> gender = new TreeMap<Boolean, String>();
//		gender.put(true, "Laki-laki");
//		gender.put(false, "perempuan");
//		model.addAttribute("listGender", gender);
//		List<keluarga> listKeluarga = klg.selectisDelete(nama);
//		model.addAttribute("listKeluarga", listKeluarga);
		return "/onlineTest/onlineTestnew";
	}
	@RequestMapping("/onlineTestadd")
	public String nlineTestadd(Model model) {
		onlineTest onlineTest = new onlineTest();
		model.addAttribute("onlineTest2", onlineTest);
		
		List<testType> listTestType= test.listAll();
		model.addAttribute("listTestType", listTestType);
		
//	
//		TreeMap<Boolean, String> gender = new TreeMap<Boolean, String>();
//		gender.put(true, "Laki-laki");
//		gender.put(false, "perempuan");
//		model.addAttribute("listGender", gender);
//		List<keluarga> listKeluarga = klg.selectisDelete(nama);
//		model.addAttribute("listKeluarga", listKeluarga);
		return "/onlineTest/onlineTestadd";
	}
	
	@ResponseBody
	@RequestMapping(value = "/savenewoln")
	public String savesoln(@ModelAttribute("onlineTest2") onlineTest onlineTest) {
			
		onlineTest.setCreatedBy((long) 1);
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			onlineTest.setCreatedOn(date);	
			onlineTest.setDeletedBy(null);
			onlineTest.setDeletedOn(null);
			onlineTest.setModifiedBy(null);
			onlineTest.setModifiedOn(null);
			onlineTest.setIsDelete(false);
			onlineTest.setBiodataId((long) 1);
			onlineTest.setPeriod(1);
			onlineTest.setPeriodCode(null);
			onlineTest.setStatus(null);
			String savests = "";
			oln.save(onlineTest);
			return savests;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveaddoln")
	public String savesaddoln(@ModelAttribute("testType2") testType testType) {
			
		testType.setCreatedBy((long) 1);
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			testType.setCreatedOn(date);	
			testType.setDeletedBy(null);
			testType.setDeletedOn(null);
			testType.setModifiedBy(null);
			testType.setModifiedOn(null);
			testType.setIsDelete(false);
			String savests = "";
			test.save(testType);
			return savests;
	}
		
	@RequestMapping("/olnedit/{id}")
	public String onlineTestedit(@PathVariable(name = "id") long id, Model model) {
		onlineTest onlineTest = oln.get(id);
		model.addAttribute("onlineTest", onlineTest);
		
		List<testType> listTestType= test.listAll();
		model.addAttribute("listTestType", listTestType);
		
	
//		TreeMap<Boolean, String> gender = new TreeMap<Boolean, String>();
//		gender.put(true, "Laki-laki");
//		gender.put(false, "perempuan");
//		model.addAttribute("listGender", gender);
		return "onlineTest/onlineTestpilihan";
	}

	@RequestMapping("/olneditdel/{id}")
	public String onlineTestdelete(@PathVariable(name = "id") long id, Model model) {
		onlineTest onlineTest= oln.get(id);
		model.addAttribute("onlineTest", onlineTest);
		return "onlineTest/onlineTestdelete";
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/deleteoln/{id}")
	public String deleteoln(@PathVariable(name = "id") long id, Model model) {
		String deletests="";
		Long l= new Long(id);
			oln.deletflag(l);
			return deletests;
	}
	
}