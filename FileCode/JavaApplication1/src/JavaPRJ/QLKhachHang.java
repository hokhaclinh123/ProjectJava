/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaPRJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author USER
 */
public class QLKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form QLKhachHang
     */
    public QLKhachHang() {
        initComponents();
        xuatDanhSachKhachHang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQLKH = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        tfMaKH = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        tfTenKH = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        lblSoDT = new javax.swing.JLabel();
        tfSDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbQLKH = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnResert = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lí Khách Hàng");

        lblQLKH.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        lblQLKH.setForeground(new java.awt.Color(51, 51, 255));
        lblQLKH.setText("QUẢN LÝ KHÁCH HÀNG");

        lblMaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblMaKH.setText("Mã Khách Hàng");

        tfMaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblTenKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTenKH.setText("Tên Khách Hàng");

        tfTenKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDiaChi.setText("Địa Chỉ");

        tfDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblSoDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSoDT.setText("SĐT");

        tfSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jtbQLKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"
            }
        ));
        jtbQLKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbQLKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbQLKH);

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/plus.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/edit (1).png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/clear.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnResert.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/refresh.png"))); // NOI18N
        btnResert.setText("Tạo lại");
        btnResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResertActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/cancel (1).png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Tìm Kiếm");

        tfTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemActionPerformed(evt);
            }
        });
        tfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQLKH)
                .addGap(193, 193, 193))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTenKH)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(btnResert)
                                    .addGap(27, 27, 27)
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblMaKH)
                            .addGap(32, 32, 32)
                            .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSoDT)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDiaChi)
                                    .addGap(44, 44, 44)
                                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblQLKH)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaKH)
                            .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi)
                            .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoDT)
                            .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenKH)
                            .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResert, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThoat))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 161, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (tfMaKH.getText().equals("") || tfTenKH.getText().equals("") || tfDiaChi.getText().equals("") || tfSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
        } else {
            String sql = "INSERT INTO `KhachHang`(`maKH`, `tenKH`, `diaChi`, `soDT`) "
                    + "VALUES ('" + tfMaKH.getText() + "','" + tfTenKH.getText() + "','" + tfDiaChi.getText() + "','" + tfSDT.getText() + "')";
            excuteQuery(sql, "đã thêm");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        String sql = "UPDATE `KhachHang` SET `tenKH`='" + tfTenKH.getText() + "',`diaChi`='" + tfDiaChi.getText() + "',`soDT`='" + tfSDT.getText() + "' WHERE `maKH` = '" + tfMaKH.getText() + "'";
        excuteQuery(sql, "đã sửa");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String sql = "DELETE FROM `KhachHang` WHERE `maKH` = '" + tfMaKH.getText() + "'";
        excuteQuery(sql, "đã xóa");
        resetText();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResertActionPerformed
        resetText();
    }//GEN-LAST:event_btnResertActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed

        if (DangNhap.cboPhanQuyen.getSelectedItem() == "ADMIN") {
            Admin admin = new Admin();
            admin.setVisible(true);
            this.setVisible(false);
        }
        if (DangNhap.cboPhanQuyen.getSelectedItem() == "NHANVIEN") {
            Employee epl = new Employee();
            epl.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnThoatActionPerformed

    private void jtbQLKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbQLKHMouseClicked
        int i = jtbQLKH.getSelectedRow();
        TableModel model = jtbQLKH.getModel();
        tfMaKH.setText(model.getValueAt(i, 0).toString());
        tfTenKH.setText(model.getValueAt(i, 1).toString());
        tfDiaChi.setText(model.getValueAt(i, 2).toString());
        tfSDT.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jtbQLKHMouseClicked

    private void tfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiemActionPerformed

    private void timKiem(String query) {
        DefaultTableModel model = (DefaultTableModel) jtbQLKH.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jtbQLKH.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void tfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyReleased
        String query = tfTimKiem.getText().toLowerCase();
        timKiem(query);
    }//GEN-LAST:event_tfTimKiemKeyReleased

    public void resetText() {
        tfMaKH.setText("");
        tfTenKH.setText("");
        tfDiaChi.setText("");
        tfSDT.setText("");
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projectjava?useUnicode=yes&characterEncoding=UTF-8", "root", "");
            return conn;

        } catch (SQLException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<KhachHang> getdanhSachKH() {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        Connection connection = getConnection();
        String sql = "SELECT * FROM `KhachHang`";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            KhachHang kh;
            while (rs.next()) {
                kh = new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getString("diaChi"), rs.getString("soDT"));
                dskh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dskh;
    }

    //Hàm thực thi các câu truy vấn
    public void excuteQuery(String sql, String message) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(sql) == 1) {
                //Xuất lại jtable sau khi thực hiện truy vấn thành công
                DefaultTableModel model = (DefaultTableModel) jtbQLKH.getModel();
                model.setRowCount(0);
                xuatDanhSachKhachHang();
                JOptionPane.showMessageDialog(rootPane, "Khách Hàng " + message + " thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Khách Hàng không " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachKhachHang() {
        ArrayList<KhachHang> list = getdanhSachKH();
        DefaultTableModel model = (DefaultTableModel) jtbQLKH.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaKH();
            row[1] = list.get(i).getTenKH();
            row[2] = list.get(i).getDiaChi();
            row[3] = list.get(i).getSoDT();
            model.addRow(row);
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
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResert;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbQLKH;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblQLKH;
    private javax.swing.JLabel lblSoDT;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfMaKH;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTenKH;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
