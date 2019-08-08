package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.login;
import com.batch200_2.model.organisasi;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;
import com.batch200_2.repository.organisasiRepository;

@Service
@Transactional
public class organisasiService {

	@Autowired
	private organisasiRepository org;

	public List<organisasi> listAll() {
		return org.findAll();
	}
		
	public organisasi save (organisasi organisasi) {
		return org.save(organisasi);
	}
	
	public organisasi get(Long idorg) {
		return org.findById(idorg).get();
	}
	
	public void deletflag (Long id) {
		org.deletflag(id);
	}
	
	public String cekIdUserDiRlg(int id) {
		return org.CekUserDiOrg(id);
	}
	
	public List<organisasi> selectisDelete(String nama) {
		return org.selectisDelete(nama);
	}
	public List<organisasi> selectBiodata(long id) {
		return org.selectBiodata(id);
	}
		
}