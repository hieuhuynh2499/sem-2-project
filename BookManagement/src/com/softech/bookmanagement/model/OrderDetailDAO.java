/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softech.bookmanagement.model;

import com.softech.bookmanagement.helpers.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author This PC
 */
public class OrderDetailDAO {
    public boolean insert(OrderDetail order) throws Exception{
        String sql = "INSERT INTO dbo.[OrderDetail] (OrderDetailID,Quantity,Price,OrderID,BookID,Total,Description,Amount)"+
                "VALUES(?,?,?,?,?,?,?,?)";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,order.getOrderDetailID());
            pstmt.setInt(2,order.getQuantity());
            pstmt.setFloat(3,order.getPrice());
            pstmt.setString(4,order.getOrderID());
            pstmt.setString(5,order.getBookID());
            pstmt.setString(6,order.getTotal());
            pstmt.setString(7,order.getDescription());
            pstmt.setFloat(8,order.getAmount());
            return pstmt.executeUpdate() > 0;
      }
    }
    public boolean update(OrderDetail order) throws Exception{

        String sql = "update [OrderDetail]"+
                " SET Quantity = ?,Price = ?, Description=?,Total = ?,Amount = ?"+
                " where OrderID = ?"; 
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setFloat(1,order.getQuantity());
            pstmt.setFloat(2,order.getPrice());
            pstmt.setString(3,order.getDescription());
            pstmt.setString(4,order.getTotal());
            pstmt.setFloat(5,order.getAmount());
            pstmt.setString(6,order.getOrderID());
            return pstmt.executeUpdate() > 0;
      }
    }
    public boolean delete(String empId) throws Exception{ 
        String sql = "delete from [OrderDetail]"+
                " where OrderDetailID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,empId);
           
            return pstmt.executeUpdate() > 0;
      }
    }
}
