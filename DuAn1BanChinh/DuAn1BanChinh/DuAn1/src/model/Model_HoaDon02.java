/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author lcinu
 */
public class Model_HoaDon02 {
    private UUID ma;
    private int tongTien;
    private String ngayTao;
    private int trangThai;
    private String maNhanVien;
    private String tenNhanVien;
    private String maKhachHang;
    private String tenKhachHang;

    public Model_HoaDon02() {
    }

    public Model_HoaDon02(UUID ma, int tongTien, String ngayTao, int trangThai, String maNhanVien, String tenNhanVien, String maKhachHang, String tenKhachHang) {
        this.ma = ma;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
    }

    public UUID getMa() {
        return ma;
    }

    public void setMa(UUID ma) {
        this.ma = ma;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    public Object[] toDataRow() {
        return new Object[] {getMa(), getTongTien(), getNgayTao(), getTrangThai() == 1 ? "Đã thanh toán":"Chưa thanh toán", getMaNhanVien(), getTenNhanVien(), getMaKhachHang(), getTenKhachHang()};
    }
}
