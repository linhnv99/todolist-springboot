package com.linkdev.todolist.dto;

import java.io.Serializable;

public class AjaxResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8245750118094970048L;
	private Boolean status;
	private String message;
	private Object data;

	public AjaxResponse() {
		super();
	}

	public AjaxResponse(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public AjaxResponse(Boolean status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
