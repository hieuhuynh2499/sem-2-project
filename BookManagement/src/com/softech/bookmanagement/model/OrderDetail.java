/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softech.bookmanagement.model;

/**
 *
 * @author This PC
 */
public class OrderDetail {
    private String OrderDetailID,OrderID,BookID,Total,Description;
    private int Quantity;
    private float  Price,Amount;

    public OrderDetail(String OrderDetailID, String OrderID, String BookID, String Total, String Description, int Quantity, float Price, float Amount) {
        this.OrderDetailID = OrderDetailID;
        this.OrderID = OrderID;
        this.BookID = BookID;
        this.Total = Total;
        this.Description = Description;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Amount = Amount;
    }

    public OrderDetail() {
    }

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    
    
}
