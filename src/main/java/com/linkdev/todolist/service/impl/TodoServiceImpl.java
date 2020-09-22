package com.linkdev.todolist.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
		if (!checkLatedWithRealtime(todo.getDue())) {
			todo.setLate(true);
		} else {
			todo.setLate(false);
		}

		if (todo.getId() != null) {
			Todo todoInDB = todoRepository.findById(todo.getId()).get();
			todo.setCreatedDate(todoInDB.getCreatedDate());
			todo.setUpdatedDate(LocalDateTime.now());
			todo.setCompleteStatus(todoInDB.getCompleteStatus());
			todo.setStatus(todoInDB.getStatus());
		} else {
			todo.setCreatedDate(LocalDateTime.now());
			todo.setCompleteStatus(false);
			todo.setStatus(true);
		}
		todoRepository.save(todo);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.getAllTodos();
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
	public void pushInTrash(Integer id) {
		Todo todoInDB = todoRepository.findById(id).get();
		if(todoInDB.getStatus()) {
			todoInDB.setStatus(false);
		}else {
			todoInDB.setStatus(true);
		}
		todoRepository.save(todoInDB);
	}

	@Override
	public void toggleCompletedTodo(Integer id) {
		Todo todoInDB = todoRepository.findById(id).get();
		if (todoInDB.getCompleteStatus()) {
			todoInDB.setCompleteStatus(false);
		} else {
			todoInDB.setCompleteStatus(true);
		}
		todoRepository.save(todoInDB);
	}

	@Override
	public List<Todo> getAllTodosByToday(LocalDate now) {
		return todoRepository.getAllTodosByToday(now);
	}

	@Override
	public void isLated() {
		List<Todo> todos = todoRepository.findAll();
		for (Todo todo : todos) {
			if (!checkLatedWithRealtime(todo.getDue()) && !todo.getCompleteStatus()) {
				todo.setLate(true);
			} else {
				todo.setLate(false);
			}
			todoRepository.save(todo);
		}
	}

	private boolean checkLatedWithRealtime(LocalDateTime due) {
		if (toEpochMilli(LocalDateTime.now()) > toEpochMilli(due)) {
			return false;
		}
		return true;
	}

	private long toEpochMilli(LocalDateTime localDateTime) {
		return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	@Override
	public List<Todo> getAllTodosFromBin() {
		return todoRepository.getAllTodosFromBin();
	}

}
