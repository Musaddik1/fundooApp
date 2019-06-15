
package com.bridgelabz.fundooApp.service;



import com.bridgelabz.fundooApp.dto.LoginDto;
import com.bridgelabz.fundooApp.dto.UserDto;
import com.bridgelabz.fundooApp.response.Response;

public interface UserService {

	Response registrationUser(UserDto userDto, StringBuffer requestUrl);

	Response loginUser(LoginDto loginDto);

	Response forgetPassword(String emailId,StringBuffer requestUrl);

	Response restSetPassword(String token,String password);
	
	//String validateUser(String token);
	Response validateUser(String token);
}
