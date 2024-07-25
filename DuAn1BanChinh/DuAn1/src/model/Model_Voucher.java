/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Model_Voucher {
    private int idVoucher;
    private String maVoucher;
    private String tenVoucher;
    private int soLuong;
    private String phanTram;
    private String ngayBatDau;
    private String ngayKetThuc;
    private boolean trangThai;

    public Model_Voucher() {
    }

    public Model_Voucher(String maVoucher, String tenVoucher, int soLuong, String phanTram, String ngayBatDau, String ngayKetThuc, boolean trangThai) {
        this.maVoucher = maVoucher;
        this.tenVoucher = tenVoucher;
        this.soLuong = soLuong;
        this.phanTram = phanTram;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public Model_Voucher(int idVoucher, String maVoucher, String tenVoucher, int soLuong, String phanTram, String ngayBatDau, String ngayKetThuc, boolean trangThai) {
        this.idVoucher = idVoucher;
        this.maVoucher = maVoucher;
        this.tenVoucher = tenVoucher;
        this.soLuong = soLuong;
        this.phanTram = phanTram;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(String phanTram) {
        this.phanTram = phanTram;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public Object[] todataRow(){
        return new Object[]{
            this.idVoucher,this.maVoucher,this.tenVoucher,this.soLuong,this.phanTram,this.ngayBatDau,this.ngayKetThuc,this.trangThai?"Còn hạn":"Hết hạn"
        };
    }
}
