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
    private String OrderId,UserID;
    private Date CreateDate;

    public Order() {
    }

    public Order(String OrderId,String UserID, Date CreateDate) {
        this.OrderId = OrderId;
        this.UserID = UserID;
        this.CreateDate = CreateDate;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
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
}
