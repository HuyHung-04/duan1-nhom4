/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;
import model.Model_HoaDon;
import model.Model_HoaDon02;
import model.Model_HoaDonChiTiet02;

public class Service_HoaDon {

    private Connection c = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Service_HoaDon() {
        c = DBConnect.getConnection();
    }

    public ArrayList<Model_HoaDon> getAllBanHang() {
        sql = "select MaHoaDon,NgayTao,TenNhanVien,TenKhachHang,TongTien,hd.TrangThai as TrangThai from HoaDon hd\n"
                + "inner join KhachHang kh on kh.ID_KhachHang=hd.ID_KhachHang\n"
                + "inner join NhanVien nv on nv.ID_NhanVien=hd.ID_NhanVien where hd.TrangThai = 0";
        ArrayList<Model_HoaDon> lsthd = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                Date ngayTao = rs.getDate(2);
                String nhanVien = rs.getString(3);
                String khachHang = rs.getString(4);
                Double tongTien = rs.getDouble(5);
                Boolean trangThai = rs.getBoolean(6);
                lsthd.add(new Model_HoaDon(ma, ngayTao, nhanVien, khachHang, tongTien, trangThai));
            }
            return lsthd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getIdFromName(String tableName, String nameColumn, String idColumn, String name) {
        String sql = "SELECT " + idColumn + " FROM " + tableName + " WHERE " + nameColumn + " = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(idColumn);
            } else {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy " + nameColumn + " với tên: " + name);
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean addHoaDonCho(String tenKhachHang, String tenNhanVien) {
        int idKhachHang = getIdFromName("KhachHang", "TenKhachHang", "ID_KhachHang", tenKhachHang);
        int idNhanVien = getIdFromName("NhanVien", "TenNhanVien", "ID_NhanVien", tenNhanVien);

        if (idKhachHang == -1 || idNhanVien == -1) {
            return false;
        }

        String sql = "INSERT INTO HoaDon (NgayTao, ID_NhanVien, ID_KhachHang, TongTien, TrangThai) "
                + "VALUES (GETDATE(), ?, ?, 0, 0)";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idNhanVien);
            ps.setInt(2, idKhachHang);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHoaDonThanhToan(String maHoaDon, double tongTien) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);

        if (idHoaDon == -1) {
            return false; // Không tìm thấy ID danh mục hoặc nhà cung cấp
        }

