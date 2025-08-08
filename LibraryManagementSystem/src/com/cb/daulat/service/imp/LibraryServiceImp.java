package com.cb.daulat.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.cb.daulat.entity.Book;
import com.cb.daulat.service.LibraryService;
import com.cb.daulat.entity.User;

public class LibraryServiceImp implements LibraryService {
	UserServiceImp userImp = new UserServiceImp();
	private List<Book> books;
    
    public LibraryServiceImp() {
        books = new ArrayList<>();  
    }

	public void addBook(Book book) {
        books.add(book);
    }
   
    public void showBooks() {
    	if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
            
        }
    	
    }

    public Book findBookById(String bookId) {
        for (Book b : books) {
            if (b.getId().equals(bookId)) return b;
        }
        return null;
    }

    public void issueBook(int userId, String bookId) {
        User user = userImp.findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null && !book.isIssued()) {
        	userImp.borrowBook(book);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book issue failed.");
        }
    }

    public void returnBook(int userId, String bookId) {
        User user = userImp.findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null && book.isIssued()) {
            if (userImp.returnBook(book)) {
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("This book was not issued to this user.");
            }
        } else {
            System.out.println("Return failed.");
        }
    }
	

}
