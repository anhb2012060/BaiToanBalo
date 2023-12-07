/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import algorithm.NhanhCan;
import algorithm.OpenFile;
import algorithm.QuyHoachDong;
import algorithm.ThamAn;
import algorithm.XuatFile;
import dao.BaloDao1;
import dao.PhuongAnDao1;
import dao.SanPhamDao1;
import database.DataValidator;
import database.MessageDialogHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Balo;
import model.SanPham;

/**
 *
 * @author OS
 */
public class Balo1Form extends javax.swing.JPanel {
    private DefaultTableModel tblModel;
    private MainView mainView;
    private boolean textFieldHasData = false;
    private UpdateFormDialog1 updateFormDialog;
    private int countShowJtable = 0;
    private int countFilter = 0;
    /**
     * Creates new form GreedyFormPanel
     */
    public Balo1Form() {
        initComponents();
        initTable();
        initComboBox_GiaiThuat();
        showReadData(false);
        showJTable(false);
    }

    public void initTable(){
        tblModel = new DefaultTableModel();
        String[] row = new String[]{"STT","Tên sản phẩm","Trọng lượng","Giá trị","Số lượng","Phương án"};
        tblModel.setColumnIdentifiers(row);
        
        jTable.setModel(tblModel);
    }
    
    public void initComboBox_GiaiThuat(){
        String[] data = new String[]{"Tham ăn","Nhánh cận","Quy hoạch động"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(data);
        jComboBox_GiaiThuat.setModel(model);
    } 
    
    public void loadDataToTable(){
        try {
            List<SanPham> list = SanPhamDao1.findByIdBalo(jTextField_MaBalo.getText());
            tblModel.setRowCount(0);
            
            Balo balo = BaloDao1.findById(jTextField_MaBalo.getText());
            jTextField_TrongLuongBalo.setText(balo.getTrongLuongBalo()+"");
            int stt = balo.getSoThuTu();
            if(stt==0){
                stt=1;
            }
            jTextField_SoThuTu.setText(stt+"");
            for(SanPham sp : list){
                tblModel.addRow(new Object[]{
                    sp.getMa().split("_")[sp.getMa().split("_").length - 1],
                    sp.getTen(),
                    sp.getTrongLuong(),
                    sp.getGiaTri(),
                    "Không hạn chế",
                    sp.getPhuongAn()
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
 
//xác định số thứ tự mình vừa nhập nó nằm ở hàng thứ mấy trong JTable:
    public int findRowIndexById(String stt){
        for(int row = 0; row < jTable.getRowCount(); row++){
            String sttInTable = (String) jTable.getValueAt(row, 0);
            if(stt.equals(sttInTable)){
                return row;
            }
        }
        return -1;
    }
    
    public String getMaBalo(){
        String str = jTextField_MaBalo.getText();
        return str;
    }
    
    public String getTrongLuongBalo(){
        return jTextField_TrongLuongBalo.getText();
    }
    
    public void resetForm(java.awt.event.ActionEvent evt){
        jTextField_SoThuTu.setText("");
        jTextField_TenSanPham.setText("");
        jTextField_GiaTri.setText("");
        jTextField_TrongLuong.setText("");
        jTextField_SoThuTu.setEditable(true); 
    }
    
    public void showJTable(boolean bl){
        jScrollPane.setVisible(bl);
        jTable.setVisible(true);
        jLabel_danhsach.setVisible(bl);
        jButton_first.setVisible(bl);
        jButton_previous.setVisible(bl);
        jButton_next.setVisible(bl);
        jButton_last.setVisible(bl);
        jButton_Loc.setVisible(bl);
    }
    
    public void showReadData(boolean bl){
        jPanel_thongTinSanPham.setVisible(bl);
        jPanel_themFile.setVisible(bl);
    }
    
    public void taoMoiForm(){
        jTextField_SoThuTu.setText("");
        jTextField_TenSanPham.setText("");
        jTextField_GiaTri.setText("");
        jTextField_TrongLuong.setText("");
        jTextField_SoThuTu.setEditable(true);
        Balo balo  = BaloDao1.findById(jTextField_MaBalo.getText());
        int soThuTu = balo.getSoThuTu();
        jTextField_SoThuTu.setText(soThuTu+"");
    }
    
//========================================================================================================================================== 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton_ChayChuongTrinh = new javax.swing.JButton();
        jPanel_thongTinSanPham = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_TenSanPham = new javax.swing.JTextField();
        jTextField_TrongLuong = new javax.swing.JTextField();
        jTextField_SoLuong = new javax.swing.JTextField();
        jTextField_GiaTri = new javax.swing.JTextField();
        jButton_Thêm = new javax.swing.JButton();
        jButton_CapNhat = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jLabel_thongtinsanpham = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField_SoThuTu = new javax.swing.JTextField();
        jButton_TimKiem = new javax.swing.JButton();
        jButton_TaoMoi = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_danhsach = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton_ResetForm = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_MaBalo = new javax.swing.JTextField();
        jButton_ThemMoiBalo = new javax.swing.JButton();
        jButton_LayDuLieu = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel_themFile = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton_OpenFile = new javax.swing.JButton();
        jButton_ReadOpenFile = new javax.swing.JButton();
        jComboBox_GiaiThuat = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel_TongTrongLuong = new javax.swing.JLabel();
        jLabel_TongGiaTri = new javax.swing.JLabel();
        jLabel_ThoiGianChay = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton_TrangThai = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField_TrongLuongBalo = new javax.swing.JTextField();
        jButton_Loc = new javax.swing.JButton();
        jButton_first = new javax.swing.JButton();
        jButton_previous = new javax.swing.JButton();
        jButton_next = new javax.swing.JButton();
        jButton_last = new javax.swing.JButton();
        jButton_YNghiaGiaiThuat = new javax.swing.JButton();
        jButton_showJTable = new javax.swing.JButton();
        jButton_Export = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BALO LOẠI 1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Chọn giải thuật:");

        jButton_ChayChuongTrinh.setBackground(new java.awt.Color(102, 102, 102));
        jButton_ChayChuongTrinh.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_ChayChuongTrinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/run.png"))); // NOI18N
        jButton_ChayChuongTrinh.setText("Run");
        jButton_ChayChuongTrinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ChayChuongTrinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ChayChuongTrinhMouseExited(evt);
            }
        });
        jButton_ChayChuongTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChayChuongTrinhActionPerformed(evt);
            }
        });

