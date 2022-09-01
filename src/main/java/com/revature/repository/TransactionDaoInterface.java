package com.revature.repository;

public interface TransactionDaoInterface {
	
	//CRUD
	public void insertTransaction(int transactAmmount, Integer accountId, Integer transacType);

}
