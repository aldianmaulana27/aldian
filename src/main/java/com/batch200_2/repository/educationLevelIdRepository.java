package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.educationLevelId;
import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.religion;

public interface educationLevelIdRepository extends JpaRepository<educationLevelId, Long> {

	@Query(value = "select p.id from educationLevelId p where p.id = ?1")
	String CekUserDiEdu(int id);	
	
	@Modifying
	@Query(value = "update educationLevelId set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM educationLevelId s where isDelete!=true ")
	List<educationLevelId> selectisDelete(String nama);

}