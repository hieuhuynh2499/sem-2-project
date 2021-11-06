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
        String sql = "INSERT INTO dbo.[OrderDetail] (NameBook,Quantity,Price,OrderID,BookID)"+
                "VALUES(?,?,?,?,?)";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,order.getNameBook());
            pstmt.setInt(2,order.getQuantity());
            pstmt.setFloat(3,order.getPrice());
            pstmt.setString(4,order.getOrderID());
            pstmt.setString(5,order.getBookID());
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
    
    public List<OrderDetail> findAll(String orderId) throws Exception{ 
        String sql = "select  * from [OrderDetail] where OrderID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,orderId);
            try(ResultSet rs = pstmt.executeQuery();){
                List<OrderDetail> list = new ArrayList<>();
                while(rs.next()){
                    OrderDetail emp = new OrderDetail();
                    emp.setOrderDetailID(rs.getString("OrderDetailID"));
                    emp.setOrderID(rs.getString("OrderID"));
                    emp.setBookID(rs.getString("BookID"));
                    emp.setPrice(rs.getFloat("Price"));
                    emp.setNameBook(rs.getString("NameBook"));
                    emp.setQuantity(rs.getInt("quantity"));
                    list.add(emp);
                }
                System.out.println(list.size());
                return list;
            }
      }
    }
}
