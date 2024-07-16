/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dbconnext.DBConnect;
import model.Model_SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        ArrayList lstsp = new ArrayList();
        sql = "select MaSanPham,TenSanPham,DanhMucSanPham,NhaCungCap,TrangThai from V_SanPham";
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
        ArrayList list = new ArrayList();
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
        ArrayList lst = new ArrayList();
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

//    public ArrayList<Model_SanPham> locDanhMuc(String DanhMucTk, String NhaCungCapTK, String TrangThaiTK) {
//        sql = "select MaSanPham,TenSanPham,DanhMucSanPham,NhaCungCap,TrangThai from V_SanPham \n"
//                + "where DanhMucSanPham like ? and NhaCungCap like ? and  TrangThai like ?";
//        ArrayList lsttk = new ArrayList();
//        try{
//            ps = c.prepareStatement(sql);
//            ps.setObject(1,"%" + DanhMucTk + "%");
//            ps.setObject(2,"%" + NhaCungCapTK + "%");
//            ps.setObject(3, TrangThaiTK);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                String masanpham = rs.getString(1);
//                String tensanpham = rs.getString(2);
//                String danhmuc = rs.getString(3);
//                String nhacungcap = rs.getString(4);
//                boolean trangthai = rs.getBoolean(5);
//
//                Model_SanPham model_SanPham = new Model_SanPham(masanpham, tensanpham, danhmuc, nhacungcap, trangthai);
//                lsttk.add(model_SanPham);
//            }
//            return lsttk;
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
    
    
    
}
