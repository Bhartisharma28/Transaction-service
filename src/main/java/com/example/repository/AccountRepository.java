package com.example.repository;

import com.example.entity.Account;

public interface AccountRepository {
	Account load(int accNumber);
	void update(Account account);
	
}
