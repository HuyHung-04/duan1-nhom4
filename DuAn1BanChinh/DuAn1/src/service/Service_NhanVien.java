/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Model_NhanVien;

public class Service_NhanVien {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_NhanVien() {
        con = DBConnect.getConnection();
    }

    public ArrayList<String> getTenNhanVien() {
        sql = "select TenNhanVien from NhanVien where TrangThai = 1";
        ArrayList<String> lstnv = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString(1);
                lstnv.add(ten);
            }
            return lstnv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Model_NhanVien> getAll() {
        sql = "select MaNhanVien,TenNhanVien,TenDangNhap,MatKhau,Email,SoDienThoai,ChucVu,TrangThai from NhanVien";
        ArrayList<Model_NhanVien> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten, tk, mk, email, sdt, cv;
                boolean tt;
                ma = rs.getString(1);
                ten = rs.getString(2);
                tk = rs.getString(3);
                mk = rs.getString(4);
                email = rs.getString(5);
                sdt = rs.getString(6);
                cv = rs.getString(7);
                tt = rs.getBoolean(8);
                Model_NhanVien nv = new Model_NhanVien(ma, ten, tk, mk, email, sdt, cv, tt);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int them(Model_NhanVien nv) {
        sql = "insert into NhanVien(MaNhanVien,TenNhanVien,TenDangNhap,MatKhau,Email,SoDienThoai,ChucVu,TrangThai) values(?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNhanVien());
            ps.setObject(2, nv.getTenNhanVien());
            ps.setObject(3, nv.getTenDangNhap());
            ps.setObject(4, nv.getMatKhau());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getSoDienThoai());
            ps.setObject(7, nv.getChucVu());
            ps.setObject(8, nv.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Model_NhanVien checkMa(String matr) {
        sql = "select MaNhanVien,TenNhanVien,TenDangNhap,MatKhau,Email,SoDienThoai,ChucVu,TrangThai from NhanVien where MaNhanVien = ?";
        Model_NhanVien nv = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten, tk, mk, email, sdt, cv;
                boolean tt;
                ma = rs.getString(1);
                ten = rs.getString(2);
                tk = rs.getString(3);
                mk = rs.getString(4);
                email = rs.getString(5);
                sdt = rs.getString(6);
                cv = rs.getString(7);
                tt = rs.getBoolean(8);
                nv = new Model_NhanVien(ma, ten, tk, mk, email, sdt, cv, tt);
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int Sua(String ma, Model_NhanVien nv) {
        sql = "update NhanVien set TenNhanVien = ?, TenDangNhap = ?, MatKhau = ?, Email = ?, SoDienThoai = ?, ChucVu = ?, TrangThai = ? where MaNhanVien = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getTenNhanVien());
            ps.setObject(2, nv.getTenDangNhap());
            ps.setObject(3, nv.getMatKhau());
            ps.setObject(4, nv.getEmail());
            ps.setObject(5, nv.getSoDienThoai());
            ps.setObject(6, nv.getChucVu());
            ps.setObject(7, nv.isTrangThai());
            ps.setObject(8, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
//    public int Xoa(String ma) {
//        sql = "delete from NhanVien where MaNhanVien = ?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, ma);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
    
    public ArrayList<Model_NhanVien> timKiem(String tennv) {
        sql = "select MaNhanVien,TenNhanVien,TenDangNhap,MatKhau,Email,SoDienThoai,ChucVu,TrangThai from NhanVien where TenNhanVien like ?";
        ArrayList<Model_NhanVien> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%"+ tennv+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten, tk, mk, email, sdt, cv;
                boolean tt;
                ma = rs.getString(1);
                ten = rs.getString(2);
                tk = rs.getString(3);
                mk = rs.getString(4);
                email = rs.getString(5);
                sdt = rs.getString(6);
                cv = rs.getString(7);
                tt = rs.getBoolean(8);
                Model_NhanVien nv = new Model_NhanVien(ma, ten, tk, mk, email, sdt, cv, tt);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
