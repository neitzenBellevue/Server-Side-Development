/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 3 - Thymeleaf
 */

package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bookstore.model.Book;
import com.bookstore.service.dao.BookDao;

public class MemBookDao implements BookDao {
    private List<Book> books = new ArrayList<Book>();

    public MemBookDao(){
        List<String> list1 = Arrays.asList("Computer Man", "Computer Woman");
        List<String> list2 = Arrays.asList("Science Man", "Science Woman");
        List<String> list3 = Arrays.asList("History Man", "History Woman");
        List<String> list4 = Arrays.asList("Fun Woman", "Fun Man");
        List<String> list5 = Arrays.asList("Boring Woman", "Boring Man");
        books.add(new Book("102341", "Computer Book", "Learn about Computers", 341, list1));
        books.add(new Book("172501", "Science Book", "Learn about Science", 22151, list2));
        books.add(new Book("624356", "History Book", "Learn about History", 912, list3));
        books.add(new Book("812356", "Fun Book", "Read for Fun", 183, list4));
        books.add(new Book("974732", "Boring Book", "Read for Sleep", 103, list5));
    }

    @Override
    public List<Book> list(){
        return this.books;
    }

    @Override
    public Book find(String key){
        for (Book book: books){
            if (book.getISBN().equals(key)) return book;
        }
        return new Book();
    }
}
