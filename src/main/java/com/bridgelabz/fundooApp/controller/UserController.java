package com.bridgelabz.fundooApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooApp.dto.ForgetPasswordDto;
import com.bridgelabz.fundooApp.dto.LoginDto;
import com.bridgelabz.fundooApp.dto.UserDto;
import com.bridgelabz.fundooApp.response.Response;
import com.bridgelabz.fundooApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody UserDto userDto, HttpServletRequest request) {
		StringBuffer requestUrl = request.getRequestURL();
		Response response = userService.registrationUser(userDto, requestUrl);
		// response = new Response(HttpStatus.OK.value(), response.getStatusMessage(),
		// null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/login")
	public ResponseEntity<Response> loginUser(@RequestBody LoginDto loginDto) {

		Response response = userService.loginUser(loginDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/forget")
	public ResponseEntity<Response> forgotPassword(@RequestBody ForgetPasswordDto forgetPasswordDto,
			HttpServletRequest request) {
		StringBuffer requestUrl = request.getRequestURL();
		Response response = userService.forgetPassword(forgetPasswordDto, requestUrl);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/verification/{token}")
	public ResponseEntity<Response> mailValidation(@PathVariable String token) {
		Response response=userService.validateUser(token);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
}
