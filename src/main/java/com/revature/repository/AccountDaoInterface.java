package com.revature.repository;

import java.util.List;

import com.revature.repository.DTO.AccountDTO;
import com.revature.services.models.User;

public interface AccountDaoInterface {
	
	//CRUD
	
	AccountDTO selectAccountById(Integer accountId);
	public void selectNoActiveAccount();
	public void selectActiveAccount();
	List <AccountDTO> selectAllAccount();
	
	//get accountId
	
	//UPDATE
	//withdraw function
	public void withdraw(Integer userId, Integer accountId, Integer transacType);
	//Deposit function
	public void deposit(Integer userId, Integer accountId, Integer transacType);
	
	//Apply to open Account
	public void openAccount(Integer userId);
	
	//approve open account
	//public void approvAccount(int userId);
	
	//deny open account

}
