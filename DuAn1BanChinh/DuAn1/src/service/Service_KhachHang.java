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
import model.Model_KhachHang;

public class Service_KhachHang {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_KhachHang() {
        con = DBConnect.getConnection();
    }
    
    public ArrayList<Model_KhachHang> getAll(){
        ArrayList<Model_KhachHang> listkh = new ArrayList<>();
        sql = "select MaKhachHang,TenKhachHang,SoDienThoai,DiaChi,TrangThai from KhachHang";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                String ma,ten,sdt,dc;
                boolean tt;
                ma = rs.getString(1);
                ten = rs.getString(2);
                sdt = rs.getString(3);
                dc = rs.getString(4);
                tt = rs.getBoolean(5);
                Model_KhachHang kh = new Model_KhachHang(ma, ten, sdt, dc, tt);
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int them(Model_KhachHang kh){
        sql = "insert into KhachHang(MaKhachHang,TenKhachHang,SoDienThoai,DiaChi,TrangThai) values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMaKhachHang());
            ps.setObject(2, kh.getTenKhachHang());
            ps.setObject(3, kh.getSoDienThoai());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Model_KhachHang checkMa(String matr){
        Model_KhachHang kh = null;
        sql = "select MaKhachHang,TenKhachHang,SoDienThoai,DiaChi,TrangThai from KhachHang where MaKhachHang = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {                
                String ma,ten,sdt,dc;
                boolean tt;
                ma = rs.getString(1);
                ten = rs.getString(2);
                sdt = rs.getString(3);
                dc = rs.getString(4);
                tt = rs.getBoolean(5);
                kh = new Model_KhachHang(ma, ten, sdt, dc, tt);
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int Sua(String ma, Model_KhachHang kh){
        sql = "update KhachHang set TenKhachHang = ?, SoDienThoai = ?, DiaChi = ?, TrangThai = ? where MaKhachHang = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getTenKhachHang());
            ps.setObject(2, kh.getSoDienThoai());
            ps.setObject(3, kh.getDiaChi());
            ps.setObject(4, kh.isTrangThai());
            ps.setObject(5, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public ArrayList<Model_KhachHang> timKiem(String sdttim) {
        sql = "select MaKhachHang,TenKhachHang,SoDienThoai,DiaChi,TrangThai from KhachHang where SoDienThoai like ?";
        ArrayList<Model_KhachHang> listkh = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%"+ sdttim+"%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                String ma,ten,sdt,dc;
                boolean tt;
                ma = rs.getString(1);
                ten = rs.getString(2);
                sdt = rs.getString(3);
                dc = rs.getString(4);
                tt = rs.getBoolean(5);
                Model_KhachHang kh = new Model_KhachHang(ma, ten, sdt, dc, tt);
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMaKhachHang(String tenKhachHang) {
        sql = "select MaKhachHang from KhachHang where TenKhachHang = ?";
        String ma =null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tenKhachHang);
            rs = ps.executeQuery();
            while (rs.next()) {
                 ma = rs.getString(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ma;
    }

    public ArrayList<String> getTenKhachHang() {
        sql = "select TenKhachHang from KhachHang where TrangThai = 1";
        ArrayList<String> lstkh = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString(1);
                lstkh.add(ten);
            }
            return lstkh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Model_KhachHang> getKhachHangDangHoatDong(){
        ArrayList<Model_KhachHang> listkh = new ArrayList<>();
        sql = "select MaKhachHang,TenKhachHang,SoDienThoai,DiaChi from KhachHang where TrangThai = 1";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                String ma,ten,sdt,dc;
                ma = rs.getString(1);
                ten = rs.getString(2);
                sdt = rs.getString(3);
                dc = rs.getString(4);
                Model_KhachHang model_KhachHang = new Model_KhachHang(ma, ten, sdt, dc);
                listkh.add(model_KhachHang);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
