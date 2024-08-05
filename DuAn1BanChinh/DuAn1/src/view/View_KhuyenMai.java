/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import Model.Model_SanPhamChiTiet;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Model_KhuyenMai;
import service.Service_KhuyenMai;

/**
 *
 * @author anhso
 */
public class View_KhuyenMai extends javax.swing.JPanel {
   private Service_KhuyenMai qlykm = new Service_KhuyenMai();
    /**
     * Creates new form View_KhuyenMai
     */
    public View_KhuyenMai() {
        initComponents();
        this.fillTable();
    }
    
   public void showData(int index) {
        txtMaKM.setText(tblGiamGia.getValueAt(index, 0).toString());
        txtPhantram.setText(tblGiamGia.getValueAt(index, 1).toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date ngayBD = dateFormat.parse(tblGiamGia.getValueAt(index, 2).toString());
            java.util.Date ngayketthuc = dateFormat.parse(tblGiamGia.getValueAt(index, 3).toString());
            datebatdau.setDate(ngayBD);
            datekt.setDate(ngayketthuc);
        } catch (ParseException e) {
            e.printStackTrace();           
        }       
        cboTrangthai.setSelectedItem(tblGiamGia.getValueAt(index, 4).toString());
    }
   
    public void fillTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblGiamGia.getModel();
        tblModel.setRowCount(0);
        
