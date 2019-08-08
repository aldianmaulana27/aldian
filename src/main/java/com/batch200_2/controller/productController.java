package com.batch200_2.controller;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch200_2.model.product;
import com.batch200_2.model.supplier;
import com.batch200_2.service.productService;
import com.batch200_2.service.supplierService;

@Controller
public class productController {
	@Autowired
	private productService prod;
	@Autowired
	private productService sply;

	@RequestMapping("/product")
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
			stsreturn = "product/product";
		} else {
			stsreturn = "redirect:/login";
		}

		return stsreturn;
	}

	@RequestMapping("/listprod")
	public String listprod(Model model) {

		List<product> listProduct = prod.listAll();
		model.addAttribute("listProduct", listProduct);
		return "/product/productlist";
	}

	@RequestMapping("/productnew")
	public String productnew(Model model) {
		product product = new product();
		model.addAttribute("product2", product);
		List<supplier> listSupplier = sply.listAll1();
		model.addAttribute("listSupplier", listSupplier);

		return "/product/productnew";
	}

//	@RequestMapping("/addproduct")
//	public String addproduct (Model model) {
//		product product = new product();
//		model.addAttribute("product", product);
//		return "product/productnew";
//	}

	@ResponseBody
	@RequestMapping(value = "/saveprod")
	public String saveprod(@ModelAttribute("product2") product product, Model model) {
		String savests = "";
		prod.save(product);
		return savests;

	}

	@RequestMapping("/prodedit/{id}")
	public String productedit(@PathVariable(name = "id") long id, Model model) {

		product product = prod.get(id);
		model.addAttribute("product", product);

		List<supplier> listSupplier = sply.listAll1();
		model.addAttribute("listSupplier", listSupplier);
		return "product/productedit";
	}

	@RequestMapping("/prodeditdel/{id}")
	public String productdelete(@PathVariable(name = "id") long id, Model model) {
		product product = prod.get(id);
		model.addAttribute("product", product);
		return "product/productdelete";
	}

	@ResponseBody
	@RequestMapping("/deleteprod/{id}")
	public String deleteProd(@PathVariable(name = "id") Long id) {
		prod.delete(id);
		return "redirect:product/product";
	}
}