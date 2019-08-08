package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.batch200_2.model.login;
import com.batch200_2.repository.loginRepository;

@Service
@Transactional
public class loginService {

	@Autowired
	private loginRepository logn;

		public List<login> listAll(){
			return logn.findAll();
		}
	public String ceklogin(String  nama, String pass){
		return logn.cekLogin(nama,pass);
	}
	
}