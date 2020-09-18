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
		if(todo.getId() != null) {
			Todo todoInDB = todoRepository.findById(todo.getId()).get();
			todo.setCreatedDate(todoInDB.getCreatedDate());
			todo.setUpdatedDate(LocalDateTime.now());
		}else {
			todo.setCreatedDate(LocalDateTime.now());
			todo.setCompleteStatus(false);
		}
		todoRepository.save(todo);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Todo getTodoById(Integer id) {
		return todoRepository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		todoRepository.deleteById(id);
	}

	@Override
	public void toggleCompletedTodo(Integer id) {
		Todo todoInDB = todoRepository.findById(id).get();
		if(todoInDB.getCompleteStatus()) {
			todoInDB.setCompleteStatus(false);
		}else {
			todoInDB.setCompleteStatus(true);
		}
		todoRepository.save(todoInDB);
	}

}
