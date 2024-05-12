/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 9 - Crud Operations
 */

package com.bookstore.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlist")
public class WishlistItem {
    @NotNull
    @NotEmpty(message = "ISBN is a required filed")
    private String ISBN;
    
    @NotNull
    @NotEmpty(message = "Title is a required filed")
    private String title;

    @Id
    private String id;

    private String username;

    public WishlistItem(){}

    public WishlistItem(String ISBN, String title, String username){
        this.ISBN = ISBN;
        this.title = title;
        this.username = username;
    }

    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("id=" + this.id);
        build.append(", isbn=" + this.ISBN);
        build.append(", title=" + this.title);
        build.append(", username=" + this.username);
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

    public void setId(String id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
