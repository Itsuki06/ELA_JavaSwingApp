package com.mycompany.englishlearningapp.Interface;

import com.mycompany.englishlearningapp.Database.LibraryController;
import com.mycompany.englishlearningapp.Proccess.User;
import javax.swing.*;

public final class PanelHome extends javax.swing.JPanel {

    private int currentUserID = -1;
    private User currentUser = new User();
    private LibraryController lib = new LibraryController();

    public PanelHome(User user) {
        currentUser = user;
        currentUserID = currentUser.getUserID();
        int numOfWord = lib.GetNumberOfWord(currentUserID);
        initComponents();

        lblWelcome.setText("Chào mừng, " + currentUser.getUsername());

        updateWordCount(numOfWord);
    }
    

    public void updateWordCount(int count) {
        lblNumOfWords.setText(String.valueOf(count));
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
        pnHome = new javax.swing.JPanel();
        pnAchivement = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblConsecutiveDays = new javax.swing.JLabel();
        lblNumOfDays = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTotalWords = new javax.swing.JLabel();
        lblNumOfWords = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblTotalQuestTaken = new javax.swing.JLabel();
        lblNumOfQuests = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnHome.setBackground(new java.awt.Color(251, 251, 251));
        pnHome.setPreferredSize(new java.awt.Dimension(1040, 680));

        pnAchivement.setBackground(new java.awt.Color(254, 250, 246));
        pnAchivement.setPreferredSize(new java.awt.Dimension(960, 250));

        jPanel3.setBackground(new java.awt.Color(251, 251, 251));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setPreferredSize(new java.awt.Dimension(278, 175));

        lblConsecutiveDays.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N
        lblConsecutiveDays.setText("Ngày học liên tiếp");

        lblNumOfDays.setFont(new java.awt.Font("Cascadia Code", 1, 48)); // NOI18N
        lblNumOfDays.setText("00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblConsecutiveDays)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumOfDays)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblConsecutiveDays)
                .addGap(30, 30, 30)
                .addComponent(lblNumOfDays)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(251, 251, 251));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.setPreferredSize(new java.awt.Dimension(278, 175));

        lblTotalWords.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N
        lblTotalWords.setText("Tổng số từ đã thêm");

        lblNumOfWords.setFont(new java.awt.Font("Cascadia Code", 1, 48)); // NOI18N
        lblNumOfWords.setText("00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTotalWords)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblNumOfWords)
                        .addGap(46, 46, 46))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTotalWords)
                .addGap(33, 33, 33)
                .addComponent(lblNumOfWords)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(251, 251, 251));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 175));

        lblTotalQuestTaken.setFont(new java.awt.Font("Cascadia Code", 0, 20)); // NOI18N
        lblTotalQuestTaken.setText("Số câu hỏi đã trả lời");

        lblNumOfQuests.setFont(new java.awt.Font("Cascadia Code", 1, 48)); // NOI18N
        lblNumOfQuests.setText("00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTotalQuestTaken)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumOfQuests)
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTotalQuestTaken)
                .addGap(31, 31, 31)
                .addComponent(lblNumOfQuests)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));
        jPanel2.setPreferredSize(new java.awt.Dimension(372, 50));

        lblWelcome.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        lblWelcome.setText("Xin chào, User");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnAchivementLayout = new javax.swing.GroupLayout(pnAchivement);
        pnAchivement.setLayout(pnAchivementLayout);
        pnAchivementLayout.setHorizontalGroup(
            pnAchivementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAchivementLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnAchivementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addGroup(pnAchivementLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        pnAchivementLayout.setVerticalGroup(
            pnAchivementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAchivementLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnAchivementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAchivementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(415, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnAchivement, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnAchivement, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblConsecutiveDays;
    private javax.swing.JLabel lblNumOfDays;
    private javax.swing.JLabel lblNumOfQuests;
    private javax.swing.JLabel lblNumOfWords;
    private javax.swing.JLabel lblTotalQuestTaken;
    private javax.swing.JLabel lblTotalWords;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnAchivement;
    private javax.swing.JPanel pnHome;
    // End of variables declaration//GEN-END:variables
}
