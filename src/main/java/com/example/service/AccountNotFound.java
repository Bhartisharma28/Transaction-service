package com.example.service;



public class AccountNotFound extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFound(String account_id) {
		super(account_id);
	
		

}
}
