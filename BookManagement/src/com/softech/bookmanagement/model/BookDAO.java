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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Bae
 */
public class BookDAO {

    public static PreparedStatement ps;
    public static ResultSet rs;

    public static void InsertBook(Book b) {
        String sql = "insert into Book(ISBN,Title,Author,PublisherID,Price,Description,CategoryID,Image) values(?,?,?,?,?,?,?,?)";
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);
            ps.setString(1, b.getISBN());
            ps.setString(2, b.getTitle());
            ps.setString(3, b.getAuthor());
            ps.setString(4, b.getPublisherID());
            ps.setDouble(5, b.getPrice());
            ps.setString(6, b.getDescription());
            ps.setString(7, b.getCategoryID());
            ps.setString(8, b.getImage());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Adding book succcesfully!", "Message", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "An error occurred. Adding book fail!!!", "Message", 1);
        }
    }

    public static void UpdateBook(Book b) {
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement("UPDATE Book SET  Title = ?, Author = ?,"
                    + "PublisherID = ?, Price = ?, Description = ?, CategoryID= ?, Image=? where ISBN = ?");
            ps.setString(8, b.getISBN());
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublisherID());
            ps.setDouble(4, b.getPrice());
            ps.setString(5, b.getDescription());
            ps.setString(6, b.getCategoryID());
            ps.setString(7, b.getImage());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Update book succesfully", "Message", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "An error occurred. Update book fail", "Message", 2);
        }
    }

    public static void DeleteBook(String isbn) {
        try {
            ps = DatabaseHelper.connectSQLServer().prepareStatement("DELETE FROM Book WHERE ISBN = ?");
            ps.setString(1, isbn);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Delete book succesfully", "Message", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "An error occurred", "Message", 2);
        }
    }

    public static Book findBookByName(String nameBook) throws Exception {
        String sql = "SELECT * FROM Book WHERE Title = ?";
        try (
                Connection con = DatabaseHelper.connectSQLServer();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, nameBook);
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Book emp = new Book();
                    emp.setISBN(rs.getString("ISBN"));
                    emp.setTitle(rs.getString("Title"));
                    emp.setAuthor(rs.getString("Author"));
                    emp.setPrice(rs.getFloat("Price"));
                    emp.setImage("");
                    emp.setDescription("");
                    emp.setCategoryID("1");
                    emp.setPublisherID("1");
                    return emp;
                }
                return null;
            }
        }

    }

    public List<Book> SearchByTitle(String Title) throws Exception {
        String sql = "Select * from Book where Title like ?";
        try (
                PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);) {
            ps.setString(1, "%" + Title + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Book> list = new ArrayList<>();
                while (rs.next()) {
                    Book book = new Book();
                    book.setISBN(rs.getString("ISBN"));
                    book.setTitle(rs.getString("Title"));
                    book.setAuthor(rs.getString("Author"));
                    book.setPrice(rs.getFloat("Price"));
                    book.setImage(rs.getString("Image"));
                    book.setDescription(rs.getString("Description"));
                    book.setCategoryID(rs.getString("CategoryID"));
                    book.setPublisherID(rs.getString("PublisherID"));
                    list.add(book);
                }
                return list;
            }
        }
    }

    public List<Book> SearchByAuthor(String Author) throws Exception {
        String sql = "Select * from Book where Author like ?";
        try (
                PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);) {
            ps.setString(1, "%" + Author + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Book> list = new ArrayList<>();
                while (rs.next()) {
                    Book book = new Book();
                    book.setISBN(rs.getString("ISBN"));
                    book.setTitle(rs.getString("Title"));
                    book.setAuthor(rs.getString("Author"));
                    book.setPrice(rs.getFloat("Price"));
                    book.setImage(rs.getString("Image"));
                    book.setDescription(rs.getString("Description"));
                    book.setCategoryID(rs.getString("CategoryID"));
                    book.setPublisherID(rs.getString("PublisherID"));
                    list.add(book);
                }
                return list;
            }
        }
    }

    public List<Book> SearchByPublisher(String PublisherName) throws Exception {
        String sql = "Select * from Book where PublisherID = ?";
        String PublisherID = "";
        String getPublisher = "select PublisherID from Publisher where PublisherName like ?";
        PreparedStatement pstmt1 = DatabaseHelper.connectSQLServer().prepareStatement(getPublisher);
        pstmt1.setString(1, "%" + PublisherName + "%");
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            PublisherID = rs1.getString("PublisherID");
        }
        try (
                PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);) {

            ps.setString(1, PublisherID);
            try (ResultSet rs = ps.executeQuery()) {
                List<Book> list = new ArrayList<>();
                while (rs.next()) {
                    Book book = new Book();
                    book.setISBN(rs.getString("ISBN"));
                    book.setTitle(rs.getString("Title"));
                    book.setAuthor(rs.getString("Author"));
                    book.setPrice(rs.getFloat("Price"));
                    book.setImage(rs.getString("Image"));
                    book.setDescription(rs.getString("Description"));
                    book.setCategoryID(rs.getString("CategoryID"));
                    book.setPublisherID(rs.getString("PublisherID"));
                    list.add(book);
                }
                return list;
            }
        }
    }

}
