/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Model_SanPhamChiTiet {

    private String MaSanPhamChiTiet;
    private String TenSanPhamChiTiet;
    private int soLuong;
    private int gia;
    private String mau;
    private String size;
    private String chatLieu;
    private String deGiay;
    private boolean trangThai;

    public Model_SanPhamChiTiet() {
    }

    public Model_SanPhamChiTiet(String MaSanPhamChiTiet, String TenSanPhamChiTiet, int soLuong, int gia, String mau, String size, String chatLieu, String deGiay, boolean trangThai) {
        this.MaSanPhamChiTiet = MaSanPhamChiTiet;
        this.TenSanPhamChiTiet = TenSanPhamChiTiet;
        this.soLuong = soLuong;
        this.gia = gia;
        this.mau = mau;
        this.size = size;
        this.chatLieu = chatLieu;
        this.deGiay = deGiay;
        this.trangThai = trangThai;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{
            getMaSanPhamChiTiet(), getTenSanPhamChiTiet(), getSoLuong(), getGia(),
             getMau(), getSize(), getChatLieu(), getDeGiay(), isTrangThai() ? "Đang hoạt động" : "Dừng hoạt động"};
    }

}
