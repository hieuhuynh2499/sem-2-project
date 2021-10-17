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
public class Publisher {
    private String ID,PushlisherNameString,Email,Address,Phone;

    public Publisher() {
    }

    public Publisher(String ID, String PushlisherNameString, String Email, String Address, String Phone) {
        this.ID = ID;
        this.PushlisherNameString = PushlisherNameString;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPushlisherNameString() {
        return PushlisherNameString;
    }

    public void setPushlisherNameString(String PushlisherNameString) {
        this.PushlisherNameString = PushlisherNameString;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
}
