/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.model;

import com.softech.bookmanagement.helpers.DatabaseHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Bae
 */
public class BookDAO {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static void InsertBook(Book b){
        String sql = "insert into Book(ISBN,Title,Author,PublisherID,Price,Description,CategoryID) values(?,?,?,?,?,?,?)";
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            ps.setString(1, b.getISBN());
            ps.setString(2, b.getTitle());
            ps.setString(3, b.getAuthor());
            ps.setString(4, b.getPublisherID());
//            ps.setInt(4, 1);
            ps.setDouble(5, b.getPrice());
            ps.setString(6, b.getDescription());
            ps.setString(7, b.getCategoryID());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm sách thành công!" , "Thông báo", 1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Sach không được thêm" , "Thông báo", 1);
        }
    }
    public static void UpdateBook(Book b) {
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement("UPDATE Book SET  Title = ?, Author = ?,"
                    + "PublisherID = ?, Price = ?, Description = ?, CategoryID= ? where ISBN = ?");
            ps.setString(7, b.getISBN());
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublisherID());
            ps.setDouble(4, b.getPrice());
            ps.setString(5, b.getDescription());
            ps.setString(6, b.getCategoryID());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Bạn đã sửa thành công", "Thông báo", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
        }
    }
    public static void DeleteBook(String isbn) {
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement("DELETE FROM Book WHERE ISBN = ?");
            ps.setString(1, isbn);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công", "Thông báo", 1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
        }
    }
}
