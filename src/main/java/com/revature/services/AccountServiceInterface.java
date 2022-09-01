package com.revature.services;

import com.revature.repository.DTO.AccountDTO;
import com.revature.services.models.Account;

public interface AccountServiceInterface {
	Account convertAccountDto(AccountDTO accountDto);

}
