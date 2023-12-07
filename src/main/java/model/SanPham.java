/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author OS
 */
public class SanPham {
    private String ma;
    private String ten;
    private double trongLuong;
    private double giaTri;
    private double donGia;
    private int soLuong;
    private int phuongAn;
    

    public SanPham() {
    }

    public SanPham(String ma, String ten, double trongLuong, double giaTri, double donGia, int soLuong, int phuongAn) {
        this.ma = ma;
        this.ten = ten;
        this.trongLuong = trongLuong;
        this.giaTri = giaTri;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.phuongAn = phuongAn;
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

    public double getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(double trongLuong) {
        this.trongLuong = trongLuong;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getPhuongAn() {
        return phuongAn;
    }

    public void setPhuongAn(int phuongAn) {
        this.phuongAn = phuongAn;
    }

    
}
