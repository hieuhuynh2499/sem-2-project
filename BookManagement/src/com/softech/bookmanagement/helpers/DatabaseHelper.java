/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.bookmanagement.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nguyen Bae
 */
public class DatabaseHelper {

    public static Connection connectSQLServer() throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DB_URL = "jdbc:sqlserver://localhost;";
        String DATABASENAME = "database=BookManagement;";
        String USER = "user=sa;";
        String PASS = "password=123";

        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        return connection;
    }
    
}
