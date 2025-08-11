package com.cb.daulat;

import java.util.Scanner;

public class BankAccountSimulation {	

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
	
	        // Create a sample account
	        System.out.print("Enter Account Number: ");
	        String accNum = sc.nextLine();
	
	        System.out.print("Enter Account Holder Name: ");
	        String accHolder = sc.nextLine();
	
	        System.out.print("Enter Initial Balance: ");
	        double initBal = sc.nextDouble();
	
	        AccountServiceImp serviceImp = new AccountServiceImp();
	        Account account = new Account(accNum, accHolder, initBal);
	
	        int choice;
	        
	        do {
	            System.out.println("\n--- Bank Menu ---");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Transaction History");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();
	
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter deposit amount: ");
	                    serviceImp.deposit(account, sc.nextDouble());
	                    break;
	                case 2:
	                    System.out.print("Enter withdraw amount: ");
	                    serviceImp.withdraw(account, sc.nextDouble());
	                    break;
	                case 3:
	                	serviceImp.checkBalance(account);
	                    break;
	                case 4:
	                	serviceImp.showTransactionHistory(account);
	                    break;
	                case 5:
	                    System.out.println("Thank you for banking with us!");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 5);
	
	        sc.close();
		}catch (Exception ex) {
            System.out.println("Invalid input. Please enter valid input.");
		}
		
	}

}
