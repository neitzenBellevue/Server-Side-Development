/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 10 - Authorization in Action
 */

package com.bookstore.model;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public class BookOfTheMonth {
    @Id
    private String id;


    private Integer month;


    @NotEmpty(message = "ISBN is a required field")
    private String ISBN;

    public BookOfTheMonth(){

    }

    public BookOfTheMonth(int month, String ISBN){
        this.month = month;
        this.ISBN = ISBN;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BookOfTheMonth{id=");
        stringBuilder.append(this.id + ", month=");
        stringBuilder.append(this.month + ", ISBN=");
        stringBuilder.append(this.ISBN + "}");
        return stringBuilder.toString();
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
}
