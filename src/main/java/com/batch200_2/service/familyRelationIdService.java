package com.batch200_2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.familyRelationId;
import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.login;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.repository.familyRelationIdRepository;
import com.batch200_2.repository.familyTreeTypeIdRepository;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;

@Service
@Transactional
public class familyRelationIdService {

	@Autowired
	private familyRelationIdRepository relat;
	@Autowired
	private familyTreeTypeIdRepository type;

	public List<familyRelationId> listAll() {
		return relat.findAll();
	}
		
	public List<familyTreeTypeId> listAll1() {
		return type.findAll();
	}

	public List<familyRelationId> findById(long id) {
		return relat.CekRelatDiType(id);
	}
	
		
}