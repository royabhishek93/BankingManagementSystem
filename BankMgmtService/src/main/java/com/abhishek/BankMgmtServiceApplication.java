package com.abhishek;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.abhishek.model.Account;
import com.abhishek.model.Transaction;
import com.abhishek.repository.AccountRepository;
import com.abhishek.repository.TransactionRepository;

@SpringBootApplication
@EnableEurekaClient
public class BankMgmtServiceApplication {

		public static void main(String[] args) {
			SpringApplication.run(BankMgmtServiceApplication.class, args);
		}
		@Bean
	    public CommandLineRunner insertCustomerDetails(AccountRepository bankAccountRepository,TransactionRepository transactionRepository) {
	        return (args) -> {

	        	bankAccountRepository.save(new Account("111","Abhishek",new BigDecimal(5000)));
	        	bankAccountRepository.save(new Account("222","Remo",new BigDecimal(10000)));
	        	bankAccountRepository.save(new Account("333","Jagjeet",new BigDecimal(15000)));
	        	bankAccountRepository.save(new Account("444","Kapil",new BigDecimal(25000)));
	        	
	        	transactionRepository.save(new Transaction(0L, "WITHDRAW",
						"333", new BigDecimal(200), new Timestamp(System.currentTimeMillis())));
	         	transactionRepository.save(new Transaction(0L, "WITHDRAW",
						"333", new BigDecimal(450), new Timestamp(System.currentTimeMillis())));
	         	transactionRepository.save(new Transaction(0L, "WITHDRAW",
						"333", new BigDecimal(999), new Timestamp(System.currentTimeMillis())));
	         	 transactionRepository.save(new Transaction(0L, "BANK_TRANSFER", "333",
		 					"111", new BigDecimal(889), new Timestamp(System.currentTimeMillis())));
	         	transactionRepository.save(new Transaction(0L, "DEPOSIT",
	        			"333", new BigDecimal(100), new Timestamp(System.currentTimeMillis())));
	        	transactionRepository.save(new Transaction(0L, "DEPOSIT",
	        			"333", new BigDecimal(1111), new Timestamp(System.currentTimeMillis())));
	        	 transactionRepository.save(new Transaction(0L, "BANK_TRANSFER", "333",
		 					"444", new BigDecimal(320), new Timestamp(System.currentTimeMillis())));
	         	transactionRepository.save(new Transaction(0L, "WITHDRAW",
						"333", new BigDecimal(2250), new Timestamp(System.currentTimeMillis())));
	        	transactionRepository.save(new Transaction(0L, "DEPOSIT",
	        			"333", new BigDecimal(350), new Timestamp(System.currentTimeMillis())));
	        	transactionRepository.save(new Transaction(0L, "DEPOSIT",
	        			"333", new BigDecimal(777), new Timestamp(System.currentTimeMillis())));
	        	
	        	 transactionRepository.save(new Transaction(0L, "BANK_TRANSFER", "333",
	 					"444", new BigDecimal(333), new Timestamp(System.currentTimeMillis())));
	        	 transactionRepository.save(new Transaction(0L, "BANK_TRANSFER", "333",
		 					"444", new BigDecimal(99), new Timestamp(System.currentTimeMillis())));
	        	
	            };
	    }
	
}
