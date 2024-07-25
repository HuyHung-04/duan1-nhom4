/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import DBConnect.DBConnect;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KhuyenMai;

/**
 *
 * @author Admin
 */
public class Service_KhuyenMai {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    public ArrayList<KhuyenMai> getAll(){
        ArrayList<KhuyenMai> list = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            String sql = """
                         select magiamgia,phantramgiamgia,ngaybatdau,ngayketthuc,trangthai from giamgia
                                   """;
             
            
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                String ma = rs.getString(1);
                String phantram = rs.getString(2);              
                String ngaybd = rs.getString(3);
                String ngaykt = rs.getString(4);
                boolean trangthai = rs.getBoolean(5);               
                KhuyenMai km = new KhuyenMai(ma,phantram,ngaybd,ngaykt,trangthai);
                list.add(km);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    }
    

