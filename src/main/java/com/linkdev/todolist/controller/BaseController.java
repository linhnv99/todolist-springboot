package com.linkdev.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.linkdev.todolist.entities.User;
import com.linkdev.todolist.service.TodoService;
import com.linkdev.todolist.service.UserService;

public abstract class BaseController {
	@Autowired
	private TodoService todoService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void changeStateLatedWithRealtime() {
		System.out.println("--Boot up--");
		todoService.isLated();
	}
	
	@ModelAttribute("user")
	public User userLogin() {
		return userService.getUserCurrent();
	}
}
