package com.mycompany.englishlearningapp.Proccess;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptor {

    public static String encryptedPassword(String password) {
        // Tạo ra một salt ngẫu nhiên
        String salt = BCrypt.gensalt();
        // Mã hóa mật khẩu với salt
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
