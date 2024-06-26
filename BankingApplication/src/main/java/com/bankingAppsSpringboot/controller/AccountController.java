package com.bankingAppsSpringboot.controller;

import java.util.List;
import java.util.Map;

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
public class AccountController {
	@Autowired
	private AccountService accountService;
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	//add account restAPi
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/{id}/deposite")
	public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String, Double > request){
		Double ammount = request.get("ammount");
		AccountDto accountDto = accountService.deposite(id, ammount);
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double > request){
		Double ammount = request.get("ammount");
		AccountDto accountDto = accountService.withdraw(id, ammount);
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountDto = accountService.getAllAccount();
		return ResponseEntity.ok(accountDto);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted succesfully");
	}


}
