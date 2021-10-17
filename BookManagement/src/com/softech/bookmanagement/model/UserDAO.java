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
}
