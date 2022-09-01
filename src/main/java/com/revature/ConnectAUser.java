package com.revature;

import java.util.Scanner;

import com.revature.controller.UserController;
import com.revature.repository.UserDao;
import com.revature.repository.UserDaoInterface;
import com.revature.services.LoginService;

public class ConnectAUser {
	
	public Integer connectNewUser() {
		UserDaoInterface uDao = new UserDao();
		LoginService loginService = new LoginService(uDao);
		UserController userController = new UserController(new Scanner(System.in), loginService);
		Integer userId = 0;
		userId = userController.login();
		return userId;
	}
	
	public ConnectAUser() {
		//connectNewUser();
	}

}
