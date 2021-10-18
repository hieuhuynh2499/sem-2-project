/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softech.bookmanagement.model;

import java.sql.Date;

/**
 *
 * @author This PC
 */
public class Order {
    private String OrderId,Description,Total,UserID;
    private Date CreateDate;
    private float Amount;

    public Order() {
    }

    public Order(String OrderId, String Description, String Total, String UserID, Date CreateDate, float Amount) {
        this.OrderId = OrderId;
        this.Description = Description;
        this.Total = Total;
        this.UserID = UserID;
        this.CreateDate = CreateDate;
        this.Amount = Amount;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }
    
    
    
}
