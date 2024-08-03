/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Model_HoaDonChiTiet;

public class Service_HoaDonChiTiet {

    private Connection c = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_HoaDonChiTiet() {
        c = DBConnect.getConnection();
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
//                JOptionPane.showMessageDialog(null, "Không tìm thấy " + nameColumn + " với tên: " + name);
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<Model_HoaDonChiTiet> getHDCTFromHD(String maHoaDon) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        sql = "select MaSanPhamChiTiet,TenSanPham,cthd.Gia,cthd.SoLuong from ChiTietHoaDon cthd\n"
                + "join HoaDon hd on hd.ID_HoaDon = cthd.ID_HoaDon\n"
                + "join SanPhamChiTiet spct on spct.ID_SanPhamChiTiet = cthd.ID_SanPhamChiTiet\n"
                + "where cthd.ID_HoaDon = ?";
        ArrayList<Model_HoaDonChiTiet> listhdct = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSanPhamChiTiet = rs.getString(1);
                String tenSanPham = rs.getString(2);
                double gia = rs.getDouble(3);
                int soLuong = rs.getInt(4);

                Model_HoaDonChiTiet mhdct = new Model_HoaDonChiTiet(maSanPhamChiTiet, tenSanPham, soLuong, gia);
                listhdct.add(mhdct);
            }
            return listhdct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean addHoaDonChiTiet(String maHoaDon, String maSanPhamChiTiet, int soLuong, double gia) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        int idSanPhamChiTiet = getIdFromName("SanPhamChiTiet", "MaSanPhamChiTiet", "ID_SanPhamChiTiet", maSanPhamChiTiet);

        if (idHoaDon == -1 || idSanPhamChiTiet == -1) {
            return false;
        }
        sql = "INSERT INTO ChiTietHoaDon (ID_HoaDon, ID_SanPhamChiTiet, SoLuong, Gia)"
                + "VALUES (?, ?, ?, ?)";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.setInt(2, idSanPhamChiTiet);
            ps.setInt(3, soLuong);
            ps.setDouble(4, gia);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateSoLuong(String maSanPhamChiTiet,String maHoaDon, int soLuong) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        int idSanPhamChiTiet = getIdFromName("SanPhamChiTiet", "MaSanPhamChiTiet", "ID_SanPhamChiTiet", maSanPhamChiTiet);
        String sql = "update ChiTietHoaDon set SoLuong = ? where ID_SanPhamChiTiet = ? and ID_HoaDon=?";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, idSanPhamChiTiet);
            ps.setInt(3, idHoaDon);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteHoaDonChiTiet(String maHoaDon,String maSanPhamChiTiet) {
        int idSanPhamChiTiet = getIdFromName("SanPhamChiTiet", "MaSanPhamChiTiet", "ID_SanPhamChiTiet", maSanPhamChiTiet);
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        String sql = "DELETE FROM ChiTietHoaDon where ID_HoaDon = ? and ID_SanPhamChiTiet = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.setInt(2, idSanPhamChiTiet);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAllHoaDonChiTiet(String maHoaDon) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        String sql = "DELETE FROM ChiTietHoaDon where ID_HoaDon = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void upateTongTien(String maSanPhamChiTiet,String maHoaDon,double tongTien){
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        int idSanPhamChiTiet = getIdFromName("SanPhamChiTiet", "MaSanPhamChiTiet", "ID_SanPhamChiTiet", maSanPhamChiTiet);
        String sql = "update ChiTietHoaDon set Gia = ? where ID_SanPhamChiTiet = ? and ID_HoaDon = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setDouble(1, tongTien);
            ps.setInt(2, idSanPhamChiTiet);
            ps.setInt(3, idHoaDon);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
