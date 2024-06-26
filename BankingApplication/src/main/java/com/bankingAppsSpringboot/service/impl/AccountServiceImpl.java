package com.bankingAppsSpringboot.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankingAppsSpringboot.dto.AccountDto;
import com.bankingAppsSpringboot.entity.Account;
import com.bankingAppsSpringboot.mapper.AccountMapper;
import com.bankingAppsSpringboot.reporsitory.AccountRepo;
import com.bankingAppsSpringboot.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposite(Long id, double ammount) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exist"));
		double totalBalance = account.getBalance() + ammount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepo.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double ammount) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exist"));
		if (account.getBalance() < ammount) {
			throw new RuntimeException("Insuficient balance");
		}
		double totalBalnce = account.getBalance() - ammount;
		account.setBalance(totalBalnce);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccount() {
		return accountRepo.findAll().stream().map((account) -> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does not Exist"));
		accountRepo.delete(account);
	}

}
