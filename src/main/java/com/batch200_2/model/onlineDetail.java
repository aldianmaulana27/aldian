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
@Table(name = "x_online_test_detail")
public class onlineDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idolnd;
	
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

	@Column(name = "online_test_id", nullable = true)
	private Long onlineTestId;
	@Column(name = "test_type_id", nullable = true)
	private Long testTypeId;
	@Column(name = "test_order", nullable = true)
	private int testOrder;
	public Long getIdolnd() {
		return idolnd;
	}
	public void setIdolnd(Long idolnd) {
		this.idolnd = idolnd;
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
	public Long getOnlineTestId() {
		return onlineTestId;
	}
	public void setOnlineTestId(Long onlineTestId) {
		this.onlineTestId = onlineTestId;
	}
	public Long getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(Long testTypeId) {
		this.testTypeId = testTypeId;
	}
	public int getTestOrder() {
		return testOrder;
	}
	public void setTestOrder(int testOrder) {
		this.testOrder = testOrder;
	}

}