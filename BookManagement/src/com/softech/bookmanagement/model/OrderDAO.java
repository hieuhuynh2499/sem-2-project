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
public class OrderDAO {
    public boolean insert(Order order) throws Exception{
        String sql = "INSERT INTO dbo.[Order] (OrderID,CreateDate,UserID)"+
                "VALUES(?,?,?)";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,order.getOrderId());
            pstmt.setDate(2,order.getCreateDate());
            pstmt.setString(3,order.getUserID());
            return pstmt.executeUpdate() > 0;
      }
    }
    public boolean update(Order order) throws Exception{

        String sql = "update [Order]"+
                " SET CreateDate = ?,UserID = ?"+
                " where OrderID = ?"; 
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setDate(1,order.getCreateDate());
            pstmt.setString(2,order.getUserID());
            pstmt.setString(3,order.getOrderId());
            return pstmt.executeUpdate() > 0;
      }
    }
    public boolean delete(String empId) throws Exception{ 
        String sql = "delete from [Order]"+
                " where OrderID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,empId);
           
            return pstmt.executeUpdate() > 0;
      }
    }
    public List<Order> findAll() throws Exception{ 
        String sql = "select  * from [Order]";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Order> list = new ArrayList<>();
                while(rs.next()){
                    Order emp = new Order();
                    emp.setOrderId(rs.getString("OrderID"));
                    emp.setCreateDate(rs.getDate("CreateDate"));
                    emp.setUserID(rs.getString("UserID"));
                    list.add(emp);
                }
                return list;
            }
      }
    }
}
