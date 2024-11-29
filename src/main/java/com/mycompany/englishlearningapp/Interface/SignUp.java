package com.mycompany.englishlearningapp.Interface;

import com.mycompany.englishlearningapp.Database.UserController;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import com.mycompany.englishlearningapp.Proccess.EmailValidator;
import com.mycompany.englishlearningapp.Proccess.PasswordEncryptor;
import com.mycompany.englishlearningapp.Proccess.PasswordValidator;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SignUp extends javax.swing.JFrame {

    public SignUp() {
        setTitle("English Learning App - Sign Up");
        initComponents();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Lấy kích thước màn hình
        int x = (screenSize.width - getWidth()) / 2; // Tính tọa độ x
        int y = (screenSize.height - getHeight()) / 2; // Tính tọa độ y
        setLocation(x, y); // Đặt vị trí cửa sổ ở giữa màn hình

        rePasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnSignUp.doClick();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        lblLogin = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblRePassword = new javax.swing.JLabel();
        rePasswordField = new javax.swing.JPasswordField();
        lblIcon = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Madimi One", 0, 32)); // NOI18N
        lblTitle.setText("SIGN UP");

        lblUsername.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        lblUsername.setText("Username:");

        lblEmail.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        lblEmail.setText("Email:");

        lblPassword.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        lblPassword.setText("Password:");

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        lblLogin.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        lblLogin.setText("Have an account?");

        btnLogin.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSignUp.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        lblRePassword.setFont(new java.awt.Font("Madimi One", 0, 20)); // NOI18N
        lblRePassword.setText("Confirm Password:");

        rePasswordField.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        lblIcon.setIcon(new javax.swing.ImageIcon("D:\\JavaProject\\EnglishLearningApp\\src\\main\\Resources\\Image\\icons8-hoyolab-cute-color\\icons8-hoyolab-80.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rePasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtUsername)
                            .addComponent(passwordField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRePassword)
                                    .addComponent(lblEmail)
                                    .addComponent(lblUsername)
                                    .addComponent(lblPassword)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblLogin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLogin)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblIcon)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSignUp)
                        .addGap(170, 170, 170))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblIcon)
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(24, 24, 24)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblRePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSignUp)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(btnLogin))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetFields() {
        txtUsername.setText("");
        txtEmail.setText("");
        passwordField.setText("");
        rePasswordField.setText("");
    }

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        String Username = txtUsername.getText();
        String Email = txtEmail.getText();
        String Password = new String(passwordField.getPassword());
        String RePassword = new String(rePasswordField.getPassword());

        UserController controller = new UserController();

        try {
            // Kiểm tra dữ liệu
            if (Username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "User name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email address is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!EmailValidator.isValidEmail(Email)) {
                JOptionPane.showMessageDialog(null, "Invalid Email format!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!PasswordValidator.isValidPassword(Password)) { // Kiểm tra mật khẩu hợp lệ
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long and contain both letters and numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Password.equals(RePassword)) { // Kiểm tra mật khẩu nhập lại
                JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra trùng lặp
            if (controller.isExistSIGNUP(Username, Email)) {
                JOptionPane.showMessageDialog(null, "Username or Email already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String hashedPassword = PasswordEncryptor.encryptedPassword(Password);

            // Nếu tất cả dữ liệu hợp lệ, ĐĂNG KÝ người dùng vào cơ sở dữ liệu
            if (controller.registerUser(Username, Email, hashedPassword)) {
                JOptionPane.showMessageDialog(null, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                resetFields();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register user!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        this.dispose();

        Login loginForm = new Login();
        loginForm.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRePassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField rePasswordField;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
