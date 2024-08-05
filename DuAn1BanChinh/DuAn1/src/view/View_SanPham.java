/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import service.Service_ThuocTinhSanPham;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Model_SanPham;
import model.Model_ThuocTinhSanPham;
import service.Service_SanPham;
import model.Model_SanPhamChiTiet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.DefaultComboBoxModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.Service_SanPhamChiTiet;

/**
 *
 * @author anhso
 */
public class View_SanPham extends javax.swing.JPanel {

    private Service_SanPham ssp = new Service_SanPham();
    private Service_ThuocTinhSanPham sttsp = new Service_ThuocTinhSanPham();
    private Service_SanPhamChiTiet qLy = new Service_SanPhamChiTiet();
    private DefaultTableModel dtm = new DefaultTableModel();

    public View_SanPham() {
        initComponents();
        fillTable(ssp.getAll());
        ArrayList<String> lstdm = ssp.getDanhMuc();
        ArrayList<String> lstncc = ssp.getNhaCungCap();
//        ArrayList<String> lsttsap = ssp.getTenSanPham();
        cbbDanhMuc.removeAllItems();
        cbbTimKiemDanhMuc.removeAllItems();
        cbbNhaCungCapLoc.removeAllItems();
        cbbNhaCungCap.removeAllItems();

        this.themtensanpham();

        String tkdanhmucdefault = "Chọn danh mục";
        String tknhacungcapdefault = "Chọn nhà cung cấp";
        String tktensanpham = "Chọn tên sản phẩm";
        cbbTimKiemDanhMuc.addItem(tkdanhmucdefault);
        cbbNhaCungCapLoc.addItem(tknhacungcapdefault);

        for (String danhmuc : lstdm) {
            cbbDanhMuc.addItem(danhmuc);
            cbbTimKiemDanhMuc.addItem(danhmuc);
//            cbbDanhMucSanPhamChiTiet.addItem(danhmuc);
        }

        for (String nhacungcap : lstncc) {
            cbbNhaCungCap.addItem(nhacungcap);
            cbbNhaCungCapLoc.addItem(nhacungcap);
        }
        cbbSanPhamLoc.removeAllItems();
        cbbTenSanPham.removeAllItems();
        String chonloctensp = "Tất cả";
        cbbSanPhamLoc.addItem(chonloctensp);
        ArrayList<String> lsttsap = ssp.getTenSanPham();
        for (String tensanpham : lsttsap) {
            cbbSanPhamLoc.addItem(tensanpham);
            cbbTenSanPham.addItem(tensanpham);
        }

        fillTableNhaCungCap(sttsp.getAllNhaCungCap());
        //add màu
        cbbMauLoc.removeAllItems();
        cbbMau.removeAllItems();
        String chonmau = "Chọn màu";
        cbbMauLoc.addItem(chonmau);
        ArrayList<String> listmau = sttsp.getMau();
        for (String mau : listmau) {
            cbbMau.addItem(mau);
            cbbMauLoc.addItem(mau);
        }
        //add size
        cbbSizeLoc.removeAllItems();
        cbbSize.removeAllItems();
        String chonsize = "Chọn size";
        cbbSizeLoc.addItem(chonsize);
        ArrayList<String> listsize = sttsp.getSize();
        for (String size : listsize) {
            cbbSize.addItem(size);
            cbbSizeLoc.addItem(size);
        }

        //add chất liệu
        cbbChatLieuLoc.removeAllItems();
        cbbChatLieu.removeAllItems();
        String chonCl = "Chọn chất liệu";
        cbbChatLieuLoc.addItem(chonCl);
        ArrayList<String> listcl = sttsp.getChatLieu();
        for (String cl : listcl) {
            cbbChatLieu.addItem(cl);
            cbbChatLieuLoc.addItem(cl);
        }
        //add đế giày
        cbbDeGiay.removeAllItems();
        ArrayList<String> listdg = sttsp.getDeGiay();
        for (String dg : listdg) {
            cbbDeGiay.addItem(dg);
        }
        //add nhà cung cấp
        cbbNhaCungCapLoc.removeAllItems();
        cbbNhaCungCap.removeAllItems();
        String chonNcc = "Chọn nhà cung cấp";
        cbbNhaCungCapLoc.addItem(chonNcc);
        ArrayList<String> listncc = sttsp.getNhaCungCap();
        for (String ncc : listncc) {
            cbbNhaCungCap.addItem(ncc);
            cbbNhaCungCapLoc.addItem(ncc);
        }
        //add danh mục
        cbbDanhMuc.removeAllItems();
        cbbTimKiemDanhMuc.removeAllItems();
        String chondm = "Chọn danh mục";
        cbbDanhMuc.addItem(chondm);
        cbbTimKiemDanhMuc.addItem(chondm);
        ArrayList<String> listdm = sttsp.getDanhMuc();
        for (String dm : listdm) {
            cbbDanhMuc.addItem(dm);
            cbbTimKiemDanhMuc.addItem(dm);
        }
    }

    void fillTable(ArrayList<Model_SanPham> list) {
        dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        for (Model_SanPham model_SanPham : list) {
            dtm.addRow(model_SanPham.toRowData());
        }
    }

    void fillTableNhaCungCap(ArrayList<Model_ThuocTinhSanPham> list) {
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        for (Model_ThuocTinhSanPham ttsp : list) {
            dtm.addRow(ttsp.toDaTaRow());
        }
    }

    void fillTableChatLieu(ArrayList<Model_ThuocTinhSanPham> list) {
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        for (Model_ThuocTinhSanPham ttsp : list) {
            dtm.addRow(ttsp.toDaTaRow());
        }
    }

