package com.abhishek.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
			    
	    @Id
	    @GeneratedValue
	    private Long accountId;
	    private String accountNumber;
	    private String fullName;
	    private BigDecimal balance;
	    
	    public Account() {
	    	
	    }

		public Long getAccountId() {
			return accountId;
		}

		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public BigDecimal getBalance() {
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		public Account(String accountNumber, String fullName, BigDecimal balance) {
			super();
			this.accountNumber = accountNumber;
			this.fullName = fullName;
			this.balance = balance;
		}
	    
	  
	
		
}
