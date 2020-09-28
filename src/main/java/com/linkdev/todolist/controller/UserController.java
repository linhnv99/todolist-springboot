package com.linkdev.todolist.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.linkdev.todolist.dto.AccountReset;
import com.linkdev.todolist.dto.AjaxResponse;
import com.linkdev.todolist.entities.User;
import com.linkdev.todolist.service.UserService;

@Controller
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<AjaxResponse> signup(@RequestBody User user) throws IllegalStateException, IOException {
		User emailExists = userService.findUserByEmail(user.getEmail());
		if (emailExists != null)
			return ResponseEntity.ok(new AjaxResponse(true, "EMAIL_EXISTS"));
		User userResp = userService.saveUser(user);
		if (userResp != null)
			return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
		return ResponseEntity.ok(new AjaxResponse(true, "ERROR"));
	}

	@GetMapping("/profile")
	public String profile(ModelMap model) {
		return "profile";
	}

	@GetMapping("/edit-profile")
	public String editProfile(ModelMap model) {
		model.addAttribute("isEdit", true);
		return "edit-profile";
	}

	@PostMapping("/save-profile")
	public String saveProfile(ModelMap model, @RequestParam("imgAvatar") MultipartFile avatar,
			@ModelAttribute("user") User user) throws IllegalStateException, IOException {
		if (!avatar.isEmpty()) {
			user.setFile(avatar);
		}
		userService.saveUser(user);
		return "redirect:/profile";
	}

	@PostMapping("/forget-password")
	public ResponseEntity<AjaxResponse> resetPassword(@RequestBody AccountReset acc) {
		User user = userService.findUserByEmail(acc.getEmail());
		if (user != null) {
			userService.generateToken(user);
			return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
		}
		return ResponseEntity.ok(new AjaxResponse(true, "EMAIL_NO_EXISTS"));
	}

	@GetMapping("/reset-password")
	public String confirmResetPass(ModelMap model, @RequestParam("token") String token) {
		User user = userService.findUserByToken(token);
		if (user != null) {
			model.addAttribute("user", user);
			return "reset-password";
		}
		return "404";
	}

	@PostMapping("/confirm-reset")
	public ResponseEntity<AjaxResponse> confirmResetPass(@RequestBody AccountReset acc) {
		User user = userService.saveNewPassword(acc);
		if (user != null) {
			return ResponseEntity.ok(new AjaxResponse(true, "SUCCESS"));
		}
		return ResponseEntity.ok(new AjaxResponse(true, "ERROR"));
	}
}
