package com.batch200_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.supplier;

public interface supplierRepository extends JpaRepository<supplier, Long> {

	@Query(value = "select s.email from supplier s where s.email = ?1")
	String CekEmailDiSply(String email);
}