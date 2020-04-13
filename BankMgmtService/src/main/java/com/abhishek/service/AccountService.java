package com.abhishek.service;

import java.math.BigDecimal;
import java.util.List;

import com.abhishek.model.Account;
import com.abhishek.model.AccountForm;
import com.abhishek.model.AccountStatement;
import com.abhishek.model.Transaction;
import com.abhishek.request.TransferBalanceRequest;
import com.abhishek.service.exception.BankTransactionException;

public interface AccountService {
	List<Account> findAll();

	Account save(Account account);

	Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);

	AccountStatement getStatement(String accountNumber);

	AccountStatement getLast10Transaction(String accountNumber);

	BigDecimal readBalance(String accountNumber) throws BankTransactionException;

	void withdrawMoney(AccountForm form) throws BankTransactionException;

	void depositMoney(AccountForm form) throws BankTransactionException;

}