        jPanel_thongTinSanPham.setBackground(new java.awt.Color(200, 200, 200));
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

        jButton_Thêm.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Thêm.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_Thêm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/save.png"))); // NOI18N
        jButton_Thêm.setText("Thêm");
        jButton_Thêm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ThêmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ThêmMouseExited(evt);
            }
        });
        jButton_Thêm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThêmActionPerformed(evt);
            }
        });

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

        jButton_Xoa.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/delete.png"))); // NOI18N
        jButton_Xoa.setText("Xóa");
        jButton_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_XoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_XoaMouseExited(evt);
            }
        });
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jLabel_thongtinsanpham.setBackground(new java.awt.Color(200, 200, 200));
        jLabel_thongtinsanpham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_thongtinsanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_thongtinsanpham.setText("Nhập thông tin sản phẩm");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("Số thứ tự:");

        jTextField_SoThuTu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_SoThuTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SoThuTuActionPerformed(evt);
            }
        });
        jTextField_SoThuTu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SoThuTuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SoThuTuKeyTyped(evt);
            }
        });

        jButton_TimKiem.setBackground(new java.awt.Color(153, 153, 153));
        jButton_TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/search.png"))); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_TimKiemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_TimKiemMouseExited(evt);
            }
        });
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jButton_TaoMoi.setBackground(new java.awt.Color(153, 153, 153));
        jButton_TaoMoi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_TaoMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/new.png"))); // NOI18N
        jButton_TaoMoi.setText("Tạo mới");
        jButton_TaoMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_TaoMoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_TaoMoiMouseExited(evt);
            }
        });
        jButton_TaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaoMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_thongTinSanPhamLayout = new javax.swing.GroupLayout(jPanel_thongTinSanPham);
        jPanel_thongTinSanPham.setLayout(jPanel_thongTinSanPhamLayout);
        jPanel_thongTinSanPhamLayout.setHorizontalGroup(
            jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_thongtinsanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(jButton_TaoMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_TrongLuong)
                            .addGroup(jPanel_thongTinSanPhamLayout.createSequentialGroup()
                                .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Thêm)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_CapNhat)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Xoa)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField_TenSanPham, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_SoThuTu, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel_thongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Thêm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_TaoMoi))
                .addContainerGap())
        );

        jSeparator3.setForeground(new java.awt.Color(0, 51, 255));

        jLabel_danhsach.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel_danhsach.setForeground(new java.awt.Color(0, 51, 204));
        jLabel_danhsach.setText("Danh sách chi tiết sản phẩm");

        jTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.setEnabled(false);
        jTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTableMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTableMouseMoved(evt);
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTableMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }
        });
        jScrollPane.setViewportView(jTable);

        jButton_ResetForm.setBackground(new java.awt.Color(153, 153, 153));
        jButton_ResetForm.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_ResetForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/resetTab_24.png"))); // NOI18N
        jButton_ResetForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ResetFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ResetFormMouseExited(evt);
            }
        });
        jButton_ResetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetFormActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/imageBalo.png"))); // NOI18N
        jLabel8.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setText("Mã Balo");

        jTextField_MaBalo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField_MaBalo.setToolTipText("");
        jTextField_MaBalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MaBaloActionPerformed(evt);
            }
        });
        jTextField_MaBalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_MaBaloKeyReleased(evt);
            }
        });

        jButton_ThemMoiBalo.setBackground(new java.awt.Color(153, 153, 153));
        jButton_ThemMoiBalo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_ThemMoiBalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/newbalo_16.png"))); // NOI18N
        jButton_ThemMoiBalo.setText("Thêm mới");
        jButton_ThemMoiBalo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ThemMoiBaloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ThemMoiBaloMouseExited(evt);
            }
        });
        jButton_ThemMoiBalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemMoiBaloActionPerformed(evt);
            }
        });

        jButton_LayDuLieu.setBackground(new java.awt.Color(153, 153, 153));
        jButton_LayDuLieu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_LayDuLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/laydulieu_16.png"))); // NOI18N
        jButton_LayDuLieu.setText("Lấy dữ liệu");
        jButton_LayDuLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_LayDuLieuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_LayDuLieuMouseExited(evt);
            }
        });
        jButton_LayDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LayDuLieuActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nhập thông tin Balo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_ThemMoiBalo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_LayDuLieu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_MaBalo))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_MaBalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_ThemMoiBalo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton_LayDuLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_themFile.setBackground(new java.awt.Color(200, 200, 200));
        jPanel_themFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setBackground(new java.awt.Color(200, 200, 200));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("    Lấy dữ liệu từ file ");

        jButton_OpenFile.setBackground(new java.awt.Color(153, 153, 153));
        jButton_OpenFile.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_OpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/open.png"))); // NOI18N
        jButton_OpenFile.setText("Import");
        jButton_OpenFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_OpenFileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_OpenFileMouseExited(evt);
            }
        });
        jButton_OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OpenFileActionPerformed(evt);
            }
        });

        jButton_ReadOpenFile.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel_themFileLayout = new javax.swing.GroupLayout(jPanel_themFile);
        jPanel_themFile.setLayout(jPanel_themFileLayout);
        jPanel_themFileLayout.setHorizontalGroup(
            jPanel_themFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_themFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_themFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_OpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_themFileLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel_themFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_ReadOpenFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel_themFileLayout.setVerticalGroup(
            jPanel_themFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_themFileLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel14)
                .addGap(37, 37, 37)
                .addComponent(jButton_OpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jButton_ReadOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jComboBox_GiaiThuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel4.setBackground(new java.awt.Color(200, 200, 200));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Tổng trọng lượng tối ưu :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tổng giá trị tối ưu:");

        jLabel_TongTrongLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_TongTrongLuong.setForeground(new java.awt.Color(255, 51, 51));

        jLabel_TongGiaTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_TongGiaTri.setForeground(new java.awt.Color(255, 51, 51));

        jLabel_ThoiGianChay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel_ThoiGianChay.setForeground(new java.awt.Color(204, 0, 0));
        jLabel_ThoiGianChay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setText("Thời gian chạy chương trình (mili giây) :");

        jButton_TrangThai.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_TongTrongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_TongGiaTri, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jLabel_ThoiGianChay, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_ThoiGianChay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel_TongTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel_TongGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton_TrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setText("Nhập trọng lượng Balo:");

        jTextField_TrongLuongBalo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jButton_Loc.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Loc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_Loc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/loc_16.png"))); // NOI18N
        jButton_Loc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_LocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_LocMouseExited(evt);
            }
        });
        jButton_Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LocActionPerformed(evt);
            }
        });

        jButton_first.setBackground(new java.awt.Color(153, 153, 153));
        jButton_first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/first_32.png"))); // NOI18N
        jButton_first.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_firstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_firstMouseExited(evt);
            }
        });
        jButton_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_firstActionPerformed(evt);
            }
        });

        jButton_previous.setBackground(new java.awt.Color(153, 153, 153));
        jButton_previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/previous_32.png"))); // NOI18N
        jButton_previous.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_previousMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_previousMouseExited(evt);
            }
        });
        jButton_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_previousActionPerformed(evt);
            }
        });

        jButton_next.setBackground(new java.awt.Color(153, 153, 153));
        jButton_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/next_32.png"))); // NOI18N
        jButton_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_nextMouseExited(evt);
            }
        });
        jButton_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nextActionPerformed(evt);
            }
        });

        jButton_last.setBackground(new java.awt.Color(153, 153, 153));
        jButton_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/last_32.png"))); // NOI18N
        jButton_last.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_lastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_lastMouseExited(evt);
            }
        });
        jButton_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_lastActionPerformed(evt);
            }
        });

        jButton_YNghiaGiaiThuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/help.png"))); // NOI18N
        jButton_YNghiaGiaiThuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_YNghiaGiaiThuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_YNghiaGiaiThuatMouseExited(evt);
            }
        });
        jButton_YNghiaGiaiThuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_YNghiaGiaiThuatActionPerformed(evt);
            }
        });

        jButton_showJTable.setBackground(new java.awt.Color(153, 153, 153));
        jButton_showJTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_showJTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/down_24.png"))); // NOI18N
        jButton_showJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_showJTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_showJTableMouseExited(evt);
            }
        });
        jButton_showJTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_showJTableActionPerformed(evt);
            }
        });

        jButton_Export.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Export.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton_Export.setText("Export File");
        jButton_Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExportActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Xem so sánh các giải thuật ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel_thongTinSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel_themFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_ResetForm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_danhsach)
                                .addGap(287, 287, 287)
                                .addComponent(jButton_first, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_next, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_last, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox_GiaiThuat, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_YNghiaGiaiThuat))
                                    .addComponent(jTextField_TrongLuongBalo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_ChayChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton_showJTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Export)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jButton_ResetForm, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel_thongTinSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_themFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jButton_showJTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_next)
                    .addComponent(jButton_last)
                    .addComponent(jButton_first, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Loc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_danhsach)
                        .addComponent(jButton_previous)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField_TrongLuongBalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_YNghiaGiaiThuat)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox_GiaiThuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton_ChayChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Export)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoLuongActionPerformed

    private void jButton_ResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetFormActionPerformed
        jTextField_MaBalo.setText("");
        jTextField_MaBalo.setEditable(true);
        resetForm(evt);
        jTextField_TrongLuongBalo.setText("");
        DefaultTableModel tblModel = (DefaultTableModel) jTable.getModel();
        tblModel.setRowCount(0); // Xóa tất cả các hàng trong bảng
        jLabel_TongTrongLuong.setText("");
        jLabel_TongGiaTri.setText("");
        showReadData(false);
        showJTable(false);
        jButton_showJTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/down_24.png")));
        jButton_Loc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/loc_16.png")));
    }//GEN-LAST:event_jButton_ResetFormActionPerformed

    private void jButton_ThemMoiBaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemMoiBaloActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validatorEmpty(jTextField_MaBalo, sb, "Mã Balo không được để trống !");
        
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainView, sb.toString(), "Error");
            return ;
        }
        if(SanPhamDao1.searchByID(jTextField_MaBalo.getText())){
            MessageDialogHelper.showErrorDialog(mainView, "Balo đã tồn tại", "Error");
            return;
        }
        try {
            Balo balo = new Balo();
            balo.setMa(jTextField_MaBalo.getText());
            if(MessageDialogHelper.showConfirmDialog(mainView, 
                                                    "Bạn xác nhận thêm Balo mã "+jTextField_MaBalo.getText()+" ?", 
                                                    "Xác nhận") == JOptionPane.NO_OPTION)
            {
                return;
            }
            if(BaloDao1.insertBalo(balo)){
                MessageDialogHelper.showMessageDialog(mainView, "Thêm Balo thành công", "Thông báo");
                jTextField_MaBalo.setEditable(false);
                showReadData(true);
                int stt =1;
                BaloDao1.updateSttBalo(jTextField_MaBalo.getText(), stt);
                jTable.setVisible(false);
                loadDataToTable();
            } else {
                MessageDialogHelper.showErrorDialog(mainView, "Thêm Balo thất bại", "Lỗi");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainView, e.getMessage(), "Lỗi");
        }
        
    }//GEN-LAST:event_jButton_ThemMoiBaloActionPerformed
    
    private void jButton_ThêmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThêmActionPerformed
        Balo balo  = BaloDao1.findById(jTextField_MaBalo.getText());
        int soThuTu = balo.getSoThuTu();
        if(Integer.parseInt(jTextField_SoThuTu.getText())<soThuTu){
            soThuTu=soThuTu;
        } else {
            soThuTu++;
        }
        
        StringBuilder sb = new StringBuilder();
        DataValidator.validatorEmpty(jTextField_TenSanPham, sb, "Tên sản phẩm không được để trống !");
        DataValidator.validatorEmpty(jTextField_TrongLuong, sb, "Trọng lượng sản phẩm không được để trống !");
        DataValidator.validatorEmpty(jTextField_GiaTri, sb, "Giá trị sản phẩm không được để trống !");
        
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainView, sb.toString(), "Error");
            return ;
        }
        
        if(SanPhamDao1.findSanPhamByID(jTextField_MaBalo.getText()+"_"+jTextField_SoThuTu.getText())){
            MessageDialogHelper.showErrorDialog(mainView, "Mã sản phẩm đã tồn tại", "Lỗi");
            jButton_TaoMoiActionPerformed(evt);
            return;
        }
        try {
            SanPham sanpham = new SanPham();
            sanpham.setMa(jTextField_MaBalo.getText()+"_"+jTextField_SoThuTu.getText());
            sanpham.setTen(jTextField_TenSanPham.getText());
            sanpham.setTrongLuong(Double.parseDouble(jTextField_TrongLuong.getText()));
            sanpham.setGiaTri(Double.parseDouble(jTextField_GiaTri.getText()));
            String maBalo = jTextField_MaBalo.getText();
            
            if(SanPhamDao1.insertSanPham(sanpham, maBalo)){
                MessageDialogHelper.showMessageDialog(mainView, "Thêm sản phẩm thành công", "Thông báo");
                BaloDao1.updateSttBalo(jTextField_MaBalo.getText(), soThuTu);
                jButton_TaoMoiActionPerformed(evt);
                jTextField_SoThuTu.setText(soThuTu+"");
                loadDataToTable();
            } else {
                MessageDialogHelper.showErrorDialog(mainView, "Thêm sản phẩm thất bại", "Lỗi");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainView, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_jButton_ThêmActionPerformed

    private void jButton_LayDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LayDuLieuActionPerformed
        if(!SanPhamDao1.searchByID(jTextField_MaBalo.getText())){
            MessageDialogHelper.showErrorDialog(mainView, "Balo chưa tồn tại", "Error");
            return;
        }
        showReadData(true);
        jTextField_MaBalo.setEditable(false);
        loadDataToTable();
    }//GEN-LAST:event_jButton_LayDuLieuActionPerformed

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validatorEmpty(jTextField_SoThuTu, sb, "Bạn chưa nhập số thứ tự Balo cần tìm !");
        
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainView, sb.toString(), "Error");
            return ;
        }   
        
        try {
            String maSanPham = jTextField_MaBalo.getText()+"_"+jTextField_SoThuTu.getText();
            SanPham sp = SanPhamDao1.findById(maSanPham);
            if(sp == null){
                MessageDialogHelper.showErrorDialog(mainView, "Không tìm thấy sản phẩm !", "Error");
            } else {
                jTextField_TenSanPham.setText(sp.getTen());
                jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                jTextField_GiaTri.setText(sp.getGiaTri()+"");
//Chọn hàng trong bảng: 
                int rowIndex = findRowIndexById(jTextField_SoThuTu.getText());
                if(rowIndex>=0){
                    jTable.setRowSelectionInterval(rowIndex, rowIndex);
                }
                // Cuộn đến vị trí của hàng được chọn
                Rectangle cellRect = jTable.getCellRect(rowIndex, 0, true);
                jTable.scrollRectToVisible(cellRect);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(mainView, "Không tìm thấy sản phẩm", "Error");
        }
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validatorEmpty(jTextField_SoThuTu, sb, "Chưa chọn sản phẩm cần xóa!");
        
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainView, sb.toString(), "Error");
            return ;
        }
        
        try {
            if(SanPhamDao1.deleteById(jTextField_MaBalo.getText()+"_"+jTextField_SoThuTu.getText())){
                Balo balo  = BaloDao1.findById(jTextField_MaBalo.getText());
                int soThuTu = balo.getSoThuTu();
                jButton_TaoMoiActionPerformed(evt);
                jTextField_SoThuTu.setText(soThuTu+"");
                loadDataToTable();
            } else {
                MessageDialogHelper.showErrorDialog(mainView,"Xóa sản phẩm thất bại", "Error");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapNhatActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validatorEmpty(jTextField_SoThuTu, sb, "Chưa nhập số thứ tự Balo!");
        
        if(sb.length() > 0){
            MessageDialogHelper.showErrorDialog(mainView, sb.toString(), "Error");
            return ;
        }
        try {
            int row = Integer.parseInt(jTextField_SoThuTu.getText());
            SanPham sp = new SanPham();
            sp.setTen(jTextField_TenSanPham.getText());
            sp.setTrongLuong(Double.parseDouble(jTextField_TrongLuong.getText()));
            sp.setGiaTri(Double.parseDouble(jTextField_GiaTri.getText()));
            sp.setMa(jTextField_MaBalo.getText()+"_"+jTextField_SoThuTu.getText());
            if(SanPhamDao1.UpdateSanPham1(sp)){
                MessageDialogHelper.showMessageDialog(mainView,"Cập nhật sản phẩm thành công", "Thông báo");
                jButton_TaoMoiActionPerformed(evt);
                loadDataToTable();
                Balo balo  = BaloDao1.findById(jTextField_MaBalo.getText());
                int soThuTu = balo.getSoThuTu();
                jTextField_SoThuTu.setText(soThuTu+"");
                jTable.setRowSelectionInterval(row-1, row-1);
            } else {
                MessageDialogHelper.showErrorDialog(mainView, "Cập nhật sản phẩm không thành công", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_CapNhatActionPerformed

    private void jButton_OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OpenFileActionPerformed
        jButton_ReadOpenFile.setBackground(Color.red);
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn tệp đã chọn
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            // Xác nhận người dùng có đọc file từ tập tin vừa chọn không:
            String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
            if(MessageDialogHelper.showConfirmDialog(mainView, 
                                                    "Bạn xác nhận đọc dữ liệu từ file "+fileName+" ?", 
                                                    "Xác nhận") == JOptionPane.NO_OPTION)
            {
                return;
            }
            try {
                // Gọi hàm đọc tệp của bạn và xử lý nó ở đây
                Balo balo = OpenFile.docTepBalo1(filePath,jTextField_MaBalo.getText());
                //Set mã balo cho đối tượng Balo, vì trong hàm đọc file đối tượng Balo chưa đc set Mã.
                String maBalo = jTextField_MaBalo.getText();
                balo.setMa(maBalo);
                //Lấy danh sách sản phẩm đọc từ file để tải lên bảng dữ liệu:
                int n = BaloDao1.findById(maBalo).getSoThuTu();
                List<SanPham> sanPhams = balo.getDanhSachSanPham();
                for(SanPham sp : sanPhams){
                    jTextField_SoThuTu.setText(n+"");
                    String ma = sp.getMa();
                    sp.setMa(ma+n);
                    SanPhamDao1.insertSanPham(sp, maBalo);
                    n++;
                }
                BaloDao1.updateSttBalo(maBalo, n);
                jTextField_TrongLuongBalo.setText(balo.getTrongLuongBalo()+"");
                //Load lại bảng, để thấy dữ liệu vừa mới lên.
                loadDataToTable();
            } catch (IOException ex) {
                Logger.getLogger(Balo1Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jButton_ReadOpenFile.setBackground(new Color(0,102,0));
    }//GEN-LAST:event_jButton_OpenFileActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                int row = jTable.getSelectedRow();
                if (row >= 0) {
                    String stt = (String) jTable.getValueAt(row, 0);
                    String maSanPham = jTextField_MaBalo.getText() + "_" + stt;
                    SanPham sp = SanPhamDao1.findById(maSanPham);

                    // Hiển thị dialog
                    updateFormDialog = new UpdateFormDialog1(this.mainView, true, this);
                    // Cập nhật các giá trị vào UpdateFormDialog
                    updateFormDialog.setSanPham(sp);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    int windowWidth = updateFormDialog.getWidth();
                    int windowHeight = updateFormDialog.getHeight();
                    int x = screenSize.width - windowWidth; // Vị trí bên phải
                    int y = 0; // Góc trên cùng
                    updateFormDialog.setLocation(x, y);
                    updateFormDialog.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        //Chọn hàng trong bảng: 
        try {
            int row = jTable.getSelectedRow();
            if(row>=0){
                String stt = (String) jTable.getValueAt(row, 0);
                String maSanPham = jTextField_MaBalo.getText()+"_"+stt;
                SanPham sp = SanPhamDao1.findById(maSanPham);
                if(sp!=null){
                    jTextField_SoThuTu.setText(stt);
                    jTextField_TenSanPham.setText(sp.getTen());
                    jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                    jTextField_GiaTri.setText(sp.getGiaTri()+"");
                }
            }
            jTextField_SoThuTu.setEditable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTableMouseClicked
  
    public String getBalo(){
        return jTextField_MaBalo.getText();
    }
    
    private void jButton_ChayChuongTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChayChuongTrinhActionPerformed
        jButton_TrangThai.setBackground(Color.red);
        // Khởi tạo trạng thái lỗi
        boolean hasError = false;

        // Kiểm tra trọng lượng có rỗng không
        String trongLuongText = jTextField_TrongLuongBalo.getText();
        if (trongLuongText.isEmpty()) {
            MessageDialogHelper.showErrorDialog(mainView, "Chưa nhập trọng lượng cho Balo!", "Error");
            hasError = true;
        }

        if (hasError) {
            return;
        }

        resetForm(evt);

        // Lấy danh sách sản phẩm dựa theo mã Balo
        List<SanPham> sanPhams = SanPhamDao1.findByIdBalo(jTextField_MaBalo.getText());

        // Tạo đối tượng Balo
        Balo balo = new Balo();
        balo.setMa(jTextField_MaBalo.getText());
        balo.setTrongLuongBalo(Double.parseDouble(trongLuongText));
        balo.setDanhSachSanPham(sanPhams);

        // Lưu thông tin cho trọng lượng Balo, để lần sau có thể xuất hiện
        BaloDao1.updateBalo(balo.getTrongLuongBalo(), balo.getMa());

        // Khởi tạo thời gian bắt đầu
        Date startTime = new Date();
        int i =0;
        // Xác định giải thuật cần chạy chương trình
        String giaiThuat = (String) jComboBox_GiaiThuat.getSelectedItem();
        switch (giaiThuat) {
            case "Tham ăn":
                ThamAn.RunThamAn1(balo);
                i=1;
                break;
            case "Nhánh cận":
                NhanhCan.runNhanhCan1(balo);
                i=2;
                break;
            case "Quy hoạch động":
                QuyHoachDong.runQuyHoachDong1(balo);
                i=3;
                break;
        }

        // Khởi tạo thời gian kết thúc
        Date endTime = new Date();

        // Sử lý in ra thông tin sau ghi chạy giải thuật
        double tongTrongLuong = 0;
        double tongGiaTri = 0;
        for (SanPham sp : balo.getDanhSachSanPham()) {
            SanPhamDao1.UpdateSanPham(sp);
            if(i==1){
                PhuongAnDao1.updateThamAn(sp.getMa(), sp.getPhuongAn());
            } else if(i==2){
                PhuongAnDao1.updateNhanhCan(sp.getMa(), sp.getPhuongAn());
            } else{
                PhuongAnDao1.updateQuyHoachDong(sp.getMa(), sp.getPhuongAn());
            }
            tongTrongLuong += sp.getTrongLuong() * sp.getPhuongAn();
            tongGiaTri += sp.getGiaTri() * sp.getPhuongAn();
        }

        jLabel_TongGiaTri.setText(String.valueOf(tongGiaTri));
        jLabel_TongTrongLuong.setText(tongTrongLuong + "/" + trongLuongText);

        // Tính thời gian chạy
        long elapsedTime = endTime.getTime() - startTime.getTime();
        jLabel_ThoiGianChay.setText(String.valueOf(elapsedTime));

        loadDataToTable();
        jButton_TrangThai.setBackground(new Color(0, 102, 0));
        jButton_TrangThai.setBackground(new Color(0,102,0));
    }//GEN-LAST:event_jButton_ChayChuongTrinhActionPerformed
    
    private void jButton_LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LocActionPerformed
        if(countFilter==0){
            try {
                List<SanPham> list = SanPhamDao1.LocSanPham(jTextField_MaBalo.getText());
                tblModel.setRowCount(0);
                for(SanPham sp : list){
                    tblModel.addRow(new Object[]{
                        sp.getMa().split("_")[sp.getMa().split("_").length - 1],
                        sp.getTen(),
                        sp.getTrongLuong(),
                        sp.getGiaTri(),
                        "Không hạn chế",
                        sp.getPhuongAn()
                    });
                }
                tblModel.fireTableDataChanged();
            } catch (Exception e) {
            }
            jButton_Loc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/reset_16.png")));
            countFilter++;
        } else if(countFilter==1){
            try {
                SanPhamDao1 dao = new SanPhamDao1();
                List<SanPham> list = dao.findByIdBalo(jTextField_MaBalo.getText());
                tblModel.setRowCount(0);
                for(SanPham sp : list){
                    tblModel.addRow(new Object[]{
                        sp.getMa().split("_")[sp.getMa().split("_").length - 1],
                        sp.getTen(),
                        sp.getTrongLuong(),
                        sp.getGiaTri(),
                        "Không hạn chế",
                        sp.getPhuongAn()
                    });
                }
                tblModel.fireTableDataChanged();
            } catch (Exception e) {
            }
            jButton_Loc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/loc_16.png")));
            countFilter--;
        }
    }//GEN-LAST:event_jButton_LocActionPerformed

//=======================Rê chuột giúp thay đổi kích thước nút button=====================================
    private void jButton_ThemMoiBaloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ThemMoiBaloMouseEntered
        jButton_ThemMoiBalo.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_ThemMoiBaloMouseEntered

    private void jButton_ThemMoiBaloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ThemMoiBaloMouseExited
        jButton_ThemMoiBalo.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_ThemMoiBaloMouseExited
//==========================================================================================================
    private void jButton_LayDuLieuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LayDuLieuMouseEntered
        jButton_LayDuLieu.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_LayDuLieuMouseEntered

    private void jButton_LayDuLieuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LayDuLieuMouseExited
        jButton_LayDuLieu.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_LayDuLieuMouseExited
//==========================================================================================================
    private void jButton_OpenFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_OpenFileMouseEntered
        jButton_OpenFile.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_OpenFileMouseEntered

    private void jButton_OpenFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_OpenFileMouseExited
        jButton_OpenFile.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_OpenFileMouseExited
//==========================================================================================================
    // Trong hàm reset form là reset lại hoàn toàn form, còn hàm tạo mới là reset form nhưng cập nhập giá trị cho stt.
    private void jButton_TaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaoMoiActionPerformed
        taoMoiForm();
        jTable.clearSelection();
    }//GEN-LAST:event_jButton_TaoMoiActionPerformed
//==========================================================================================================
    private void jButton_ChayChuongTrinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ChayChuongTrinhMouseEntered
        jButton_ChayChuongTrinh.setBackground(Color.RED);
//        jButton_ChayChuongTrinh.setSize(104, 62);
    }//GEN-LAST:event_jButton_ChayChuongTrinhMouseEntered

    private void jButton_ChayChuongTrinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ChayChuongTrinhMouseExited
        jButton_ChayChuongTrinh.setBackground(new Color(102,102,102));
//        jButton_ChayChuongTrinh.setSize(98, 54);
    }//GEN-LAST:event_jButton_ChayChuongTrinhMouseExited
//==========================================================================================================
    private void jButton_TaoMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TaoMoiMouseEntered
        jButton_TaoMoi.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_TaoMoiMouseEntered

    private void jButton_TaoMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TaoMoiMouseExited
        jButton_TaoMoi.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_TaoMoiMouseExited
//==========================================================================================================
    private void jButton_TimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TimKiemMouseEntered
        jButton_TimKiem.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_TimKiemMouseEntered

    private void jButton_TimKiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TimKiemMouseExited
        jButton_TimKiem.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_TimKiemMouseExited
//==========================================================================================================
    private void jButton_ThêmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ThêmMouseEntered
        jButton_Thêm.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_ThêmMouseEntered

    private void jButton_ThêmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ThêmMouseExited
        jButton_Thêm.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_ThêmMouseExited
//==========================================================================================================
    private void jButton_CapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CapNhatMouseEntered
        jButton_CapNhat.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_CapNhatMouseEntered

    private void jButton_CapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CapNhatMouseExited
        jButton_CapNhat.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_CapNhatMouseExited
//==========================================================================================================
    private void jButton_XoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_XoaMouseEntered
        jButton_Xoa.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_XoaMouseEntered

    private void jButton_XoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_XoaMouseExited
        jButton_Xoa.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_XoaMouseExited
//==========================================================================================================
    private void jButton_LocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LocMouseEntered
        jButton_Loc.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_LocMouseEntered

    private void jButton_LocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LocMouseExited
        jButton_Loc.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_LocMouseExited
//==========================================================================================================
    private void jButton_ResetFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ResetFormMouseEntered
//        jButton_ResetForm.setSize(78, 40);
        jButton_ResetForm.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_ResetFormMouseEntered

    private void jButton_ResetFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ResetFormMouseExited
//        jButton_ResetForm.setSize(72, 35);
        jButton_ResetForm.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_ResetFormMouseExited

    private void jTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseReleased
        
    }//GEN-LAST:event_jTableMouseReleased

    //Vừa duy chuyển vừa nhấn giữ chuột mới được
    private void jTableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseDragged

    }//GEN-LAST:event_jTableMouseDragged
    //Chỉ cần rê chuột ngang qua không cần nhấn giữ
    private void jTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseMoved
        if (!textFieldHasData) {
            int row = jTable.rowAtPoint(evt.getPoint()); // Lấy hàng được chọn
            if (row >= 0) {
                jTable.getSelectionModel().setSelectionInterval(row, row); // Chọn hàng
            }
        }
    }//GEN-LAST:event_jTableMouseMoved

    private void jTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseExited
        jTable.clearSelection(); // Xóa lựa chọn hàng
        //Chọn hàng trong bảng: 
        int rowIndex = findRowIndexById(jTextField_SoThuTu.getText());
        if(rowIndex>=0){
            jTable.setRowSelectionInterval(rowIndex, rowIndex);
        }
    }//GEN-LAST:event_jTableMouseExited

    private void jTextField_MaBaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MaBaloActionPerformed
