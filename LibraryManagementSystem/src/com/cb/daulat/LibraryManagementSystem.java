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

        library.addUser(new User(101, "Alice"));
        library.addUser(new User(102, "Bob"));

        while (true) {
            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Add Book");
            System.out.println("3. Show Books");
            System.out.println("4. Find book");
            
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            
            System.out.println("\n---- User  Menu ----");
            System.out.println("2. Add user");
            System.out.println("11. View users");
            System.out.println("5. Find user");
            System.out.println("8. Borrow Book");
            System.out.println("9. Return borrowedBook");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
	            case 1:
	            	System.out.print("Create Book ID: ");
	            	int bookId = scanner.nextInt();
	            	System.out.print("Enter Book Name: ");
	            	String bookName = scanner.nextLine();
	            	System.out.print("Enter Auther Name: ");
	            	String autherName = scanner.nextLine();
	            	library.addBook(new Book(bookId, bookName,autherName));
	                break;
	            case 2:
	            	System.out.print("Enter User ID: ");
	            	int userId = scanner.nextInt();
	            	System.out.print("Enter User Name: ");
	            	String userName = scanner.nextLine();
	                library.addUser(new User(userId, userName));
	                break;
                case 3:
                    library.showBooks();
                    break;
                case 11:
                	library.viewUsers();
                    break;
                case 4:
                	System.out.print("Enter Book ID: ");
                	int bookID = scanner.nextInt();
                    library.findBookById(bookID);
                    break;
                case 5:
                	System.out.print("Enter User ID: ");
                	int userID = scanner.nextInt();
                    library.findUserById(userID);
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId1 = scanner.nextInt();
                    library.issueBook(userId1, bookId1);
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    int userId2 = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId2 = scanner.nextInt();
                    library.returnBook(userId2, bookId2);
                    break;
                    
                case 8:
                	System.out.print("Enter Book  ID to borrow: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Book name: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Auther Name: ");
	            	String autherName1 = scanner.nextLine();
                    user.borrowBook(new Book(id, title,autherName1));
                    break;
                case 9:
                    System.out.print("Enter Book  ID to borrow: ");
                    bookId = scanner.nextInt();
                    System.out.print("Enter Book name: ");
                    bookName = scanner.nextLine();
                    System.out.print("Enter Auther Name: ");
	            	String autherName2 = scanner.nextLine();
                    user.returnBook(new Book(bookId,bookName,autherName2));
                    
                    break;
                case 10:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }

	}

}
