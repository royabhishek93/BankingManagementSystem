package com.abhishek.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abhishek.model.Transaction;

public interface TransactionRepository  extends CrudRepository<Transaction, Long> {
    List<Transaction> findByFromAccountEquals(String accountNumber);
    List<Transaction> findTop10ByFromAccountOrderByTransactionDateTimeDesc(String accountNumber);
}
