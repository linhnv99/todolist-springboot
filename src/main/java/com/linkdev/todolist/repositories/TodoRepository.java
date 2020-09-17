package com.linkdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linkdev.todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
