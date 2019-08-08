package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.login;
import com.batch200_2.model.onlineTest;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.model.testType;
import com.batch200_2.repository.familyTreeTypeIdRepository;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;
import com.batch200_2.repository.testTypeRepository;

@Service
@Transactional
public class testTypeService {

	@Autowired
	private testTypeRepository test;
	@Autowired
	private loginRepository lgn;

	public List<testType> listAll() {
		return test.findAll();
	}

	public testType save (testType testType) {
		return test.save(testType);
	}

		
}