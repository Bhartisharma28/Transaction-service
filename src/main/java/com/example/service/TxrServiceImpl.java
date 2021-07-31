package com.example.service;

import java.util.List;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.example.entity.Account;
import com.example.entity.Txn;
import com.example.entity.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.TxnRepository;

public class TxrServiceImpl implements TxrService {
	
	private static Logger logger = Logger.getLogger("txr-system");

	private AccountRepository accountRepository;
	private TxnRepository txnRepository;

	public TxrServiceImpl(AccountRepository accountRepository,TxnRepository txnRepository ) {
		this.accountRepository = accountRepository;
		this.txnRepository=txnRepository;
	}

	public void transfer(double amount, int fromAcc, int toAcc) {

		logger.info("transaction intiated...");

		Account fromAccount = accountRepository.load(fromAcc);

		if (fromAccount == null) {
			logger.error("account not found " + fromAcc);
			throw new AccountNotFound("Not Found"+fromAcc);
		}

		Account toAccount = accountRepository.load(toAcc);

		if (toAccount == null) {
			logger.error("account not found " + toAcc);
			throw new AccountNotFound("Account Not found"+toAcc);
		}

		if (fromAccount.getBalance() < amount) {
			logger.error("no enough balance " + fromAccount.getBalance());
			throw new AccountBalanceException(fromAccount.getBalance());
		}

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		
		 txnRepository.save(amount,toAccount,"debit");
		 txnRepository.save(amount, fromAccount,"credit");
		 

		logger.info("transaction successfull ...");
		
		

	}
	
	public void getTop10Transaction(int accNum)
	{
		Account account=accountRepository.load(accNum);
		List<Txn> transactions = txnRepository.findByCount(account); 
		
		for(Txn transaction:transactions) {
			System.out.println(transaction);
		}
		
		
	}

	@Override
	public void getCurrentMonthTxr(int accNum) {
		// TODO Auto-generated method stub
		Account account=accountRepository.load(accNum);
		List<Txn> transactions = txnRepository.findCurrentMonthTxr(account); 
		
		for(Txn transaction:transactions) {
			System.out.println(transaction);
		}
		
		
	}

	@Override
	public void getLastThreeMonthTxr(int accNum) {
		// TODO Auto-generated method stub
		Account account=accountRepository.load(accNum);
		List<Txn> transactions = txnRepository.findTopThreeMonth(account); 
		
		for(Txn transaction:transactions) {
			System.out.println(transaction);
		}
		
	}

	
}
