package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.onlineTest;
import com.batch200_2.model.religion;

public interface onlineTestRepository extends JpaRepository<onlineTest, Long> {

	@Query(value = "select p.id from onlineTest p where p.id = ?1")
	String CekUserDiOln(int id);	
	
	@Modifying
	@Query(value = "update onlineTest set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM onlineTest s where isDelete!=true ")
	List<onlineTest> selectisDelete(String nama);

//	@Query(value = "select r.testType from onlineTest r where r.testType = ?1")
//	String CekTestDiOln(int id);
//	
//	@Query(value = "select r.familyRelationId from onlineTest r where r.familyRelationId = ?1")
//	String CekRelatDiKlg(int id);
//	
//	@Query(value = "select r.educationLevelId from onlineTest r where r.educationLevelId = ?1")
//	String CekEduDiKlg(int id);
}