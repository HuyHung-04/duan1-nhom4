/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Date;
import DBConnect.DBConnect;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
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
        String sql = "SELECT ID_Voucher, MaVoucher, TenVoucher, SoLuong, PhanTramGiamGia, NgayBatDau, NgayKetThuc, TrangThai FROM Voucher";
        ArrayList<Model_Voucher> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();

            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                int sl = rs.getInt(4);
                String phantram = rs.getString(5);
                String ngaybatdau = rs.getString(6);
                String ngayketthuc = rs.getString(7);
                boolean tt = rs.getBoolean(8);

                Date ngayKetThuc = sdf.parse(ngayketthuc);

                // Tính toán mốc thời gian 00:00 ngày hôm sau ngày kết thúc
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayKetThuc);
                cal.add(Calendar.DAY_OF_MONTH, 1); // Thêm 1 ngày
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Date ngayHetHan = cal.getTime();

                if (currentDate.after(ngayHetHan) && tt) {
                    // Nếu mốc thời gian đã qua và trạng thái chưa hết hạn
                    tt = false;
                    // Cập nhật trạng thái trong cơ sở dữ liệu
                    updateVoucherStatus(id, tt);
                }

                Model_Voucher vc = new Model_Voucher(id, ma, ten, sl, phantram, ngaybatdau, ngayketthuc, tt);
                list.add(vc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVoucherStatus(int id, boolean status) {
        String updateSql = "UPDATE Voucher SET TrangThai = ? WHERE ID_Voucher = ?";
        try {
            PreparedStatement updatePs = con.prepareStatement(updateSql);
            updatePs.setBoolean(1, status);
            updatePs.setInt(2, id);
            updatePs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            ps.setObject(1, "%" + tenTim + "%");
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

    public String getVoucherByTen(String tenVoucher) {
        sql = "select PhanTramGiamGia from Voucher where TenVoucher = ?";
        String PhanTramGiamGia = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tenVoucher);
            rs = ps.executeQuery();
            while (rs.next()) {
                PhanTramGiamGia = rs.getString("PhanTramGiamGia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PhanTramGiamGia;
    }

    public ArrayList<String> getTenVoucher() {
        sql = "select TenVoucher from Voucher where TrangThai = 1";
        ArrayList<String> lstvc = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString(1);
                lstvc.add(ten);
            }
            return lstvc;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
    // hùng làm update số lượng
    public int getSoLuongVoucher(String ten) {
        sql = "select SoLuong from Voucher where TenVoucher = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                int soLuong = rs.getInt(1);
                return soLuong;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
    
     public void updateVoucherSoLuong(String tenVoucher, int newSoLuong) {
        String sql = "UPDATE Voucher SET SoLuong = ? WHERE TenVoucher = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, newSoLuong);
            ps.setString(2, tenVoucher);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public ArrayList<String> phucHoiSoLuongVch(String maHoaDon) {
    ArrayList<String> phucHoi = new ArrayList<>();
    String sql = """
                 SELECT vc.MaVoucher 
                 FROM HoaDon hd
                 INNER JOIN Voucher vc ON vc.ID_Voucher = hd.ID_Voucher 
                 WHERE hd.MaHoaDon = ?
                 """;
    try {
        ps = con.prepareStatement(sql);
        ps.setObject(1, UUID.fromString(maHoaDon));
        rs = ps.executeQuery();
        while (rs.next()) {
            String maVoucher = rs.getString("MaVoucher");
            phucHoi.add(maVoucher);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return phucHoi;
}



}
