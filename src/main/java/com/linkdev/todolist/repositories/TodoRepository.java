package com.linkdev.todolist.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.linkdev.todolist.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Query(value = "select * from todo where Date(due) = ?1 and status = 1", nativeQuery = true)
	List<Todo> getAllTodosByToday(LocalDate now);

	@Query(value = "select * from todo where status = 1", nativeQuery = true)
	List<Todo> getAllTodos();

	@Query(value = "select * from todo where status = 0", nativeQuery = true)
	List<Todo> getAllTodosFromBin();
}
