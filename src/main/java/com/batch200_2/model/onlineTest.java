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
@Table(name = "x_online_test")
public class onlineTest {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idoln;
	
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

	@Column(name = "biodata_id", nullable = false)
	private Long biodataId;

	@Column(name = "period_code", nullable = true)
	private String periodCode;
	
	@Column(name = "period", nullable = true)
	private int period;
	
	@Column(name = "test_date", nullable = true)
	private Date testDate;
	
	@Column(name = "expired_test", nullable = true)
	private Date expiredTest;
	
	@Column(name = "user_access", nullable = true)
	private String userAccess;
	
	@Column(name = "status", nullable = true)
	private String status;

	public Long getIdoln() {
		return idoln;
	}

	public void setIdoln(Long idoln) {
		this.idoln = idoln;
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

	public String getPeriodCode() {
		return periodCode;
	}

	public void setPeriodCode(String periodCode) {
		this.periodCode = periodCode;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Date getExpiredTest() {
		return expiredTest;
	}

	public void setExpiredTest(Date expiredTest) {
		this.expiredTest = expiredTest;
	}

	public String getUserAccess() {
		return userAccess;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}