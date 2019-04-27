package com.team5.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team5.webapi.model.User;
import com.team5.webapi.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/user", method = { RequestMethod.GET })
	public User signup(User user) {
		User userData = userRepository.save(user);

		return userData;
	}

	@RequestMapping("/users")
	public List<User> getUsers(Model model) {
		List<User> userList = userRepository.findAll();

		return userList;
	}
}