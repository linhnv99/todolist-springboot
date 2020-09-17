package com.linkdev.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.linkdev.todolist.dto.AjaxResponse;
import com.linkdev.todolist.entities.Todo;
import com.linkdev.todolist.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/todo-list")
	public String index(ModelMap model) {
		return "todolist";
	}

	@GetMapping("/todo-viewer")
	public String loadTodo(ModelMap model) {
		List<Todo> todos = todoService.getAllTodos();
		model.addAttribute("todos", todos);
		return "todo-viewer";
	}

	@PostMapping("/api/add-todo")
	public ResponseEntity<AjaxResponse> addTodo(ModelMap model, @RequestBody Todo todo) {
		todoService.save(todo);
		return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
	}
}
