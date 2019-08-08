package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.familyRelationId;
import com.batch200_2.model.familyTreeTypeId;
import com.batch200_2.model.religion;

public interface familyRelationIdRepository extends JpaRepository<familyRelationId, Long> {

	@Query(value = "select p.id from familyRelationId p where p.id = ?1")
	String CekUserDiRelat(int id);	
	
	@Modifying
	@Query(value = "update familyRelationId set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM familyRelationId s where isDelete!=true ")
	List<familyRelationId> selectisDelete(String nama);
	
	@Query(value = "SELECT s FROM familyRelationId s where s.familyTreeTypeId=?1 ")
	List<familyRelationId> CekRelatDiType(long id);

}