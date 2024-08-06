/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DBConnect.DBConnect;
import model.Model_SanPhamChiTiet;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import model.KhuyenMai;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Service_KhuyenMai {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public ArrayList<KhuyenMai> getAll() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        try {
            conn = DBConnect.getConnection();
            String sql = """
                         select  ID_GiamGia, magiamgia,phantramgiamgia,ngaybatdau,ngayketthuc,trangthai from giamgia
                                   """;

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String phantram = rs.getString(3);
                String ngaybd = rs.getString(4);
                String ngaykt = rs.getString(5);
                boolean trangthai = rs.getBoolean(6);
                Date ngayKetThuc = sdf.parse(ngaykt);
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayKetThuc);
                cal.add(Calendar.DAY_OF_MONTH, 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Date ngayHetHan = cal.getTime();
                if (currentDate.after(ngayHetHan) && trangthai) {
                    updateKhuyenMaiStatus(id, false);
                    trangthai = false;
                }
                KhuyenMai km = new KhuyenMai(id, ma, phantram, ngaybd, ngaykt, trangthai);
                list.add(km);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void updateKhuyenMaiStatus(int id, boolean status) {
        String updateSql = "UPDATE giamgia SET trangthai = ? WHERE ID_GiamGia = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setBoolean(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Model_SanPhamChiTiet> getSanPhamChiTiet(int idGG) {
        ArrayList<Model_SanPhamChiTiet> list = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            String sql = """
                         select ID_SanPhamChiTiet, MaSanPhamChiTiet, TenSanPham, ID_GiamGia from SanPhamChiTiet
                         WHERE TrangThai = 1 AND ID_GiamGia = ? OR ID_GiamGia IS NULL 
                                   """;

            ps = conn.prepareStatement(sql);

            ps.setInt(1, idGG);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Model_SanPhamChiTiet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int themkhuyenmai(KhuyenMai km) {
        try {
            conn = DBConnect.getConnection();
            sql = """
                  insert into GiamGia
                        	(MaGiamGia,PhanTramGiamGia,NgayBatDau,NgayKetThuc,TrangThai)
                        values 
                        	(?, ?, ?, ?, ?)""";

            ps = conn.prepareStatement(sql);

            ps.setString(1, km.getMaKhuyenMai());
            ps.setString(2, km.getPtGiamGia());
            ps.setString(3, km.getNgayBD());
            ps.setString(4, km.getNgayKT());
            ps.setBoolean(5, km.isTrangThai());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua(KhuyenMai km) {
        try {
            conn = DBConnect.getConnection();
            sql = """
                  update GiamGia
                        	set MaGiamGia = ?,PhanTramGiamGia=?,NgayBatDau=?,NgayKetThuc=?,TrangThai=?
                  where id_giamgia =?
                       """;

            ps = conn.prepareStatement(sql);

            ps.setString(1, km.getMaKhuyenMai());
            ps.setString(2, km.getPtGiamGia());
            ps.setString(3, km.getNgayBD());
            ps.setString(4, km.getNgayKT());
            ps.setBoolean(5, km.isTrangThai());
            ps.setInt(6, km.getId());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int chonKhuyenMai(int idGiamGia, int idSpct) {
        try {
            conn = DBConnect.getConnection();
            sql = """
                  update SanPhamChiTiet set ID_GiamGia = ? where ID_SanPhamChiTiet = ?
                       """;

            ps = conn.prepareStatement(sql);

            ps.setInt(1, idGiamGia);
            ps.setInt(2, idSpct);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int boChonKhuyenMai(int idSpct) {
        try {
            conn = DBConnect.getConnection();
            sql = """
                  update SanPhamChiTiet set ID_GiamGia = null where ID_SanPhamChiTiet = ?
                       """;

            ps = conn.prepareStatement(sql);

            ps.setInt(1, idSpct);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Model_SanPhamChiTiet getSanPhamChiTietModel(int idGG, int idSpct) {
        try {

            for (Model_SanPhamChiTiet x : getSanPhamChiTiet(idGG)) {
                if (x.getId() == idSpct) {

                    return x;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private int getIdFromName(String tableName, String nameColumn, String idColumn, String name) {
        String sql = "SELECT " + idColumn + " FROM " + tableName + " WHERE " + nameColumn + " = ?";
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
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

    public void dungKhuyenMai(String maGiamGia) {
        int idGiamGia = getIdFromName("GiamGia", "MaGiamGia", "ID_GiamGia", maGiamGia);
        sql = "update SanPhamChiTiet set ID_GiamGia = null where ID_GiamGia = ?";
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idGiamGia);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KhuyenMai getById(int id) {
        String sql = "SELECT ID_KhuyenMai, MaKhuyenMai, PhanTramGiamGia, NgayBatDau, NgayKetThuc, TrangThai FROM KhuyenMai WHERE ID_KhuyenMai = ?";
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idKhuyenMai = rs.getInt(1);
                String maKhuyenMai = rs.getString(2);
                String phanTramGiamGia = rs.getString(3);
                String ngayBatDau = rs.getString(4);
                String ngayKetThuc = rs.getString(5);
                boolean trangThai = rs.getBoolean(6);

                return new KhuyenMai(idKhuyenMai, maKhuyenMai, phanTramGiamGia, ngayBatDau, ngayKetThuc, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhuyenMai checkDate(String maCheck) {
        KhuyenMai mkm = null;
        try {
            conn = DBConnect.getConnection();
            String sql = """
                         select  ID_GiamGia, magiamgia,phantramgiamgia,ngaybatdau,ngayketthuc,trangthai from giamgia where MaGiamGia = ? and TrangThai=0 
                                   """;

            ps = conn.prepareStatement(sql);
            ps.setString(1, maCheck);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String phantram = rs.getString(3);
                String ngaybd = rs.getString(4);
                String ngaykt = rs.getString(5);
                boolean trangthai = rs.getBoolean(6);
                KhuyenMai km = new KhuyenMai(id, ma, phantram, ngaybd, ngaykt, trangthai);
                mkm = km;
            }
            return mkm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
