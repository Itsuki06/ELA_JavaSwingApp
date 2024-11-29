package com.mycompany.englishlearningapp.Proccess;

public class PasswordValidator {

    // Hàm kiểm tra mật khẩu hợp lệ (độ dài tối thiểu 8 ký tự)
    public static boolean isValidPassword(String password) {
        // Kiểm tra mật khẩu có tối thiểu 8 ký tự, bao gồm chữ cái và số
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
        return password.matches(passwordRegex);
    }
}
