package com.team5.webapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team5.webapi.model.habit_register;
import com.team5.webapi.repository.habitRegisterRepository;

@RestController
public class habitRegisterController {
	@Autowired
	private habitRegisterRepository habitRegisterRepository;
	
	@RequestMapping(value = "/habit_register", method = { RequestMethod.GET })
	public habit_register signup(habit_register habit_register) {
		habit_register habit_registerData = habitRegisterRepository.save(habit_register);

		return habit_registerData;
	}

	@RequestMapping("/habit_registers")
	public List<habit_register> gethabit_register(Model model) {
		List<habit_register> habit_registerList = habitRegisterRepository.findAll();

		return habit_registerList;
	}
}
