/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.model;


import com.softech.bookmanagement.helpers.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Bae
 */
public class UserDAO {
    public User checkLogin(String username, String password) throws Exception{
        String query = "Select Username, Password , RoleID from [User] where Username=? and Password=?";
        try(
                Connection conn = DatabaseHelper.connectSQLServer();
                PreparedStatement pstmt = conn.prepareStatement(query);
            )
        {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setRole(rs.getString("RoleID"));
                    return user;
                }
            }
        }
        return null;
    }
    public static void UpdateInfo(User u) {
        try {
            PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement("UPDATE [User] SET Username=?, Fullname = ?, Phone = ?,"
                    + "Address = ?, Image= ? where UserID = ?");
            ps.setString(6, u.getUserid());
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getFullname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getImage());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Update Info succesfully", "Message", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "An error occurred. Update Info fail", "Message", 2);
        }
    }
    public static void UpdatePassword(User u) {
        try {
            PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement("UPDATE [User] SET Password=? where UserID = ?");
            ps.setString(2, u.getUserid());
            ps.setString(1, u.getPassword());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Update Password succesfully", "Message", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "An error occurred. Update Passwrd fail", "Message", 2);
        }
    }
    
}
