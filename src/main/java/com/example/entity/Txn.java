package com.example.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Timestamp;
public class Txn {
	
	
	private int transaction_id;
	private double amount;
	private LocalDateTime dateTime;
	private TxnType type;
	private Account account;
	
	@Override
	public String toString() {
		return "Txn [transaction_id=" + transaction_id + ", amount=" + amount + ", dateTime=" + dateTime + ", type="
				+ type + ", account=" + account + "]";
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public Txn(double amount, LocalDateTime dateTime, TxnType type) {
		super();
		this.amount = amount;
		this.dateTime = dateTime;
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	
	
	public Txn() {}

	public void settime_stamp(Timestamp timestamp) {
		// TODO Auto-generated method stub
		
	}

}
