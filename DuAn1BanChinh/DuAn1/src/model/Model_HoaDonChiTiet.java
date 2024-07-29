/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhso
 */
public class Model_HoaDonChiTiet {
    private String ma;
    private String ten;
    private int soLuong;
    private Double gia;

    public Model_HoaDonChiTiet(String ma, String ten, int soLuong, Double gia) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public Model_HoaDonChiTiet() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }
    
    public Object[] toDatarow(){
        return new Object[]{
            this.ma,this.ten,this.gia,this.soLuong
        };
    }
}
