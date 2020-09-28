package com.linkdev.todolist.service;

import java.time.LocalDate;
import java.util.List;

import com.linkdev.todolist.entities.Todo;

public interface TodoService {
	List<Todo> getAllTodosByToday(LocalDate now);

	List<Todo> getAllTodos();

	List<Todo> getAllTodosFromBin();

	void save(Todo todo);

	Todo getTodoById(Integer id);

	void deleteTodoById(Integer id);

	void toggleCompletedTodo(Integer id);

	void isLated();

	void pushInTrash(Integer id);

}
