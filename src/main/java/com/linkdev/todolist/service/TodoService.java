package com.linkdev.todolist.service;

import java.util.List;

import com.linkdev.todolist.entities.Todo;

public interface TodoService {
	void save(Todo todo);

	List<Todo> getAllTodos();

	Todo getTodoById(Integer id);

	void delete(Integer id);

	void toggleCompletedTodo(Integer id);
}
