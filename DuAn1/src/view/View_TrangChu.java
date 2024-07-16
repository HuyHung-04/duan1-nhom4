/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.CardLayout;

/**
 *
 * @author ADMIN
 */
public class View_TrangChu extends javax.swing.JFrame {

    CardLayout cardLayout;

    /**
     * Creates new form View_TrangChu
     */
    public View_TrangChu() {
        initComponents();
        cardLayout = (CardLayout) card.getLayout();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSanPham = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnVoucher = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        card = new javax.swing.JPanel();
        cardSanPham = new javax.swing.JPanel();
        view_SanPham2 = new view.View_SanPham();
        cardVoucher = new javax.swing.JPanel();
        view_Voucher2 = new view.View_Voucher();
        cardBanHang = new javax.swing.JPanel();
        view_BanHang1 = new view.View_BanHang();
        cardKhuyenMai = new javax.swing.JPanel();
        view_KhuyenMai1 = new view.View_KhuyenMai();
        cardKhachHang = new javax.swing.JPanel();
        view_KhachHang2 = new view.View_KhachHang();
        cardNhanVien = new javax.swing.JPanel();
        view_NhanVien2 = new view.View_NhanVien();
        cardHoaDon = new javax.swing.JPanel();
        view_HoaDon2 = new view.View_HoaDon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 800));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nike");

        btnSanPham.setBackground(new java.awt.Color(0, 102, 102));
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Basket.png"))); // NOI18N
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(0, 102, 102));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(255, 255, 255));
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add to basket.png"))); // NOI18N
        btnBanHang.setText("Bán Hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/List.png"))); // NOI18N
        btnHoaDon.setText("Hoá Đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnKhuyenMai.setBackground(new java.awt.Color(0, 102, 102));
        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Coins.png"))); // NOI18N
        btnKhuyenMai.setText("Khuyến Mại");
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnVoucher.setBackground(new java.awt.Color(0, 102, 102));
        btnVoucher.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnVoucher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Money.png"))); // NOI18N
        btnVoucher.setText("Voucher");
        btnVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoucherActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(0, 102, 102));
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User.png"))); // NOI18N
        btnNhanVien.setText("Nhân Viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(0, 102, 102));
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User group.png"))); // NOI18N
        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(0, 102, 102));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Log out.png"))); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 102, 102));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Log out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(950, 800));

        card.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        card.setLayout(new java.awt.CardLayout());

        cardSanPham.setPreferredSize(new java.awt.Dimension(946, 803));

        javax.swing.GroupLayout cardSanPhamLayout = new javax.swing.GroupLayout(cardSanPham);
        cardSanPham.setLayout(cardSanPhamLayout);
        cardSanPhamLayout.setHorizontalGroup(
            cardSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_SanPham2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardSanPhamLayout.setVerticalGroup(
            cardSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_SanPham2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        card.add(cardSanPham, "cardSanPham");

        javax.swing.GroupLayout cardVoucherLayout = new javax.swing.GroupLayout(cardVoucher);
        cardVoucher.setLayout(cardVoucherLayout);
        cardVoucherLayout.setHorizontalGroup(
            cardVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardVoucherLayout.createSequentialGroup()
                .addComponent(view_Voucher2, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        cardVoucherLayout.setVerticalGroup(
            cardVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardVoucherLayout.createSequentialGroup()
                .addComponent(view_Voucher2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        card.add(cardVoucher, "cardVoucher");

        javax.swing.GroupLayout cardBanHangLayout = new javax.swing.GroupLayout(cardBanHang);
        cardBanHang.setLayout(cardBanHangLayout);
        cardBanHangLayout.setHorizontalGroup(
            cardBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBanHangLayout.createSequentialGroup()
                .addComponent(view_BanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        cardBanHangLayout.setVerticalGroup(
            cardBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBanHangLayout.createSequentialGroup()
                .addComponent(view_BanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        card.add(cardBanHang, "cardBanHang");

        javax.swing.GroupLayout cardKhuyenMaiLayout = new javax.swing.GroupLayout(cardKhuyenMai);
        cardKhuyenMai.setLayout(cardKhuyenMaiLayout);
        cardKhuyenMaiLayout.setHorizontalGroup(
            cardKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardKhuyenMaiLayout.createSequentialGroup()
                .addComponent(view_KhuyenMai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        cardKhuyenMaiLayout.setVerticalGroup(
            cardKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardKhuyenMaiLayout.createSequentialGroup()
                .addComponent(view_KhuyenMai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        card.add(cardKhuyenMai, "cardKhuyenMai");

        javax.swing.GroupLayout cardKhachHangLayout = new javax.swing.GroupLayout(cardKhachHang);
        cardKhachHang.setLayout(cardKhachHangLayout);
        cardKhachHangLayout.setHorizontalGroup(
            cardKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_KhachHang2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        cardKhachHangLayout.setVerticalGroup(
            cardKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_KhachHang2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );

        card.add(cardKhachHang, "cardKhachHang");

        javax.swing.GroupLayout cardNhanVienLayout = new javax.swing.GroupLayout(cardNhanVien);
        cardNhanVien.setLayout(cardNhanVienLayout);
        cardNhanVienLayout.setHorizontalGroup(
            cardNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardNhanVienLayout.createSequentialGroup()
                .addComponent(view_NhanVien2, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                .addContainerGap())
        );
        cardNhanVienLayout.setVerticalGroup(
            cardNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardNhanVienLayout.createSequentialGroup()
                .addComponent(view_NhanVien2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );

        card.add(cardNhanVien, "cardNhanVien");

        javax.swing.GroupLayout cardHoaDonLayout = new javax.swing.GroupLayout(cardHoaDon);
        cardHoaDon.setLayout(cardHoaDonLayout);
        cardHoaDonLayout.setHorizontalGroup(
            cardHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_HoaDon2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        cardHoaDonLayout.setVerticalGroup(
            cardHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_HoaDon2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );

        card.add(cardHoaDon, "cardHoaDon");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(card, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(card, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        cardLayout.show(card, "cardSanPham");
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        cardLayout.show(card, "cardBanHang");
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        cardLayout.show(card, "cardHoaDon");
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        cardLayout.show(card, "cardKhuyenMai");
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoucherActionPerformed
        cardLayout.show(card, "cardVoucher");
    }//GEN-LAST:event_btnVoucherActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        cardLayout.show(card, "cardNhanVien");
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        cardLayout.show(card, "cardKhachHang");
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        View_Login viewLg = new View_Login();
        viewLg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(View_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnVoucher;
    private javax.swing.JPanel card;
    private javax.swing.JPanel cardBanHang;
    private javax.swing.JPanel cardHoaDon;
    private javax.swing.JPanel cardKhachHang;
    private javax.swing.JPanel cardKhuyenMai;
    private javax.swing.JPanel cardNhanVien;
    private javax.swing.JPanel cardSanPham;
    private javax.swing.JPanel cardVoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.View_BanHang view_BanHang1;
    private view.View_HoaDon view_HoaDon2;
    private view.View_KhachHang view_KhachHang2;
    private view.View_KhuyenMai view_KhuyenMai1;
    private view.View_NhanVien view_NhanVien2;
    private view.View_SanPham view_SanPham2;
    private view.View_Voucher view_Voucher2;
    // End of variables declaration//GEN-END:variables
}
