/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import model.Model_SanPhamChiTiet;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Model_HoaDon;
import model.Model_HoaDonChiTiet;
import model.Model_SPCTBanHang;
import service.Service_HoaDon;
import service.Service_HoaDonChiTiet;
import service.Service_NhanVien;
import service.Service_KhachHang;
import service.Service_Voucher;

import service.Service_SanPhamChiTiet;

public class View_BanHang extends javax.swing.JPanel {

    View_SanPham vsp = new View_SanPham();
    private Service_HoaDonChiTiet shdct = new Service_HoaDonChiTiet();
    private Service_SanPhamChiTiet sspct = new Service_SanPhamChiTiet();
    private Service_HoaDon hdsvr = new Service_HoaDon();
    private Service_NhanVien snv = new Service_NhanVien();
    private Service_KhachHang skh = new Service_KhachHang();
    private Service_Voucher vcsvr = new Service_Voucher();
    private DefaultTableModel defaultTableModelGioHang;
    private DefaultTableModel defaultTableModelHoaDon;
    private DefaultTableModel defaultTableModelSanPhamChitiet;

    public View_BanHang() {
        initComponents();
        fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
        fillTableHoaDon(hdsvr.getAllBanHang());
        fillcbbNhanVien();
        fillcbbKhachHang();
        fillcbbVoucher();
    }

    void setCustomerData(String ma, String tenKh) {
        txtMaKhachHang.setText(ma);
        cbbTenKhachHang.setSelectedItem(tenKh);
    }

    public void fillcbbVoucher() {
        String vc1 = "Không thêm voucher";
        cbbVoucher.removeAllItems();
        cbbVoucher.addItem(vc1);
        ArrayList<String> lstvc = vcsvr.getTenVoucher();
        for (String vc : lstvc) {
            cbbVoucher.addItem(vc);
        }
    }

    public void fillcbbNhanVien() {
        cbbTenNhanVien.removeAllItems();
        ArrayList<String> lstnv = snv.getTenNhanVien();
        for (String nv : lstnv) {
            cbbTenNhanVien.addItem(nv);
        }
    }

    public void fillcbbKhachHang() {
        cbbTenKhachHang.removeAllItems();
        ArrayList<String> lstkh = skh.getTenKhachHang();
        for (String kh : lstkh) {
            cbbTenKhachHang.addItem(kh);
        }
    }

    public void fillTableSanPhamCHiTiet(ArrayList<Model_SPCTBanHang> lst) {
        defaultTableModelSanPhamChitiet = (DefaultTableModel) tblDanhSachSanPham.getModel();
        defaultTableModelSanPhamChitiet.setRowCount(0);

        for (Model_SPCTBanHang spctbh : lst) {
            defaultTableModelSanPhamChitiet.addRow(spctbh.toDataRow());
        }
    }

    private void fillTableGioHang(ArrayList<Model_HoaDonChiTiet> lst) {
        defaultTableModelGioHang = (DefaultTableModel) tblGioHang_HDCT.getModel();
        defaultTableModelGioHang.setRowCount(0);

        for (Model_HoaDonChiTiet hdct : lst) {
            Object[] rowData = {
                hdct.getMa(),
                hdct.getTen(),
                hdct.getGia(),
                hdct.getSoLuong()
            };
            defaultTableModelGioHang.addRow(rowData);
        }
    }

    public void fillTableHoaDon(ArrayList<Model_HoaDon> lsthdc) {
        defaultTableModelHoaDon = (DefaultTableModel) tblHoaDonCho.getModel();
        defaultTableModelHoaDon.setRowCount(0);
        for (Model_HoaDon model_HoaDon : lsthdc) {
            defaultTableModelHoaDon.addRow(new Object[]{
                model_HoaDon.getMa(), model_HoaDon.getNgayTao(), model_HoaDon.getNhanVien(), model_HoaDon.getKhachHang(), model_HoaDon.getTongTien(), model_HoaDon.getTrangThai() ? "Đã Thanh Toán" : "Chưa Thanh Toán"
            });
        }
    }

    public double tongTien() {
        double tongTien = 0;
        for (int i = 0; i < tblGioHang_HDCT.getRowCount(); i++) {
            double gia = Double.parseDouble(tblGioHang_HDCT.getValueAt(i, 2).toString());
            double soLuong = Double.parseDouble(tblGioHang_HDCT.getValueAt(i, 3).toString());
            tongTien += (gia * soLuong);
        }
        return tongTien;
    }

