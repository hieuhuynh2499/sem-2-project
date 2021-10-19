/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.model;

import com.softech.bookmanagement.helpers.DatabaseHelper;
import static com.softech.bookmanagement.model.BookDAO.ps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Bae
 */
public class PublisherDAO {
        public boolean insert(Publisher publish) throws Exception{
        String sql = "INSERT INTO dbo.[Publisher] (PublisherID,PublisherName,Email,Address,Phone,Image)"+
                "VALUES(?,?,?,?,?,?)";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,publish.getID());
            pstmt.setString(2,publish.getPushlisherNameString());
            pstmt.setString(3,publish.getEmail());
            pstmt.setString(4,publish.getAddress());
            pstmt.setString(5,publish.getPhone());
            pstmt.setString(6,publish.getImage());
            return pstmt.executeUpdate() > 0;
      }
    }
    public boolean update(Publisher publish) throws Exception{ 
        String sql = "update [Publisher]"+
                " SET PublisherName = ? ,Email = ?,Address = ?,Phone = ?,Image = ?"+
                " where PublisherID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(6,publish.getID());
            pstmt.setString(1,publish.getPushlisherNameString());
            pstmt.setString(2,publish.getEmail());
            pstmt.setString(3,publish.getAddress());
            pstmt.setString(4,publish.getPhone());
            pstmt.setString(5,publish.getImage());
            return pstmt.executeUpdate() > 0;
      }
    }
    
    public boolean delete(String publisherId) throws Exception{ 
        String sql = "delete from [Publisher]"+
                " where PublisherID = ?";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,publisherId);
            return pstmt.executeUpdate() > 0;
      }
    }
    public List<Publisher> findAll() throws Exception{ 
        String sql = "select  * from [Publisher]";           
        try(
            Connection  con = DatabaseHelper.connectSQLServer(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Publisher> list = new ArrayList<>();
                while(rs.next()){
                    Publisher publisher = new Publisher();
                    publisher.setID(rs.getString("PublisherID"));
                    publisher.setPushlisherNameString(rs.getString("PublisherName"));
                    publisher.setEmail(rs.getString("Email"));
                    publisher.setAddress(rs.getString("Address"));
                    publisher.setPhone(rs.getString("Phone"));
                    publisher.setImage(rs.getString("Image"));
                    list.add(publisher);
                }
                return list;
            }
      }
    }
}
