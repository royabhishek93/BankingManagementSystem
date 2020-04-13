package com.abhishek.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.model.Account;
import com.abhishek.model.AccountForm;
import com.abhishek.model.AccountStatement;
import com.abhishek.model.Transaction;
import com.abhishek.repository.AccountRepository;
import com.abhishek.repository.TransactionRepository;
import com.abhishek.request.TransferBalanceRequest;
import com.abhishek.service.AccountService;
import com.abhishek.service.exception.BankTransactionException;

import java.sql.Timestamp;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account save(Account account) {
		accountRepository.save(account);
		return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
	}

	public Account findByAccountNumber(String accountNumber) {
		Account account = accountRepository.findByAccountNumberEquals(accountNumber);
		return account;
	}

	@Override
	public synchronized Transaction sendMoney(TransferBalanceRequest transferBalanceRequest) {
		String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
		String toAccountNumber = transferBalanceRequest.getToAccountNumber();
		BigDecimal amount = transferBalanceRequest.getAmount();
		Account fromAccount = accountRepository.findByAccountNumberEquals(fromAccountNumber);
		Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
		if (fromAccount.getBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getBalance().compareTo(amount) == 1) {
			fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
			accountRepository.save(fromAccount);
			toAccount.setBalance(toAccount.getBalance().add(amount));
			accountRepository.save(toAccount);
			Transaction transaction = transactionRepository.save(new Transaction(0L, "BANK_TRANSFER", fromAccountNumber,
					toAccountNumber, amount, new Timestamp(System.currentTimeMillis())));
			return transaction;
		}
		return null;
	}

	@Override
	public synchronized AccountStatement getStatement(String accountNumber) {
		Account account = accountRepository.findByAccountNumberEquals(accountNumber);
		return new AccountStatement(account.getBalance(), transactionRepository.findByFromAccountEquals(accountNumber));

	}

	@Override
	public AccountStatement getLast10Transaction(String accountNumber) {
		Account account = accountRepository.findByAccountNumberEquals(accountNumber);
		return new AccountStatement(account.getBalance(),
				transactionRepository.findTop10ByFromAccountOrderByTransactionDateTimeDesc(accountNumber));

	}

	@Override
	public synchronized void depositMoney(AccountForm form) throws BankTransactionException {
		Account account = accountRepository.findByAccountNumberEquals(form.getAccountNumber());

		if (account == null) {
			throw new BankTransactionException("Account_NOT_FOUND " + form.getAccountNumber());
		}

		if (account.getBalance().compareTo(BigDecimal.ONE) == 1
				&& account.getBalance().compareTo(form.getAmount()) == 1) {
			account.setBalance(account.getBalance().add(form.getAmount()));
			accountRepository.save(account);
			Transaction transaction = transactionRepository.save(new Transaction(0L, "DEPOSIT",
					form.getAccountNumber(), form.getAmount(), new Timestamp(System.currentTimeMillis())));

		}
	}

	@Override
	public synchronized BigDecimal readBalance(String accountNumber) throws BankTransactionException {
		Account account = accountRepository.findByAccountNumberEquals(accountNumber);
		if (account == null) {
			throw new BankTransactionException("Account_NOT_FOUND " + accountNumber);
		}
		return account.getBalance();
	}

	@Override
	public synchronized void withdrawMoney(AccountForm form) throws BankTransactionException {
		Account account = accountRepository.findByAccountNumberEquals(form.getAccountNumber());

		if (account == null) {
			throw new BankTransactionException("Account_NOT_FOUND " + form.getAccountNumber());
		}

		if (account.getBalance().compareTo(BigDecimal.ONE) == 1
				&& account.getBalance().compareTo(form.getAmount()) == 1) {
			account.setBalance(account.getBalance().subtract(form.getAmount()));
			accountRepository.save(account);
			Transaction transaction = transactionRepository.save(new Transaction(0L, "WITHDRAW",
					form.getAccountNumber(), form.getAmount(), new Timestamp(System.currentTimeMillis())));

		}

	}

}
