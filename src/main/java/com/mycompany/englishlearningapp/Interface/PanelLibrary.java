package com.mycompany.englishlearningapp.Interface;

import com.mycompany.englishlearningapp.Database.LibraryController;
import com.mycompany.englishlearningapp.Database.VocabularyController;
import com.mycompany.englishlearningapp.Proccess.User;
import com.mycompany.englishlearningapp.Proccess.Vocabulary;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelLibrary extends javax.swing.JPanel {
    private final DefaultTableModel tableModel = new DefaultTableModel();
    final VocabularyController voc = new VocabularyController();
    final LibraryController lib = new LibraryController();
    private boolean apply = true;
    private Runnable callBack;
    private User currentUser = new User();
    private int currentUserID = -1;
    private int currentWordID = -1;

    public PanelLibrary(User user) throws SQLException {
        this.currentUser = user;
        this.currentUserID = currentUser.getUserID();
        
        initComponents();
        centerWindow();

        // Initialize Table Columns
        String[] columnNames = {"Từ mới", "Định nghĩa", "Ví dụ"};
        tableModel.setColumnIdentifiers(columnNames);
        tblVocabulary.setModel(tableModel);

        // Load initial data
        LoadVocabularyData();
        SetNull();
        SetLock(true);
        SetButton(true);

        tblVocabulary.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVocabularyMouseClicked(evt);
            }
        });
    }

    public PanelLibrary() throws SQLException {
        initComponents();
    }

    private void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnEnterInfo = new javax.swing.JPanel();
        lblVocabulary = new javax.swing.JLabel();
        lblDefinition = new javax.swing.JLabel();
        lblExample = new javax.swing.JLabel();
        txtVocabulary = new javax.swing.JTextField();
        txtDefinition = new javax.swing.JTextField();
        txtExample = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnUnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tblVocabulary = new javax.swing.JTable();

        pnEnterInfo.setBackground(new java.awt.Color(254, 250, 246));
        pnEnterInfo.setPreferredSize(new java.awt.Dimension(960, 238));
        pnEnterInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVocabulary.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblVocabulary.setText("Từ mới");
        pnEnterInfo.add(lblVocabulary, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        lblDefinition.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblDefinition.setText("Định nghĩa");
        pnEnterInfo.add(lblDefinition, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        lblExample.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        lblExample.setText("Ví dụ");
        pnEnterInfo.add(lblExample, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        txtVocabulary.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        pnEnterInfo.add(txtVocabulary, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 350, -1));

        txtDefinition.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        pnEnterInfo.add(txtDefinition, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 700, -1));

        txtExample.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        pnEnterInfo.add(txtExample, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 700, -1));

        btnAdd.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnEnterInfo.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        btnModify.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnModify.setText("Sửa");
        btnModify.setPreferredSize(new java.awt.Dimension(100, 30));
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        pnEnterInfo.add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        btnDelete.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnEnterInfo.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        btnSave.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnEnterInfo.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        btnClose.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnClose.setText("Thoát");
        btnClose.setPreferredSize(new java.awt.Dimension(100, 30));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnEnterInfo.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, -1, -1));

        btnUnSave.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnUnSave.setText("Không Lưu");
        btnUnSave.setPreferredSize(new java.awt.Dimension(100, 30));
        btnUnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnSaveActionPerformed(evt);
            }
        });
        pnEnterInfo.add(btnUnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 130, -1));

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));
        jPanel2.setPreferredSize(new java.awt.Dimension(372, 50));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 1, 30)); // NOI18N
        jLabel1.setText("THƯ VIỆN TỪ VỰNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(244, 244, 244))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pnEnterInfo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 800, -1));

        jScrollPane.setBackground(new java.awt.Color(251, 251, 251));
        jScrollPane.setFont(new java.awt.Font("Cascadia Code", 0, 16)); // NOI18N

        tblVocabulary.setFont(new java.awt.Font("Cascadia Code", 0, 16)); // NOI18N
        tblVocabulary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Từ mới", "Định nghĩa", "Ví dụ"
            }
        ));
        tblVocabulary.setRowHeight(30);
        jScrollPane.setViewportView(tblVocabulary);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnEnterInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
            .addComponent(jScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnEnterInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        SetNull();
        SetLock(false);
        SetButton(false);
        apply = true;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed

    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String word = txtVocabulary.getText();
        if (word.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xoá!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            if (currentWordID <= 0) {
                JOptionPane.showMessageDialog(this, "Chưa chọn từ vựng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa từ \"" + word + "\"?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean isDeleted = lib.DeleteVocabularyAndUserLibrary(currentUserID, currentWordID);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(null, "Xóa từ vựng thành công!");
                    LoadVocabularyData();
                    SetNull();
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa từ vựng thất bại!");
                }
            }
        }        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String nw = txtVocabulary.getText();
        String wd = txtDefinition.getText();
        String eg = txtExample.getText();

        if (nw.length() == 0 || wd.length() == 0 || eg.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", 1);
        } else {
            try {
                if (apply) {
                    boolean isInserted = lib.InsertVocabularyAndUserLibrary(currentUserID, nw, wd, eg);
                    if (isInserted) {
                        JOptionPane.showMessageDialog(null, "Thêm từ vựng thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm từ vựng thất bại!");
                    }
                } else {
                    lib.UpdateVocabulary(currentWordID, nw, wd, eg);
                }
                ClearData();
                LoadVocabularyData();
                SetNull();
                SetLock(true);
                SetButton(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Thông báo", 1);
            }
        }

        if (callBack != null) {
            callBack.run();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnSaveActionPerformed
        SetNull(); // Xóa các TextField
        SetLock(true); // Khóa các TextField
        SetButton(true); // Kích hoạt các Button Thêm, Sửa, Xóa, Thoát
    }//GEN-LAST:event_btnUnSaveActionPerformed


    public void tblVocabularyMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = tblVocabulary.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy từ vựng được chọn từ bảng
            String word = tableModel.getValueAt(selectedRow, 0).toString();

            // Dùng VocabularyController để lấy chi tiết từ vựng
            Vocabulary vocab = voc.getVocabularyByWord(word);

            if (vocab != null) {
                currentWordID = vocab.getVocabularyID(); // Cập nhật biến toàn cục
                txtVocabulary.setText(vocab.getWord());
                txtDefinition.setText(vocab.getDefinition());
                txtExample.setText(vocab.getExample());
            } else {
                currentWordID = -1; // Reset nếu không tìm thấy
                System.out.println("Không tìm thấy từ vựng: " + word);
            }
            System.out.println("currentWordID đã được cập nhật: " + currentWordID);

        }
    }

    private void LoadVocabularyData() {
        try {
            // Lấy danh sách các từ vựng dựa trên UserID
            List<Vocabulary> vocabList = lib.GetVocabByUserID(currentUserID);

            // Xóa dữ liệu cũ trong bảng
            ClearData();

            // Duyệt qua các từ vựng và lấy thông tin chi tiết từ VocabularyController
            for (Vocabulary vocab : vocabList) {
                if (vocab != null) {
                    tableModel.addRow(new String[]{vocab.getWord(), vocab.getDefinition(), vocab.getExample()});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading vocabulary data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ClearData() throws SQLException {
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void SetNull() {
        this.txtVocabulary.setText(null);
        this.txtDefinition.setText(null);
        this.txtExample.setText(null);
    }

    private void SetLock(boolean a) {
        this.txtVocabulary.setEnabled(!a);
        this.txtDefinition.setEnabled(!a);
        this.txtExample.setEnabled(!a);
    }

    private void SetButton(boolean a) {
        this.btnAdd.setEnabled(a);
        this.btnDelete.setEnabled(a);
        this.btnModify.setEnabled(a);
        this.btnSave.setEnabled(!a);
        this.btnUnSave.setEnabled(!a);
        this.btnClose.setEnabled(a);
    }

    public void setCallBack(Runnable callBack) {
        this.callBack = callBack;
    }

    // Gọi lại khi cần, ví dụ sau khi lưu dữ liệu
    private void onSave() {
        if (callBack != null) {
            callBack.run(); // Thực thi callBack để cập nhật dữ liệu
        }
    }

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
            java.util.logging.Logger.getLogger(PanelLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PanelLibrary().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelLibrary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblDefinition;
    private javax.swing.JLabel lblExample;
    private javax.swing.JLabel lblVocabulary;
    private javax.swing.JPanel pnEnterInfo;
    private javax.swing.JTable tblVocabulary;
    private javax.swing.JTextField txtDefinition;
    private javax.swing.JTextField txtExample;
    private javax.swing.JTextField txtVocabulary;
    // End of variables declaration//GEN-END:variables
}
