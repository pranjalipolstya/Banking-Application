package com.springboot.applicationbanking.Controller;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.List;
import java.util.Map;

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

import com.springboot.applicationbanking.Service.AccountService;
import com.springboot.applicationbanking.dto.Accountdto;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService=accountService;
		
	}
	
	//Add account REST API
	@PostMapping
	public ResponseEntity<Accountdto> addAccount (@RequestBody Accountdto accountdto){
		return new ResponseEntity<>(accountService.createAccount(accountdto),HttpStatus.CREATED);
		
	}
	
	//Get account REST API
	@GetMapping ("/{id}")
	public ResponseEntity<Accountdto> getAccountbyId(@PathVariable Long id){
		Accountdto accountdto= accountService.getAccountById(id);
		
		return ResponseEntity.ok(accountdto);
		
	}
	
	//deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<Accountdto>deposit(@PathVariable Long id,
			                             @RequestBody Map<String, Double>request){
		
	Double amount=request.get("amount");
	
	Accountdto accountdto=accountService.deposit(id, request.get("amount"));
	
	return ResponseEntity.ok(accountdto);
		
	}
	
	//withdraw REST API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<Accountdto> withdraw(@PathVariable Long id,
			                          @RequestBody Map<String, Double>request){
		double amount= request.get("amount");
		Accountdto accountdto=accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountdto);
	}
	
	//Get all accounts REST API
	@GetMapping
	public ResponseEntity<List<Accountdto>> getAllAccounts(){
	    List<Accountdto> accounts=accountService.getAllAccounts();
	    
	    return ResponseEntity.ok(accounts);
}
	//delete account REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted successfully");
		
	}
	
}


