
package com.bridgelabz.fundooApp.service;


import com.bridgelabz.fundooApp.dto.ForgetPasswordDto;
import com.bridgelabz.fundooApp.dto.LoginDto;
import com.bridgelabz.fundooApp.dto.UserDto;
import com.bridgelabz.fundooApp.model.User;
import com.bridgelabz.fundooApp.response.Response;

public interface UserService {

	Response registrationUser(UserDto userDto, StringBuffer requestUrl);

	Response loginUser(LoginDto loginDto);

	Response forgetPassword(ForgetPasswordDto forgetPasswordDto,StringBuffer requestUrl);

	User restSetPassword(String token, ForgetPasswordDto forgetPasswordDto);
	
	//String validateUser(String token);
	Response validateUser(String token);
}