        for (Model_KhuyenMai x : qlykm.getAll()) {
            tblModel.addRow(x.toDataRow());
        }
    }
    
    public void fillTableSanPhamKM() {
        DefaultTableModel tblModel = (DefaultTableModel) tblSpKm.getModel();
        tblModel.setRowCount(0);
        
        for (Model_SanPhamChiTiet x : qlykm.getSanPhamChiTiet(qlykm.getAll().get(tblGiamGia.getSelectedRow()).getId())) {
            tblModel.addRow(x.toDataRowKhuyenMai());
        }
    }
    public void lamMoi() {
        txtMaKM.setText("");
        txtPhantram.setText("");
        datebatdau.setDate(null);
        datekt.setDate(null);
        cboTrangthai.setSelectedIndex(0);
        
    }

    Model_KhuyenMai readformthem() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new Model_KhuyenMai(0, txtMaKM.getText(), txtPhantram.getText(), format.format(datebatdau.getDate()), format.format(datekt.getDate()), cboTrangthai.getSelectedIndex() == 0);
    }

    Model_KhuyenMai readformSUA() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new Model_KhuyenMai(qlykm.getAll().get(tblGiamGia.getSelectedRow()).getId(), txtMaKM.getText(), txtPhantram.getText(), format.format(datebatdau.getDate()), format.format(datekt.getDate()), cboTrangthai.getSelectedIndex() == 0);
    }
    
    public boolean checkNull() {
        if (txtMaKM.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        } else if (txtPhantram.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phần trăm không được để trống");
            return false;
        } else if (datebatdau.getDate() == null) {
            JOptionPane.showMessageDialog(this,  "Ngày bắt đầu không được để trống");
            
            return false;
        } else if (datekt.getDate()==null) {
            JOptionPane.showMessageDialog(this,  "Ngày kết thúc không được để trống");
            return false;
        } else {
            
            return true;
        }
    }
    public  boolean  checkTrung(){
        for (Model_KhuyenMai x : qlykm.getAll()) {
            if (x.getMaKhuyenMai().equals(txtMaKM.getText())) {
                JOptionPane.showMessageDialog(this,  "Mã Khuyến Mại đã tồn tại");
                return false;
            }
        }
        return true;
    }
    
    public boolean  checkso(){
        if (Double.parseDouble(txtPhantram.getText())<=0) {
             JOptionPane.showMessageDialog(this,  "Phần trăm khuyến mại không được âm");
                return false;
        }
        return true;
    }
    
    public boolean check() {
        if (datebatdau.getDate().after(datekt.getDate())) {
             JOptionPane.showMessageDialog(this,  "Ngay bat dau < ngày kết thuc");
                return false;
        }
        return true;
    }
    
    public static boolean isValidDate(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        // Kiểm tra tháng và năm hợp lệ
        if (month < Calendar.JANUARY || month > Calendar.DECEMBER || year < 1900 || year > 2100) {
            return false;
        }

        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Kiểm tra ngày có hợp lệ trong tháng hay không
        return day <= maxDay && day > 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtPhantram = new javax.swing.JTextField();
        cboTrangthai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSpKm = new javax.swing.JTable();
        btnLammoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        datebatdau = new com.toedter.calendar.JDateChooser();
        datekt = new com.toedter.calendar.JDateChooser();
        btnGiamGia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGiamGia = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mã khuyến mại:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Phần trăm giảm giá:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ngày bắt đầu:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ngày kết thúc:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Trạng thái:");

        txtPhantram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhantramActionPerformed(evt);
            }
        });

        cboTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Hoạt Động", "Dừng Hoạt Động" }));

        tblSpKm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chọn", "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSpKm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpKmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSpKm);

        btnLammoi.setBackground(new java.awt.Color(0, 102, 102));
        btnLammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLammoi.setText("Làm mới");
        btnLammoi.setPreferredSize(new java.awt.Dimension(76, 30));
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 102));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(76, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 102, 102));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(76, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnGiamGia.setBackground(new java.awt.Color(0, 102, 102));
        btnGiamGia.setForeground(new java.awt.Color(255, 255, 255));
        btnGiamGia.setText("Giảm giá");
        btnGiamGia.setPreferredSize(new java.awt.Dimension(76, 30));
        btnGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(datekt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datebatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhantram, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPhantram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datebatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datekt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cboTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Chương trình giảm giá");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Danh sách giảm giá");

        tblGiamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mại", "Phần trăm giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiamGiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGiamGia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSpKmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpKmMouseClicked
         if (tblSpKm.getSelectedRow() == -1) {
            
            btnGiamGia.setText("Giảm giá");
        } else if (tblSpKm.getValueAt(tblSpKm.getSelectedRow(), 2).toString().equals("Đã chọn")) {
            
            btnGiamGia.setText("Bỏ chọn");
        } else {
            
            btnGiamGia.setText("Chọn");
        }
    }//GEN-LAST:event_tblSpKmMouseClicked

    private void tblGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiamGiaMouseClicked
        this.fillTableSanPhamKM();
        this.showData(tblGiamGia.getSelectedRow());
        btnGiamGia.setText("Giảm giá");
        txtMaKM.setEnabled(false);
    }//GEN-LAST:event_tblGiamGiaMouseClicked

    private void btnGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamGiaActionPerformed
        int indexGg = tblGiamGia.getSelectedRow();
        int indexSp = tblSpKm.getSelectedRow();
        
        if (indexSp != -1) {
            if (btnGiamGia.getText().equals("Chọn")) {
            
            qlykm.chonKhuyenMai(qlykm.getAll().get(indexGg).getId() , qlykm.getSanPhamChiTiet(qlykm.getAll().get(indexGg).getId()).get(indexSp).getId());
            btnGiamGia.setText("Bỏ chọn");
        } else if (btnGiamGia.getText().equals("Bỏ chọn")) {
            
            qlykm.boChonKhuyenMai(qlykm.getSanPhamChiTiet(qlykm.getAll().get(indexGg).getId()).get(indexSp).getId());
            btnGiamGia.setText("Chọn");
        }
        
        this.fillTable();
        tblGiamGia.setRowSelectionInterval(indexGg, indexGg);
        fillTableSanPhamKM();
        tblSpKm.setRowSelectionInterval(indexSp, indexSp);
        }      
    }//GEN-LAST:event_btnGiamGiaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (checkNull() &&checkTrung() &&checkso()&&check()) {
            qlykm.themkhuyenmai(readformthem());
            this.fillTable();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (checkNull()&&checkso()&&check()) {
            qlykm.sua(readformSUA());
            this.fillTable();
            if(cboTrangthai.getSelectedItem().toString().equals("Dừng Hoạt Động")){
                qlykm.dungKhuyenMai(txtMaKM.getText());
            }
        }
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        this.lamMoi();
        JOptionPane.showMessageDialog(this, "Làm mới thành công");
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void txtPhantramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhantramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhantramActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiamGia;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboTrangthai;
    private com.toedter.calendar.JDateChooser datebatdau;
    private com.toedter.calendar.JDateChooser datekt;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGiamGia;
    private javax.swing.JTable tblSpKm;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtPhantram;
    // End of variables declaration//GEN-END:variables
}
