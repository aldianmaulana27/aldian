package com.batch200_2.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class product {
	@Id
	@Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprod;
	
	@Column(name = "nama", nullable = false)
	private String nama;
	@Column(name = "brand", nullable = false)
	private String brand;
	@Column(name = "made_in", nullable = false)
	private String made;
	@Column(name = "price", nullable = false)
	private float price;
	
	// untuk join table
	@Column(name = "id_supplier", nullable = false)
	private int id_supplier;
	
	@ManyToOne
	@JoinColumn(name="id_supplier", nullable=true, updatable=false, insertable=false)
	// mengganti id jadi nama dengan menambah sply ex: supplier.sply.nama
	private supplier sply;

	public Long getIdprod() {
		return idprod;
	}

	public void setIdprod(Long idprod) {
		this.idprod = idprod;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId_supplier() {
		return id_supplier;
	}

	public void setId_supplier(int id_supplier) {
		this.id_supplier = id_supplier;
	}

	public supplier getSply() {
		return sply;
	}

	public void setSply(supplier sply) {
		this.sply = sply;
	}

	
	
}