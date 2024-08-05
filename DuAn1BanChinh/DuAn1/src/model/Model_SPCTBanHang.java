/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Model_SPCTBanHang {
    private String MaSanPhamChiTiet;
    private String TenSanPhamChiTiet;
    private int soLuong;
    private int gia;
    private String mau;
    private String size;
    private String chatLieu;
    private String deGiay;
    private double phanTramGiamGia;

    public Model_SPCTBanHang() {
    }

    public Model_SPCTBanHang(String MaSanPhamChiTiet, String TenSanPhamChiTiet, int soLuong, int gia, String mau, String size, String chatLieu, String deGiay, double phanTramGiamGia) {
        this.MaSanPhamChiTiet = MaSanPhamChiTiet;
        this.TenSanPhamChiTiet = TenSanPhamChiTiet;
        this.soLuong = soLuong;
        this.gia = gia;
        this.mau = mau;
        this.size = size;
        this.chatLieu = chatLieu;
        this.deGiay = deGiay;
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public String getMaSanPhamChiTiet() {
        return MaSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(String MaSanPhamChiTiet) {
        this.MaSanPhamChiTiet = MaSanPhamChiTiet;
    }

    public String getTenSanPhamChiTiet() {
        return TenSanPhamChiTiet;
    }

    public void setTenSanPhamChiTiet(String TenSanPhamChiTiet) {
        this.TenSanPhamChiTiet = TenSanPhamChiTiet;
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

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(String deGiay) {
        this.deGiay = deGiay;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    
    public Object[] toDataRow() {
        return new Object[]{
            this.MaSanPhamChiTiet,this.TenSanPhamChiTiet,this.soLuong,this.gia,this.mau,this.size,this.chatLieu,this.deGiay,this.phanTramGiamGia
        };
    }
}
