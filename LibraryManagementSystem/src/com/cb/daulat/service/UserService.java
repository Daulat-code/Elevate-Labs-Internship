package com.cb.daulat.service;

import com.cb.daulat.entity.Book;

public interface UserService {
	public void borrowBook(Book book); 

    public boolean returnBook(Book book);
}
