package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.login;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.role;
import com.batch200_2.model.supplier;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;

@Service
@Transactional
public class religionService {

	@Autowired
	private religionRepository rlg;
	@Autowired
	private loginRepository lgn;

	public List<religion> listAll() {
		return rlg.findAll();
	}
	
	public List<login> listAll1() {
		return lgn.findAll();
	}
	
	public religion save (religion religion) {
		return rlg.save(religion);
	}
	
	public religion get(Long idrlg) {
		return rlg.findById(idrlg).get();
	}
	
	
	public void deletflag (Long id) {
		rlg.deletflag(id);
	}
	
	public String cekIdUserDiRlg(int id) {
		return rlg.CekUserDiRlg(id);
	}
	
	public List<religion> selectisDelete(String nama) {
		return rlg.selectisDelete(nama);
	}

	public void getAll(Long id) {
		rlg.getAll(id);
	}
	
	public List<religion> selectsearch(String nama) {

		return rlg.selectsearch(nama);
	}
		
}