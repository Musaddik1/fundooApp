package com.bridgelabz.fundooApp.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooApp.dto.ForgetPasswordDto;
import com.bridgelabz.fundooApp.dto.LoginDto;
import com.bridgelabz.fundooApp.dto.UserDto;
import com.bridgelabz.fundooApp.model.Email;
import com.bridgelabz.fundooApp.model.User;
import com.bridgelabz.fundooApp.repository.UserRepository;
import com.bridgelabz.fundooApp.utility.EncryptUtil;
import com.bridgelabz.fundooApp.utility.MailUtil;
import com.bridgelabz.fundooApp.utility.TokenUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	MailUtil mailsender;
	Email email = new Email();
	@Override
	public User registrationUser(UserDto userDto ) {

		boolean ismail = userRepository.findByEmailId(userDto.getEmailId()).isPresent();
		String token = null;
		if (!ismail) 
		{
			userDto.setPassword(encoder.encode(userDto.getPassword()));
			User user = mapper.map(userDto, User.class);
			
			try {
				token = TokenUtil.generateToken(user.getUserid());
				System.out.println(token);
				 userRepository.save(user);
				 mailValidation(token,user);

					email.setTo("musaddikshaikh10@gmail.com");
					email.setSubject("Account verification");
					email.setBody("http://localhost:8080/verification/"+user.getToken());
					email.getBody();
					
					mailsender.send(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		
		
			return user;
		} else
		{
			System.out.println("User already present...");
			return null;
		}
	}
	
	public String mailValidation(String token,User user) throws IllegalArgumentException, UnsupportedEncodingException
	{
		

			String id = TokenUtil.verifyToken(token);
			 
			
			boolean present=userRepository.findByUserid(user.getUserid()).isPresent();
			if(present)
			{
				System.out.println("Account verified...");
				
				user.setToken(token);
				user.setVerified(true);
				
				userRepository.save(user);
				
			System.out.println("data saved into database..");
			}
			else
			{
				System.out.println("not verified..");
			}
		
		return "";
	}
	@Override
	public String loginUser(LoginDto loginDto) {

	
		boolean isemail = userRepository.findByEmailId(loginDto.getEmailId()).isPresent();
		
		User user = userRepository.findByEmailId(loginDto.getEmailId()).get();
		boolean ispassword = EncryptUtil.isPassword(loginDto, user);
		if (isemail && ispassword) {

			System.out.println("login successfully...");
			return "Welcome";
		} else {
			System.out.println("Invalid email or password");
			return null;
		}
	}

	@Override
	public User forgetPassword(String emailId) {

		boolean isemail=userRepository.findByEmailId(emailId).isPresent();
		User user=userRepository.findByEmailId(emailId).get();
		String token=user.getToken();
		
		/*
		 * boolean isemail = userRepository.findByEmailId(emailId).isPresent(); if
		 * (isemail) { email.setTo("musaddikshaikh10@gmail.com");
		 * email.setSubject("forgot"); email.setBody("localhost:8080/restSetPassword");
		 * mailsender.send(email); return null; } else {
		 * System.out.println("Invalid email "); return null; }
		 */
		return null;
	}

	@Override
	public User restSetPassword(String token, ForgetPasswordDto forgetPasswordDto) {

		return null;
	}

}
