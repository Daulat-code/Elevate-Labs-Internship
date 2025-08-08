package com.cb.daulat.service;

import com.cb.daulat.entity.Book;

public interface LibraryService {
	public void addBook(Book book);

    public void showBooks();

    public Book findBookById(String bookId);
    
    public void issueBook(int userId, String bookId);

    public void returnBook(int userId, String bookId);

}
