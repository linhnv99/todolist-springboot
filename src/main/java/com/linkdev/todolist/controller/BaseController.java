package com.linkdev.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.linkdev.todolist.service.TodoService;

public abstract class BaseController {
	@Autowired
	private TodoService todoService;
	
	@ModelAttribute
	public void changeStateLatedWithRealtime() {
		System.out.println("--Đang chạy--");
		todoService.isLated();
	}
}
