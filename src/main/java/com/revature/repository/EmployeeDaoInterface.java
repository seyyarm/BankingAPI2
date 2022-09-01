package com.revature.repository;


//import java.util.ArrayList;
import java.util.List;

import com.revature.repository.DTO.EmployeeDTO;

public interface EmployeeDaoInterface {
	//CRUD
	
	EmployeeDTO selectEmployeeById(Integer employeeId);
	List <EmployeeDTO> selectEmployee();
	
	//display all customers account and balances
	public void displayCustomersAccountBalance(Integer userId);
	
	//Approve Account
	public void approveAccount(Integer accountId, Integer userId);
	//Deny Account
	public void denyAccount(Integer accountId, Integer userId);
	
	//canceling account
	public void deleteAccount(Integer accountId);

}
