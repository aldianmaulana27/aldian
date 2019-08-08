package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.keluarga;
import com.batch200_2.model.religion;

public interface keluargaRepository extends JpaRepository<keluarga, Long> {

	@Query(value = "select p.id from keluarga p where p.id = ?1")
	String CekUserDiKlg(int id);	
	
	@Modifying
	@Query(value = "update keluarga set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM keluarga s where isDelete!=true ")
	List<keluarga> selectisDelete(String nama);

	@Query(value = "select r.familyTreeTypeId from keluarga r where r.familyTreeTypeId = ?1")
	String CekTypeDiKlg(int id);
	
	@Query(value = "select r.familyRelationId from keluarga r where r.familyRelationId = ?1")
	String CekRelatDiKlg(int id);
	
	@Query(value = "select r.educationLevelId from keluarga r where r.educationLevelId = ?1")
	String CekEduDiKlg(int id);
	
	@Query(value = "select c.idrelat,c.name from familyRelationId c where c.familyTreeTypeId = ?1")
	String CekRelatDiType(int id);
	
}