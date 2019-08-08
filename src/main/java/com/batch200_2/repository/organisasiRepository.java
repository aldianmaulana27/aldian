package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.organisasi;
import com.batch200_2.model.religion;

public interface organisasiRepository extends JpaRepository<organisasi, Long> {

	@Query(value = "select p.id from organisasi p where p.id = ?1")
	String CekUserDiOrg(int id);	
	
	@Modifying
	@Query(value = "update organisasi set isDelete=true where id = ?1")
	int deletflag(Long id);	
	
	@Query(value = "SELECT s FROM organisasi s where isDelete!=true ")
	List<organisasi> selectisDelete(String nama);

	@Query(value = "SELECT s FROM organisasi s where s.biodataId=?1 and isDelete!=true ")
	List<organisasi> selectBiodata(long id);

}