    void fillTableMau(ArrayList<Model_ThuocTinhSanPham> list) {
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        for (Model_ThuocTinhSanPham ttsp : list) {
            dtm.addRow(ttsp.toDaTaRow());
        }
    }

    void fillTableDeGiay(ArrayList<Model_ThuocTinhSanPham> list) {
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        for (Model_ThuocTinhSanPham ttsp : list) {
            dtm.addRow(ttsp.toDaTaRow());
        }
    }

    void fillTableSize(ArrayList<Model_ThuocTinhSanPham> list) {
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        for (Model_ThuocTinhSanPham ttsp : list) {
            dtm.addRow(ttsp.toDaTaRow());
        }
    }

    void fillTableDanhMuc(ArrayList<Model_ThuocTinhSanPham> list) {
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        for (Model_ThuocTinhSanPham ttsp : list) {
            dtm.addRow(ttsp.toDaTaRow());
        }
    }

    public void fillTableSanPhamCHiTiet() {
        DefaultTableModel dblModel = (DefaultTableModel) tblSanPhamChiTiet.getModel();
        dblModel.setRowCount(0);
        list.clear();

        for (Model_SanPhamChiTiet x : qLy.getAll(cbbSizeLoc.getSelectedIndex(), cbbMauLoc.getSelectedIndex(), cbbChatLieuLoc.getSelectedIndex(), cbbSanPhamLoc.getSelectedIndex())) {
            dblModel.addRow(x.toDataRow());
            list.add(x);
        }
    }

    public void fillTableLocSanPham() {
        DefaultTableModel dblModel = (DefaultTableModel) tblSanPham.getModel();
        dblModel.setRowCount(0);

        for (Model_SanPham x : ssp.getSanPhamLoc(cbbTimKiemDanhMuc.getSelectedIndex(), cbbNhaCungCapLoc.getSelectedIndex(), cbbTimKiemTrangThai.getSelectedIndex())) {
            dblModel.addRow(x.toRowData());
        }
    }

    private Model_SanPham readForm() {
        String maSanPham = txtMaSanPham.getText();
        String tenSanPham = txtTenSanPham.getText();
        String tenDanhMuc = (String) cbbDanhMuc.getSelectedItem();
        String tenNhaCungCap = (String) cbbNhaCungCap.getSelectedItem();
        boolean trangThai = true; // Default value

        // Assuming cbbTrangThai represents a JComboBox
        String trangThaiString = (String) cbbTrangThai.getSelectedItem();
        if (trangThaiString != null && trangThaiString.equals("Dừng hoạt động")) {
            trangThai = false;
        }

        if (maSanPham.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mã sản phẩm", "", JOptionPane.ERROR_MESSAGE);
            txtMaSanPham.requestFocus();
            return null;
        }
        if (tenSanPham.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống tên sản phẩm", "", JOptionPane.ERROR_MESSAGE);
            txtTenSanPham.requestFocus();
            return null;
        }

        Model_SanPham model_SanPham = new Model_SanPham(maSanPham, tenSanPham, tenDanhMuc, tenNhaCungCap, trangThai);
        return model_SanPham;
    }

    Model_ThuocTinhSanPham readFormThuocTinh() {
        String ma, ten;
        ma = txtMaThuocTinh.getText();
        ten = txtTenThuocTinh.getText();
        if (ma.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã thuộc tính không được để trống", "", JOptionPane.ERROR_MESSAGE);
            txtMaThuocTinh.requestFocus();
            return null;
        }
        if (ten.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên thuộc tính không được để trống", "", JOptionPane.ERROR_MESSAGE);
            txtMaThuocTinh.requestFocus();
            return null;
        }
        return new Model_ThuocTinhSanPham(ma, ten);
    }

    // Sp Chi Tiet
    public void showData(int index) {
        txtspct.setText(tblSanPhamChiTiet.getValueAt(index, 0).toString());
        txttspct.setText(tblSanPhamChiTiet.getValueAt(index, 1).toString());
        txtSoLuong.setText(tblSanPhamChiTiet.getValueAt(index, 2).toString());
        txtGia.setText(tblSanPhamChiTiet.getValueAt(index, 3).toString());
        cbbMau.setSelectedItem(tblSanPhamChiTiet.getValueAt(index, 4).toString());
        cbbSize.setSelectedItem(tblSanPhamChiTiet.getValueAt(index, 5).toString());
        cbbChatLieu.setSelectedItem(tblSanPhamChiTiet.getValueAt(index, 6).toString());
        cbbDeGiay.setSelectedItem(tblSanPhamChiTiet.getValueAt(index, 7).toString());
        cbbTrangThaiSPCT.setSelectedItem(tblSanPhamChiTiet.getValueAt(index, 8).toString());
        cbbTenSanPham.setSelectedItem(tblSanPhamChiTiet.getValueAt(index, 9).toString());
    }

    public void lamMoi() {
        txtspct.setText("");
        txttspct.setText("");
        txtSoLuong.setText("");
        txtGia.setText("");
        cbbMau.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        cbbChatLieu.setSelectedIndex(0);
        cbbDeGiay.setSelectedIndex(0);
        cbbTrangThaiSPCT.setSelectedIndex(0);
        cbbSizeLoc.setSelectedIndex(0);
        cbbSanPhamLoc.setSelectedIndex(0);
        cbbChatLieuLoc.setSelectedIndex(0);
        cbbMauLoc.setSelectedIndex(0);
        cbbTenSanPham.setSelectedIndex(0);

    }

