package com.linkdev.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.linkdev.todolist.service.TodoService;

@Controller
public class BinController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/bin")
	public String index(ModelMap model) {
		return "bin";
	}
	
	@GetMapping("/bin-todo-viewer")
	public String loadTodobyToday(ModelMap model) {
		model.addAttribute("bin", true);
		model.addAttribute("todos", todoService.getAllTodosFromBin());
		return "todo-viewer";
	}
}
