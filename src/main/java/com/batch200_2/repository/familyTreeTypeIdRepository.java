package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.religion;

public interface familyTreeTypeIdRepository extends JpaRepository<familyTreeTypeId, Long> {

	@Query(value = "select p.id from religion p where p.id = ?1")
	String CekUserDiRlg(int id);	
	
	@Modifying
	@Query(value = "update religion set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM religion s where isDelete!=true ")
	List<religion> selectisDelete(String nama);

}