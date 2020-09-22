package com.linkdev.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.linkdev.todolist.dto.AjaxResponse;
import com.linkdev.todolist.entities.Todo;
import com.linkdev.todolist.service.TodoService;

@Controller
public class TodoController extends BaseController {
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

	@GetMapping("/add-todo")
	public String addTodo(ModelMap model) {
		model.addAttribute("isAdd", true);
		return "save-todo";
	}

	@GetMapping("/edit-todo/{id}")
	public String editTodo(ModelMap model, @PathVariable("id") Integer id) {
		model.addAttribute("isAdd", false);
		model.addAttribute("todo", todoService.getTodoById(id));
		return "save-todo";
	}

	@PostMapping("/api/save-todo")
	public ResponseEntity<AjaxResponse> addTodo(ModelMap model, @RequestBody Todo todo) {
		todoService.save(todo);
		return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
	}

	@PutMapping("/api/put-in-trash/{id}")
	public ResponseEntity<AjaxResponse> putInTrash(ModelMap model, @PathVariable("id") Integer id) {
		todoService.pushInTrash(id);
		return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
	}

	@DeleteMapping("/api/delete-todo/{id}")
	public ResponseEntity<AjaxResponse> deleteTodo(ModelMap model, @PathVariable("id") Integer id) {
		todoService.delete(id);
		return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
	}

	@PostMapping("/api/completed/{id}")
	public ResponseEntity<AjaxResponse> toggleCompletedTodo(ModelMap model, @PathVariable("id") Integer id) {
		todoService.toggleCompletedTodo(id);
		return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
	}
}
