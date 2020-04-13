package com.abhishek.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;
    private String fromAccount;
    private BigDecimal  transactionAmount;
    private String toAccount;
	private Timestamp transactionDateTime;
	private String transferType;

    public Transaction() {
	}

	public Transaction(Long transactionId, String transferType,String fromAccount, String toAccount,BigDecimal transactionAmount, 
			Timestamp transactionDateTime) {
		
		this.transactionId = transactionId;
		this.transferType=transferType;
		this.fromAccount = fromAccount;
		this.toAccount=toAccount;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
	}

	
	public Transaction(Long transactionId, String transferType, String fromAccount, BigDecimal transactionAmount,
			Timestamp transactionDateTime) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
		this.transferType = transferType;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Timestamp transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

    
    
    

}
