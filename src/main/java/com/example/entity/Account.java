package com.example.entity;

public class Account {

	private int num;
	
    private double balance;

	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(int num, double balance) {
		super();
		this.num = num;
		this.balance = balance;
		
	}
	
	public Account() {}
	
	
}
