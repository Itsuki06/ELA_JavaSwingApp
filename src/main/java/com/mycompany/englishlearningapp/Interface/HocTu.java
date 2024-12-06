/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.englishlearningapp.Interface;
import com.mycompany.englishlearningapp.Database.VocabularyController;
import com.mycompany.englishlearningapp.Model.Vocabulary;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class HocTu extends javax.swing.JFrame {
    /**
     * Creates new form HocTu
     */
    private List<String[]> flashcards;  // List chứa các flashcards (câu hỏi và đáp án)
    private int currentCardIndex;       // Chỉ số của flashcard hiện tại
    private boolean showingAnswer;// Kiểm tra xem có đang hiển thị đáp án không?
    private VocabularyController vocabControll = new VocabularyController();
    private List<Vocabulary> vocabularys = vocabControll.getAllVocabulary();
    
    
    public HocTu() {
        initComponents();
        flashcards = new ArrayList<>();
        loadFlashcardsFromDatabase();  // Tải flashcards từ cơ sở dữ liệu
        currentCardIndex = 0;  // Bắt đầu từ flashcard đầu tiên
        showingAnswer = false; // Ban đầu chỉ hiển thị câu hỏi
        
        // Hiển thị câu hỏi đầu tiên
        if (!vocabularys.isEmpty()) {
            jLabel1.setText(vocabularys.get(currentCardIndex).getWord());
        }
        
    }
    private void loadFlashcardsFromDatabase() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ELA_Database"; // Thay đổi tên cơ sở dữ liệu
        String username = "admin"; // Thay đổi tên người dùng
        String password = "1234567"; // Thay đổi mật khẩu

        String query = "SELECT Word, Definition FROM Vocabulary";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String word = rs.getString("Word");
                String definition = rs.getString("Definition");
                flashcards.add(new String[]{word, definition});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1040, 680));

        jPanel1.setBackground(new java.awt.Color(254, 250, 246));

        jButton1.setBackground(new java.awt.Color(234, 219, 200));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Hiển thị đáp án");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hiển thị từ, nghĩa, ví dụ");

        jButton2.setBackground(new java.awt.Color(234, 219, 200));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Câu tiếp");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(234, 219, 200));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Câu trước");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(234, 219, 200));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)
                        .addGap(73, 73, 73)
                        .addComponent(jButton2)
                        .addGap(61, 61, 61)
                        .addComponent(jButton3)
                        .addGap(74, 74, 74)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(170, 170, 170))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Hiển thị đáp án khi nhấn nút "Hiển thị đáp án"
        vocabularys = vocabControll.getAllVocabulary();
        if (!showingAnswer) {
            jLabel1.setText(vocabularys.get(currentCardIndex).getDefinition()); // Hiển thị đáp án flashcards.get(currentCardIndex)[1]
            jButton1.setText("Hiển thị câu hỏi");
        } else {
            jLabel1.setText(vocabularys.get(currentCardIndex).getWord()); // Hiển thị câu hỏi flashcards.get(currentCardIndex)[0
            jButton1.setText("Hiển thị đáp án");
        }
        showingAnswer = !showingAnswer;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Chuyển đến flashcard tiếp theo khi nhấn nút "Next"
        currentCardIndex = (currentCardIndex + 1) % vocabularys.size();  // Quay lại đầu danh sách khi hết
        jLabel1.setText(vocabularys.get(currentCardIndex).getWord());  // Hiển thị câu hỏi mới
        jButton1.setText("Hiển thị đáp án");
        showingAnswer = false;  // Đặt lại trạng thái về câu hỏi
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // Quay lại flashcard trước đó khi nhấn nút "Previous"
        currentCardIndex = (currentCardIndex - 1 + vocabularys.size()) % vocabularys.size();  // Quay lại cuối danh sách khi ở đầu
        jLabel1.setText(vocabularys.get(currentCardIndex).getWord());  // Hiển thị câu hỏi mới
        jButton1.setText("Hiển thị đáp án");
        showingAnswer = false;  // Đặt lại trạng thái về câu hỏi
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          // Thoát ứng dụng
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocTu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HocTu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}