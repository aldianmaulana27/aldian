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
import com.batch200_2.model.role;
import com.batch200_2.service.productService;
import com.batch200_2.service.religionService;
import com.batch200_2.service.roleService;
import com.batch200_2.service.supplierService;

@Controller
public class roleController {
	@Autowired
	private roleService rl;

	@RequestMapping("/role")
	public String role() {
		return "role/role";
	}

	@RequestMapping("/listrl")
	public String listrl(Model model) {
		String nama = "";
		List<role> listRole = rl.selectisDelete(nama);
		model.addAttribute("listRole", listRole);
		return "/role/rolelist";
	}

	@RequestMapping("/rolenew")
	public String rolenew(Model model) {
		role role = new role();
		model.addAttribute("role2", role);
		List<role> listRole = rl.listAll();
		model.addAttribute("listRole", listRole);
		return "/role/rolenew";
	}

	@ResponseBody
	@RequestMapping(value = "/saverl")
	public String savesrl(@ModelAttribute("role2") role role) {
		String savests = "0";

		String cekKode = rl.cekIdKodeDiRole(role.getCode());
		System.out.println(cekKode);
		if (cekKode == "" || cekKode == null) {
			role.setCreatedBy((long) 2);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			role.setCreatedOn(date);
			role.setDeletedBy(null);
			role.setDeletedOn(null);
			role.setModifiedBy(null);
			role.setModifiedOn(null);
			role.setIsDelete(false);
			savests = "1";
			rl.save(role);
		} else {
			savests = "0";
		}

		return savests;
	}

	@ResponseBody
	@RequestMapping(value = "/saveeditrl")
	public String saveseditrl(@ModelAttribute("role2") role role) {
		String savests = "0";

		String kode = role.getCode();
		String cekKode = rl.cekIdKodeDiRole(kode);
		System.out.println(cekKode);
		if (cekKode == "" || cekKode == null || cekKode.equals(kode)) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());

			role.setDeletedBy(null);
			role.setDeletedOn(null);
			role.setModifiedBy((long) 2);
			role.setModifiedOn(date);
			role.setIsDelete(false);
			savests = "1";
			rl.save(role);
		} else {
			savests = "0";
		}

		return savests;
	}

	@RequestMapping("/rledit/{id}")
	public String roleedit(@PathVariable(name = "id") long id, Model model) {
		role role = rl.get(id);
		model.addAttribute("role", role);
		return "role/roleedit";
	}

	@RequestMapping("/rleditdel/{id}")
	public String roledelete(@PathVariable(name = "id") long id, Model model) {
		role role = rl.get(id);
		model.addAttribute("role", role);
		return "role/roledelete";
	}

	@ResponseBody
	@RequestMapping(value = "/deleterl/{id}")
	public String deleterl(@ModelAttribute("role2") role role, @PathVariable(name = "id") long id, Model model) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		role.setDeletedBy((long) 2);
		role.setDeletedOn(date);
		role.setIsDelete(false);
		rl.save(role);
		String deletests = "";
		Long l = new Long(id);
		rl.deletflag(id);
		return deletests;
	}
	
}