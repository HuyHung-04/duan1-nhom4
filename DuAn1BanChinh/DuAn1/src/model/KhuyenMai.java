/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
    private int id;
    private String MaKhuyenMai;
    private String ptGiamGia;
    private String ngayBD;
    private String ngayKT;
    private boolean trangThai;

    public KhuyenMai(int id, String MaKhuyenMai, String ptGiamGia, String ngayBD, String ngayKT, boolean trangThai) {
        this.id = id;
        this.MaKhuyenMai = MaKhuyenMai;
        this.ptGiamGia = ptGiamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public String getPtGiamGia() {
        return ptGiamGia;
    }

    public void setPtGiamGia(String ptGiamGia) {
        this.ptGiamGia = ptGiamGia;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{
            getMaKhuyenMai(),getPtGiamGia(),getNgayBD(),getNgayKT(), isTrangThai() ? "Còn hạn" : "Hết hạn"};
    }
    
}
