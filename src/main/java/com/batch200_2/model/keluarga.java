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
@Table(name = "x_keluarga")
public class keluarga {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idklg;
	

	@Column(name = "created_by", nullable = false)
	private Long createdBy;
	@Column(name = "created_on", nullable = false)
	private Date createdOn;
	@Column(name = "modified_by", nullable = true)
	private Long modifiedBy;
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;

	@Column(name = "deleted_by", nullable = true)
	private Long deletedBy;
	@Column(name = "deleted_on", nullable = true)
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = false)
	private Boolean isDelete;

	@Column(name = "biodata_id", nullable = false)
	private Long biodataId;

	@Column(name = "family_tree_type_id", nullable = true)
	private Long familyTreeTypeId;
	@Column(name = "family_relation_id", nullable = true)
	private Long familyRelationId;
	@ManyToOne
	@JoinColumn(name="family_relation_id", nullable=true, updatable=false, insertable=false)
	// mengganti id jadi nama dengan menambah sply ex: supplier.sply.nama
	public familyRelationId relat;

	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "gender", nullable = false)
	private Boolean gender;

	@Column(name = "dob", nullable = true)
	private Date dob;

	@Column(name = "education_level_id", nullable = true)
	private Long educationLevelId;
	@ManyToOne
	@JoinColumn(name="education_level_id", nullable=true, updatable=false, insertable=false)
	// mengganti id jadi nama dengan menambah sply ex: supplier.sply.nama
	public educationLevelId edu;
	@Column(name = "job", nullable = true)
	private String job;
	@Column(name = "notes", nullable = true)
	private String notes;
	public Long getIdklg() {
		return idklg;
	}
	public void setIdklg(Long idklg) {
		this.idklg = idklg;
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
	public Long getBiodataId() {
		return biodataId;
	}
	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
	}
	public Long getFamilyTreeTypeId() {
		return familyTreeTypeId;
	}
	public void setFamilyTreeTypeId(Long familyTreeTypeId) {
		this.familyTreeTypeId = familyTreeTypeId;
	}
	public Long getFamilyRelationId() {
		return familyRelationId;
	}
	public void setFamilyRelationId(Long familyRelationId) {
		this.familyRelationId = familyRelationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getEducationLevelId() {
		return educationLevelId;
	}
	public void setEducationLevelId(Long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
}