/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DBConnect.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import model.Model_Voucher;

/**
 *
 * @author ADMIN
 */
public class Service_Voucher {

    private static Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_Voucher() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Model_Voucher> getAll() {
        sql = "select ID_Voucher,MaVoucher,TenVoucher,SoLuong,PhanTramGiamGia,NgayBatDau,NgayKetThuc,TrangThai from Voucher";
        ArrayList<Model_Voucher> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id, sl;
                String ma, ten, phantram, ngaybatdau, ngayketthuc;
                boolean tt;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                sl = rs.getInt(4);
                phantram = rs.getString(5);
                ngaybatdau = rs.getString(6);
                ngayketthuc = rs.getString(7);
                tt = rs.getBoolean(8);
                Model_Voucher vc = new Model_Voucher(id, ma, ten, sl, phantram, ngaybatdau, ngayketthuc, tt);
                list.add(vc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int Them(Model_Voucher vc) {
        sql = "insert into Voucher(MaVoucher,TenVoucher,SoLuong,PhanTramGiamGia,NgayBatDau,NgayKetThuc,TrangThai) values(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, vc.getMaVoucher());
            ps.setObject(2, vc.getTenVoucher());
            ps.setObject(3, vc.getSoLuong());
            ps.setObject(4, vc.getPhanTram());
            ps.setObject(5, vc.getNgayBatDau());
            ps.setObject(6, vc.getNgayKetThuc());
            ps.setObject(7, vc.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Model_Voucher checkMa(String matr) {
        sql = "select ID_Voucher,MaVoucher,TenVoucher,SoLuong,PhanTramGiamGia,NgayBatDau,NgayKetThuc,TrangThai from Voucher where MaVoucher = ?";
        Model_Voucher vc = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id, sl;
                String ma, ten, phantram, ngaybatdau, ngayketthuc;
                boolean tt;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                sl = rs.getInt(4);
                phantram = rs.getString(5);
                ngaybatdau = rs.getString(6);
                ngayketthuc = rs.getString(7);
                tt = rs.getBoolean(8);
                vc = new Model_Voucher(id, ma, ten, sl, phantram, ngaybatdau, ngayketthuc, tt);
            }
            return vc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int Xoa(int id) {
        sql = "delete from Voucher where ID_Voucher = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Sua(int id, Model_Voucher vcnew) {
        sql = "update Voucher set MaVoucher = ?, TenVoucher = ?, SoLuong = ?, PhanTramGiamGia = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ? where ID_Voucher = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, vcnew.getMaVoucher());
            ps.setObject(2, vcnew.getTenVoucher());
            ps.setObject(3, vcnew.getSoLuong());
            ps.setObject(4, vcnew.getPhanTram());
            ps.setObject(5, vcnew.getNgayBatDau());
            ps.setObject(6, vcnew.getNgayKetThuc());
            ps.setObject(7, vcnew.isTrangThai());
            ps.setObject(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public ArrayList<Model_Voucher> timKiem(String tenTim) {
        sql = "select ID_Voucher,MaVoucher,TenVoucher,SoLuong,PhanTramGiamGia,NgayBatDau,NgayKetThuc,TrangThai from Voucher where TenVoucher like ?";
        ArrayList<Model_Voucher> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%"+ tenTim +"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id, sl;
                String ma, ten, phantram, ngaybatdau, ngayketthuc;
                boolean tt;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                sl = rs.getInt(4);
                phantram = rs.getString(5);
                ngaybatdau = rs.getString(6);
                ngayketthuc = rs.getString(7);
                tt = rs.getBoolean(8);
                Model_Voucher vc = new Model_Voucher(id, ma, ten, sl, phantram, ngaybatdau, ngayketthuc, tt);
                list.add(vc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
