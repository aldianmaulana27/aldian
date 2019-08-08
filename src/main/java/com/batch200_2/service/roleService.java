package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.login;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.model.role;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;
import com.batch200_2.repository.roleRepository;

@Service
@Transactional
public class roleService {

	@Autowired
	private roleRepository rl;

	public List<role> listAll() {
		return rl.findAll();
	}
	
	
	public role save (role role) {
		return rl.save(role);
	}
	
	
	public role get(Long idrl) {
		return rl.findById(idrl).get();
	}
	
	public void deletflag (Long id) {
		rl.deletflag(id);
	}
	
	public String cekIdUserDiRl(int id) {
		return rl.CekUserDiRl(id);
	}
	
	public List<role> selectisDelete(String nama) {
		return rl.selectisDelete(nama);
	}
	
	public String cekIdKodeDiRole(String email) {
		return rl.CekKodeDiRole(email);
	}		
}