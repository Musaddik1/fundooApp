package com.bridgelabz.fundooApp.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooApp.dto.LoginDto;
import com.bridgelabz.fundooApp.dto.UserDto;
import com.bridgelabz.fundooApp.model.User;
import com.bridgelabz.fundooApp.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody UserDto userDto)
	{
		return userServiceImpl.registrationUser(userDto);
	}
	@GetMapping("/login")
	public String loginUser(@RequestBody LoginDto loginDto)
	{
		
		return userServiceImpl.loginUser(loginDto);
	}
	@GetMapping("/forget")
	public User forgotPassword(@RequestParam String emailId)
	{
		return userServiceImpl.forgetPassword(emailId);
	}
	@RequestMapping("/verification/{verify}")
	public String mailValidation(@PathVariable String verify)
	{
		return "Account Verified";
	}
}
