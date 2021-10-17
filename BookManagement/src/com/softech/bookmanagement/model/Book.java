/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.model;

/**
 *
 * @author Nguyen Bae
 */
public class Book {
    private String ISBN,Title,Author,PublisherID,CategoryID,Description;
    private double Price;
    //private boolean status;

    public Book() {
    }
    
    public Book(String ISBN, String Title, String Author, String PublisherID, double Price, String Description,String CategoryID) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Author = Author;
        this.PublisherID = PublisherID;
        this.Price = Price;
        this.Description = Description;
        this.CategoryID = CategoryID;
    }

    public String getPublisherID() {
        return PublisherID;
    }

    public void setPublisherID(String PublisherID) {
        this.PublisherID = PublisherID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }
    
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }


    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
