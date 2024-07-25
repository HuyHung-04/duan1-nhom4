/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.Model_SanPhamChiTiet;
import DBConnect.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Service_SanPhamChiTiet {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
            
    public ArrayList<Model_SanPhamChiTiet> getAll(int sizeCbo , int mauCbo,int chatLieuCbo,int sanPhamCbo ) {
        ArrayList<Model_SanPhamChiTiet> list = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            StringBuilder sql = new StringBuilder("""
                  select 
                  	 spct.MaSanPhamChiTiet, spct.TenSanPham, spct.SoLuong, spct.Gia,
                  	m.TenMau, s.TenSize, c.TenChatLieu, d.TenDeGiay,
                  	spct.TrangThai,sp.TenSanPham, spct.ID_SanPhamChiTiet
                  from SanPhamChiTiet spct
                  left join SanPham sp on spct.ID_SanPham = sp.ID_SanPham
                  left join Mau M ON spct.ID_Mau = M.ID_Mau
                  left join Size S on spct.ID_Size = S.ID_Size
                  left join ChatLieu C  on spct.ID_ChatLieu = c.ID_ChatLieu
                  left join DeGiay D  on spct.ID_DeGiay = D.ID_DeGiay
                    where 1 = 1""");
             if (sanPhamCbo != 0) {
                sql.append(" and spct.id_sanpham = ").append(sanPhamCbo);
            }
            if (mauCbo != 0) {
                sql.append(" and spct.id_mau = ").append(mauCbo);
            }
            if (sizeCbo != 0) {
                sql.append( " and spct.id_size = ").append(sizeCbo);
            }
            if (chatLieuCbo !=0 ){
                sql.append(" and spct.id_chatlieu =").append(chatLieuCbo);
            }
            
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            
            while (rs.next()) {      
                int id = rs.getInt(11);
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                int soLuong = rs.getInt(3);
                int gia = rs.getInt(4);
                String mau = rs.getString(5);
                String size = rs.getString(6);
                String chatlieu= rs.getString(7);
                String degiay = rs.getString(8);
                boolean trangthai = rs.getBoolean(9);
                String tensanpham = rs.getString(10);
                Model_SanPhamChiTiet sptc = new Model_SanPhamChiTiet(id, ma, ten, soLuong, gia, mau, size, chatlieu, degiay, trangthai,tensanpham);
                list.add(sptc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int them(Model_SanPhamChiTiet spct, int mau, int size, int chatLieu, int deGiay, int sanPham) {
        try {
            conn = DBConnect.getConnection();
            sql = """
                  insert into SanPhamChiTiet
                        	(MaSanPhamChiTiet,TenSanPham,SoLuong,Gia,ID_Mau,ID_Size,ID_ChatLieu,ID_DeGiay,TrangThai,ID_SanPham)
                        values 
                        	(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
                  
            ps = conn.prepareStatement(sql);
            
            
            
            ps.setString(1, spct.getMaSanPhamChiTiet());
            ps.setString(2, spct.getTenSanPhamChiTiet());
            ps.setInt(3, spct.getSoLuong());
            ps.setInt(4, spct.getGia());
            ps.setInt(5, mau);
            ps.setInt(6, size);
            ps.setInt(7, chatLieu);
            ps.setInt(8, deGiay);          
            ps.setBoolean(9, spct.isTrangThai());
            ps.setInt(10, sanPham);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int sua(Model_SanPhamChiTiet spct, int mau, int size, int chatLieu, int deGiay, int sanPham) {
        try {
            conn = DBConnect.getConnection();
            sql = """
                  update SanPhamChiTiet
                        	set TenSanPham = ?,SoLuong=?,Gia=?,ID_Mau=?,ID_Size=?,ID_ChatLieu=?,ID_DeGiay=?,TrangThai=?,ID_SanPham=?
                  where ID_SanPhamChiTiet = ?
                       """;
                  
            ps = conn.prepareStatement(sql);
            
            
            
            ps.setString(1, spct.getTenSanPhamChiTiet());
            ps.setInt(2, spct.getSoLuong());
            ps.setInt(3, spct.getGia());
            ps.setInt(4, mau);
            ps.setInt(5, size);
            ps.setInt(6, chatLieu);
            ps.setInt(7, deGiay);          
            ps.setBoolean(8, spct.isTrangThai());
            ps.setInt(9, sanPham);
            ps.setInt(10, spct.getId());
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean ckeckMaSPCT(String matr) {
        sql = """
                  select *
                  from SanPhamChiTiet 
                    where MaSanPhamChiTiet = ?"""; 
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
    
}
