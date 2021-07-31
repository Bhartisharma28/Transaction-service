package com.example.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.sql.rowset.spi.TransactionalWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import com.example.database.*;
import java.sql.*;
import java.time.LocalDateTime;

import com.example.entity.*;
public class TxnRepositoryImpl  implements TxnRepository{
	Txn txn;



	
	
		// TODO Auto-generated method stub
		public void save (double amount, Account account, String type) {
			Connection connection = null;
			try {
				connection = ConnectionFactory.getConnection();
				Timestamp myDate= Timestamp.valueOf(LocalDateTime.now());
	
				String sql = "insert into transaction(account_no,time_stamp,amount,txn_type) values(?, ?, ?,?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setDouble(1,account.getNum());
				ps.setTimestamp(2, myDate);
				ps.setDouble(3,amount);
				if(type.equals("credit"))
					ps.setString(4,TxnType.CREDIT.toString());
				else
					ps.setString(4,TxnType.DEBIT.toString());
				
			ps.execute();
			System.out.println("Transaction Updated......");
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	}
	

	

	public List<Txn> findByCount( Account account) {
		// TODO Auto-generated method stub
		List<Txn> transactions = new ArrayList<>();

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			String sql = "select * from transaction where account_no= ? LIMIT 10" ;
			PreparedStatement ps = connection.prepareStatement(sql);
		     ps.setInt(1,account.getNum());
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Txn transaction = new Txn();
			
		        transaction.setAccount(account);
		       
				transaction.setAmount(rs.getDouble(3));
				transaction.setType(TxnType.valueOf(rs.getString(5)));
                transaction.setTransaction_id(rs.getInt(4));
				transaction.settime_stamp(rs.getTimestamp(2));	
				transactions.add(transaction);
				
			}
			
			System.out.println("Top 10 transactions");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return transactions;
		
		
	}

	public List<Txn> findCurrentMonthTxr( Account account) {
		
		// TODO Auto-generated method stub
		List<Txn> transactions = new ArrayList<>();

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			String sql = "select * from transaction where account_no= ? and MONTH(time_stamp)=MONTH(now()) and YEAR(time_stamp)=YEAR(now()) " ;
			PreparedStatement ps = connection.prepareStatement(sql);
		     ps.setInt(1,account.getNum());
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Txn transaction = new Txn();
			
		        transaction.setAccount(account);
		       
				transaction.setAmount(rs.getDouble(3));
				transaction.setType(TxnType.valueOf(rs.getString(5)));
                transaction.setTransaction_id(rs.getInt(4));
				transaction.settime_stamp(rs.getTimestamp(2));	
				transactions.add(transaction);
				
			}
			
			System.out.println("Current month transactions");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return transactions;
		
		
		
	}

	public List<Txn> findTopThreeMonth( Account account) {
		// TODO Auto-generated method stub
		List<Txn> transactions = new ArrayList<>();

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

			String sql = "select * from transaction where account_no= ? and MONTH(time_stamp)>=MONTH(now())-3 and YEAR(time_stamp)=YEAR(now()) " ;
			PreparedStatement ps = connection.prepareStatement(sql);
		     ps.setInt(1,account.getNum());
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Txn transaction = new Txn();
			
		        transaction.setAccount(account);
		       
				transaction.setAmount(rs.getDouble(3));
				transaction.setType(TxnType.valueOf(rs.getString(5)));
                transaction.setTransaction_id(rs.getInt(4));
				transaction.settime_stamp(rs.getTimestamp(2));	
				transactions.add(transaction);
				
			}
			
			System.out.println(" Last three month transactions");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return transactions;
	}


	

	}



