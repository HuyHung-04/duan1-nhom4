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
    private int tongTienTruocVch;
    private int tongTienSauVch;
    private String tenVoucher;
    private String ngayTao;
    private int trangThai;
    private String tenNhanVien;
    private String tenKhachHang;

    public Model_HoaDon02() {
    }

    public Model_HoaDon02(UUID ma, int tongTienTruocVch, int tongTienSauVch, String tenVoucher, String ngayTao, int trangThai, String tenNhanVien, String tenKhachHang) {
        this.ma = ma;
        this.tongTienTruocVch = tongTienTruocVch;
        this.tongTienSauVch = tongTienSauVch;
        this.tenVoucher = tenVoucher;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
    }

    public UUID getMa() {
        return ma;
    }

    public void setMa(UUID ma) {
        this.ma = ma;
    }

    public int getTongTienTruocVch() {
        return tongTienTruocVch;
    }

    public void setTongTienTruocVch(int tongTienTruocVch) {
        this.tongTienTruocVch = tongTienTruocVch;
    }

    public int getTongTienSauVch() {
        return tongTienSauVch;
    }

    public void setTongTienSauVch(int tongTienSauVch) {
        this.tongTienSauVch = tongTienSauVch;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
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

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Object[] toDataRow() {
        return new Object[]{getMa(),getTongTienTruocVch(),getTongTienSauVch(), getTenVoucher(), getNgayTao(), getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán", getTenNhanVien(), getTenKhachHang()};
    }
}
