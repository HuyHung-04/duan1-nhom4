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

public class Service_NhanVien {

    private Connection c = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private String sql = null;

    public Service_NhanVien() {
        c = DBConnect.getConnection();
    }

    public ArrayList<String> getTenNhanVien() {
        sql = "select TenNhanVien from NhanVien";
        ArrayList<String> lstnv = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
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
}
