package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.religion;
import com.batch200_2.model.testType;

public interface testTypeRepository extends JpaRepository<testType, Long> {

	@Query(value = "select p.id from testType p where p.id = ?1")
	String CekUserDiTest(int id);	
	
	@Modifying
	@Query(value = "update testType set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM testType s where isDelete!=true ")
	List<testType> selectisDelete(String nama);

}