package com.batch200_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.product;

public interface productRepository extends JpaRepository<product, Long> {

	@Query(value = "select p.id_supplier from product p where p.id_supplier = ?1")
	String CekSplyDiProd(int id);
	
}