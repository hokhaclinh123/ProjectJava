/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaPRJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class frmBanHang extends javax.swing.JFrame {

    /**
     * Creates new form frmBanHang
     */
    public frmBanHang() {
        initComponents();
        loadForm();
        xuatDanhSachKhachHang();
        xuatDanhSachHangHoa();
    }

    public void loadForm() {
        tfMaNV.setText(DangNhap.tfTaiKhoan.getText());
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        tfNgayBan.setText(timeFormat.format(today.getTime()));
        //Lấy tên nhân viên từ mã nhân viên đã lấy ở trên
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM `nhanvien` WHERE `maNV` = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, tfMaNV.getText());
            rs = ps.executeQuery();
            while (rs.next()) {
                tfMaNV.setText(rs.getString("maNV"));
                tfTenNV.setText(rs.getString("tenNV"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_projectjava?useUnicode=yes&characterEncoding=UTF-8", "root", "");
            return conn;

        } catch (SQLException ex) {
            Logger.getLogger(frmBanHang.class.getName()).log(Level.SEVERE, null, ex);
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
    public void excuteQueryKH(String sql, String message) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(sql) == 1) {
                //Xuất lại jtable sau khi thực hiện truy vấn thành công
                DefaultTableModel model = (DefaultTableModel) jtbKhachHang.getModel();
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
        DefaultTableModel model = (DefaultTableModel) jtbKhachHang.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaKH();
            row[1] = list.get(i).getTenKH();
            row[2] = list.get(i).getDiaChi();
            row[3] = list.get(i).getSoDT();
            model.addRow(row);
        }
    }

    public ArrayList<HangHoa> getdanhSachHH() {
        ArrayList<HangHoa> dskh = new ArrayList<HangHoa>();
        Connection connection = getConnection();
        String sql = "SELECT * FROM `hanghoa`";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            HangHoa hh;
            while (rs.next()) {
                hh = new HangHoa(rs.getString("maHH"), rs.getString("tenHH"), rs.getInt("soLuong"), rs.getDouble("donGiaNhap"), rs.getDouble("donGiaBan"), rs.getString("ghiChu"));
                dskh.add(hh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dskh;
    }

    //Hàm thực thi các câu truy vấn
    public void excuteQueryHH(String sql, String message) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(sql) == 1) {
                //Xuất lại jtable sau khi thực hiện truy vấn thành công
                DefaultTableModel model = (DefaultTableModel) jtbHangHoa.getModel();
                model.setRowCount(0);
                xuatDanhSachHangHoa();
                JOptionPane.showMessageDialog(rootPane, "Sản phẩm " + message + " thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sản phâm không " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachHangHoa() {
        ArrayList<HangHoa> list = getdanhSachHH();
        DefaultTableModel model = (DefaultTableModel) jtbHangHoa.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaHang();
            row[1] = list.get(i).getTenHang();
            row[2] = list.get(i).getSoLuong();
            row[3] = list.get(i).getDonGiaNhap();
            row[4] = list.get(i).getDonGiaBan();
            row[5] = list.get(i).getGhiChu();
            model.addRow(row);
        }
    }

    public String layHDMax() {
        String sMaHDMax = "";
        Connection connection = getConnection();
        String sql = "SELECT MAX(`maHD`) FROM `hoadon`";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                sMaHDMax = rs.getString("maHD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sMaHDMax;
    }

    public String xuatMaHD() {
        String sql = "";
        return sql;
    }

    public void tinhTongTien() {
        int tongTien = 0;

        for (int i = 0; i < jtbGioHang.getRowCount(); i++) {
            tongTien += Integer.parseInt(jtbGioHang.getValueAt(i, 3).toString()) * Integer.parseInt(jtbGioHang.getValueAt(i, 2).toString());
            tfTongTien.setText(tongTien + "");
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

        jLabel1 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        tfMaHD = new javax.swing.JTextField();
        lblNgayBan = new javax.swing.JLabel();
        tfNgayBan = new javax.swing.JTextField();
        lblMaNV = new javax.swing.JLabel();
        tfMaNV = new javax.swing.JTextField();
        lblTenNV = new javax.swing.JLabel();
        tfTenNV = new javax.swing.JTextField();
        tfMaKH = new javax.swing.JTextField();
        lblMaKH = new javax.swing.JLabel();
        tfTenKH = new javax.swing.JTextField();
        lblTenKH = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        tfSDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbKhachHang = new javax.swing.JTable();
        tfTimKiemKH = new javax.swing.JTextField();
        tfDonGia = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        lblThanhTien = new javax.swing.JLabel();
        tfThanhTien = new javax.swing.JTextField();
        lblMaHH = new javax.swing.JLabel();
        tfMaHH = new javax.swing.JTextField();
        lblTenHH = new javax.swing.JLabel();
        tfTenHH = new javax.swing.JTextField();
        lblDonGia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbGioHang = new javax.swing.JTable();
        lblGioHang = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        tfTongTien = new javax.swing.JTextField();
        btnTinhTien = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbHangHoa = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTimKiemSP = new javax.swing.JLabel();
        tfTimKiemSP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bán Hàng");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("BÁN HÀNG");

        lblMaHD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblMaHD.setText("Mã HD");

        tfMaHD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblNgayBan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblNgayBan.setText("Ngày bán");

        tfNgayBan.setEditable(false);
        tfNgayBan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblMaNV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblMaNV.setText("Mã NV");

        tfMaNV.setEditable(false);
        tfMaNV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblTenNV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTenNV.setText("Tên NV");

        tfTenNV.setEditable(false);
        tfTenNV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        tfMaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblMaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblMaKH.setText("Mã KH");

        tfTenKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblTenKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTenKH.setText("Tên KH");

        tfDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDiaChi.setText("Địa chỉ");

        lblSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSDT.setText("SĐT");

        tfSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jtbKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jtbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Địa Chỉ", "Số ĐT"
            }
        ));
        jtbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbKhachHang);

        tfTimKiemKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemKHActionPerformed(evt);
            }
        });
        tfTimKiemKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemKHKeyReleased(evt);
            }
        });

        tfDonGia.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDonGiaActionPerformed(evt);
            }
        });

        lblSoLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSoLuong.setText("Số lượng");

        spnSoLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        spnSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        spnSoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSoLuongStateChanged(evt);
            }
        });

        lblThanhTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblThanhTien.setText("Thành tiền");

        tfThanhTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblMaHH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblMaHH.setText("Mã hàng hóa");

        tfMaHH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblTenHH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTenHH.setText("Tên hàng hóa");

        tfTenHH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        lblDonGia.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDonGia.setText("Đơn giá");

        jtbGioHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jtbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Số Lượng", "Giá Tiền"
            }
        ));
        jtbGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbGioHang);

        lblGioHang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGioHang.setForeground(new java.awt.Color(204, 0, 204));
        lblGioHang.setText("Giỏ Hàng");

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTongTien.setText("Tổng Tiền");

        tfTongTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        btnTinhTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnTinhTien.setText("Tính Tiền");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton1.setText("Tạo Lại");

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThoat.setText("Thoát");

        jtbHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jtbHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá Bán"
            }
        ));
        jScrollPane3.setViewportView(jtbHangHoa);

        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/clear.png"))); // NOI18N
        btnXoa.setText("Xóa");

        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JavaPRJ/icoin/plus.png"))); // NOI18N
        btnThem.setText("Thêm vào GH");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Tìm Kiếm KH");

        lblTimKiemSP.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblTimKiemSP.setText("Tìm Kiếm SP");

        tfTimKiemSP.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tfTimKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemSPActionPerformed(evt);
            }
        });
        tfTimKiemSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTenHH)
                                            .addComponent(lblThanhTien)
                                            .addComponent(lblMaHH))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfTenHH)
                                            .addComponent(tfThanhTien)
                                            .addComponent(tfMaHH)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblDonGia)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblSoLuong)
                                                .addGap(18, 18, 18)
                                                .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTongTien)
                                                .addGap(30, 30, 30)
                                                .addComponent(tfTongTien))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTinhTien)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnThoat)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblGioHang)
                                        .addGap(101, 101, 101)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSDT)
                                        .addGap(48, 48, 48)
                                        .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(lblNgayBan)
                                                                    .addGap(18, 18, 18))
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(lblMaHD)
                                                                    .addGap(30, 30, 30)))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblMaNV)
                                                                .addGap(29, 29, 29)))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(lblTenNV)
                                                            .addGap(27, 27, 27)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblMaKH)
                                                        .addGap(29, 29, 29)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblTenKH)
                                                    .addGap(27, 27, 27)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDiaChi)
                                                .addGap(35, 35, 35)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(37, 37, 37)
                                        .addComponent(tfTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimKiemSP)
                                .addGap(34, 34, 34)
                                .addComponent(tfTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(523, 523, 523)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTimKiemSP)
                            .addComponent(tfTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaHD)
                                    .addComponent(tfMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNgayBan)
                                    .addComponent(tfNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaNV)
                                    .addComponent(tfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTenNV)
                                    .addComponent(tfTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaKH)
                                    .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTenKH)
                                    .addComponent(tfTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDiaChi)
                                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSDT)
                                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaHH)
                            .addComponent(tfMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGioHang)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTenHH)
                                    .addComponent(tfTenHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblThanhTien)
                                    .addComponent(tfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDonGia)
                                    .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSoLuong)
                                    .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTongTien)
                                    .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTinhTien)
                                    .addComponent(jButton1)
                                    .addComponent(btnThoat)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        if (jtbGioHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sản phẩm");
        } 
        else if (tfMaHD.getText().equals("") ||tfMaKH.getText().equals("") ||tfMaNV.getText().equals("") ||tfNgayBan.getText().equals("") 
                ||tfTongTien.getText().equals("") ||tfMaHH.getText().equals("") ||tfDonGia.getText().equals("") ||tfThanhTien.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin vào các ô");
        }
        else {
            Connection conn = getConnection();
            PreparedStatement psHD = null;
            PreparedStatement psCTHD = null;
            String sqlHD = "INSERT INTO `hoadon`(`maHD`, `maKH`, `maNV`, `ngayLap`, `tongTien`) VALUES (?,?,?,?,?)";
            String sqlCTHD = "INSERT INTO `chitiethd`(`maHD`, `maHH`, `soLuong`, `donGia`, `thanhTien`) VALUES (?,?,?,?,?)";
            try {
                psHD = conn.prepareStatement(sqlHD);
                psHD.setString(1, tfMaHD.getText());
                psHD.setString(2, tfMaKH.getText());
                psHD.setString(3, tfMaNV.getText());
                psHD.setString(4, tfNgayBan.getText());
                psHD.setString(5, tfTongTien.getText());
                psHD.executeUpdate();
                
                psCTHD = conn.prepareStatement(sqlCTHD);
                psCTHD.setString(1, tfMaHD.getText());
                psCTHD.setString(2, tfMaHH.getText());
                psCTHD.setString(3, spnSoLuong.getValue().toString());
                psCTHD.setString(4, tfDonGia.getText());
                psCTHD.setString(5, tfThanhTien.getText());
                psCTHD.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Tính tiền thành công!");
                QLHoaDon qlhd = new QLHoaDon();
                qlhd.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(frmBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void jtbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbKhachHangMouseClicked
        int i = jtbKhachHang.getSelectedRow();
        TableModel model = jtbKhachHang.getModel();
        tfMaKH.setText(model.getValueAt(i, 0).toString());
        tfTenKH.setText(model.getValueAt(i, 1).toString());
        tfDiaChi.setText(model.getValueAt(i, 2).toString());
        tfSDT.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jtbKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        TableModel model1 = jtbHangHoa.getModel();
        int index[] = jtbHangHoa.getSelectedRows();
        Object[] row = new Object[4];
        DefaultTableModel model2 = (DefaultTableModel) jtbGioHang.getModel();
        for (int i = 0; i < index.length; i++) {

            row[0] = model1.getValueAt(index[i], 0);
            row[1] = model1.getValueAt(index[i], 1);
            row[2] = 1;
            row[3] = model1.getValueAt(index[i], 3);
            model2.addRow(row);
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void jtbGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbGioHangMouseClicked
        int i = jtbGioHang.getSelectedRow();
        TableModel model = jtbGioHang.getModel();
        tfMaHH.setText(model.getValueAt(i, 0).toString());
        tfTenHH.setText(model.getValueAt(i, 1).toString());
        spnSoLuong.setValue(model.getValueAt(i, 2));
        tfDonGia.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jtbGioHangMouseClicked

    private void spnSoLuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSoLuongStateChanged

        if (jtbGioHang.getRowCount() == 0) {
            spnSoLuong.setValue(1);
            JOptionPane.showMessageDialog(rootPane, "Giỏ hàng còn trống");
        } else {
            int index = jtbGioHang.getSelectedRow();
            Integer myInt = (Integer) spnSoLuong.getValue();
            String spinner = "Value Changed";
            spinner = myInt.toString();
            TableModel model = jtbGioHang.getModel();
            model.setValueAt(spinner, index, 2);
            double thanhTien = 0;
            thanhTien += Double.parseDouble(jtbGioHang.getValueAt(index, 2).toString()) * Double.parseDouble(tfDonGia.getText());
            model.setValueAt(thanhTien, index, 3);
            tfThanhTien.setText(thanhTien + "");
            double tongTien = 0;
            for (int i = 0; i < jtbGioHang.getRowCount(); i++) {
                tongTien += Double.parseDouble(jtbGioHang.getValueAt(index, 3).toString());
            }
            tfTongTien.setText(tongTien + "");
        }
    }//GEN-LAST:event_spnSoLuongStateChanged


    private void timKiemSP(String query) {
        DefaultTableModel model = (DefaultTableModel) jtbHangHoa.getModel();
        TableRowSorter<DefaultTableModel> tr =  new TableRowSorter<DefaultTableModel>(model);
        jtbHangHoa.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }  
    private void timKiemKH(String query) {
        DefaultTableModel model = (DefaultTableModel) jtbKhachHang.getModel();
        TableRowSorter<DefaultTableModel> tr =  new TableRowSorter<DefaultTableModel>(model);
        jtbKhachHang.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }  
    private void tfDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDonGiaActionPerformed

    private void tfTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemKHActionPerformed

    }//GEN-LAST:event_tfTimKiemKHActionPerformed

    private void tfTimKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemSPActionPerformed

    }//GEN-LAST:event_tfTimKiemSPActionPerformed

    private void tfTimKiemKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKHKeyReleased
        String query = tfTimKiemKH.getText().toLowerCase();
        timKiemKH(query);
    }//GEN-LAST:event_tfTimKiemKHKeyReleased

    private void tfTimKiemSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemSPKeyReleased
        String query = tfTimKiemSP.getText().toLowerCase();
        timKiemKH(query);
    }//GEN-LAST:event_tfTimKiemSPKeyReleased

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
            java.util.logging.Logger.getLogger(frmBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtbGioHang;
    private javax.swing.JTable jtbHangHoa;
    private javax.swing.JTable jtbKhachHang;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblGioHang;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaHH;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgayBan;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenHH;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTimKiemSP;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfMaHD;
    private javax.swing.JTextField tfMaHH;
    private javax.swing.JTextField tfMaKH;
    private javax.swing.JTextField tfMaNV;
    private javax.swing.JTextField tfNgayBan;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTenHH;
    private javax.swing.JTextField tfTenKH;
    private javax.swing.JTextField tfTenNV;
    private javax.swing.JTextField tfThanhTien;
    private javax.swing.JTextField tfTimKiemKH;
    private javax.swing.JTextField tfTimKiemSP;
    private javax.swing.JTextField tfTongTien;
    // End of variables declaration//GEN-END:variables
}
