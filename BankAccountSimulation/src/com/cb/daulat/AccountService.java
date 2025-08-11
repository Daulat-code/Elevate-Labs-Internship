package com.cb.daulat;

public interface AccountService {
	
	public void deposit(Account acc,double amount);
	
	public void withdraw(Account acc,double amount);
	
	public void checkBalance(Account acc);
	
	public void showTransactionHistory(Account acc);

}
