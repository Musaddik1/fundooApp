package com.bridgelabz.fundooApp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration

public class UserConfiguration {

	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new  BCryptPasswordEncoder();
	}
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	
	
}
