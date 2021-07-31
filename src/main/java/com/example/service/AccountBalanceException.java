package com.example.service;

public class AccountBalanceException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountBalanceException(double balance) {
		super(String.valueOf(balance));
	}

}
