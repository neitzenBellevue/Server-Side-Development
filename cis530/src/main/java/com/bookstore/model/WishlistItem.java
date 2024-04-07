/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 4 - Forms and Data Validation
 */

package com.bookstore.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {
    @NotNull
    @NotEmpty(message = "ISBN is a required filed")
    private String ISBN;
    
    @NotNull
    @NotEmpty(message = "Title is a required filed")
    private String title;

    public WishlistItem(){
        this.ISBN = "0";
        this.title = "Empty";
    }

    public WishlistItem(String ISBN, String title){
        this.ISBN = ISBN;
        this.title = title;
    }

    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("isbn=" + this.ISBN);
        build.append(", title=" + this.title);
        return build.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
}
