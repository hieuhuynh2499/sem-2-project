/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.model;

import com.softech.bookmanagement.helpers.DatabaseHelper;
import static com.softech.bookmanagement.model.BookDAO.ps;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Bae
 */
public class PublisherDAO {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static void initComboboxPub(){
        String sql = "Select PublisherID from Publisher";
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            ps.executeQuery();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
