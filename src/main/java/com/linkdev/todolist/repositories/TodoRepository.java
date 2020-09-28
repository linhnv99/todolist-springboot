package com.linkdev.todolist.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.linkdev.todolist.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	@Query(value = "select * from todo where Date(due) = ?1 and user_id = ?2 and status = 1", nativeQuery = true)
	List<Todo> getAllTodosByToday(LocalDate now, Integer id);

	@Query(value = "select * from todo where user_id = ?1 and status = 1", nativeQuery = true)
	List<Todo> getAllTodosByUserLogin(Integer id);

	@Query(value = "select * from todo where user_id = ?1 and status = 0", nativeQuery = true)
	List<Todo> getAllTodosFromBinByUserLogin(Integer id);

	@Transactional
	@Modifying
	@Query(value = "delete from todo where id = ?1", nativeQuery = true)
	void deleteTodoById(Integer id);

}
