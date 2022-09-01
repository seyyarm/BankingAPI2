package com.revature.controller;

import java.util.Scanner;

import com.revature.services.LoginService;
import com.revature.services.models.User;

public class UserController implements UserInputInterface, LoginInterface {
	private Scanner sc;
	private LoginService loginService;
	
	public UserController(Scanner sc, LoginService loginService) {
		super();
		this.sc = sc;
		this.loginService = loginService;
	}

	@Override
	public User validateLogin(String username, String password) {
		if (username == null && password == null) {
			return null;
		}
		User user = loginService.login(username, password);
		return user;
	}

	@Override
	public String getUserInput() {
		System.out.println("Hello please input something!");
		return sc.nextLine();
	}

	@Override
	public Integer login() {
		System.out.println("Please login by typing your username and password \n");
		String username = getUserInput();
		String password = getUserInput();
		User user = validateLogin(username, password);
		
		Integer i = 0;
		
		if(user != null) {
			System.out.println("Successful login!");
			int userType = user.getUser_type_id();
			if (userType == 1)
				System.out.println("Hello Customer :" + user.getFullname());
			if (userType == 2)
				System.out.println("Hello Employee :" + user.getFullname());
			if (userType == 3)
				System.out.println("Hello Bank Admin :" + user.getFullname());
			
			System.out.println(user);
			i =  user.getUserid();
		}else {
			System.out.println("Failed login!");
		}
		return i;
	}

}
