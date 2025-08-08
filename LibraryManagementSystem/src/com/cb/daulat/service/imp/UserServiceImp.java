package com.cb.daulat.service.imp;

import com.cb.daulat.entity.Book;
import com.cb.daulat.entity.User;

import java.util.*;


import com.cb.daulat.service.UserService;

public class UserServiceImp implements UserService{
	
	private List<Book> borrowedBooks = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	public void addUser(User user) {
        users.add(user);
    }
	
	public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in library.");
        } else {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }
	public User findUserById(int userId) {
        for (User u : users) {
            if (u.getId() == userId) return u;
        }
        return null;
    }
	
	@Override
	public void borrowBook(Book book) {
		borrowedBooks.add(book);
        book.issueBook();
        System.out.println("Book borrowed successfuly");
		
	}

	@Override
	public boolean returnBook(Book book) {
		if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("Borrowed book returned successfuly");
            return true;
        }
		System.out.println("This book is not borrowed");
        return false;
    }
	
	

}
