/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 4 - Forms and Data Validation
 */

package com.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String ISBN;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    

    public Book(String ISBN, String title, String description, int numOfPages, List<String> authors){
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    public Book(){
        this.ISBN = "0";
        this.title = "placeholder title";
        this.description = "placeholder description";
        this.numOfPages = 0;
        this.authors = new ArrayList<String>();
    }

    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Book{isbn=" + ISBN + ", ");
        returnString.append("title=" + title + ", ");
        returnString.append("description=" + description + ", ");
        returnString.append("numOfPages=" + numOfPages + ", ");
        returnString.append("authors=" + authors.toString() + "}"); // Need to verify list toString behavior.
        return returnString.toString();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setIsbn(String isbn) {
        this.ISBN = isbn;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
