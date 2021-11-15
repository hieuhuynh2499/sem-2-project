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
public class CategoryDAO {

    public boolean insert(Category cate) throws Exception {

        String sql = "INSERT INTO dbo.[Category] (CategoryID,CategoryName)"
                + "VALUES(?,?)";
        try (
                Connection con = DatabaseHelper.connectSQLServer();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, cate.getCategoryId());
            pstmt.setString(2, cate.getCategoryName());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(Category cate) throws Exception {
        String sql = "update [Category]"
                + " SET CategoryName = ? "
                + " where CategoryID = ?";
        try (
                Connection con = DatabaseHelper.connectSQLServer();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(2, cate.getCategoryId());
            pstmt.setString(1, cate.getCategoryName());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(String cateId) throws Exception {
        String sql = "delete from [Category]"
                + " where CategoryID = ?";
        try (
                Connection con = DatabaseHelper.connectSQLServer();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, cateId);

            return pstmt.executeUpdate() > 0;
        }
    }

    public List<Category> findAll() throws Exception {
        String sql = "select  * from [Category]";
        try (
                Connection con = DatabaseHelper.connectSQLServer();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rs = pstmt.executeQuery();) {
                List<Category> list = new ArrayList<>();
                while (rs.next()) {
                    Category cate = new Category();
                    cate.setCategoryId(rs.getString("CategoryID"));
                    cate.setCategoryName(rs.getString("CategoryName"));
                    list.add(cate);
                }
                return list;
            }
        }
    }

    public List<Category> SearchByCatName(String catName) throws Exception {
        String sql = "Select * from Category where CategoryName like ?";
        try (
                PreparedStatement ps = DatabaseHelper.connectSQLServer().prepareStatement(sql);) {
            ps.setString(1, "%" + catName + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Category> list = new ArrayList<>();
                while (rs.next()) {
                    Category cate = new Category();
                    cate.setCategoryId(rs.getString("CategoryID"));
                    cate.setCategoryName(rs.getString("CategoryName"));
                    list.add(cate);
                }
                return list;
            }
        }
    }

}
