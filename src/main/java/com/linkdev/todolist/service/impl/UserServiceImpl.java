package com.linkdev.todolist.service.impl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.linkdev.todolist.dto.AccountReset;
import com.linkdev.todolist.entities.Role;
import com.linkdev.todolist.entities.User;
import com.linkdev.todolist.repositories.RoleRepository;
import com.linkdev.todolist.repositories.UserRepository;
import com.linkdev.todolist.service.EmailService;
import com.linkdev.todolist.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private EmailService emailService;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public User saveUser(User user) throws IllegalStateException, IOException {
		if (user.getId() == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findRoleByName("ROLE_USER"));
			user.setRoles(roles);
			user.setCreatedDate(LocalDateTime.now());
		} else {
			User userInDB = userRepository.findById(user.getId()).get();
			user.setCreatedDate(userInDB.getCreatedDate());
			user.setUpdatedDate(LocalDateTime.now());
			if (user.getFile() != null) {
				File file = new File("F:\\JavaWeb\\todolist\\uploads\\" + userInDB.getAvatar());
				if (file.exists()) {
					file.delete();
				}
				saveFile(user);
			} else {
				user.setAvatar(userInDB.getAvatar());
			}
			user.setPassword(userInDB.getPassword());
			user.setRoles(userInDB.getRoles());
			user.setEmail(userInDB.getEmail());
		}
		user.setActive(true);
		user.setStatus(true);
		return userRepository.save(user);
	}

	public void saveFile(User user) throws IllegalStateException, IOException {
		String storePath = "F:\\JavaWeb\\todolist\\uploads\\" + user.getFile().getOriginalFilename();
		user.getFile().transferTo(new File(storePath));
		user.setAvatar(user.getFile().getOriginalFilename());
	}

	@Override
	public User getUserCurrent() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			User u = (User) auth.getPrincipal();
			User uCurrent = userRepository.findUserByEmail(u.getEmail());
			return uCurrent;
		}
		return null;
	}

	@Override
	public User findUserByToken(String token) {
		return userRepository.findUserByToken(token);
	}

	@Override
	public void generateToken(User user) {
		String token = UUID.randomUUID().toString();
		user.setPasswordResetToken(token);
		userRepository.save(user);

		String text = "Hi there, I'm Linh" + "\n";
		text += "Nice to meet you!^^" + "\n";
		text += "Please change your password" + "\n";
		text += "Link: " + "http://localhost:8080/reset-password?token=" + token;
		emailService.sendMail(user.getEmail(), "Reset Password", text);
	}

	@Override
	public User saveNewPassword(AccountReset acc) {
		User user = userRepository.findUserByEmail(acc.getEmail());
		user.setPassword(passwordEncoder.encode(acc.getPassword()));
		user.setPasswordResetToken(null);
		return userRepository.save(user);
	}

}
