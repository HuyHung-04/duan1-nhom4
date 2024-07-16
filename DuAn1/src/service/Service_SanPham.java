package service;

import DBConnect.DBConnect;
import model.Model_SanPham;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service_SanPham {

    private Connection c = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_SanPham() {
        c = DBConnect.getConnection();
    }

    public ArrayList<Model_SanPham> getAll() {
        ArrayList<Model_SanPham> lstsp = new ArrayList<>();
        sql = "select MaSanPham, TenSanPham, DanhMucSanPham, NhaCungCap, TrangThai from V_SanPham";
        try {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString(1);
                String tensanpham = rs.getString(2);
                String danhmuc = rs.getString(3);
                String nhacungcap = rs.getString(4);
                boolean trangthai = rs.getBoolean(5);

                Model_SanPham model_SanPham = new Model_SanPham(masanpham, tensanpham, danhmuc, nhacungcap, trangthai);
                lstsp.add(model_SanPham);
            }
            return lstsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getDanhMuc() {
        sql = "select TenDanhMuc from DanhMucSanPham";
        ArrayList<String> list = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tendanhmuc = rs.getString(1);
                list.add(tendanhmuc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getNhaCungCap() {
        sql = "select TenNhaCungCap from NhaCungCap";
        ArrayList<String> lst = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tennhacungcap = rs.getString(1);
                lst.add(tennhacungcap);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getIdFromName(String tableName, String nameColumn, String idColumn, String name) {
        sql = "SELECT " + idColumn + " FROM " + tableName + " WHERE " + nameColumn + " = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(idColumn);
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy " + nameColumn + " với tên: " + name);
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean addSanPham(String maSanPham, String tenSanPham, String tenDanhMucSanPham, String tenNhaCungCap, boolean trangThai) {
        int idDanhMucSanPham = getIdFromName("DanhMucSanPham", "TenDanhMuc", "ID_DanhMuc", tenDanhMucSanPham);
        int idNhaCungCap = getIdFromName("NhaCungCap", "TenNhaCungCap", "ID_NhaCungCap", tenNhaCungCap);

        if (idDanhMucSanPham == -1 || idNhaCungCap == -1) {
            return false;  // Không tìm thấy ID danh mục hoặc nhà cung cấp
        }

        sql = "INSERT INTO SanPham (MaSanPham, TenSanPham, ID_DanhMucSanPham, ID_NhaCungCap, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, maSanPham);
            ps.setString(2, tenSanPham);
            ps.setInt(3, idDanhMucSanPham);
            ps.setInt(4, idNhaCungCap);
            ps.setBoolean(5, trangThai);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSanPham(String maSanPham, String tenSanPham, String tenDanhMucSanPham, String tenNhaCungCap, boolean trangThai) {
        int idDanhMucSanPham = getIdFromName("DanhMucSanPham", "TenDanhMuc", "ID_DanhMuc", tenDanhMucSanPham);
        int idNhaCungCap = getIdFromName("NhaCungCap", "TenNhaCungCap", "ID_NhaCungCap", tenNhaCungCap);

        if (idDanhMucSanPham == -1 || idNhaCungCap == -1) {
            return false;  // Không tìm thấy ID danh mục hoặc nhà cung cấp
        }

        sql = "UPDATE SanPham SET TenSanPham = ?, ID_DanhMucSanPham = ?, ID_NhaCungCap = ?, TrangThai = ? WHERE MaSanPham = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, tenSanPham);
            ps.setInt(2, idDanhMucSanPham);
            ps.setInt(3, idNhaCungCap);
            ps.setBoolean(4, trangThai);
            ps.setString(5, maSanPham);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public Model_SanPham checkTrungMaSanPham(String maForm) {
        
        sql = "select MaSanPham, TenSanPham, DanhMucSanPham, NhaCungCap, TrangThai from V_SanPham where MaSanPham = ?";
        Model_SanPham msp = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setObject(1, maForm);
            rs = ps.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString(1);
                String tensanpham = rs.getString(2);
                String danhmuc = rs.getString(3);
                String nhacungcap = rs.getString(4);
                boolean trangthai = rs.getBoolean(5);

                Model_SanPham model_SanPham = new Model_SanPham(masanpham, tensanpham, danhmuc, nhacungcap, trangthai);
                msp = model_SanPham;
            }
            return msp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    
    public ArrayList<Model_SanPham> timKiem(String tenSP) {
        ArrayList lstsp = new ArrayList<>();
        sql = "select MaSanPham, TenSanPham, DanhMucSanPham, NhaCungCap, TrangThai from V_SanPham where TenSanPham like ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setObject(1, "%"+tenSP+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String masanpham = rs.getString(1);
                String tensanpham = rs.getString(2);
                String danhmuc = rs.getString(3);
                String nhacungcap = rs.getString(4);
                boolean trangthai = rs.getBoolean(5);

                Model_SanPham model_SanPham = new Model_SanPham(masanpham, tensanpham, danhmuc, nhacungcap, trangthai);
                lstsp.add(model_SanPham);
            }
            return lstsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
