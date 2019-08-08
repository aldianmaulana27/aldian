package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.product;
import com.batch200_2.model.supplier;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.supplierRepository;

@Service
@Transactional
public class productService {

	@Autowired
	private productRepository prod;

	@Autowired
	private supplierRepository sply;
//---------------------------Default fungsi JPA-------------------------
	public List<product> listAll() {
		return prod.findAll();
	}
	
	public List<supplier> listAll1() {
		return sply.findAll();
	}
	
	public product save (product product) {
		return prod.save(product);
	}
	
	public product get(Long idprod) {
		return prod.findById(idprod).get();
	}
	
	public void delete (long id) {
		prod.deleteById(id);
	}
	
	public String cekIdSplyDiProd(int id) {
		return prod.CekSplyDiProd(id);
	}
	
}