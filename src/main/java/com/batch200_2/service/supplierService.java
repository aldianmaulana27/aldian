package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.supplier;
import com.batch200_2.repository.supplierRepository;

@Service
@Transactional
public class supplierService {

	@Autowired
	private supplierRepository splr;

//---------------------------Default fungsi JPA-------------------------
	public List<supplier> listAll() {
		return splr.findAll();
	}
	
	public supplier save (supplier supplier) {
		return splr.save(supplier);
	}
	
	public supplier get(Long idsply) {
		return splr.findById(idsply).get();
	}
	
	public void delete (long id) {
		splr.deleteById(id);
	}
	
	public String cekIdEmailDiSply(String email) {
		return splr.CekEmailDiSply(email);
	}


	
}