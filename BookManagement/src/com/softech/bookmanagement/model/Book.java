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
    private String ISBN,Title,Author,PublisherID,CategoryID,Description,Image;
    private double Price;
    //private boolean status;

    public Book() {
    }

    public Book(String ISBN, String Title, String Author, String PublisherID, String CategoryID, String Description, String Image, double Price) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Author = Author;
        this.PublisherID = PublisherID;
        this.CategoryID = CategoryID;
        this.Description = Description;
        this.Image = Image;
        this.Price = Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
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
