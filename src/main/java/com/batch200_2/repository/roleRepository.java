package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.religion;
import com.batch200_2.model.role;

public interface roleRepository extends JpaRepository<role, Long> {

	@Query(value = "select p.id from role p where p.id = ?1")
	String CekUserDiRl(int id);	
	
	@Modifying
	@Query(value = "update role set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM role s where isDelete!=true ")
	List<role> selectisDelete(String nama);

	@Query(value = "select r.code from role r where r.code = ?1 and isDelete!=true ")
	String CekKodeDiRole(String code);
	
}