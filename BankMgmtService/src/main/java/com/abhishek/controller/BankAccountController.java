package com.abhishek.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abhishek.model.Account;
import com.abhishek.model.AccountForm;
import com.abhishek.request.AccountStatementRequest;
import com.abhishek.request.TransferBalanceRequest;
import com.abhishek.response.ApiResponse;
import com.abhishek.service.AccountService;
import com.abhishek.service.exception.BankTransactionException;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BankAccountController {

	@Autowired
	private AccountService accountService;

	// Create a Savings Account
	@PostMapping("/createAccount")
	public List<Account> create(@RequestBody Account account) {
		accountService.save(account);
		return accountService.findAll();
	}

	// Get Account All Details
	@GetMapping("/getAllAccounts")
	public List<Account> all() {
		return accountService.findAll();
	}

	// Transfer Money From Account to Another
	@PostMapping("/sendmoney")
	public ApiResponse sendMoney(@RequestBody TransferBalanceRequest transferBalanceRequest) {

		return ApiResponse.ok().setPayload(accountService.sendMoney(transferBalanceRequest));
	}

	// List last 10 transactions of the Account
	@GetMapping("/get10Transaction/{accountNumber}")
	public ApiResponse getStatement(@PathVariable String accountNumber) {
		return ApiResponse.ok()
				.setPayload(accountService.getLast10Transaction(accountNumber));

	}

	// Read Available Balance
	@GetMapping(value = "/checkBalance/{accountNumber}")
	public BigDecimal readBalance(@PathVariable String accountNumber) {
		try {
			return accountService.readBalance(accountNumber);
		} catch (BankTransactionException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BigDecimal(0);
	}

	// Deposit to Account
	@PostMapping(value = "/depositMoney")
	public void depositMoney(@RequestBody AccountForm form) {
		try {
			accountService.depositMoney(form);
		} catch (BankTransactionException e) {

		}
	}

	// Withdraw Money from Account
	@PostMapping(value = "/withdrawMoney")
	public void withdrawMoney(@RequestBody AccountForm form) {
		try {
			accountService.withdrawMoney(form);
		} catch (BankTransactionException e) {

		}
	}

}
