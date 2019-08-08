package com.batch200_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batch200_2.model.login;


public interface loginRepository extends JpaRepository<login, Long> {
	@Query(value = "SELECT l.nama FROM login l where l.nama = ?1 and l.password = ?2 ")
	String cekLogin(String nama, String pass);
}