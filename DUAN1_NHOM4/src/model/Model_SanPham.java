/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhso
 */
public class Model_SanPham {

    private String masanpham;
    private String tensanpham;
    private String danhmuc;
    private String nhacungcap;
    private boolean trangthai;

    public Model_SanPham() {
    }

    public Model_SanPham(String masanpham, String tensanpham, String danhmuc, String nhacungcap, boolean trangthai) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.danhmuc = danhmuc;
        this.nhacungcap = nhacungcap;
        this.trangthai = trangthai;
    }

    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Object[] toRowData() {
        return new Object[]{this.masanpham, this.tensanpham, this.danhmuc, this.nhacungcap, this.trangthai ? "Đang hoạt động" : "Dừng hoạt động"};
    }

}