    public boolean checkNumber() {
        try {
            int i = Integer.parseInt(txtSoLuong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là kiểu số", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int i = Integer.parseInt(txtGia.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá phải là kiểu số", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (Integer.parseInt(txtSoLuong.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (Integer.parseInt(txtGia.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    Model_SanPhamChiTiet readFormSanPhamChiTiet() {
        int id = tblSanPhamChiTiet.getSelectedRow() + 1;
        String masp = txtspct.getText();
        if (masp.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống", "", JOptionPane.ERROR_MESSAGE);
            txtspct.requestFocus();
            return null;
        }
        String ten = txttspct.getText();
        if (ten.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống", "", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (txtSoLuong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống", "", JOptionPane.ERROR_MESSAGE);
            txtSoLuong.requestFocus();
            return null;
        }
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        int gia = Integer.parseInt(txtGia.getText());
        String mau = cbbMau.getSelectedItem().toString();
        String size = cbbSize.getSelectedItem().toString();
        String chatLieu = cbbChatLieu.getSelectedItem().toString();
        String deGiay = cbbDeGiay.getSelectedItem().toString();
        boolean trangThai = cbbTrangThaiSPCT.getSelectedIndex() == 0;
        String tensanpham = cbbTenSanPham.getSelectedItem().toString();
        return new Model_SanPhamChiTiet(id, masp, ten, soLuong, gia, mau, size, chatLieu, deGiay, trangThai, tensanpham);
    }

    public boolean checkNull() {
        if (txtspct.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã trống", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (txttspct.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên trống", "", JOptionPane.ERROR_MESSAGE);
            return false;

        } else if (txtSoLuong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số Lượng trống", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (txtGia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá trống", "", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TabbedPaneSanPham = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbbTimKiemDanhMuc = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbbNhaCungCapLoc = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbbTimKiemTrangThai = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        btnTimKiemSanPham = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JPane123 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbbNhaCungCap = new javax.swing.JComboBox<>();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnChiTietSanPham = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtspct = new javax.swing.JTextField();
        txttspct = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cbbMau = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbDeGiay = new javax.swing.JComboBox<>();
        cbbTrangThaiSPCT = new javax.swing.JComboBox<>();
        btnThemChiTietSanPham = new javax.swing.JButton();
        btnSuaChiTietSanPham = new javax.swing.JButton();
        btnLamMoiChiTietSanPham = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        cbbTenSanPham = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        cbbSanPhamLoc = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        cbbSizeLoc = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cbbMauLoc = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cbbChatLieuLoc = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtMaThuocTinh = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        rdoSize = new javax.swing.JRadioButton();
        rdoNhaCungCap = new javax.swing.JRadioButton();
        rdoMau = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoDeGiay = new javax.swing.JRadioButton();
        rdoDanhMuc = new javax.swing.JRadioButton();
        btnThemThuocTinh = new javax.swing.JButton();
        btnSuaThuocTinh = new javax.swing.JButton();
        btnLamMoiThuocTinh = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1130, 800));

        TabbedPaneSanPham.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPaneSanPham.setPreferredSize(new java.awt.Dimension(1130, 800));
        TabbedPaneSanPham.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 800));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(1083, 122));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Danh mục:");

        cbbTimKiemDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Nike Mercurial", "Nike Phantom", "Nike Tiempo", "Nike Hypervenom" }));
        cbbTimKiemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemDanhMucActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Nhà cung cấp:");

        cbbNhaCungCapLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Nike Hà Nội", "Nike TPHCM", "Nike Đà Nẵng" }));
        cbbNhaCungCapLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhaCungCapLocActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Trạng thái:");

        cbbTimKiemTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn trạng thái", "Đang hoạt động", "Dừng hoạt động" }));
        cbbTimKiemTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemTrangThaiActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Tìm kiếm sản phẩm:");

        txtTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSanPhamActionPerformed(evt);
            }
        });

        btnTimKiemSanPham.setBackground(new java.awt.Color(0, 102, 102));
        btnTimKiemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemSanPham.setText("Tìm Kiếm");
        btnTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(cbbTimKiemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbNhaCungCapLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTimKiemTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(82, 82, 82)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnTimKiemSanPham))
                    .addComponent(jLabel14))
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTimKiemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNhaCungCapLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTimKiemTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemSanPham))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thông tin sản phẩm");

        JPane123.setBackground(new java.awt.Color(255, 255, 255));
        JPane123.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JPane123.setPreferredSize(new java.awt.Dimension(700, 177));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mã Sản Phẩm:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nhà Cung Cấp:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tên Sản Phẩm:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Trạng Thái:");

        cbbNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nike Hà Nội", "Nike TPHCM", "Nike Đà Nẵng" }));

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Dừng hoạt động" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 102, 102));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(80, 23));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnChiTietSanPham.setBackground(new java.awt.Color(0, 102, 102));
        btnChiTietSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietSanPham.setText("Chi Tiết");
        btnChiTietSanPham.setPreferredSize(new java.awt.Dimension(80, 23));
        btnChiTietSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSanPhamActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 102));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(80, 23));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 102));
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setPreferredSize(new java.awt.Dimension(80, 23));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Danh Mục:");

        javax.swing.GroupLayout JPane123Layout = new javax.swing.GroupLayout(JPane123);
        JPane123.setLayout(JPane123Layout);
        JPane123Layout.setHorizontalGroup(
            JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPane123Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSanPham)
                    .addComponent(txtMaSanPham)
                    .addComponent(cbbDanhMuc, 0, 150, Short.MAX_VALUE))
                .addGap(80, 80, 80)
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbTrangThai, 0, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPane123Layout.createSequentialGroup()
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(190, 190, 190))
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        JPane123Layout.setVerticalGroup(
            JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPane123Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPane123Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPane123Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JPane123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 40, Short.MAX_VALUE))))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Lọc sản phẩm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Danh Mục Sản Phẩm", "Nhà Cung Cấp", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPane123, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1083, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPane123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        TabbedPaneSanPham.addTab("Sản Phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Mã sản phẩm chi tiết:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Tên sản phẩm chi tiết:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Số lượng:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Giá:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Màu:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Size:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Chất liệu:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Đế giày:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Trạng thái:");

        jLabel28.setText("VND");

        cbbTrangThaiSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Dừng hoạt động" }));

        btnThemChiTietSanPham.setBackground(new java.awt.Color(0, 102, 102));
        btnThemChiTietSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThemChiTietSanPham.setText("Thêm");
        btnThemChiTietSanPham.setMaximumSize(new java.awt.Dimension(80, 23));
        btnThemChiTietSanPham.setMinimumSize(new java.awt.Dimension(80, 23));
        btnThemChiTietSanPham.setPreferredSize(new java.awt.Dimension(80, 30));
        btnThemChiTietSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTietSanPhamActionPerformed(evt);
            }
        });

        btnSuaChiTietSanPham.setBackground(new java.awt.Color(0, 102, 102));
        btnSuaChiTietSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaChiTietSanPham.setText("Sửa");
        btnSuaChiTietSanPham.setMaximumSize(new java.awt.Dimension(80, 23));
        btnSuaChiTietSanPham.setMinimumSize(new java.awt.Dimension(80, 23));
        btnSuaChiTietSanPham.setPreferredSize(new java.awt.Dimension(80, 30));
        btnSuaChiTietSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaChiTietSanPhamActionPerformed(evt);
            }
        });

        btnLamMoiChiTietSanPham.setBackground(new java.awt.Color(0, 102, 102));
        btnLamMoiChiTietSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiChiTietSanPham.setText("Làm mới");
        btnLamMoiChiTietSanPham.setMaximumSize(new java.awt.Dimension(80, 23));
        btnLamMoiChiTietSanPham.setMinimumSize(new java.awt.Dimension(80, 23));
        btnLamMoiChiTietSanPham.setPreferredSize(new java.awt.Dimension(80, 30));
        btnLamMoiChiTietSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiChiTietSanPhamActionPerformed(evt);
            }
        });

        btnXuatFile.setBackground(new java.awt.Color(0, 102, 102));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.setMaximumSize(new java.awt.Dimension(80, 30));
        btnXuatFile.setMinimumSize(new java.awt.Dimension(80, 30));
        btnXuatFile.setPreferredSize(new java.awt.Dimension(80, 30));
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        cbbTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Tên Sản Phẩm:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel27))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong)
                            .addComponent(txttspct)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbbTenSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtspct, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTrangThaiSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbMau, 0, 217, Short.MAX_VALUE)
                            .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbDeGiay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnThemChiTietSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLamMoiChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txttspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(cbbDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnLamMoiChiTietSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbbTrangThaiSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel28))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Lọc sản phẩm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Thông tin sản phẩm chi tiết");

        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm chi tiết", "Tên sản phẩm chi tiết", "Số lượng", "Giá", "Màu", "Size", "Chất liệu", "Đế giày", "Trạng thái", "Tên Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPhamChiTiet);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Sản phẩm:");

        cbbSanPhamLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSanPhamLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSanPhamLocActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Size:");

        cbbSizeLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSizeLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSizeLocActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Màu:");

        cbbMauLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMauLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauLocActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Chất liệu:");

        cbbChatLieuLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChatLieuLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChatLieuLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(cbbSanPhamLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSizeLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbMauLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(112, 112, 112)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(cbbChatLieuLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSanPhamLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSizeLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMauLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbChatLieuLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        TabbedPaneSanPham.addTab("Chi tiết sản phẩm", jPanel2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Thuộc tính");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Mã thuộc tính:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Tên thuộc tính:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rdoSize);
        rdoSize.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoSize.setText("Size");
        rdoSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSizeMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoNhaCungCap);
        rdoNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNhaCungCap.setSelected(true);
        rdoNhaCungCap.setText("Nhà cung cấp");
        rdoNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNhaCungCapMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoMau);
        rdoMau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoMau.setText("Màu");
        rdoMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMauMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChatLieuMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDeGiay);
        rdoDeGiay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoDeGiay.setText("Đế giày");
        rdoDeGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDeGiayMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDanhMuc);
        rdoDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoDanhMuc.setText("Danh mục");
        rdoDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDanhMucMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoNhaCungCap)
                    .addComponent(rdoMau, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoSize, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNhaCungCap)
                    .addComponent(rdoChatLieu))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMau)
                    .addComponent(rdoDanhMuc))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSize)
                    .addComponent(rdoDeGiay))
                .addGap(38, 38, 38))
        );

        btnThemThuocTinh.setBackground(new java.awt.Color(0, 102, 102));
        btnThemThuocTinh.setForeground(new java.awt.Color(255, 255, 255));
        btnThemThuocTinh.setText("Thêm");
        btnThemThuocTinh.setPreferredSize(new java.awt.Dimension(76, 30));
        btnThemThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocTinhActionPerformed(evt);
            }
        });

        btnSuaThuocTinh.setBackground(new java.awt.Color(0, 102, 102));
        btnSuaThuocTinh.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThuocTinh.setText("Sửa");
        btnSuaThuocTinh.setPreferredSize(new java.awt.Dimension(76, 30));
        btnSuaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuocTinhActionPerformed(evt);
            }
        });

        btnLamMoiThuocTinh.setBackground(new java.awt.Color(0, 102, 102));
        btnLamMoiThuocTinh.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiThuocTinh.setText("Làm mới");
        btnLamMoiThuocTinh.setPreferredSize(new java.awt.Dimension(76, 30));
        btnLamMoiThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiThuocTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLamMoiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSuaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnThemThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSuaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnLamMoiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thuộc tính", "Tên thuộc tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        TabbedPaneSanPham.addTab("Thuộc tính sản phẩm", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TabbedPaneSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TabbedPaneSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int i = tblSanPham.getSelectedRow();
        txtMaSanPham.setText(tblSanPham.getValueAt(i, 0).toString());
        txtTenSanPham.setText(tblSanPham.getValueAt(i, 1).toString());
        cbbDanhMuc.setSelectedItem(tblSanPham.getValueAt(i, 2).toString());
        cbbNhaCungCap.setSelectedItem(tblSanPham.getValueAt(i, 3).toString());
        cbbTrangThai.setSelectedItem(tblSanPham.getValueAt(i, 4).toString());
        txtMaSanPham.setEnabled(false);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        cbbDanhMuc.setSelectedIndex(0);
        cbbNhaCungCap.setSelectedIndex(0);
        cbbTimKiemDanhMuc.setSelectedIndex(0);
        cbbNhaCungCapLoc.setSelectedIndex(0);
        cbbTimKiemTrangThai.setSelectedIndex(0);
        cbbTrangThai.setSelectedIndex(0);
        txtTimKiemSanPham.setText("");
        txtMaSanPham.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int i = tblSanPham.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm nào", "", JOptionPane.WARNING_MESSAGE);
        } else if (readForm() != null) {
            Model_SanPham model = readForm();
            boolean success = ssp.updateSanPham(model.getMasanpham(), model.getTensanpham(),
                    model.getDanhmuc(), model.getNhacungcap(), model.isTrangthai());
            cbbSanPhamLoc.removeAllItems();
            cbbTenSanPham.removeAllItems();
            String chonloctensp = "Tất cả";
            cbbSanPhamLoc.addItem(chonloctensp);
            ArrayList<String> lsttsap = ssp.getTenSanPham();
            for (String tensanpham : lsttsap) {
                cbbSanPhamLoc.addItem(tensanpham);
                cbbTenSanPham.addItem(tensanpham);
            }
            if (success) {
                JOptionPane.showMessageDialog(this, "Sửa thành công!", "", JOptionPane.INFORMATION_MESSAGE);
                this.fillTable(ssp.getAll());
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnChiTietSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSanPhamActionPerformed
        int i = tblSanPham.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tenSP = tblSanPham.getValueAt(i, 1).toString();
        cbbSanPhamLoc.setSelectedItem(tenSP);
        cbbTenSanPham.setSelectedItem(tenSP);
        if (tblSanPhamChiTiet.getRowCount() > 0) {
            tblSanPhamChiTiet.setRowSelectionInterval(0, 0);
            this.showData(tblSanPhamChiTiet.getSelectedRow());
            txtspct.setEnabled(false);
            TabbedPaneSanPham.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm chi tiết", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }//GEN-LAST:event_btnChiTietSanPhamActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (readForm() != null) {
            if (ssp.checkTrungMaSanPham(txtMaSanPham.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Mã này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
            } else if (ssp.checkTrungTenSanPham(txtTenSanPham.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
            } else {
                Model_SanPham model = readForm();
                boolean success = ssp.addSanPham(model.getMasanpham(), model.getTensanpham(),
                        model.getDanhmuc(), model.getNhacungcap(), model.isTrangthai());
                cbbSanPhamLoc.removeAllItems();
                cbbTenSanPham.removeAllItems();
                String chonloctensp = "Tất cả";
                cbbSanPhamLoc.addItem(chonloctensp);
                ArrayList<String> lsttsap = ssp.getTenSanPham();
                for (String tensanpham : lsttsap) {
                    cbbSanPhamLoc.addItem(tensanpham);
//                    cbbTenSanPham.addItem(tensanpham);
                }
                if (success) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTable(ssp.getAll());
                }
            }
        }

        this.themtensanpham();
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed

    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamActionPerformed

        if (txtTimKiemSanPham.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm tìm kiếm", "", JOptionPane.ERROR_MESSAGE);
            txtTimKiemSanPham.requestFocus();
        } else {
            if (ssp.timKiem(txtTimKiemSanPham.getText()).isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy", "", JOptionPane.WARNING_MESSAGE);
            } else {
                fillTable(ssp.timKiem(txtTimKiemSanPham.getText()));
                JOptionPane.showMessageDialog(this, "Tìm thành công", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnTimKiemSanPhamActionPerformed

    private void txtTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamActionPerformed

    }//GEN-LAST:event_txtTimKiemSanPhamActionPerformed

    private void cbbTimKiemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemDanhMucActionPerformed
        this.fillTableLocSanPham();
    }//GEN-LAST:event_cbbTimKiemDanhMucActionPerformed

    private void rdoNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNhaCungCapMouseClicked
        this.fillTableNhaCungCap(sttsp.getAllNhaCungCap());
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_rdoNhaCungCapMouseClicked

    private void rdoChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChatLieuMouseClicked
        this.fillTableChatLieu(sttsp.getAllChatLieu());
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_rdoChatLieuMouseClicked

    private void rdoMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMauMouseClicked
        this.fillTableMau(sttsp.getAllMau());
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_rdoMauMouseClicked

    private void rdoDeGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDeGiayMouseClicked
        this.fillTableDeGiay(sttsp.getAllDeGiay());
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_rdoDeGiayMouseClicked

    private void rdoSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSizeMouseClicked
        this.fillTableSize(sttsp.getAllSize());
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_rdoSizeMouseClicked

    private void btnThemThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocTinhActionPerformed
        if (rdoNhaCungCap.isSelected()) {
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckMaNhaCungCap(txtMaThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
                } else if (sttsp.ckeckTenNhaCungCap(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Nhà cung cấp này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    sttsp.themNhaCungCap(this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableNhaCungCap(sttsp.getAllNhaCungCap());
                    cbbNhaCungCapLoc.removeAllItems();
                    cbbNhaCungCap.removeAllItems();
                    String chonNcc = "Chọn nhà cung cấp";
                    cbbNhaCungCapLoc.addItem(chonNcc);
                    ArrayList<String> listncc = sttsp.getNhaCungCap();
                    for (String ncc : listncc) {
                        cbbNhaCungCap.addItem(ncc);
                        cbbNhaCungCapLoc.addItem(ncc);
                    }
                }
            }
        } else if (rdoChatLieu.isSelected()) {
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckMaChatLieu(txtMaThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
                } else if (sttsp.ckeckTenChatLieu(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Chất liệu này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    sttsp.themChatLieu(this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableChatLieu(sttsp.getAllChatLieu());
                    cbbChatLieuLoc.removeAllItems();
                    cbbChatLieu.removeAllItems();
                    String chonCl = "Chọn chất liệu";
                    cbbChatLieuLoc.addItem(chonCl);
                    ArrayList<String> listcl = sttsp.getChatLieu();
                    for (String cl : listcl) {
                        cbbChatLieu.addItem(cl);
                        cbbChatLieuLoc.addItem(cl);
                    }
                }
            }
        }
        if (rdoMau.isSelected()) {
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckMaMau(txtMaThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
                } else if (sttsp.ckeckTenMau(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Màu này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    sttsp.themMau(this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableMau(sttsp.getAllMau());
                    cbbMauLoc.removeAllItems();
                    cbbMau.removeAllItems();
                    String chonmau = "Chọn màu";
                    cbbMauLoc.addItem(chonmau);
                    ArrayList<String> listmau = sttsp.getMau();
                    for (String mau : listmau) {
                        cbbMau.addItem(mau);
                        cbbMauLoc.addItem(mau);
                    }
                }
            }
        }
        if (rdoDeGiay.isSelected()) {
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckMaDeGiay(txtMaThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
                } else if (sttsp.ckeckTenDeGiay(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Đế giày này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    sttsp.themDeGiay(this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableDeGiay(sttsp.getAllDeGiay());
                    cbbDeGiay.removeAllItems();
                    ArrayList<String> listdg = sttsp.getDeGiay();
                    for (String dg : listdg) {
                        cbbDeGiay.addItem(dg);
                    }
                }
            }
        }
        if (rdoSize.isSelected()) {
            if (readFormThuocTinh() != null) {
                try {
                    Double.parseDouble(txtTenThuocTinh.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Size phải là số!", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (sttsp.ckeckMaSize(txtMaThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
                } else if (sttsp.ckeckTenSize(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Size này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    sttsp.themsize(this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableSize(sttsp.getAllSize());
                    cbbSizeLoc.removeAllItems();
                    cbbSize.removeAllItems();
                    String chonsize = "Chọn size";
                    cbbSizeLoc.addItem(chonsize);
                    ArrayList<String> listsize = sttsp.getSize();
                    for (String size : listsize) {
                        cbbSize.addItem(size);
                        cbbSizeLoc.addItem(size);
                    }
                }
            }
        }
        if (rdoDanhMuc.isSelected()) {
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckMaSize(txtMaThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
                } else if (sttsp.ckeckTenDanhMuc(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Danh mục này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    sttsp.themDanhMuc(this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableDanhMuc(sttsp.getAllDanhMuc());
                    cbbDanhMuc.removeAllItems();
                    cbbTimKiemDanhMuc.removeAllItems();
                    String chondm = "Chọn danh mục";
                    cbbDanhMuc.addItem(chondm);
                    cbbTimKiemDanhMuc.addItem(chondm);
                    ArrayList<String> listdm = sttsp.getDanhMuc();
                    for (String dm : listdm) {
                        cbbDanhMuc.addItem(dm);
                        cbbTimKiemDanhMuc.addItem(dm);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnThemThuocTinhActionPerformed

    private void btnSuaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuocTinhActionPerformed
        int i = tblThuocTinh.getSelectedRow();
        if (rdoNhaCungCap.isSelected()) {
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để sửa!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckTenNhaCungCap(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Nhà cung cấp này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ma = tblThuocTinh.getValueAt(i, 0).toString();
                    sttsp.SuaNCC(ma, this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableNhaCungCap(sttsp.getAllNhaCungCap());
                    cbbNhaCungCapLoc.removeAllItems();
                    cbbNhaCungCap.removeAllItems();
                    String chonNcc = "Chọn nhà cung cấp";
                    cbbNhaCungCapLoc.addItem(chonNcc);
                    ArrayList<String> listncc = sttsp.getNhaCungCap();
                    for (String ncc : listncc) {
                        cbbNhaCungCap.addItem(ncc);
                        cbbNhaCungCapLoc.addItem(ncc);
                    }
                }
            }
        } else if (rdoMau.isSelected()) {
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để sửa!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckTenMau(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Màu này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ma = tblThuocTinh.getValueAt(i, 0).toString();
                    sttsp.SuaMau(ma, this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableMau(sttsp.getAllMau());
                    cbbMauLoc.removeAllItems();
                    cbbMau.removeAllItems();
                    String chonmau = "Chọn màu";
                    cbbMauLoc.addItem(chonmau);
                    ArrayList<String> listmau = sttsp.getMau();
                    for (String mau : listmau) {
                        cbbMau.addItem(mau);
                        cbbMauLoc.addItem(mau);
                    }
                }
            }
        }
        if (rdoChatLieu.isSelected()) {
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để sửa!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckTenChatLieu(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Chất liệu này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ma = tblThuocTinh.getValueAt(i, 0).toString();
                    sttsp.SuaCL(ma, this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableChatLieu(sttsp.getAllChatLieu());
                    cbbChatLieuLoc.removeAllItems();
                    cbbChatLieu.removeAllItems();
                    String chonCl = "Chọn chất liệu";
                    cbbChatLieuLoc.addItem(chonCl);
                    ArrayList<String> listcl = sttsp.getChatLieu();
                    for (String cl : listcl) {
                        cbbChatLieu.addItem(cl);
                        cbbChatLieuLoc.addItem(cl);
                    }
                }
            }
        }
        if (rdoSize.isSelected()) {
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để sửa!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                Double.parseDouble(txtTenThuocTinh.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Size phải là số!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckTenSize(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Size này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ma = tblThuocTinh.getValueAt(i, 0).toString();
                    sttsp.SuaSize(ma, this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableSize(sttsp.getAllSize());
                    cbbSizeLoc.removeAllItems();
                    cbbSize.removeAllItems();
                    String chonsize = "Chọn size";
                    cbbSizeLoc.addItem(chonsize);
                    ArrayList<String> listsize = sttsp.getSize();
                    for (String size : listsize) {
                        cbbSize.addItem(size);
                        cbbSizeLoc.addItem(size);
                    }
                }
            }
        }
        if (rdoDeGiay.isSelected()) {
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để sửa!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckTenDeGiay(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Đế giày này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ma = tblThuocTinh.getValueAt(i, 0).toString();
                    sttsp.SuaDG(ma, this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableDeGiay(sttsp.getAllDeGiay());
                    cbbDeGiay.removeAllItems();
                    ArrayList<String> listdg = sttsp.getDeGiay();
                    for (String dg : listdg) {
                        cbbDeGiay.addItem(dg);
                    }
                }
            }
        }
        if (rdoDanhMuc.isSelected()) {
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng để sửa!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (readFormThuocTinh() != null) {
                if (sttsp.ckeckTenDanhMuc(txtTenThuocTinh.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "Danh mục này đã tồn tại", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ma = tblThuocTinh.getValueAt(i, 0).toString();
                    sttsp.SuaDM(ma, this.readFormThuocTinh());
                    JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                    this.fillTableDanhMuc(sttsp.getAllDanhMuc());
                    cbbDanhMuc.removeAllItems();
                    cbbTimKiemDanhMuc.removeAllItems();
                    String chondm = "Chọn danh mục";
                    cbbDanhMuc.addItem(chondm);
                    cbbTimKiemDanhMuc.addItem(chondm);
                    ArrayList<String> listdm = sttsp.getDanhMuc();
                    for (String dm : listdm) {
                        cbbDanhMuc.addItem(dm);
                        cbbTimKiemDanhMuc.addItem(dm);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaThuocTinhActionPerformed

    private void btnLamMoiThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiThuocTinhActionPerformed
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiThuocTinhActionPerformed

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        int i = tblThuocTinh.getSelectedRow();
        this.txtMaThuocTinh.setText(tblThuocTinh.getValueAt(i, 0).toString());
        this.txtTenThuocTinh.setText(tblThuocTinh.getValueAt(i, 1).toString());
        txtMaThuocTinh.setEnabled(false);
    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void btnThemChiTietSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietSanPhamActionPerformed
        if (checkNull()) {
            if (!qLy.ckeckMaSPCT(txtspct.getText())) { //run
                JOptionPane.showMessageDialog(this, "Mã này đã tồn tại!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                if (checkNumber()) {
                    qLy.them(readFormSanPhamChiTiet(), cbbMau.getSelectedIndex() + 1, cbbSize.getSelectedIndex() + 1, cbbChatLieu.getSelectedIndex() + 1, cbbDeGiay.getSelectedIndex() + 1, cbbTenSanPham.getSelectedIndex() + 1);
                    fillTableSanPhamCHiTiet();
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnThemChiTietSanPhamActionPerformed

    private void btnSuaChiTietSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaChiTietSanPhamActionPerformed
        int i = tblSanPhamChiTiet.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để sửa", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (checkNull()) {

            if (checkNumber()) {
                qLy.sua(readFormSanPhamChiTiet(), cbbMau.getSelectedIndex() + 1, cbbSize.getSelectedIndex() + 1, cbbChatLieu.getSelectedIndex() + 1, cbbDeGiay.getSelectedIndex() + 1, cbbTenSanPham.getSelectedIndex() + 1);
                System.out.println(cbbTenSanPham.getSelectedIndex() + 1);
                fillTableSanPhamCHiTiet();
                JOptionPane.showMessageDialog(this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnSuaChiTietSanPhamActionPerformed

    private void btnLamMoiChiTietSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiChiTietSanPhamActionPerformed
        this.lamMoi();
        txtspct.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiChiTietSanPhamActionPerformed
    ArrayList<Model_SanPhamChiTiet> list = new ArrayList<>();
    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        try {
            XSSFWorkbook fWorkbook = new XSSFWorkbook();
            XSSFSheet fSheet = fWorkbook.createSheet("chitietsanpham");
            XSSFRow row = null;
            Cell cell = null;

            row = fSheet.createRow(3);
            String[] headers = {"Mã sản phẩm chi tiết", "Tên sản phẩm chi tiết", "Số lượng", "Giá", "Màu", "Size", "Chất liệu", "Đế giày", "Trạng thái", "Tên sản phẩm"};
            for (int i = 0; i < headers.length; i++) {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(headers[i]);
            }

            for (int i = 0; i < list.size(); i++) {
                Model_SanPhamChiTiet spct = list.get(i);
                row = fSheet.createRow(4 + i);
                row.createCell(0, CellType.STRING).setCellValue(spct.getMaSanPhamChiTiet());
                row.createCell(1, CellType.STRING).setCellValue(spct.getTenSanPhamChiTiet());
                row.createCell(2, CellType.STRING).setCellValue(String.valueOf(spct.getSoLuong()));
                row.createCell(3, CellType.STRING).setCellValue(String.valueOf(spct.getGia()));
                row.createCell(4, CellType.STRING).setCellValue(spct.getMau());
                row.createCell(5, CellType.STRING).setCellValue(spct.getSize());
                row.createCell(6, CellType.STRING).setCellValue(spct.getChatLieu());
                row.createCell(7, CellType.STRING).setCellValue(spct.getDeGiay());
                row.createCell(8, CellType.STRING).setCellValue(spct.isTrangThai() ? "Đang hoạt động" : "Dừng hoạt động");
                row.createCell(9, CellType.STRING).setCellValue(spct.getTenSanPham());
            }

            File f = new File("D://chitietsanpham.xlsx");
            FileOutputStream fis = new FileOutputStream(f);
            fWorkbook.write(fis);
            fis.close();
            JOptionPane.showMessageDialog(this, "Xuất file thành công", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void cbbSizeLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSizeLocActionPerformed
        this.fillTableSanPhamCHiTiet();
    }//GEN-LAST:event_cbbSizeLocActionPerformed

    private void cbbSanPhamLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSanPhamLocActionPerformed
        this.fillTableSanPhamCHiTiet();
    }//GEN-LAST:event_cbbSanPhamLocActionPerformed

    private void cbbMauLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauLocActionPerformed
        this.fillTableSanPhamCHiTiet();
    }//GEN-LAST:event_cbbMauLocActionPerformed

    private void cbbChatLieuLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChatLieuLocActionPerformed
        this.fillTableSanPhamCHiTiet();
    }//GEN-LAST:event_cbbChatLieuLocActionPerformed

    private void tblSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamChiTietMouseClicked
        this.showData(tblSanPhamChiTiet.getSelectedRow());
        txtspct.setEnabled(false);
    }//GEN-LAST:event_tblSanPhamChiTietMouseClicked

    private void cbbNhaCungCapLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhaCungCapLocActionPerformed
        this.fillTableLocSanPham();
    }//GEN-LAST:event_cbbNhaCungCapLocActionPerformed

    private void cbbTimKiemTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemTrangThaiActionPerformed
        this.fillTableLocSanPham();
    }//GEN-LAST:event_cbbTimKiemTrangThaiActionPerformed

    private void rdoDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDanhMucMouseClicked
        this.fillTableDanhMuc(sttsp.getAllDanhMuc());
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        txtMaThuocTinh.setEnabled(true);
    }//GEN-LAST:event_rdoDanhMucMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPane123;
    private javax.swing.JTabbedPane TabbedPaneSanPham;
    private javax.swing.JButton btnChiTietSanPham;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiChiTietSanPham;
    private javax.swing.JButton btnLamMoiThuocTinh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaChiTietSanPham;
    private javax.swing.JButton btnSuaThuocTinh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemChiTietSanPham;
    private javax.swing.JButton btnThemThuocTinh;
    private javax.swing.JButton btnTimKiemSanPham;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbChatLieuLoc;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbDeGiay;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbMauLoc;
    private javax.swing.JComboBox<String> cbbNhaCungCap;
    private javax.swing.JComboBox<String> cbbNhaCungCapLoc;
    private javax.swing.JComboBox<String> cbbSanPhamLoc;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbSizeLoc;
    private javax.swing.JComboBox<String> cbbTenSanPham;
    private javax.swing.JComboBox<String> cbbTimKiemDanhMuc;
    private javax.swing.JComboBox<String> cbbTimKiemTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThaiSPCT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoDanhMuc;
    private javax.swing.JRadioButton rdoDeGiay;
    private javax.swing.JRadioButton rdoMau;
    private javax.swing.JRadioButton rdoNhaCungCap;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaThuocTinh;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtspct;
    private javax.swing.JTextField txttspct;
    // End of variables declaration//GEN-END:variables

    public void themtensanpham() {
        DefaultComboBoxModel comboBox = (DefaultComboBoxModel) cbbTenSanPham.getModel();
        comboBox.removeAllElements();

        for (String x : ssp.getNameSP()) {
            comboBox.addElement(x);
        }
    }

}
