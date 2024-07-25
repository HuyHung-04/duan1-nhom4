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
    private String MaKhuyenMai;
    private String TenKhuyenMai;
    private String ptGiamGia;
    private String ngayBD;
    private String ngayKT;
    private boolean trangThai;

    public KhuyenMai(String ma, String phantram, String ngaybd, String ngaykt, boolean trangthai) {
    }

    public KhuyenMai(String MaKhuyenMai, String TenKhuyenMai, String ptGiamGia, String ngayBD, String ngayKT, boolean trangThai) {
        this.MaKhuyenMai = MaKhuyenMai;
        this.TenKhuyenMai = TenKhuyenMai;
        this.ptGiamGia = ptGiamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String TenKhuyenMai) {
        this.TenKhuyenMai = TenKhuyenMai;
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
            getMaKhuyenMai(),getTenKhuyenMai(),getPtGiamGia(),getNgayBD(),getNgayKT(), isTrangThai() ? "Đang hoạt động" : "Dừng hoạt động"};
    }
    
}
