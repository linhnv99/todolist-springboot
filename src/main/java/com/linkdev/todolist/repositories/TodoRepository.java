package com.linkdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkdev.todolist.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
