/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lcinu
 */
public class Model_HoaDonChiTiet02 {
    private int id;
    private String maSp;
    private String tenSp;
    private int soLuong;
    private int gia;
    private int thanhTien;

    public Model_HoaDonChiTiet02() {
    }

    public Model_HoaDonChiTiet02(int id, String maSp, String tenSp, int soLuong, int gia, int thanhTien) {
        this.id = id;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public Object[] toDataRow() {
        return new Object[] {getId(), getMaSp(), getTenSp(), getSoLuong(), getGia(), getSoLuong() * getGia()};
    }
}
