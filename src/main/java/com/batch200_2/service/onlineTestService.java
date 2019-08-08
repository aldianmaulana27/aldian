package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.onlineTest;
import com.batch200_2.model.login;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.model.testType;
import com.batch200_2.repository.onlineTestRepository;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.onlineTestRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;
import com.batch200_2.repository.testTypeRepository;

@Service
@Transactional
public class onlineTestService {

	@Autowired
	private onlineTestRepository oln;
	@Autowired
	private testTypeRepository test;
//	@Autowired
//	private loginRepository lgn;
	

	public List<onlineTest> listAll() {
		return oln.findAll();
	}
	public List<testType> listAll1() {
		return test.findAll();
	}
	
	
//	public List<login> listAll1() {
//		return lgn.findAll();
//	}

	public onlineTest save (onlineTest onlineTest) {
		return oln.save(onlineTest);
	}
	
	public onlineTest get(Long idoln) {
		return oln.findById(idoln).get();
	}
	
	public void deletflag (Long id) {
		oln.deletflag(id);
	}
	public String cekIdUserDiOln(int id) {
		return oln.CekUserDiOln(id);
	}
	
	
	public List<onlineTest> selectisDelete(String nama) {

		return oln.selectisDelete(nama);
	}
	
//	public String cekIdtestType(int id) {
//		return oln.CekTestDiOln(id);
//	}
//	
//	public String cekIdRelatDiOln(int id) {
//		return oln.CekRelatDiOln(id);
//	}
//	
//	public String cekIdEduDiOln(int id) {
//		return oln.CekEduDiOln(id);
//	}
}		
