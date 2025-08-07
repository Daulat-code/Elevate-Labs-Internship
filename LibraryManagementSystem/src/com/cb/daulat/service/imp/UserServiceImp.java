package com.cb.daulat.service.imp;

import com.cb.daulat.entity.Book;
import java.util.*;


import com.cb.daulat.service.UserService;

public class UserServiceImp implements UserService{
	
	private List<Book> borrowedBooks = new ArrayList<>();
	
	@Override
	public void borrowBook(Book book) {
		borrowedBooks.add(book);
        book.issueBook();
		
	}

	@Override
	public boolean returnBook(Book book) {
		if (borrowedBooks.remove(book)) {
            book.returnBook();
            return true;
        }
        return false;
    }
	
	

}
