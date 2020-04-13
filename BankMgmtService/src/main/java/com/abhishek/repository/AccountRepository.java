package com.abhishek.repository;

import org.springframework.data.repository.CrudRepository;

import com.abhishek.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
    Account findByAccountNumberEquals(String accountNumber);

}