        sql = "UPDATE HoaDon SET TongTien = ?,TrangThai = 1 WHERE ID_HoaDon = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setDouble(1, tongTien);
            ps.setInt(2, idHoaDon);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHoaDonCho(String maHoaDon, double tongTien) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);

        if (idHoaDon == -1) {
            return false; // Không tìm thấy ID danh mục hoặc nhà cung cấp
        }

        sql = "UPDATE HoaDon SET TongTien = ?,TrangThai = 0 WHERE ID_HoaDon = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setDouble(1, tongTien);
            ps.setInt(2, idHoaDon);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//   hoa don
    public ArrayList<Model_HoaDon02> getAllBanHang(String id, int ngay, int thang) {
        ArrayList<Model_HoaDon02> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("""
              SELECT hd.MaHoaDon, hd.TongTien, hd.NgayTao, hd.TrangThai, nv.MaNhanVien, nv.TenNhanVien, kh.MaKhachHang, kh.TenKhachHang FROM HoaDon hd
              LEFT JOIN NhanVien nv ON hd.ID_NhanVien = nv.ID_NhanVien
              LEFT JOIN KhachHang kh ON hd.ID_KhachHang = kh.ID_KhachHang
              LEFT JOIN Voucher v ON hd.ID_Voucher = v.ID_Voucher
              WHERE 1 = 1 AND hd.TrangThai = 1""");
        if (id != null) {
            sql.append(" AND hd.ID_HoaDon LIKE '%").append(id).append("%'");
        }
        if (ngay != 0) {
            sql.append(" AND DAY(hd.NgayTao) = ").append(ngay);
        }
        if (thang != 0) {
            sql.append(" AND MONTH(hd.NgayTao) = ").append(thang);
        }
        try {
            ps = c.prepareStatement(sql.toString());

            rs = ps.executeQuery();
            while (rs.next()) {
                UUID maHoaDon = UUID.fromString(rs.getString(1));
                list.add(new Model_HoaDon02(maHoaDon, rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Model_HoaDon02> getIdHoaDon() {
        ArrayList<Model_HoaDon02> list = new ArrayList<>();
        String sql = """
              SELECT hd.MaHoaDon, hd.TongTien, hd.NgayTao, hd.TrangThai, nv.MaNhanVien, nv.TenNhanVien, kh.MaKhachHang, kh.TenKhachHang FROM HoaDon hd
              LEFT JOIN NhanVien nv ON hd.ID_NhanVien = nv.ID_NhanVien
              LEFT JOIN KhachHang kh ON hd.ID_KhachHang = kh.ID_KhachHang
              LEFT JOIN Voucher v ON hd.ID_Voucher = v.ID_Voucher""";
        try {
            ps = c.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                UUID maHoaDon = UUID.fromString(rs.getString(1));
                list.add(new Model_HoaDon02(maHoaDon, rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Model_HoaDonChiTiet02> getHoaDonChiTietById(UUID idHd) {
        ArrayList<Model_HoaDonChiTiet02> list = new ArrayList<>();
        sql = """
              SELECT cthd.ID_ChiTietHoaDon, spct.MaSanPhamChiTiet, spct.TenSanPham, cthd.SoLuong, spct.Gia, cthd.SoLuong * spct.Gia FROM ChiTietHoaDon cthd 
              LEFT JOIN SanPhamChiTiet spct ON cthd.ID_SanPhamChiTiet = spct.ID_SanPhamChiTiet
              LEFT JOIN HoaDon hd ON cthd.ID_HoaDon = hd.ID_HoaDon
              WHERE hd.MaHoaDon = ?
              """;

        try {
            ps = c.prepareStatement(sql);

            ps.setString(1, idHd.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Model_HoaDonChiTiet02(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteHoaDonCho(String maHoaDon) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);

        sql = "exec DeleteHoaDonBanHang ?";
        if (idHoaDon == -1) {
            return 0;
        }

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int checkVoucher(String maHoaDon) {
        sql = "select ID_Voucher from HoaDon where MaHoaDon = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, maHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public void addVoucher(String maHoaDon, String tenVoucher) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        int idVoucher = getIdFromName("Voucher", "TenVoucher", "ID_Voucher", tenVoucher);
        sql = "update HoaDon\n"
                + "set ID_Voucher  = ?\n"
                + "where ID_HoaDon = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idVoucher);
            ps.setInt(2, idHoaDon);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTongTienByHoaDon(String maHoaDon) {
        int idHoaDon = getIdFromName("HoaDon", "MaHoaDon", "ID_HoaDon", maHoaDon);
        sql = "select TongTien from HoaDon where ID_HoaDon=?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getVoucherByIDHoaDon(String maHoaDon) {
        int idVoucher = getIdFromName("HoaDon", "MaHoaDon", "ID_Voucher", maHoaDon);
        sql = "select PhanTramGiamGia from Voucher where ID_Voucher = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idVoucher);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTenVoucherByIDHoaDon(String maHoaDon) {
        int idVoucher = getIdFromName("HoaDon", "MaHoaDon", "ID_Voucher", maHoaDon);
        sql = "select TenVoucher from Voucher where ID_Voucher = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idVoucher);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSoLuongVoucherByIDHoaDon(String maHoaDon) {
        int idVoucher = getIdFromName("HoaDon", "MaHoaDon", "ID_Voucher", maHoaDon);
        sql = "select SoLuong from Voucher where ID_Voucher = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, idVoucher);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVoucherSoLuongByMaHoaDon(String maHoaDon, int newSoLuong) {
        int idVoucher = getIdFromName("HoaDon", "MaHoaDon", "ID_Voucher", maHoaDon);
        String sql = "UPDATE Voucher SET SoLuong = ? WHERE ID_Voucher = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, newSoLuong);
            ps.setInt(2, idVoucher);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
