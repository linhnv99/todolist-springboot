package com.linkdev.todolist.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkdev.todolist.entities.Todo;
import com.linkdev.todolist.repositories.TodoRepository;
import com.linkdev.todolist.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void save(Todo todo) {
		todo.setCreatedDate(LocalDateTime.now());
		todoRepository.save(todo);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

}
