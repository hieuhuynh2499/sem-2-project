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
public class EmployeeDAO {
    
    public boolean insert(Employee emp) throws Exception{
        System.out.println(emp.getFullName() + "dao");
        String sql = "INSERT INTO dbo.[User] (UserID,FullName,Phone,Address,Username,Password,Status,Image,RoleID)"+
                "VALUES(?,?,?,?,?,?,?,?,?)";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,emp.getUserID());
            pstmt.setString(2,emp.getFullName());
            pstmt.setString(3,emp.getPhone());
            pstmt.setString(4,emp.getAddress());
            pstmt.setString(5,emp.getUsername());
            pstmt.setString(6,emp.getPassword());
            pstmt.setInt(7,emp.getStatus());
            pstmt.setString(8,emp.getImage());
            pstmt.setString(9,emp.getRoleID());
            return pstmt.executeUpdate() > 0;
      }
    }
    public boolean update(Employee emp) throws Exception{ 
        System.out.println(emp.getFullName() + "dao");
        String sql = "update [User]"+
                " SET FullName = ?,Phone = ? ,Address = ?,Username = ?,Password = ?,Status = ?,RoleID = ?"+
                " where UserID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(8,emp.getUserID());
            pstmt.setString(1,emp.getFullName());
            pstmt.setString(2,emp.getPhone());
            pstmt.setString(3,emp.getAddress());
            pstmt.setString(4,emp.getUsername());
            pstmt.setString(5,emp.getPassword());
            pstmt.setInt(6,emp.getStatus());
            pstmt.setString(7,emp.getRoleID());
            return pstmt.executeUpdate() > 0;
      }
    }
    
    public boolean delete(String empId) throws Exception{ 
        String sql = "delete from [User]"+
                " where UserID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,empId);
           
            return pstmt.executeUpdate() > 0;
      }
    }
    public List<Employee> findAll() throws Exception{ 
        String sql = "select  * from [User]";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Employee> list = new ArrayList<>();
                while(rs.next()){
                    Employee emp = new Employee();
                    emp.setUserID(rs.getString("UserID"));
                    emp.setFullName(rs.getString("FullName"));
                    emp.setPhone(rs.getString("Phone"));
                    emp.setAddress(rs.getString("Address"));
                    emp.setUsername(rs.getString("Username"));
                    emp.setPassword(rs.getString("Password"));
                    emp.setStatus(rs.getInt("Status"));
                    emp.setImage(rs.getString("Image"));
                    emp.setRoleID(rs.getString("RoleID"));
                    list.add(emp);
                }
                return list;
            }
      }
    }
    
}
