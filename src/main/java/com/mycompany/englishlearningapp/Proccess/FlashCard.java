/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.englishlearningapp.Proccess;
import com.mycompany.englishlearningapp.Model.Cauhoi;
import com.mycompany.englishlearningapp.Model.Dapan;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
/**
 *
 * @author ACER
 */
public class FlashCard extends javax.swing.JFrame {
    private CrudCauHoi crudCauHoi = new CrudCauHoi();
    private CrudDapAn crudDapAn = new CrudDapAn();
    List<String> questions = new ArrayList<>();
    List<List<String>> answers = new ArrayList<>();
    
    int index = 0, correct = 0;
    ButtonGroup bg = new ButtonGroup();
    /**
     * Creates new form FlashCard
     */
    public FlashCard() {
        initComponents();
        // TODO add your handling code here:
        List<Cauhoi> cauHoiList = crudCauHoi.getAllCauHoi();
        List<Dapan> dapanList = crudDapAn.getAllDapAn();
//        List<String> questions = new ArrayList<>();
//        List<List<String>> answers = new ArrayList<>();
        int i = 0;
        for (Cauhoi x : cauHoiList) {
            questions.add(x.getCauHoi());
            //List<Dapan> dapan = crudDapAn.getAllDapAnbyMaCauHoi(x.getMaCauHoi());
            List<String> answerForQuestion = dapanList.stream()
                    .filter(dapan -> dapan.getMaCauHoi() == x.getMaCauHoi())
                    .map(Dapan::getDapAn)
                    .collect(Collectors.toList());
            Collections.shuffle(dapanList);
            answers.add(answerForQuestion);

        }
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        bg.add(jRadioButton4);

        jButton_Next_QActionPerformed(null);
    }
    public void getSelectedOption(JRadioButton rbtn)
    {
// Kiểm tra giới hạn chỉ số trước khi xử lý
        if (index >= answers.size()) {
            System.out.println("No more questions available.");
            return;
        }

        // Lấy giá trị từ RadioButton được chọn
        System.out.println(rbtn.getText());
        System.out.println(answers.get(index).get(3)); // Log đáp án đúng

        if (index >= answers.size()) {
        System.out.println("No more questions available.");
        return;
    }

    // Kiểm tra đáp án
    String selectedAnswer = rbtn.getText();
    String correctAnswer = crudDapAn.getDapAnDung(questions.get(index)); 

    if (selectedAnswer.equals(correctAnswer)) {
        correct++;
        Lbl_key.setForeground(Color.GREEN);
        Lbl_key.setText("Correct! Answer: " + correctAnswer);
    } else {
        Lbl_key.setForeground(Color.RED);
        Lbl_key.setText("Wrong! Correct Answer: " + correctAnswer);
    }

    // Tăng chỉ số câu hỏi
    index++;

    // Vô hiệu hóa các nút RadioButton
    enableRbuttons(false);

        
    }
    public void enableRbuttons(boolean yes_or_no)
    {
        jRadioButton1.setEnabled(yes_or_no);
        jRadioButton2.setEnabled(yes_or_no);
        jRadioButton3.setEnabled(yes_or_no);
        jRadioButton4.setEnabled(yes_or_no);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Q_Container = new javax.swing.JPanel();
        Lbl_Question = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton_Next_Q = new javax.swing.JButton();
        Lbl_key = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 219, 200));

        jPanel_Q_Container.setBackground(new java.awt.Color(234, 219, 200));

        Lbl_Question.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Lbl_Question.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\icons8-question-50.png")); // NOI18N
        Lbl_Question.setText("Question here... ?");

        javax.swing.GroupLayout jPanel_Q_ContainerLayout = new javax.swing.GroupLayout(jPanel_Q_Container);
        jPanel_Q_Container.setLayout(jPanel_Q_ContainerLayout);
        jPanel_Q_ContainerLayout.setHorizontalGroup(
            jPanel_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Q_ContainerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Lbl_Question, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel_Q_ContainerLayout.setVerticalGroup(
            jPanel_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Q_ContainerLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(Lbl_Question)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(234, 219, 200));

        jRadioButton1.setBackground(new java.awt.Color(255, 247, 209));
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 247, 209));
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 247, 209));
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(255, 247, 209));
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton_Next_Q.setBackground(new java.awt.Color(255, 247, 209));
        jButton_Next_Q.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Next_Q.setText("Next");
        jButton_Next_Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Next_QActionPerformed(evt);
            }
        });

        Lbl_key.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Lbl_key.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jButton_Next_Q))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(Lbl_key, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addGap(9, 9, 9)
                .addComponent(Lbl_key, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Next_Q)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Q_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Q_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        getSelectedOption(jRadioButton1);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        getSelectedOption(jRadioButton2);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        getSelectedOption(jRadioButton3);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        getSelectedOption(jRadioButton4);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton_Next_QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Next_QActionPerformed
       
        if (index > 0 && index < questions.size() && bg.getSelection() == null) {
            // Hiển thị thông báo nếu chưa chọn đáp án
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Bạn chưa chọn đáp án!",
                    "Thông báo",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return; // Dừng lại, không chuyển câu hỏi
        }
        if (jButton_Next_Q.getText().equals("Restart The Quiz")) {
            jButton_Next_Q.setText("Next");
            jPanel_Q_Container.setBackground(new Color(0xEADBC8));
            index = 0;
            correct = 0;
        }

        // Nếu đã trả lời hết các câu hỏi
        if (index == questions.size()) {
            if (correct >= (float) questions.size() / 2) {
                Lbl_Question.setText("Your Score: " + correct + " / " + questions.size());
                jPanel_Q_Container.setBackground(Color.green);
            } else {
                Lbl_Question.setText("Your Score: " + correct + " / " + questions.size());
                jPanel_Q_Container.setBackground(Color.red);
            }
            jButton_Next_Q.setText("Restart The Quiz");
        } else {
            // Chuyển sang câu hỏi mới
            enableRbuttons(true);

            // Hiển thị câu hỏi tiếp theo
            Lbl_Question.setText(questions.get(index));
            jRadioButton1.setText(answers.get(index).get(0));
            jRadioButton2.setText(answers.get(index).get(1));
            jRadioButton3.setText(answers.get(index).get(2));
            jRadioButton4.setText(answers.get(index).get(3));

            // Đặt lại trạng thái LbL_key
            Lbl_key.setText(""); // Xóa nội dung LbL_key
            Lbl_key.setForeground(Color.BLACK); // Đặt lại màu nếu cần

            // Nếu đây là câu hỏi cuối
            if (index == questions.size() - 1) {
                jButton_Next_Q.setText("Finish and See Your Result");
            }
        }

        // Xóa lựa chọn của người dùng
        bg.clearSelection();
    }//GEN-LAST:event_jButton_Next_QActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FlashCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashCard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_Question;
    private javax.swing.JLabel Lbl_key;
    private javax.swing.JButton jButton_Next_Q;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Q_Container;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
