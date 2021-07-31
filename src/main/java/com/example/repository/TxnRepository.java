package com.example.repository;

import java.time.LocalDate;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.example.database.*;


import com.example.entity.*;


public interface TxnRepository {
	
	
	

	List<Txn> findByCount(Account account);
	List<Txn> findCurrentMonthTxr(Account account);
	List<Txn>findTopThreeMonth( Account account);



	void save(double amount, Account toAccount, String type);

}
