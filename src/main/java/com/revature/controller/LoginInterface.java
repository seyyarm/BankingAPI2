package com.revature.controller;

import com.revature.services.models.User;

public interface LoginInterface {
	//valid user input
	Integer login();
	User validateLogin(String username, String password);

}
