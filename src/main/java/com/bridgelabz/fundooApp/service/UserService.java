
package com.bridgelabz.fundooApp.service;

import javax.servlet.http.HttpServlet;

import com.bridgelabz.fundooApp.dto.ForgetPasswordDto;
import com.bridgelabz.fundooApp.dto.LoginDto;
import com.bridgelabz.fundooApp.dto.UserDto;
import com.bridgelabz.fundooApp.model.Response;
import com.bridgelabz.fundooApp.model.User;

public interface UserService {

	User registrationUser(UserDto userDto);
	String loginUser(LoginDto loginDto);
	User forgetPassword(String password);
	User restSetPassword(String token,ForgetPasswordDto forgetPasswordDto);
}
