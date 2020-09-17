package com.linkdev.todolist.service;

import java.util.List;

import com.linkdev.todolist.entities.Todo;

public interface TodoService {
	void save(Todo todo);

	List<Todo> getAllTodos();
}
