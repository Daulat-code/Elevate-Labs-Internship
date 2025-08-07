package com.cb.daulat.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
    private String name;
    public List<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=" + name + "]";
    }

}
