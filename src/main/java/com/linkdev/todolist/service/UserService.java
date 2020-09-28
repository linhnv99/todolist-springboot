package com.linkdev.todolist.service;

import java.io.IOException;

import com.linkdev.todolist.dto.AccountReset;
import com.linkdev.todolist.entities.User;

public interface UserService {
	User findUserByEmail(String email);

	User saveUser(User user) throws IllegalStateException, IOException;

	User getUserCurrent();

	User findUserByToken(String token);

	void generateToken(User user);

	User saveNewPassword(AccountReset acc);

}
