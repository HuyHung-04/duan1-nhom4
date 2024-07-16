/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Model_ThuocTinhSanPham;
import dbconnext.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Service_ThuocTinhSanPham {

    private static Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_ThuocTinhSanPham() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Model_ThuocTinhSanPham> getAllNhaCungCap() {
        sql = "select MaNhaCungCap,TenNhaCungCap from NhaCungCap";
        ArrayList<Model_ThuocTinhSanPham> listtt = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                Model_ThuocTinhSanPham ttsp = new Model_ThuocTinhSanPham(ma, ten);
                listtt.add(ttsp);
            }
            return listtt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Model_ThuocTinhSanPham> getAllChatLieu() {
        sql = "select MaChatLieu,TenChatLieu from ChatLieu";
        ArrayList<Model_ThuocTinhSanPham> listtt = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                Model_ThuocTinhSanPham ttsp = new Model_ThuocTinhSanPham(ma, ten);
                listtt.add(ttsp);
            }
            return listtt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Model_ThuocTinhSanPham> getAllMau() {
        sql = "select MaMau,TenMau from Mau";
        ArrayList<Model_ThuocTinhSanPham> listtt = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                Model_ThuocTinhSanPham ttsp = new Model_ThuocTinhSanPham(ma, ten);
                listtt.add(ttsp);
            }
            return listtt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Model_ThuocTinhSanPham> getAllDeGiay() {
        sql = "select MaDeGiay,TenDeGiay from DeGiay";
        ArrayList<Model_ThuocTinhSanPham> listtt = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                Model_ThuocTinhSanPham ttsp = new Model_ThuocTinhSanPham(ma, ten);
                listtt.add(ttsp);
            }
            return listtt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Model_ThuocTinhSanPham> getAllSize() {
        sql = "select MaSize,TenSize from Size";
        ArrayList<Model_ThuocTinhSanPham> listtt = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                Model_ThuocTinhSanPham ttsp = new Model_ThuocTinhSanPham(ma, ten);
                listtt.add(ttsp);
            }
            return listtt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int themNhaCungCap(Model_ThuocTinhSanPham ttsp) {
        sql = "insert into NhaCungCap(MaNhaCungCap,TenNhaCungCap) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttsp.getMaThuocTinh());
            ps.setObject(2, ttsp.getTenThuocTinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int themChatLieu(Model_ThuocTinhSanPham ttsp) {
        sql = "insert into ChatLieu(MaChatLieu,TenChatLieu) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttsp.getMaThuocTinh());
            ps.setObject(2, ttsp.getTenThuocTinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int themMau(Model_ThuocTinhSanPham ttsp) {
        sql = "insert into Mau(MaMau,TenMau) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttsp.getMaThuocTinh());
            ps.setObject(2, ttsp.getTenThuocTinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int themDeGiay(Model_ThuocTinhSanPham ttsp) {
        sql = "insert into DeGiay(MaDeGiay,TenDeGiay) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttsp.getMaThuocTinh());
            ps.setObject(2, ttsp.getTenThuocTinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int themsize(Model_ThuocTinhSanPham ttsp) {
        sql = "insert into Size(MaSize,TenSize) values(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttsp.getMaThuocTinh());
            ps.setObject(2, ttsp.getTenThuocTinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Model_ThuocTinhSanPham ckeckMaNhaCungCap(String matr) {
        sql = "select MaNhaCungCap,TenNhaCungCap from NhaCungCap where MaNhaCungCap = ?";
        Model_ThuocTinhSanPham ttsp = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                ttsp = new Model_ThuocTinhSanPham(ma, ten);
            }
            return ttsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Model_ThuocTinhSanPham ckeckMaChatLieu(String matr) {
        sql = "select MaChatLieu,TenChatLieu from ChatLieu where MaChatLieu = ?";
        Model_ThuocTinhSanPham ttsp = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                ttsp = new Model_ThuocTinhSanPham(ma, ten);
            }
            return ttsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Model_ThuocTinhSanPham ckeckMaMau(String matr) {
        sql = "select MaMau,TenMau from Mau where MaMau = ?";
        Model_ThuocTinhSanPham ttsp = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                ttsp = new Model_ThuocTinhSanPham(ma, ten);
            }
            return ttsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Model_ThuocTinhSanPham ckeckMaDeGiay(String matr) {
        sql = "select MaDeGiay,TenDeGiay from DeGiay where MaDeGiay = ?";
        Model_ThuocTinhSanPham ttsp = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                ttsp = new Model_ThuocTinhSanPham(ma, ten);
            }
            return ttsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Model_ThuocTinhSanPham ckeckMaSize(String matr) {
        sql = "select MaSize,TenSize from Size where MaSize = ?";
        Model_ThuocTinhSanPham ttsp = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, matr);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma, ten;
                ma = rs.getString(1);
                ten = rs.getString(2);
                ttsp = new Model_ThuocTinhSanPham(ma, ten);
            }
            return ttsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> getMau() {
        sql = "select TenMau from Mau";
        ArrayList list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String temmau = rs.getString(1);
                list.add(temmau);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> getSize() {
        sql = "select TenSize from Size";
        ArrayList list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tensize = rs.getString(1);
                list.add(tensize);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> getChatLieu() {
        sql = "select TenChatLieu from ChatLieu";
        ArrayList list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tencl = rs.getString(1);
                list.add(tencl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> getDeGiay() {
        sql = "select TenDeGiay from DeGiay";
        ArrayList list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String dg = rs.getString(1);
                list.add(dg);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> getNhaCungCap() {
        sql = "select TenNhaCungCap from NhaCungCap";
        ArrayList list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ncc = rs.getString(1);
                list.add(ncc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int SuaNCC(String mancc, Model_ThuocTinhSanPham ttspnew){
        sql = "update NhaCungCap set TenNhaCungCap = ? where MaNhaCungCap = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttspnew.getTenThuocTinh());
            ps.setObject(2, mancc);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int SuaMau(String mamau, Model_ThuocTinhSanPham ttspnew){
        sql = "update Mau set TenMau = ? where MaMau = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttspnew.getTenThuocTinh());
            ps.setObject(2, mamau);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int SuaCL(String macl, Model_ThuocTinhSanPham ttspnew){
        sql = "update ChatLieu set TenChatLieu = ? where MaChatLieu = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttspnew.getTenThuocTinh());
            ps.setObject(2, macl);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int SuaSize(String masize, Model_ThuocTinhSanPham ttspnew){
        sql = "update Size set TenSize = ? where MaSize = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttspnew.getTenThuocTinh());
            ps.setObject(2, masize);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int SuaDG(String madg, Model_ThuocTinhSanPham ttspnew){
        sql = "update DeGiay set TenDeGiay = ? where MaDeGiay = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, ttspnew.getTenThuocTinh());
            ps.setObject(2, madg);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
