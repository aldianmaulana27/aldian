package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.religion;
import com.batch200_2.model.role;

public interface religionRepository extends JpaRepository<religion, Long> {

	@Query(value = "select p.id from religion p where p.id = ?1")
	String CekUserDiRlg(int id);
	
	@Query(value = "select s from religion s where s.name like %?1% ")
	int getAll(Long id);
	
	@Modifying
	@Query(value = "update religion set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM religion s where isDelete!=true ")
	List<religion> selectisDelete(String nama);
	
	@Query(value = "select s from religion s where s.name like %?1% ")
	List<religion> selectsearch(String nama);
}