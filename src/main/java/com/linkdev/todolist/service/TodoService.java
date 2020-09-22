package com.linkdev.todolist.service;

import java.time.LocalDate;
import java.util.List;

import com.linkdev.todolist.entities.Todo;

public interface TodoService {
	void save(Todo todo);

	List<Todo> getAllTodos();

	Todo getTodoById(Integer id);

	void delete(Integer id);

	void toggleCompletedTodo(Integer id);

	List<Todo> getAllTodosByToday(LocalDate now);
	
	void isLated();

	void pushInTrash(Integer id);

	List<Todo> getAllTodosFromBin();
}
