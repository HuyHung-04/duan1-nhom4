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

public class Service_KhachHang {

    private Connection c = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_KhachHang() {
        c = DBConnect.getConnection();
    }

    public String getMaKhachHang(String tenKhachHang) {
        sql = "select MaKhachHang from KhachHang where TenKhachHang = ?";
        String ma =null;
        try {
            ps = c.prepareStatement(sql);
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
        sql = "select TenKhachHang from KhachHang";
        ArrayList<String> lstkh = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
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
}