//        jButton_LayDuLieu.doClick();
    }//GEN-LAST:event_jTextField_MaBaloActionPerformed
    
    private void jTextField_SoThuTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoThuTuActionPerformed
        jButton_TimKiem.doClick();
    }//GEN-LAST:event_jTextField_SoThuTuActionPerformed

    private void jTextField_SoThuTuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SoThuTuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoThuTuKeyTyped

    private void jTextField_MaBaloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_MaBaloKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Xử lý khi nhấn Enter
            if (!SanPhamDao1.searchByID(jTextField_MaBalo.getText())) {
                MessageDialogHelper.showErrorDialog(mainView, "Balo chưa tồn tại", "Error");
                return;
            }
            showReadData(true);
            jTextField_MaBalo.setEditable(false);
            loadDataToTable();
        }
    }//GEN-LAST:event_jTextField_MaBaloKeyReleased

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMousePressed
        
    }//GEN-LAST:event_jTableMousePressed
//==========================================================================================================
    private void jButton_lastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_lastMouseEntered
        jButton_last.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_lastMouseEntered

    private void jButton_lastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_lastMouseExited
        jButton_last.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_lastMouseExited
//==========================================================================================================
    private void jButton_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_nextMouseEntered
        jButton_next.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_nextMouseEntered

    private void jButton_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_nextMouseExited
        jButton_next.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_nextMouseExited
