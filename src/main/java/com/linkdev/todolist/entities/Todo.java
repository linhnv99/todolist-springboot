package com.linkdev.todolist.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo extends BaseEntity{
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "priority", nullable = false)
	private Integer priority;
	
	@Column(name = "description", columnDefinition = "text")
	private String description;
	
	@Column(name = "due", nullable = false)
	private LocalDateTime due;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDue() {
		return due;
	}

	public void setDue(LocalDateTime due) {
		this.due = due;
	}
	
}
