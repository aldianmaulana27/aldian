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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "x_family_relation")
public class familyRelationId {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrelat;
	
	@Column(name = "created_by", nullable = false)
	private Long createdBy;
	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	private Date createdOn;
	@Column(name = "modified_by", nullable = true)
	private Long modifiedBy;
	@Column(name = "modified_on", nullable = true)
	@UpdateTimestamp
	private Date modifiedOn;

	@Column(name = "deleted_by", nullable = true)
	private Long deletedBy;
	@Column(name = "deleted_on", nullable = true)
	@UpdateTimestamp
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = false)
	private Boolean isDelete;
	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = true)
	private String description;
	@Column(name = "family_tree_type_id", nullable = true)
	private Long familyTreeTypeId;
	
	@ManyToOne
	@JoinColumn(name="family_tree_type_id", nullable=true, updatable=false, insertable=false)
	// mengganti id jadi nama dengan menambah sply ex: supplier.sply.nama
	private familyTreeTypeId type;

	
	public Long getIdrelat() {
		return idrelat;
	}
	public void setIdrelat(Long idrelat) {
		this.idrelat = idrelat;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Long getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}
	public Date getDeletedOn() {
		return deletedOn;
	}
	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getFamilyTreeTypeId() {
		return familyTreeTypeId;
	}
	public void setFamilyTreeTypeId(Long familyTreeTypeId) {
		this.familyTreeTypeId = familyTreeTypeId;
	}
	
}