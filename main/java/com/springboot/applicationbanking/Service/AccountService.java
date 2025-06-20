package com.springboot.applicationbanking.Service;

import java.util.List;

import com.springboot.applicationbanking.dto.Accountdto;

public interface AccountService {

	Accountdto createAccount(Accountdto accountdto);
	
	Accountdto getAccountById(Long id);
	
	Accountdto deposit(Long id, double amount);
	
	Accountdto withdraw(Long id, double amount);
	
	List<Accountdto> getAllAccounts();
	
	void deleteAccount(Long id);
}
