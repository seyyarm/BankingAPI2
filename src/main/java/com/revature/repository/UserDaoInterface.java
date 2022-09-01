package com.revature.repository;

import com.revature.services.models.User;

public interface UserDaoInterface {
	//CRUD
	//create
	User createUser(User newUser);
	
	//read
	User getUser(String username, String password);
	
	//update
	User updateUser(User updatedUser);
	
	//delete
	boolean deleteUser(User user);
	
	// get userById
	Integer getUserById();

}
