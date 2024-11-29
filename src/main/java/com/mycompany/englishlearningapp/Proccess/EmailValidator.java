package com.mycompany.englishlearningapp.Proccess;

import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra định dạng email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }
}
