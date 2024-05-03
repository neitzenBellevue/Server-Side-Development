/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 8 - OpenAPI/Swagger
 */

package com.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String ISBN;
    private String title;
    private String description;
    private int numOfPages;
    //private List<String> authors;
    private String infoUrl;

    public Book(String ISBN, String title, String description, int numOfPages, String infoUrl){
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.infoUrl = infoUrl;
    }

    public Book(String isbn, String title, String infoUrl){
        this.ISBN = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
    }

    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("Book{isbn=" + ISBN + ", ");
        returnString.append("title=" + title + ", ");
        returnString.append("description=" + description + ", ");
        returnString.append("numOfPages=" + numOfPages + ", ");
        returnString.append("infoUrl=" + infoUrl + "}"); // Need to verify list toString behavior.
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

    //public List<String> getAuthors() {
    //    return authors;
    //}

    //public void setAuthors(List<String> authors) {
    //    this.authors = authors;
    //}

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

    
    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }
}
