package com.bankingAppsSpringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankingAppsSpringboot.dto.AccountDto;

@Service
public interface AccountService {
	AccountDto createAccount(AccountDto account);

	AccountDto getAccountById(Long id);

	AccountDto deposite(Long id, double ammount);

	AccountDto withdraw(Long id, double ammount);

	List<AccountDto> getAllAccount();

	void deleteAccount(Long id);
}
