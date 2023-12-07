/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OS
 */
public class Balo {
    
    //Balo QHD thì trọng lượng là số thực
    private String ma;
    private Double trongLuongBalo;
    private List<SanPham> danhSachSanPham;
    private int soThuTu;

    public Balo() {
        danhSachSanPham = new ArrayList<>();
    }

    public Balo(String ma, Double trongLuongBalo, List<SanPham> danhSachSanPham) {
        this.ma = ma;
        this.trongLuongBalo = trongLuongBalo;
        this.danhSachSanPham = danhSachSanPham;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Double getTrongLuongBalo() {
        return trongLuongBalo;
    }

    public void setTrongLuongBalo(Double trongLuongBalo) {
        this.trongLuongBalo = trongLuongBalo;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }
    
    public int getTrongLuongQDH(){
        int integerPart = (int) Math.floor(trongLuongBalo);
        return integerPart;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }
    
    
}
