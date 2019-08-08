package com.batch200_2.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "supplier")
public class supplier {
	@Id
	@Column(name = "id_supplier")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsply;
	@Column(name = "nama", nullable = false)
	private String nama;
	@Column(name = "alamat", nullable = false)
	private String alamat;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "tanggal_join", nullable = false)
	private Date tanggal;

	public Long getIdsply() {
		return idsply;
	}

	public void setIdsply(Long idsply) {
		this.idsply = idsply;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public String getEmail() {
		return email;
	}
	
	public Date getTanggal() {
		return tanggal;
	}
	
	
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal ;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}


}