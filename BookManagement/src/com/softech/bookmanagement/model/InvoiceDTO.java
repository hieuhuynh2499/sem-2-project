/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softech.bookmanagement.model;

/**
 *
 * @author This PC
 */
public class InvoiceDTO {
    String orderId,quantity,nameBook,nameEmployee;

    public InvoiceDTO(String orderId, String quantity, String nameBook, String nameEmployee) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.nameBook = nameBook;
        this.nameEmployee = nameEmployee;
    }

    public InvoiceDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
    
}
