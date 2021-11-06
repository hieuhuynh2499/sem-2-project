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
    private String OrderId,UserID,nameUser;
    private Date CreateDate;

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

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Order(String OrderId, String UserID, String nameUser, Date CreateDate) {
        this.OrderId = OrderId;
        this.UserID = UserID;
        this.nameUser = nameUser;
        this.CreateDate = CreateDate;
    }

    public Order() {
    }

   
}
