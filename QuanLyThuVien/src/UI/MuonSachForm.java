package UI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ConnectionUtility.DatabaseConnection;
import java.sql.SQLException;
import UI.ChiTietPhieuMuonForm;
/**
 *
 * @author Admin
 */
public class MuonSachForm extends javax.swing.JFrame {

    public static String timaphieu_CDM="";
 public boolean daTonTaiTrongDB(String maPhieu) {
    try {
        Connection conn =DatabaseConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM phieumuon WHERE MaPhieuMuon = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, maPhieu);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

    /**
     * Creates new form ChiTietPhieuMuonForm
     */
    public MuonSachForm() {
        initComponents();
        loadDocGia();
        loadData();
        loadNhanVien();
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();

        DefaultTableModel model1 = (DefaultTableModel) tblPhieuMuon.getModel();
        model.setColumnIdentifiers(new String[]{"Mã Sách", "Tên Sách", "Số Lượng"});
        tblSach.setModel(model);
        
        tblPhieuMuon.setModel(model1);
        loadSachToTable();
        ngaylapphieu.setText(java.time.LocalDate.now().toString());

    }
    private void loadSachToTable() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;


    DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
    model.setRowCount(0); // Xoá dữ liệu cũ

    try {
        conn = DatabaseConnection.getConnection();
        String sql = "SELECT MaSach, TenSach, SoLuong FROM sach";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            String ma = rs.getString("MaSach");
            String ten = rs.getString("TenSach");
            int soLuong = rs.getInt("SoLuong");

            model.addRow(new Object[]{ma, ten, soLuong});
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách sách");
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

    private void loadNhanVien() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = DatabaseConnection.getConnection();
        String sql = "SELECT MaNhanVien, TenNhanVien FROM nhanvien";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        cbNhanVien_DCM.removeAllItems(); // Xoá các item cũ trong ComboBox

        while (rs.next()) {
            String ma = rs.getString("MaNhanVien");
            String ten = rs.getString("TenNhanVien");
            
            cbNhanVien_DCM.addItem(ma+" - "+ten  ); // Thêm item vào ComboBox
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách nhân viên");
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
public void loadData() 
{
    
        DefaultTableModel model1 = (DefaultTableModel) tblPhieuMuon.getModel();
    model1.setRowCount(0); // Xóa bảng trước khi load mới

    String sql = "SELECT * FROM phieumuon";

    try {
        ResultSet rs = ConnectionUtility.DatabaseConnection.executeQuery(sql);

        while (rs.next()) {
            String maPhieuMuon = rs.getString("MaPhieuMuon");
            String maNhanVien = rs.getString("MaNhanVienLapPhieu");
            String ngayLap = rs.getString("NgayLapPhieu");
            String maDocGia = rs.getString("MaDocGia");
            String sachMuon = rs.getString("SachMuon");
            int soLuongMuon = rs.getInt("SoLuongMuon");

            model1.addRow(new Object[]{
                maPhieuMuon, maNhanVien, ngayLap, maDocGia, sachMuon, soLuongMuon
            });
        }

        rs.getStatement().getConnection().close(); // Đóng luôn kết nối khi xong
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage());
        e.printStackTrace();
    }
}

private void loadDocGia() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = DatabaseConnection.getConnection();
        String sql = "SELECT MaDocGia, TenDocGia FROM docgia";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        cbDocGia_DCM.removeAllItems(); // Xoá các item cũ trong ComboBox

        while (rs.next()) {
            String ma = rs.getString("MaDocGia");
            String ten = rs.getString("TenDocGia");
            cbDocGia_DCM.addItem(ma+" - "+ten); // Thêm item vào ComboBox
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách độc giả");
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

        cbNhanVien_DCM = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbDocGia_DCM = new javax.swing.JComboBox<>();
        btnLapphieu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhieuMuon = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        maphieumuon_DCM = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        ngaylapphieu = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnLapphieu1 = new javax.swing.JButton();
        btnLapphieu2 = new javax.swing.JButton();
        btnLapphieu3 = new javax.swing.JButton();
        btnChitietphieu = new javax.swing.JButton();
        timmaphieu_DCM = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnLapphieu5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbNhanVien_DCM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Mã độc giả:");

        jButton1.setText("Hủy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbDocGia_DCM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLapphieu.setText("Lập phiếu");
        btnLapphieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapphieuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ MƯỢN SÁCH");

        jLabel10.setText("Ngày lập phiếu:");

        jLabel9.setText("Mã NV lập phiếu:");

        tblPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ PHIẾU MƯỢN", "MÃ NHÂN VIÊN LẬP PHIẾU", "NGÀY LẬP PHIẾU", "MÃ ĐỘC GIẢ", "SÁCH MƯỢN", "SỐ LƯỢNG MƯỢN"
            }
        ));
        tblPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhieuMuon);

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MÃ SÁCH", "TÊN SÁCH", "SỐ LƯỢNG "
            }
        ));
        jScrollPane4.setViewportView(tblSach);

        jLabel11.setText("Mã phiếu mượn:");

        jLabel12.setText("TÌM KIẾM MÃ PHIẾU:");

        jButton3.setText("Trang chủ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ngaylapphieu.setText("Ngày hiện tại");

        jLabel14.setText("Đỗ Công Minh");

        jLabel16.setText("Chọn sách muốn mượn:");

        btnLapphieu1.setText("Lưu phiếu");
        btnLapphieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapphieu1ActionPerformed(evt);
            }
        });

        btnLapphieu2.setText("Sửa thông tin");
        btnLapphieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapphieu2ActionPerformed(evt);
            }
        });

        btnLapphieu3.setText("Xóa phiếu");
        btnLapphieu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapphieu3ActionPerformed(evt);
            }
        });

        btnChitietphieu.setText("Chi tiết phiếu");
        btnChitietphieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChitietphieuActionPerformed(evt);
            }
        });

        jLabel15.setText("THÔNG TIN PHIẾU MƯỢN");

        btnLapphieu5.setText("Tìm kiếm mã");
        btnLapphieu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapphieu5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLapphieu)
                        .addGap(38, 38, 38)
                        .addComponent(btnLapphieu1)
                        .addContainerGap(980, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(378, 378, 378)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(maphieumuon_DCM)
                                            .addComponent(cbDocGia_DCM, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbNhanVien_DCM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ngaylapphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(107, 107, 107)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timmaphieu_DCM, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnLapphieu5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(176, 176, 176)
                                .addComponent(btnLapphieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btnLapphieu3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(btnChitietphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maphieumuon_DCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbDocGia_DCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbNhanVien_DCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(ngaylapphieu))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLapphieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLapphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLapphieu3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLapphieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChitietphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timmaphieu_DCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(btnLapphieu5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     maphieumuon_DCM.setText("");
    ngaylapphieu.setText(java.time.LocalDate.now().toString());
    cbNhanVien_DCM.setSelectedIndex(0);
    cbDocGia_DCM.setSelectedIndex(0);

    DefaultTableModel model = (DefaultTableModel) tblPhieuMuon.getModel();
    model.setRowCount(0); // Xóa dữ liệu phiếu mượn tạm thời

      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLapphieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapphieuActionPerformed
     String maPhieu = maphieumuon_DCM.getText().trim();
    if (maPhieu.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu mượn!");
        return;
    }

    // Kiểm tra tổng số lượng sách đã mượn với mã phiếu này
    int tongSoLuongHienTai = 0;
    try {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT SUM(SoLuongMuon) FROM phieumuon WHERE MaPhieuMuon = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, maPhieu);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tongSoLuongHienTai = rs.getInt(1);
        }
        rs.close();
        pst.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi kiểm tra số lượng mượn: " + ex.getMessage());
        return;
    }

    int[] selectedRowsArray = tblSach.getSelectedRows();
    if (selectedRowsArray.length == 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một cuốn sách!");
        return;
    }

    if (selectedRowsArray.length > 5) {
        JOptionPane.showMessageDialog(this, "Chỉ được chọn tối đa 5 cuốn sách!");
        return;
    }

    String maNhanVien = cbNhanVien_DCM.getSelectedItem().toString().split(" - ")[0];
    String maDocGia = cbDocGia_DCM.getSelectedItem().toString().split(" - ")[0];
    String ngayLap = ngaylapphieu.getText();

    DefaultTableModel model = (DefaultTableModel) tblPhieuMuon.getModel();

    int tongSoLuongMuonMoi = 0;
    List<String> tenSachList = new ArrayList<>();
    List<Integer> soLuongMuonList = new ArrayList<>();
    List<String> maSachList = new ArrayList<>();

    for (int row : selectedRowsArray) {
        String maSach = tblSach.getValueAt(row, 0).toString();
        String tenSach = tblSach.getValueAt(row, 1).toString();
        int soLuongCoSan = Integer.parseInt(tblSach.getValueAt(row, 2).toString());

        String input = JOptionPane.showInputDialog(this, "Nhập số lượng muốn mượn cho \"" + tenSach + "\" (còn " + soLuongCoSan + " quyển):");
        if (input == null || input.isEmpty()) return;

        int soLuongMuon;
        try {
            soLuongMuon = Integer.parseInt(input);
            if (soLuongMuon <= 0 || soLuongMuon > soLuongCoSan) {
                JOptionPane.showMessageDialog(this, "Số lượng mượn không hợp lệ cho sách: " + tenSach);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên cho sách: " + tenSach);
            return;
        }

        tongSoLuongMuonMoi += soLuongMuon;

        if (tongSoLuongHienTai + tongSoLuongMuonMoi > 5) {
            JOptionPane.showMessageDialog(this, "Tổng số sách mượn đã vượt quá giới hạn 5 quyển!");
            return;
        }

        tenSachList.add(tenSach);
        soLuongMuonList.add(soLuongMuon);
        maSachList.add(maSach);
    }

    // Ghép danh sách sách mượn thành chuỗi cách nhau bởi dấu phẩy
    String danhSachTenSach = String.join(", ", tenSachList);

    // Cộng tổng số lượng mượn
    int tongSoLuongMuon = soLuongMuonList.stream().mapToInt(Integer::intValue).sum();

    // Kiểm tra xem mã phiếu đã tồn tại chưa
    try {
        Connection conn = DatabaseConnection.getConnection();
        String checkSql = "SELECT COUNT(*) FROM phieumuon WHERE MaPhieuMuon = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setString(1, maPhieu);
        ResultSet rsCheck = checkStmt.executeQuery();
        rsCheck.next();
        if (rsCheck.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Mã phiếu '" + maPhieu + "' đã tồn tại. Vui lòng dùng mã khác!");
            rsCheck.close();
            checkStmt.close();
            conn.close();
            return;
        }
        rsCheck.close();
        checkStmt.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi kiểm tra mã phiếu: " + ex.getMessage());
        return;
    }

    // Thêm vào bảng hiển thị
    model.insertRow(0, new Object[]{
        maPhieu,
        cbNhanVien_DCM.getSelectedItem(),
        ngayLap,
        cbDocGia_DCM.getSelectedItem(),
        danhSachTenSach,
        tongSoLuongMuon
    });

    // Ghi vào CSDL
    try {
        Connection conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false); // Start transaction

        // Insert into phieumuon
        String sql = "INSERT INTO phieumuon (MaPhieuMuon, MaNhanVienLapPhieu, NgayLapPhieu, MaDocGia, SachMuon, SoLuongMuon) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, maPhieu);
        pst.setString(2, maNhanVien);
        pst.setString(3, ngayLap);
        pst.setString(4, maDocGia);
        pst.setString(5, danhSachTenSach);
        pst.setInt(6, tongSoLuongMuon);
        pst.executeUpdate();

        // Cập nhật số lượng sách trong bảng sach
        String updateSql = "UPDATE sach SET SoLuong = SoLuong - ? WHERE MaSach = ?";
        PreparedStatement updatePst = conn.prepareStatement(updateSql);
        for (int i = 0; i < maSachList.size(); i++) {
            updatePst.setInt(1, soLuongMuonList.get(i));
            updatePst.setString(2, maSachList.get(i));
            updatePst.executeUpdate();
        }

        // Cập nhật trực tiếp trong JTable hiển thị
        for (int i = 0; i < selectedRowsArray.length; i++) {
            int rowIndex = selectedRowsArray[i];
            int currentSoLuong = Integer.parseInt(tblSach.getValueAt(rowIndex, 2).toString());
            int soLuongMuon = soLuongMuonList.get(i);
            tblSach.setValueAt(currentSoLuong - soLuongMuon, rowIndex, 2);
        }

        conn.commit(); // Commit transaction
        conn.setAutoCommit(true); // Reset auto commit to true
        pst.close();
        updatePst.close();
        conn.close();
        JOptionPane.showMessageDialog(this, "Lập phiếu mượn thành công và đã lưu vào CSDL!");
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi lưu vào CSDL: " + ex.getMessage());
    }



// TODO add your handling code here:
    }//GEN-LAST:event_btnLapphieuActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    this.dispose(); // đóng form hiện tại
    new MainForm().setVisible(true); // mở form chính
  // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuMuonMouseClicked
int i= tblPhieuMuon.getSelectedRow();

if (i < 0) {

return;

}

maphieumuon_DCM.setText (tblPhieuMuon.getValueAt(i, 1).toString());
 ngaylapphieu.setText (tblPhieuMuon.getValueAt(i, 2).toString());
cbDocGia_DCM.setSelectedItem (tblPhieuMuon.getValueAt(i, 3).toString());

cbNhanVien_DCM.setSelectedItem (tblPhieuMuon.getValueAt(i, 4).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_tblPhieuMuonMouseClicked

    private void btnLapphieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapphieu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLapphieu1ActionPerformed

    private void btnLapphieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapphieu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLapphieu2ActionPerformed

    private void btnLapphieu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapphieu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLapphieu3ActionPerformed

    private void btnChitietphieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChitietphieuActionPerformed
           int row = tblPhieuMuon.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Chọn 1 phiếu để xem chi tiết!");
        return;
    }
    // cột 0 thường là Mã phiếu mượn – nếu bạn để ở cột khác thì thay chỉ số cho đúng
    String maPhieu = tblPhieuMuon.getValueAt(row, 0).toString();

    // Mở form chi tiết
    ChiTietPhieuMuonForm ctForm = new ChiTietPhieuMuonForm(maPhieu);
    ctForm.setVisible(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_btnChitietphieuActionPerformed

    private void btnLapphieu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapphieu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLapphieu5ActionPerformed

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
            java.util.logging.Logger.getLogger(MuonSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuonSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuonSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuonSachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuonSachForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChitietphieu;
    private javax.swing.JButton btnLapphieu;
    private javax.swing.JButton btnLapphieu1;
    private javax.swing.JButton btnLapphieu2;
    private javax.swing.JButton btnLapphieu3;
    private javax.swing.JButton btnLapphieu5;
    private javax.swing.JComboBox<String> cbDocGia_DCM;
    private javax.swing.JComboBox<String> cbNhanVien_DCM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField maphieumuon_DCM;
    private javax.swing.JLabel ngaylapphieu;
    private javax.swing.JTable tblPhieuMuon;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField timmaphieu_DCM;
    // End of variables declaration//GEN-END:variables
}