    public double soTienGiamAfterAddVoucher(double tongTien, double phanTramGiam) {
        double soTienSauGiam = tongTien - (tongTien * (phanTramGiam / 100));
        return soTienSauGiam;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        cbbTenKhachHang = new javax.swing.JComboBox<>();
        btnChonKhachHang = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        btnLamMoiBanHang = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnAddVocher = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbbTenNhanVien = new javax.swing.JComboBox<>();
        cbbVoucher = new javax.swing.JComboBox<>();
        btnHuyDonHang = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGioHang_HDCT = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnThemSanPhamToHoaDon = new javax.swing.JButton();
        btnUpdateHoaDonChiTiet = new javax.swing.JButton();
        btnXoaAll = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Hoá đơn chờ");

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Đơn giá", "Màu", "Size", "Chất liệu", "Đế giày", "Giảm giá(%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDanhSachSanPham);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Ngày tạo", "Nhân viên", "Khách hàng", "Tổng Tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDonCho);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Danh sách sản phẩm");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Mã khách hàng:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tên khách hàng:");

        txtMaKhachHang.setEnabled(false);

        cbbTenKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nguyen Van A" }));
        cbbTenKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenKhachHangActionPerformed(evt);
            }
        });

        btnChonKhachHang.setBackground(new java.awt.Color(0, 102, 102));
        btnChonKhachHang.setFont(btnChonKhachHang.getFont());
        btnChonKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnChonKhachHang.setText("Chọn");
        btnChonKhachHang.setMaximumSize(new java.awt.Dimension(90, 23));
        btnChonKhachHang.setMinimumSize(new java.awt.Dimension(90, 23));
        btnChonKhachHang.setPreferredSize(new java.awt.Dimension(90, 23));
        btnChonKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbTenKhachHang, 0, 133, Short.MAX_VALUE)
                    .addComponent(txtMaKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Mã hoá đơn:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Voucher:");

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.setPreferredSize(new java.awt.Dimension(85, 23));
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Tổng tiền:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Tiền phải trả:");

        jLabel22.setText("VNĐ");

        jLabel23.setText("VNĐ");

        txtThanhTien.setText("0.0");
        txtThanhTien.setEnabled(false);
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        btnLamMoiBanHang.setBackground(new java.awt.Color(0, 102, 102));
        btnLamMoiBanHang.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiBanHang.setText("Làm mới");
        btnLamMoiBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiBanHangActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 102, 102));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Piggy bank.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnAddVocher.setBackground(new java.awt.Color(0, 102, 102));
        btnAddVocher.setFont(btnAddVocher.getFont());
        btnAddVocher.setForeground(new java.awt.Color(255, 255, 255));
        btnAddVocher.setText("Áp dụng");
        btnAddVocher.setMaximumSize(new java.awt.Dimension(90, 23));
        btnAddVocher.setMinimumSize(new java.awt.Dimension(90, 23));
        btnAddVocher.setPreferredSize(new java.awt.Dimension(90, 23));
        btnAddVocher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVocherActionPerformed(evt);
            }
        });

        txtTongTien.setText("0.0");
        txtTongTien.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nhân viên:");

        cbbTenNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nguyen Van F" }));

        cbbVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnHuyDonHang.setBackground(new java.awt.Color(0, 102, 102));
        btnHuyDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyDonHang.setText("Huỷ");
        btnHuyDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(13, 13, 13))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(15, 15, 15)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(26, 26, 26)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnHuyDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbTenNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTongTien)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(txtThanhTien))
                                            .addComponent(cbbVoucher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddVocher, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnLamMoiBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblMaHoaDon))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(btnAddVocher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoiBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblGioHang_HDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang_HDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHang_HDCTMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblGioHang_HDCT);

        btnXoa.setBackground(new java.awt.Color(0, 102, 102));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xoá sản phẩm");
        btnXoa.setPreferredSize(new java.awt.Dimension(120, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThemSanPhamToHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnThemSanPhamToHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSanPhamToHoaDon.setText("Thêm sản phẩm");
        btnThemSanPhamToHoaDon.setPreferredSize(new java.awt.Dimension(120, 30));
        btnThemSanPhamToHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamToHoaDonActionPerformed(evt);
            }
        });

        btnUpdateHoaDonChiTiet.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdateHoaDonChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateHoaDonChiTiet.setText("Sửa sản phẩm");
        btnUpdateHoaDonChiTiet.setPreferredSize(new java.awt.Dimension(120, 30));
        btnUpdateHoaDonChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHoaDonChiTietActionPerformed(evt);
            }
        });

        btnXoaAll.setBackground(new java.awt.Color(0, 102, 102));
        btnXoaAll.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaAll.setText("Xoá tất cả");
        btnXoaAll.setPreferredSize(new java.awt.Dimension(120, 30));
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemSanPhamToHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateHoaDonChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnThemSanPhamToHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(btnUpdateHoaDonChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnXoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giỏ hàng");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Đơn hàng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tìm kiếm sản phẩm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(0, 703, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked

    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void btnThemSanPhamToHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamToHoaDonActionPerformed

        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Hóa Đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int j = tblDanhSachSanPham.getSelectedRow();
        if (j == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        String maSanPhamChiTiet = tblDanhSachSanPham.getValueAt(j, 0).toString();
        double gia = Double.parseDouble(tblDanhSachSanPham.getValueAt(j, 3).toString());
        int SoLuongHienTai = Integer.parseInt(tblDanhSachSanPham.getValueAt(j, 2).toString());
        double phanTram = Double.valueOf(tblDanhSachSanPham.getValueAt(j, 8).toString());
        double giaSauKhiGiam = soTienGiamAfterAddVoucher(gia, phanTram);

        String soStr = JOptionPane.showInputDialog(this, "Nhập số lượng", "Nhập số lượng", JOptionPane.INFORMATION_MESSAGE);
        int soLuong;
        try {
            soLuong = Integer.parseInt(soStr);
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (soLuong > SoLuongHienTai) {
                JOptionPane.showMessageDialog(this, "Số lượng nhập vượt quá số lượng sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ. Vui lòng nhập lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean sanPhamDaCo = false;
        for (Model_HoaDonChiTiet mhdct : shdct.getHDCTFromHD(maHoaDon)) {
            if (mhdct.getMa().equals(maSanPhamChiTiet)) {
                int newSoLuong = mhdct.getSoLuong() + soLuong;
                shdct.updateSoLuong(mhdct.getMa(), maHoaDon, newSoLuong);
                shdct.upateTongTien(maSanPhamChiTiet, maHoaDon, giaSauKhiGiam);
                mhdct.setSoLuong(newSoLuong);
                mhdct.setGia(giaSauKhiGiam);
                sanPhamDaCo = true;
                break;
            }
        }

        if (!sanPhamDaCo) {
            shdct.addHoaDonChiTiet(maHoaDon, maSanPhamChiTiet, soLuong, giaSauKhiGiam);
        }
        int newSoLuongSanPhamCHiTiet = SoLuongHienTai - soLuong;
        sspct.updateSoLuongSanPhamChiTiet(maSanPhamChiTiet, newSoLuongSanPhamCHiTiet);
        fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
        fillTableGioHang(shdct.getHDCTFromHD(maHoaDon));
        txtTongTien.setText(String.valueOf(tongTien()));
        txtThanhTien.setText(String.valueOf(tongTien()));
        hdsvr.updateHoaDonCho(maHoaDon, tongTien());
        vsp.fillTableSanPhamCHiTiet();
        fillTableHoaDon(hdsvr.getAllBanHang());
        tblHoaDonCho.setRowSelectionInterval(tblHoaDonCho.getRowCount() - 1, tblHoaDonCho.getRowCount() - 1);
    }//GEN-LAST:event_btnThemSanPhamToHoaDonActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Hóa Đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int j = tblGioHang_HDCT.getSelectedRow();
        if (j == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        String maSanPhamChiTiet = tblGioHang_HDCT.getValueAt(j, 0).toString();
        double gia = Double.parseDouble(tblGioHang_HDCT.getValueAt(j, 2).toString());

        int SoLuongHienTai = sspct.getSoLuongSanPhamChiTiet(maSanPhamChiTiet);

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm khỏi hóa đơn không", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        boolean sanPhamCo = false;
        for (Model_HoaDonChiTiet mhdct : shdct.getHDCTFromHD(maHoaDon)) {
            if (mhdct.getMa().equals(maSanPhamChiTiet)) {
                int soLuongCu = mhdct.getSoLuong();
                shdct.deleteHoaDonChiTiet(maHoaDon, maSanPhamChiTiet);
                int soLuongMoi = soLuongCu + SoLuongHienTai;
                sspct.updateSoLuongSanPhamChiTiet(maSanPhamChiTiet, soLuongMoi);
                fillTableGioHang(shdct.getHDCTFromHD(maHoaDon));
                fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
                txtTongTien.setText(String.valueOf(tongTien()));
                txtThanhTien.setText(String.valueOf(tongTien()));
                hdsvr.updateHoaDonCho(maHoaDon, tongTien());
                fillTableHoaDon(hdsvr.getAllBanHang());
                tblHoaDonCho.setRowSelectionInterval(tblHoaDonCho.getRowCount() - 1, tblHoaDonCho.getRowCount() - 1);
                sanPhamCo = true;
                return;
            }
        }
        if (!sanPhamCo) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Hóa Đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá tất cả sản phẩm khỏi giỏ hàng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        boolean sanPhamCo = false;
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        ArrayList<Model_HoaDonChiTiet> lstHDCT = shdct.getHDCTFromHD(maHoaDon);

        for (Model_HoaDonChiTiet mhdct : lstHDCT) {
            String maSanPhamChiTiet = mhdct.getMa();

            int soLuongCu = mhdct.getSoLuong();
            int SoLuongHienTai = sspct.getSoLuongSanPhamChiTiet(maSanPhamChiTiet);
            shdct.deleteAllHoaDonChiTiet(maHoaDon);
            int soLuongMoi = soLuongCu + SoLuongHienTai;
            sspct.updateSoLuongSanPhamChiTiet(maSanPhamChiTiet, soLuongMoi);
            sanPhamCo = true;
        }
        if (sanPhamCo) {
            fillTableGioHang(shdct.getHDCTFromHD(maHoaDon));
            fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
            txtTongTien.setText(String.valueOf(tongTien()));
            txtThanhTien.setText(String.valueOf(tongTien()));
            hdsvr.updateHoaDonCho(maHoaDon, tongTien());
            fillTableHoaDon(hdsvr.getAllBanHang());
            vsp.fillTableSanPhamCHiTiet();

            JOptionPane.showMessageDialog(this, "Đã xoá tất cả sản phẩm khỏi giỏ hàng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        if (!sanPhamCo) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        String tenKhachHang = (String) cbbTenKhachHang.getSelectedItem();
        String tenNhanVien = (String) cbbTenNhanVien.getSelectedItem();
        Model_HoaDon model_HoaDon = new Model_HoaDon(tenNhanVien, tenKhachHang);
        hdsvr.addHoaDonCho(tenKhachHang, tenNhanVien);
        fillTableHoaDon(hdsvr.getAllBanHang());
        tblHoaDonCho.setRowSelectionInterval(tblHoaDonCho.getRowCount() - 1, tblHoaDonCho.getRowCount() - 1);
        int i = tblHoaDonCho.getSelectedRow();
        lblMaHoaDon.setText(tblHoaDonCho.getValueAt(i, 0).toString());
        if (tblGioHang_HDCT.getRowCount() > 0) {
            this.defaultTableModelGioHang.setRowCount(0);
        }
        JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        int i = tblHoaDonCho.getSelectedRow();
        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        lblMaHoaDon.setText(tblHoaDonCho.getValueAt(i, 0).toString());
        cbbTenKhachHang.setSelectedItem(tblHoaDonCho.getValueAt(i, 3).toString());
        cbbTenNhanVien.setSelectedItem(tblHoaDonCho.getValueAt(i, 2).toString());
        if (hdsvr.getVoucherByIDHoaDon(maHoaDon) == null) {
            txtTongTien.setText(String.valueOf(tongTien()));
            txtThanhTien.setText(tblHoaDonCho.getValueAt(i, 4).toString());
            cbbVoucher.setSelectedIndex(0);
        } else {
            String phanTramGiamStr = hdsvr.getVoucherByIDHoaDon(maHoaDon);
            double phanTramGiam = Double.valueOf(phanTramGiamStr);
            String tongTienStr = hdsvr.getTongTienByHoaDon(maHoaDon);
            double tongTien = Double.valueOf(tongTienStr);
            txtTongTien.setText(tongTienStr);
            txtThanhTien.setText(String.valueOf(soTienGiamAfterAddVoucher(tongTien, phanTramGiam)));
            cbbVoucher.setSelectedItem(hdsvr.getTenVoucherByIDHoaDon(maHoaDon));
        }
        fillTableGioHang(shdct.getHDCTFromHD(tblHoaDonCho.getValueAt(i, 0).toString()));
    }//GEN-LAST:event_tblHoaDonChoMouseClicked

    private void tblGioHang_HDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHang_HDCTMouseClicked

    }//GEN-LAST:event_tblGioHang_HDCTMouseClicked

    private void btnUpdateHoaDonChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHoaDonChiTietActionPerformed
        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Hóa Đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int k = tblGioHang_HDCT.getSelectedRow();
        if (k == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        String maSanPhamChiTiet = tblGioHang_HDCT.getValueAt(k, 0).toString();
        double gia = sspct.getGiaSanPhamChiTiet(maSanPhamChiTiet);
        double phanTramGiamGia = sspct.getPhanTramGiamGia(maSanPhamChiTiet);
        double giaSauKhiGiam = soTienGiamAfterAddVoucher(gia, phanTramGiamGia);
        int SoLuongHienTai = sspct.getSoLuongSanPhamChiTiet(maSanPhamChiTiet);
        int soLuongSPGioHang = Integer.valueOf(tblGioHang_HDCT.getValueAt(k, 3).toString());
        int soLuongBanDau = soLuongSPGioHang + SoLuongHienTai;
        boolean sanPhamCo = false;

        if (sanPhamCo) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String soStr = JOptionPane.showInputDialog(this, "Nhập số lượng", "Nhập số lượng", JOptionPane.INFORMATION_MESSAGE);
        int soLuongMoi;
        try {
            soLuongMoi = Integer.parseInt(soStr);
            if (soLuongMoi <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (soLuongMoi > soLuongBanDau) {
                JOptionPane.showMessageDialog(this, "Số lượng nhập vượt quá số lượng sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ. Vui lòng nhập lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int soLuongCu = 0;

        for (Model_HoaDonChiTiet mhdct : shdct.getHDCTFromHD(maHoaDon)) {
            if (mhdct.getMa().equals(maSanPhamChiTiet)) {
                soLuongCu = mhdct.getSoLuong();
                mhdct.setSoLuong(soLuongMoi);
                mhdct.setGia(giaSauKhiGiam);
                shdct.updateSoLuong(maSanPhamChiTiet, maHoaDon, soLuongMoi);
                shdct.upateTongTien(maSanPhamChiTiet, maHoaDon, giaSauKhiGiam);

            }
        }

        int soLuongSanPhamChiTietMoi = SoLuongHienTai + (soLuongCu - soLuongMoi);
        sspct.updateSoLuongSanPhamChiTiet(maSanPhamChiTiet, soLuongSanPhamChiTietMoi);
        fillTableGioHang(shdct.getHDCTFromHD(maHoaDon));
        fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
        txtTongTien.setText(String.valueOf(tongTien()));
        txtThanhTien.setText(String.valueOf(tongTien()));
        hdsvr.updateHoaDonCho(maHoaDon, tongTien());
        fillTableHoaDon(hdsvr.getAllBanHang());
        tblHoaDonCho.setRowSelectionInterval(tblHoaDonCho.getRowCount() - 1, tblHoaDonCho.getRowCount() - 1);
    }//GEN-LAST:event_btnUpdateHoaDonChiTietActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Hóa Đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        String nhanVien = tblHoaDonCho.getValueAt(i, 2).toString();
        String khachHang = tblHoaDonCho.getValueAt(i, 3).toString();
        double tongTien = Double.valueOf(txtThanhTien.getText());
        if (!nhanVien.equalsIgnoreCase(cbbTenNhanVien.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không trùng với hóa đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!khachHang.equalsIgnoreCase(cbbTenKhachHang.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không trùng với hóa đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (tblGioHang_HDCT.getRowCount() > 0) {
                hdsvr.updateHoaDonThanhToan(maHoaDon, tongTien);
                JOptionPane.showMessageDialog(this, "Thanh toán thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                fillTableHoaDon(hdsvr.getAllBanHang());
                defaultTableModelGioHang.setRowCount(0);
                fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
                txtThanhTien.setText("0.0");
                txtTongTien.setText("0.0");
                cbbVoucher.setSelectedIndex(0);
                lblMaHoaDon.setText("");
                vsp.fillTableSanPhamCHiTiet();
            } else {
                JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào trong hóa đơn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại", "Thông Báo", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnLamMoiBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiBanHangActionPerformed
        txtMaKhachHang.setText("");
        cbbTenKhachHang.setSelectedIndex(0);
        cbbTenNhanVien.setSelectedIndex(0);
        lblMaHoaDon.setText("");
        cbbVoucher.setSelectedIndex(0);
        txtTongTien.setText("0.0");
        txtThanhTien.setText("");
        fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
        int rowCount = tblHoaDonCho.getRowCount();
        if (rowCount > 0) {
            tblHoaDonCho.setRowSelectionInterval(rowCount - 1, rowCount - 1);
        }
    }//GEN-LAST:event_btnLamMoiBanHangActionPerformed

    private void cbbTenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenKhachHangActionPerformed
        Object selectedItem = cbbTenKhachHang.getSelectedItem();

        if (selectedItem != null) {
            String tenkh = selectedItem.toString();
            String maKhachHang = skh.getMaKhachHang(tenkh);

            if (maKhachHang != null) {
                txtMaKhachHang.setText(maKhachHang);
            } else {
                txtMaKhachHang.setText("Không tìm thấy");
            }
        }

    }//GEN-LAST:event_cbbTenKhachHangActionPerformed

    private void btnAddVocherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVocherActionPerformed
        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn Hóa Đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String selectedVoucher = cbbVoucher.getSelectedItem().toString();
        int soLuongVoucher = vcsvr.getSoLuongVoucher(selectedVoucher);
        if (soLuongVoucher <= 0) {
            JOptionPane.showMessageDialog(this, "Hết voucher", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        if (hdsvr.checkVoucher(maHoaDon) != 0) {
            JOptionPane.showMessageDialog(this, "Hóa đơn đã áp dụng voucher", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String tenVoucher = cbbVoucher.getSelectedItem().toString();
            hdsvr.addVoucher(maHoaDon, tenVoucher);
            String phanTramGiamStr = vcsvr.getVoucherByTen(tenVoucher);
            double phanTramGiam = Double.valueOf(phanTramGiamStr);
            String tongTienStr = hdsvr.getTongTienByHoaDon(maHoaDon);
            double tongTien = Double.valueOf(tongTienStr);
            txtThanhTien.setText(String.valueOf(soTienGiamAfterAddVoucher(tongTien, phanTramGiam)));
            vcsvr.updateVoucherSoLuong(selectedVoucher, soLuongVoucher - 1);
        }

    }//GEN-LAST:event_btnAddVocherActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void btnHuyDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonHangActionPerformed
        int i = tblHoaDonCho.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hoá đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn hủy hóa đơn?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String maHoaDon = tblHoaDonCho.getValueAt(i, 0).toString();
        if (hdsvr.checkVoucher(maHoaDon) != 0) {
            String getSoLuongVoucherStr = hdsvr.getSoLuongVoucherByIDHoaDon(maHoaDon);
            int getSoLuongVoucherMoi = Integer.parseInt(getSoLuongVoucherStr);
            hdsvr.updateVoucherSoLuongByMaHoaDon(maHoaDon, getSoLuongVoucherMoi + 1);
        }
        ArrayList<Model_HoaDonChiTiet> lstHDCT = shdct.getHDCTFromHD(maHoaDon);
        hdsvr.deleteHoaDonCho(maHoaDon);
        for (Model_HoaDonChiTiet mhdct : lstHDCT) {

            String maSanPhamChiTiet = mhdct.getMa();
            int soLuongCu = mhdct.getSoLuong();
            int SoLuongHienTai = sspct.getSoLuongSanPhamChiTiet(maSanPhamChiTiet);
            shdct.deleteAllHoaDonChiTiet(maHoaDon);
            int soLuongMoi = soLuongCu + SoLuongHienTai;
            sspct.updateSoLuongSanPhamChiTiet(maSanPhamChiTiet, soLuongMoi);
        }

        fillTableGioHang(shdct.getHDCTFromHD(maHoaDon));
        fillTableSanPhamCHiTiet(sspct.getAllSPBanHang());
        txtTongTien.setText("0.0");
        txtThanhTien.setText("0.0");
        fillTableHoaDon(hdsvr.getAllBanHang());
        JOptionPane.showMessageDialog(this, "Huỷ hoá đơn chờ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnHuyDonHangActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        fillTableSanPhamCHiTiet(sspct.searchSPBanHang(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnChonKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachHangActionPerformed
        View_ChonKhachHang chonKhachHang = new View_ChonKhachHang(this);
        chonKhachHang.setVisible(true);
        chonKhachHang.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnChonKhachHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVocher;
    private javax.swing.JButton btnChonKhachHang;
    private javax.swing.JButton btnHuyDonHang;
    private javax.swing.JButton btnLamMoiBanHang;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSanPhamToHoaDon;
    private javax.swing.JButton btnUpdateHoaDonChiTiet;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JComboBox<String> cbbTenKhachHang;
    private javax.swing.JComboBox<String> cbbTenNhanVien;
    private javax.swing.JComboBox<String> cbbVoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tblGioHang_HDCT;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
