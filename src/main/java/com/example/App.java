package com.example;

import java.util.Scanner;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;
import com.example.repository.TxnRepository;
import com.example.repository.TxnRepositoryImpl;
import java.util.*;

import com.example.entity.*;

public class App {

	public static void main(String[] args) {

		AccountRepository accountRepository = new JdbcAccountRepository();
		TxnRepository txnRepository=new TxnRepositoryImpl();
		TxrService txrService = new TxrServiceImpl(accountRepository,txnRepository);
		
		
		
		
		TxnRepositoryImpl txn=new TxnRepositoryImpl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter from account number");
		int account1=sc.nextInt();
		
		System.out.println("Enter to account number");
		int account2=sc.nextInt();
		
		System.out.println("Enter amount you want to transfer");
		double amt=sc.nextDouble();
		
		
		
		
		

		txrService.transfer(amt, account1, account2);
		txrService.getTop10Transaction(account1);
		txrService.getTop10Transaction(account2);
		
		txrService.getCurrentMonthTxr(account1);
		txrService.getCurrentMonthTxr(account2);
		
		txrService.getLastThreeMonthTxr(account1);
		txrService.getLastThreeMonthTxr(account2);
		
		
		
		
	     
		

	}

}