package com.cb.daulat;
import java.util.Scanner;

public class StudentRecordManagementSystem{
	private static Scanner scanner = new Scanner(System.in);
	private static StudentServiceImp s = new StudentServiceImp();

	public static void main(String[] args) {
		        boolean running = true;

		        while (running) {
		            System.out.println("\n====== Student Management System ======");
		            System.out.println("1. Add Student");
		            System.out.println("2. View Students");
		            System.out.println("3. Update Student");
		            System.out.println("4. Delete Student");
		            System.out.println("5. Exit");
		            
		            System.out.print("Enter your choice: ");

		            int choice;
		            try {
		                choice = Integer.parseInt(scanner.nextLine());
		            } catch (NumberFormatException ex) {
		                System.out.println("Invalid input. Please enter a number.");
		                continue;
		            }

		            switch (choice) {
		                case 1:
		                    s.addStudent();
		                    break;
		                case 2:
		                    s.viewStudents();
		                    break;
		                case 3:
		                    s.updateStudent();
		                    break;
		                case 4:
		                    s.deleteStudent();
		                    break;
		                case 5:
		                    running = false;
		                    System.out.println("Exiting... Goodbye!");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Try again.");
		            }
		        }
		    }

	}
