package com.linkdev.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.linkdev.todolist.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("select r from Role r where r.name = ?1")
	Role findRoleByName(String name);

}
