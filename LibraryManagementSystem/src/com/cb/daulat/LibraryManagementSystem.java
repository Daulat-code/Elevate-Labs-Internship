package com.cb.daulat;

import com.cb.daulat.entity.Book;
import java.util.Scanner;

import com.cb.daulat.entity.User;
import com.cb.daulat.service.imp.LibraryServiceImp;
import com.cb.daulat.service.imp.UserServiceImp;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		
	
		Scanner scanner = new Scanner(System.in);
		LibraryServiceImp library = new LibraryServiceImp();
		UserServiceImp user = new UserServiceImp();

        while (true) {
            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Add Book");
            System.out.println("2. Add user");
            System.out.println("3. Show Books");
            System.out.println("4. Show users");
            System.out.println("5. Find book");
            System.out.println("6. Find user");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Issued Book");
            System.out.println("9. Borrow Book");
            System.out.println("10. Return borrowedBook");
            System.out.println("11. Exit");
            
            System.out.print("\nChoose: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            

            switch (choice) {
	            case 1:
	            	System.out.print("Create Book ID: ");
	            	String bookId = scanner.nextLine();
	            	System.out.print("Enter Book Name: ");
	            	String bookName = scanner.nextLine();
	            	System.out.print("Enter Auther Name: ");
	            	String autherName = scanner.nextLine();
	            	library.addBook(new Book(bookId, bookName,autherName));
	                break;
	            case 2:
	            	System.out.print("Enter User ID: ");
	            	int userId = Integer.parseInt(scanner.nextLine());
	            	System.out.print("Enter User Name: ");
	            	String userName = scanner.nextLine();
	            	user.addUser(new User(userId, userName));
	                break;
	            case 3:
                    library.showBooks();
                    break;
	            case 4:
                	user.viewUsers();
                    break;
                case 5:
                	System.out.print("Enter Book ID: ");
                	String bookId1 = scanner.nextLine();
                	System.out.print(library.findBookById(bookId1));
                    break;
                case 6:
                	System.out.print("Enter User ID: ");
                	int userID = Integer.parseInt(scanner.nextLine());
                	System.out.print(user.findUserById(userID));
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    int userId1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Book ID: ");
                    String bookId2 = scanner.nextLine();
                    library.issueBook(userId1, bookId2);
                    break;
                case 8:
                    System.out.print("Enter User ID: ");
                    int userId2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Book ID: ");
                    String bookId3 = scanner.nextLine();
                    library.returnBook(userId2, bookId3);
                    break;
                case 9:
                	System.out.print("Enter Book  ID to borrow: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Book name: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Auther Name: ");
	            	String autherName1 = scanner.nextLine();
                    user.borrowBook(new Book(id, title,autherName1));
                    break;
                case 10:
                    System.out.print("Enter Book  ID to borrow: ");
                    String bookId4 = scanner.nextLine();
                    System.out.print("Enter Book name: ");
                    String bookName3 = scanner.nextLine();
                    System.out.print("Enter Auther Name: ");
	            	String autherName2 = scanner.nextLine();
                    user.returnBook(new Book(bookId4,bookName3,autherName2));
                    break;
                case 11:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
        }
            

	}

}
