package com.mycompany.englishlearningapp.Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
    public static Connection getConnection() throws SQLException {
        try {
            String username = "admin";
            String password = "1234567";
            String url = "jdbc:sqlserver://localhost:1433;databasename=ELA_Database;encrypt=true;trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = java.sql.DriverManager.getConnection(url, username, password);
            
            return conn;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database!", "Announcement", 1);
        }
        return null;
    }
}
