/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author anhso
 */
public class Model_HoaDon {
    private String ma;
    private Date ngayTao;
    private String nhanVien;
    private String khachHang;
    private Double tongTien;
    private Boolean trangThai;

    public Model_HoaDon() {
    }

    public Model_HoaDon(String nhanVien, String khachHang) {
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
    }

    public Model_HoaDon(String ma, Date ngayTao, String nhanVien, String khachHang, Double tongTien, Boolean trangThai) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
        
}
