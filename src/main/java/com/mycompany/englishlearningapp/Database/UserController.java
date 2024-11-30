package com.mycompany.englishlearningapp.Database;

import java.sql.*;
import com.mycompany.englishlearningapp.Proccess.User;
import com.mycompany.englishlearningapp.Proccess.PasswordEncryptor;

public class UserController {
    
// Sign Ưp STATEMENT -------------------------------------------------------------------------------------------------------------------
    // Kiểm tra tồn tại cho SIGNUP
    public boolean isExistSIGNUP(String Username, String Email) throws SQLException {
        String checkQuery = "SELECT * FROM UserInfo WHERE Username = ? OR Email = ?";
        
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(checkQuery)) {
            pst.setString(1, Username);
            pst.setString(2, Email);
            
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        }
    } 

    // Thêm người dùng vào cơ sở dữ liệu
    public boolean registerUser(String Username, String Email, String hashedPassword) throws SQLException {
        String sql = "INSERT INTO UserInfo (Username, Email, PasswordHash) VALUES (?, ?, ?)";

        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, Username);
            pst.setString(2, Email);
            pst.setString(3, hashedPassword);

            return pst.executeUpdate() > 0;
        }
    }
    
// Login STATEMENT ---------------------------------------------------------------------------------------------------------------------
    // Kiểm tra thông tin đăng nhập
    public boolean isUserValid(String Username, String Password) throws SQLException {
        String query = "SELECT PasswordHash FROM UserInfo WHERE Username = ?";
        
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, Username);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("PasswordHash");
                    return PasswordEncryptor.checkPassword(Password, hashedPassword);
                }
            }
        }
        return false; // Người dùng không tồn tại hoặc mật khẩu không khớp
    }
    
    // Kiểm tra tồn tại cho LOGIN
    public boolean isExistLOGIN(String Username) throws SQLException {
        String query = "SELECT Username FROM UserInfo WHERE Username = ?";
        
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, Username);
            
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        }
    }
    
// Using Data STATEMENT ---------------------------------------------------------------------------------------------------------------------
    // Lấy thông tin người dùng từ cơ sở dữ liệu theo UserName
    public static User getUserByName(String Username) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM UserInfo WHERE Username = ?";

        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, Username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    user.setUserID(rs.getInt("UserID"));
                    user.setUsername(rs.getString("Username"));
                    user.setEmail(rs.getString("Email"));
                }
            }
        }
        return user;
    }
    
    // Cập nhật thông tin người dùng
//    public boolean editUser(UserController user) throws SQLException {
//        String sql = "UPDATE UserInfo SET Username = ?, Email = ? WHERE UserID = ?";
//
//        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
//            pst.setString(1, user.getUsername());
//            pst.setString(2, user.getEmail());
//            pst.setInt(3, user.getUserID());
//
//            return pst.executeUpdate() > 0;
//        }
//    }

    // Xóa người dùng
//    public boolean deleteUser(int UserID, String UserName) throws SQLException {
//        String sql = "DELETE FROM UserInfo WHERE UserID = ? AND UserName = ?";
//
//        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
//            pst.setInt(1, UserID);
//            pst.setString(2, UserName);
//            return pst.executeUpdate() > 0;
//        }
//    }
}
