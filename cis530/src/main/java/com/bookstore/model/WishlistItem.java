/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 5 - MongoDB
 */

package com.bookstore.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class WishlistItem {
    @NotNull
    @NotEmpty(message = "ISBN is a required filed")
    private String ISBN;
    
    @NotNull
    @NotEmpty(message = "Title is a required filed")
    private String title;

    @Id
    private String id;

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
        build.append("id=" + this.id);
        build.append(", isbn=" + this.ISBN);
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

    public String getId() {
        return id;
    }
}
