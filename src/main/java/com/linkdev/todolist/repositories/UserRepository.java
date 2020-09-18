package com.linkdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkdev.todolist.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
