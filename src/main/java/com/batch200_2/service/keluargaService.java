package com.batch200_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch200_2.model.familyRelationId;
import com.batch200_2.model.keluarga;
import com.batch200_2.model.login;
import com.batch200_2.model.product;
import com.batch200_2.model.religion;
import com.batch200_2.model.supplier;
import com.batch200_2.repository.familyRelationIdRepository;
import com.batch200_2.repository.keluargaRepository;
import com.batch200_2.repository.loginRepository;
import com.batch200_2.repository.productRepository;
import com.batch200_2.repository.religionRepository;
import com.batch200_2.repository.supplierRepository;

@Service
@Transactional
public class keluargaService {

	@Autowired
	private keluargaRepository klg;
	@Autowired
	private	familyRelationIdRepository relat;
	

	public List<keluarga> listAll() {
		return klg.findAll();
	}
	public List<familyRelationId> listAll1() {
		return relat.findAll();
	}

	
	public List<familyRelationId> findById(long id) { 
		return relat.CekRelatDiType(id);
	}
	
	public keluarga save (keluarga keluarga) {
		return klg.save(keluarga);
	}
	
	public keluarga get(Long idklg) {
		return klg.findById(idklg).get();
	}
	
	public void deletflag (Long id) {
		klg.deletflag(id);
	}
	public String cekIdUserDiKlg(int id) {
		return klg.CekUserDiKlg(id);
	}
	
	
	public List<keluarga> selectisDelete(String nama) {

		return klg.selectisDelete(nama);
	}
	
	public String cekIdTypeDiKlg(int id) {
		return klg.CekTypeDiKlg(id);
	}
	
	public String cekIdRelatDiKlg(int id) {
		return klg.CekRelatDiKlg(id);
	}
	
	public String cekIdEduDiKlg(int id) {
		return klg.CekEduDiKlg(id);
	}
}		
