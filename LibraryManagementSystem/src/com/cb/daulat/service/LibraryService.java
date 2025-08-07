package com.cb.daulat.service;

import com.cb.daulat.entity.Book;
import com.cb.daulat.entity.User;

public interface LibraryService {
	public void addBook(Book book);

    public void addUser(User user);
    
    public void viewUsers();
    
    public void showBooks();

    public Book findBookById(int bookId);

    public User findUserById(int userId);

    public void issueBook(int userId, int bookId);

    public void returnBook(int userId, int bookId);

}