//==========================================================================================================
    private void jButton_previousMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_previousMouseEntered
        jButton_previous.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_previousMouseEntered

    private void jButton_previousMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_previousMouseExited
        jButton_previous.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_previousMouseExited
//==========================================================================================================
    private void jButton_firstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_firstMouseEntered
        jButton_first.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_firstMouseEntered

    private void jButton_firstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_firstMouseExited
        jButton_first.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_firstMouseExited

    private void jButton_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_firstActionPerformed
        //Chọn hàng trong bảng: 
        jTable.setRowSelectionInterval(0, 0);
        // Cuộn đến vị trí của hàng được chọn
        Rectangle cellRect = jTable.getCellRect(0, 0, true);
        jTable.scrollRectToVisible(cellRect);
        try {
            int row = jTable.getSelectedRow();
            if(row>=0){
                String stt = (String) jTable.getValueAt(row, 0);
                String maSanPham = jTextField_MaBalo.getText()+"_"+stt;
                SanPham sp = SanPhamDao1.findById(maSanPham);
                if(sp!=null){
                    jTextField_SoThuTu.setText(stt);
                    jTextField_TenSanPham.setText(sp.getTen());
                    jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                    jTextField_GiaTri.setText(sp.getGiaTri()+"");
                }
            }
            jTextField_SoThuTu.setEditable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_firstActionPerformed

    private void jButton_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_lastActionPerformed
        //Chọn hàng trong bảng: 
        int rowSelect = jTable.getRowCount()-1;
        jTable.setRowSelectionInterval(rowSelect, rowSelect);
        // Cuộn đến vị trí của hàng được chọn
        Rectangle cellRect = jTable.getCellRect(rowSelect, 0, true);
        jTable.scrollRectToVisible(cellRect);
        try {
            int row = jTable.getSelectedRow();
            if(row>=0){
                String stt = (String) jTable.getValueAt(row, 0);
                String maSanPham = jTextField_MaBalo.getText()+"_"+stt;
                SanPham sp = SanPhamDao1.findById(maSanPham);
                if(sp!=null){
                    jTextField_SoThuTu.setText(stt);
                    jTextField_TenSanPham.setText(sp.getTen());
                    jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                    jTextField_GiaTri.setText(sp.getGiaTri()+"");
                }
            }
            jTextField_SoThuTu.setEditable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_lastActionPerformed

    private void jButton_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nextActionPerformed
        int rowSelect = jTable.getSelectedRow();
        int rowMax = jTable.getRowCount()-1;
        int row = rowSelect+1;
        if(row>rowMax){
            row = 0;
        }
        // Cuộn đến vị trí của hàng được chọn
        Rectangle cellRect = jTable.getCellRect(row, 0, true);
        jTable.scrollRectToVisible(cellRect);
        if(row >=0 && row<=rowMax){
            jTable.setRowSelectionInterval(row, row);
        } else {
            return;
        }
        try {
            if(row>=0){
                String stt = (String) jTable.getValueAt(row, 0);
                String maSanPham = jTextField_MaBalo.getText()+"_"+stt;
                SanPham sp = SanPhamDao1.findById(maSanPham);
                if(sp!=null){
                    jTextField_SoThuTu.setText(stt);
                    jTextField_TenSanPham.setText(sp.getTen());
                    jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                    jTextField_GiaTri.setText(sp.getGiaTri()+"");
                }
            }
            jTextField_SoThuTu.setEditable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_nextActionPerformed

    private void jButton_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_previousActionPerformed
        int rowSelect = jTable.getSelectedRow();
        int rowMax = jTable.getRowCount()-1;
        int row = rowSelect-1;
        if(row<0){
            row = rowMax;
        }
        // Cuộn đến vị trí của hàng được chọn
        Rectangle cellRect = jTable.getCellRect(row, 0, true);
        jTable.scrollRectToVisible(cellRect);
        if(row >=0 && row<=rowMax){
            jTable.setRowSelectionInterval(row, row);
        } else {
            return;
        }
        try {
            if(row>=0){
                String stt = (String) jTable.getValueAt(row, 0);
                String maSanPham = jTextField_MaBalo.getText()+"_"+stt;
                SanPham sp = SanPhamDao1.findById(maSanPham);
                if(sp!=null){
                    jTextField_SoThuTu.setText(stt);
                    jTextField_TenSanPham.setText(sp.getTen());
                    jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                    jTextField_GiaTri.setText(sp.getGiaTri()+"");
                }
            }
            jTextField_SoThuTu.setEditable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_previousActionPerformed

    private void jTextField_SoThuTuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SoThuTuKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            StringBuilder sb = new StringBuilder();
            DataValidator.validatorEmpty(jTextField_SoThuTu, sb, "Bạn chưa nhập số thứ tự Balo cần tìm !");

            if(sb.length() > 0){
                MessageDialogHelper.showErrorDialog(mainView, sb.toString(), "Error");
                return ;
            }

            try {
                String maSanPham = jTextField_MaBalo.getText()+"_"+jTextField_SoThuTu.getText();
                SanPham sp = SanPhamDao1.findById(maSanPham);
                if(sp == null){
                    MessageDialogHelper.showErrorDialog(mainView, "Không tìm thấy sản phẩm !", "Error");
                } else {
                    jTextField_TenSanPham.setText(sp.getTen());
                    jTextField_TrongLuong.setText(sp.getTrongLuong()+"");
                    jTextField_GiaTri.setText(sp.getGiaTri()+"");
    //Chọn hàng trong bảng: 
                    int rowIndex = findRowIndexById(jTextField_SoThuTu.getText());
                    if(rowIndex>=0){
                        jTable.setRowSelectionInterval(rowIndex, rowIndex);
                    }
                    // Cuộn đến vị trí của hàng được chọn
                    Rectangle cellRect = jTable.getCellRect(rowIndex, 0, true);
                    jTable.scrollRectToVisible(cellRect);
                }

            } catch (Exception e) {
                e.printStackTrace();
                MessageDialogHelper.showErrorDialog(mainView, "Không tìm thấy sản phẩm", "Error");
            }
        }
    }//GEN-LAST:event_jTextField_SoThuTuKeyReleased

    private void jButton_YNghiaGiaiThuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_YNghiaGiaiThuatActionPerformed
        String giaiThuat = (String) jComboBox_GiaiThuat.getSelectedItem();
        JDialog dialog = null; // Khai báo biến dialog ở ngoài để kiểm tra trạng thái

        if (giaiThuat.equals("Tham ăn")) {
            dialog = new ThamAnDialog(this.mainView, true);
        } else if (giaiThuat.equals("Nhánh cận")) {
            dialog = new NhanhCanDialog(mainView, true);
        } else if (giaiThuat.equals("Quy hoạch động")) {
            dialog = new QuyHoachDongDialog(mainView, true);
        }

        if (dialog != null) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int windowWidth = dialog.getWidth();
            int windowHeight = dialog.getHeight();
            int x = screenSize.width - windowWidth; // Vị trí bên phải
            int y = 0; // Góc trên cùng
            dialog.setLocation(x, y);

            // Kiểm tra trạng thái hiển thị của dialog
            if (dialog.isVisible()) {
                dialog.setVisible(false);
            } else {
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton_YNghiaGiaiThuatActionPerformed

    private void jButton_showJTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_showJTableActionPerformed
        if(countShowJtable==0){
            showJTable(true);
            loadDataToTable();
            jButton_showJTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/up_24.png")));
            countShowJtable = 1;
        } else if(countShowJtable==1){
            loadDataToTable();
            showJTable(false);
            jButton_showJTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/down_24.png")));
            countShowJtable = 0;
        }
    }//GEN-LAST:event_jButton_showJTableActionPerformed

    private void jButton_showJTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_showJTableMouseEntered
        jButton_showJTable.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_showJTableMouseEntered

    private void jButton_showJTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_showJTableMouseExited
        jButton_showJTable.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_showJTableMouseExited

    private void jButton_YNghiaGiaiThuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_YNghiaGiaiThuatMouseEntered
        // TODO add your handling code here:
        jButton_YNghiaGiaiThuat.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_jButton_YNghiaGiaiThuatMouseEntered

    private void jButton_YNghiaGiaiThuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_YNghiaGiaiThuatMouseExited
        // TODO add your handling code here:
        jButton_YNghiaGiaiThuat.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_jButton_YNghiaGiaiThuatMouseExited

    private void jButton_ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Set chế độ chọn file là "Save"
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);

        // Hiển thị hộp thoại để chọn nơi lưu file
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn đã chọn
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            
            XuatFile.exportToTxt(SanPhamDao1.findByIdBalo(jTextField_MaBalo.getText())
                    ,PhuongAnDao1.findThamAn(jTextField_MaBalo.getText()+"%")
                    ,PhuongAnDao1.findNhanhCan(jTextField_MaBalo.getText()+"%") 
                    ,PhuongAnDao1.findQuyHoachDong(jTextField_MaBalo.getText()+"%")
                    ,filePath
                    , "KGH"
                    ,jTextField_TrongLuongBalo.getText());
        }
        
    }//GEN-LAST:event_jButton_ExportActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        CompareFormDialog1 conCompareFormDialog = new CompareFormDialog1(mainView, true, this);
        conCompareFormDialog.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked
