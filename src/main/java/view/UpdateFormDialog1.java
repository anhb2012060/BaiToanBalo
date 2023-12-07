/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import dao.SanPhamDao1;
import database.DataValidator;
import database.MessageDialogHelper;
import java.awt.Color;
import java.awt.Frame;
import model.SanPham;

/**
 *
 * @author OS
 */
public class UpdateFormDialog1 extends javax.swing.JDialog {

    private Balo1Form balo1Form;

    // Trong UpdateFormDialog
    public UpdateFormDialog1(java.awt.Frame parent, boolean modal, Balo1Form balo1Form) {
        super(parent, modal);
        initComponents();
        this.balo1Form = balo1Form;
        UpdateSanPhamForm();
    }
    
    public void setSanPham(SanPham sp) {
//        String stt = sp.getMa().split("_")[1];
        jTextField_SoThuTu.setText(sp.getMa());
        jTextField_TenSanPham.setText(sp.getTen());
        jTextField_TrongLuong.setText(sp.getTrongLuong() + "");
        jTextField_GiaTri.setText(sp.getGiaTri() + "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_thongTinSanPham = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_TenSanPham = new javax.swing.JTextField();
        jTextField_TrongLuong = new javax.swing.JTextField();
        jTextField_SoLuong = new javax.swing.JTextField();
        jTextField_GiaTri = new javax.swing.JTextField();
        jButton_CapNhat = new javax.swing.JButton();
        jLabel_thongtinsanpham = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField_SoThuTu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel_thongTinSanPham.setBackground(new java.awt.Color(204, 204, 204));
        jPanel_thongTinSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Trọng lượng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Giá trị:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Số lượng:");

        jTextField_TenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jTextField_TrongLuong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jTextField_SoLuong.setEditable(false);
        jTextField_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_SoLuong.setText("Không hạn chế");
        jTextField_SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SoLuongActionPerformed(evt);
            }
        });

        jTextField_GiaTri.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jButton_CapNhat.setBackground(new java.awt.Color(153, 153, 153));
        jButton_CapNhat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_CapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/update.png"))); // NOI18N
        jButton_CapNhat.setText("Cập nhật");
        jButton_CapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_CapNhatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_CapNhatMouseExited(evt);
            }
        });
        jButton_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapNhatActionPerformed(evt);
            }
        });

        jLabel_thongtinsanpham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_thongtinsanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_thongtinsanpham.setText("Nhập thông tin sản phẩm");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("Mã sản phẩm:");

        jTextField_SoThuTu.setEditable(false);
        jTextField_SoThuTu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_SoThuTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SoThuTuActionPerformed(evt);
            }
        });
        jTextField_SoThuTu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SoThuTuKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/delete.png"))); // NOI18N
        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_thongTinSanPhamLayout = new javax.swing.GroupLayout(jPanel_thongTinSanPham);
        jPanel_thongTinSanPham.setLayout(jPanel_thongTinSanPhamLayout);
        jPanel_thongTinSanPhamLayout.setHorizontalGroup(
            jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_thongtinsanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                        .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_GiaTri)
                            .addComponent(jTextField_SoLuong)))
                    .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                        .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_TrongLuong)
                            .addComponent(jTextField_TenSanPham)
                            .addComponent(jTextField_SoThuTu)
                            .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(jButton_CapNhat)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel_thongTinSanPhamLayout.setVerticalGroup(
            jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_thongtinsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jTextField_SoThuTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_TenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_TrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_GiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_thongTinSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_thongTinSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoLuongActionPerformed

    private void jButton_CapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CapNhatMouseEntered
        jButton_CapNhat.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_CapNhatMouseEntered

    private void jButton_CapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CapNhatMouseExited
        jButton_CapNhat.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_CapNhatMouseExited

    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatActionPerformed
        try {
            SanPham sp = new SanPham();
            sp.setTen(jTextField_TenSanPham.getText());
            sp.setTrongLuong(Double.parseDouble(jTextField_TrongLuong.getText()));
            sp.setGiaTri(Double.parseDouble(jTextField_GiaTri.getText()));
            sp.setMa(jTextField_SoThuTu.getText());
            if(SanPhamDao1.UpdateSanPham1(sp)){
                MessageDialogHelper.showMessageDialog(this,"Cập nhật sản phẩm thành công", "Thông báo");
                balo1Form.loadDataToTable(); // Gọi phương thức loadDataToTable để cập nhật dữ liệu trong bảng
                balo1Form.taoMoiForm();
                this.setVisible(false);
            } else {
                MessageDialogHelper.showErrorDialog(this, "Cập nhật sản phẩm không thành công", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_CapNhatActionPerformed

    private void jTextField_SoThuTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoThuTuActionPerformed
//        jButton_TimKiem.doClick();
    }//GEN-LAST:event_jTextField_SoThuTuActionPerformed

    private void jTextField_SoThuTuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SoThuTuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoThuTuKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        balo1Form.resetForm(evt);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_thongtinsanpham;
    private javax.swing.JPanel jPanel_thongTinSanPham;
    private javax.swing.JTextField jTextField_GiaTri;
    private javax.swing.JTextField jTextField_SoLuong;
    private javax.swing.JTextField jTextField_SoThuTu;
    private javax.swing.JTextField jTextField_TenSanPham;
    private javax.swing.JTextField jTextField_TrongLuong;
    // End of variables declaration//GEN-END:variables

    private void UpdateSanPhamForm() {
    }

}
