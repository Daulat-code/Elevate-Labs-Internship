package com.cb.daulat;

public class AccountServiceImp implements AccountService {
	
	@Override
    public void deposit(Account account, double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposited successfully: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.println("Withdrawn successfully: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public void checkBalance(Account account) {
        System.out.println("Current balance: " + account.getBalance());
    }

    @Override
    public void showTransactionHistory(Account account) {
        System.out.println("\n--- Transaction History ---");
        for (String record : account.getTransactionHistory()) {
            System.out.println(record);
        }
    }

}
