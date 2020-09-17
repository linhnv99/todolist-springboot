package com.linkdev.todolist.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "created_by")
	private LocalDateTime createdBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "updated_by")
	private LocalDateTime updatedBy;

	@Column(name = "status")
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(LocalDateTime createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDateTime getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(LocalDateTime updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
