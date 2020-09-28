package com.linkdev.todolist.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.linkdev.todolist.service.TodoService;

@Controller
public class HomeController extends BaseController{
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String index(ModelMap model) {
		return "index";
	}
	
	@GetMapping("/home-todo-viewer")
	public String loadTodobyToday(ModelMap model) {
		model.addAttribute("todos", todoService.getAllTodosByToday(LocalDate.now()));
		return "todo-viewer";
	}
	
	@GetMapping("/login")
	public String login(ModelMap model) {
		return "login";
	}
}
