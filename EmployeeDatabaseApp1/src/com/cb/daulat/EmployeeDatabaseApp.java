package com.cb.daulat;

import java.util.Scanner;

public class EmployeeDatabaseApp extends AppServiceImp{
	static AppServiceImp app = new AppServiceImp();

		public static void main(String[] args) {
	    	try (Scanner sc = new Scanner(System.in)) {
	            while (true) {
	                System.out.println("\n=== Employee Database ===");
	                System.out.println("1. Add Employee");
	                System.out.println("2. View Employees");
	                System.out.println("3. Update Employee");
	                System.out.println("4. Delete Employee");
	                System.out.println("5. Exit");
	                System.out.print("Enter choice: ");
	                int choice = sc.nextInt();

	                switch (choice) {
	                    case 1 -> app.addEmployee(sc);
	                    case 2 -> app.viewEmployees();
	                    case 3 -> app.updateEmployee(sc);
	                    case 4 -> app.deleteEmployee(sc);
	                    case 5 -> {
	                        System.out.println("Exiting...");
	                        return;
	                    }
	                    default -> System.out.println("Invalid choice!");
	                }
	            }
	    	}catch (Exception ex) {
	            System.out.println("Invalid input. Please enter valid input.");
	    	}
	    }
	}
	            
	        
	    

	   