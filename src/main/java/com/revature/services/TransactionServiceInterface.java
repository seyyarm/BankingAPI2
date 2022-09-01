package com.revature.services;


import com.revature.repository.DTO.TransactionDTO;
import com.revature.services.models.Transaction;

public interface TransactionServiceInterface {
	Transaction convertTransactionDto(TransactionDTO transactionDto);

}