//==========================================================================================================  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhat;
    private javax.swing.JButton jButton_ChayChuongTrinh;
    private javax.swing.JButton jButton_Export;
    private javax.swing.JButton jButton_LayDuLieu;
    private javax.swing.JButton jButton_Loc;
    private javax.swing.JButton jButton_OpenFile;
    private javax.swing.JButton jButton_ReadOpenFile;
    private javax.swing.JButton jButton_ResetForm;
    private javax.swing.JButton jButton_TaoMoi;
    private javax.swing.JButton jButton_ThemMoiBalo;
    private javax.swing.JButton jButton_Thêm;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_TrangThai;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JButton jButton_YNghiaGiaiThuat;
    private javax.swing.JButton jButton_first;
    private javax.swing.JButton jButton_last;
    private javax.swing.JButton jButton_next;
    private javax.swing.JButton jButton_previous;
    private javax.swing.JButton jButton_showJTable;
    private javax.swing.JComboBox<String> jComboBox_GiaiThuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_ThoiGianChay;
    private javax.swing.JLabel jLabel_TongGiaTri;
    private javax.swing.JLabel jLabel_TongTrongLuong;
    private javax.swing.JLabel jLabel_danhsach;
    private javax.swing.JLabel jLabel_thongtinsanpham;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_themFile;
    private javax.swing.JPanel jPanel_thongTinSanPham;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_GiaTri;
    private javax.swing.JTextField jTextField_MaBalo;
    private javax.swing.JTextField jTextField_SoLuong;
    private javax.swing.JTextField jTextField_SoThuTu;
    private javax.swing.JTextField jTextField_TenSanPham;
    private javax.swing.JTextField jTextField_TrongLuong;
    private javax.swing.JTextField jTextField_TrongLuongBalo;
    // End of variables declaration//GEN-END:variables
}
