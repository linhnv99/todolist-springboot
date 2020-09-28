package com.linkdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.linkdev.todolist.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);

	@Query(value = "select * from user where user.password_reset_token = ?1", nativeQuery = true)
	User findUserByToken(String token);

}
