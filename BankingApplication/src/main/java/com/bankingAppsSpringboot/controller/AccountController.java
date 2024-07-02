package com.bankingAppsSpringboot.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingAppsSpringboot.dto.AccountDto;
import com.bankingAppsSpringboot.service.AccountService;

@RestController
@RequestMapping("api/accounts")
//@RequiredArgsConstructor       If you take this annotation then remove the line number of 28 to 31
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	// add account restAPi
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		try {
			logger.info("Received request to add account: {}", accountDto);
			AccountDto createdAccount = accountService.createAccount(accountDto);
			logger.info("Account created: {}", createdAccount);
			return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error adding account: {}", accountDto, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		try {
			logger.info("Received request to get account by id: {}", id);
			AccountDto accountDto = accountService.getAccountById(id);
			logger.info("Retrieved account: {}", accountDto);
			return ResponseEntity.ok(accountDto);
		} catch (Exception e) {
			logger.error("Error retrieving account with id: {}", id, e);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		try {
			logger.info("Received request to deposit {} to account id: {}", amount, id);
			AccountDto accountDto = accountService.deposite(id, amount);
			logger.info("Deposited amount: {}. Updated account: {}", amount, accountDto);
			return ResponseEntity.ok(accountDto);
		} catch (Exception e) {
			logger.error("Error depositing amount: {} to account id: {}", amount, id, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		try {
			logger.info("Received request to withdraw {} from account id: {}", amount, id);
			AccountDto accountDto = accountService.withdraw(id, amount);
			logger.info("Withdrawn amount: {}. Updated account: {}", amount, accountDto);
			return ResponseEntity.ok(accountDto);
		} catch (Exception e) {
			logger.error("Error withdrawing amount: {} from account id: {}", amount, id, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		try {
			logger.info("Received request to get all accounts");
			List<AccountDto> accountDtoList = accountService.getAllAccount();
			logger.info("Retrieved all accounts");
			return ResponseEntity.ok(accountDtoList);
		} catch (Exception e) {
			logger.error("Error retrieving all accounts", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		try {
			logger.info("Received request to delete account id: {}", id);
			accountService.deleteAccount(id);
			logger.info("Deleted account id: {}", id);
			return ResponseEntity.ok("Account deleted successfully");
		} catch (Exception e) {
			logger.error("Error deleting account with id: {}", id, e);
			return new ResponseEntity<>("Failed to delete account", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
