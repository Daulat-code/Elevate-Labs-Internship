package com.cb.daulat.service;

import com.cb.daulat.entity.Book;
import com.cb.daulat.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public void viewUsers();
	
	public User findUserById(int userId);
	
	public void borrowBook(Book book);

    public boolean returnBook(Book book);
}
