package com.example.service;

public interface TxrService {
	
	void transfer(double amount, int fromAcc, int toAcc);
	
	void getTop10Transaction(int accNum);
	
	void getCurrentMonthTxr(int accNum);
	void getLastThreeMonthTxr(int accNum);

}

