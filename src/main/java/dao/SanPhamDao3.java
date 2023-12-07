/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.xdevapi.Result;
import database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author OS
 */
public class SanPhamDao3 {
    public static boolean insertSanPham(SanPham sanPham, String maBalo){
        String sql = "insert into sanpham3(ma,ten,trongLuong,giaTri,donGia,phuongAn,maBalo) values (?,?,?,?,?,null,?)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sanPham.getMa());
            pstmt.setString(2, sanPham.getTen());
            pstmt.setDouble(3, sanPham.getTrongLuong());
            pstmt.setDouble(4, sanPham.getGiaTri());
            pstmt.setDouble(5, sanPham.getGiaTri()/sanPham.getTrongLuong());
            pstmt.setString(6, maBalo);
            PhuongAnDao3.addPhuongAnThamAn(sanPham.getMa());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static SanPham findById(String maSanPham){
        String sql = "select ma,ten,trongLuong,giaTri from sanpham3 where ma = ?";
        try {
            Connection con  = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSanPham);
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setTrongLuong(rs.getDouble(3));
                sp.setGiaTri(rs.getDouble(4));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean searchByID(String maBalo){
        String sql = "select ma from balo3 where ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maBalo);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<SanPham> findAll(){
        String sql = "select ma,ten,trongLuong,giaTri,phuongAn from sanpham3";
        try {
            Connection con  = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs  = pstmt.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setTrongLuong(rs.getDouble(3));
                sp.setGiaTri(rs.getDouble(4));
                sp.setPhuongAn(rs.getInt(5));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<SanPham> findByIdBalo(String maBalo){
        String sql = "select ma,ten,trongLuong,giaTri,donGia,phuongAn from sanpham3 where maBalo = ? ORDER BY CAST(SUBSTRING_INDEX(ma, '_', -1) AS SIGNED) ASC";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maBalo);
            ResultSet rs  = pstmt.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setTrongLuong(rs.getDouble(3));
                sp.setGiaTri(rs.getDouble(4));
                sp.setDonGia(rs.getDouble(5));
                sp.setPhuongAn(rs.getInt(6));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean deleteById(String maSanPham){
        String sql = "delete from sanpham3 where ma = ? ";
        try {
            Connection con  = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSanPham);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean UpdateSanPham(SanPham sp){
        String sql = "UPDATE sanpham3  SET ten = ?, trongLuong = ?, giaTri = ?, phuongAn = ? WHERE ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getTrongLuong());
            pstmt.setDouble(3, sp.getGiaTri());
            pstmt.setInt(4, sp.getPhuongAn());
            pstmt.setString(5, sp.getMa());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean UpdateSanPham1(SanPham sp){
        String sql = "UPDATE sanpham3  SET ten = ?, trongLuong = ?, giaTri = ?, donGia = ? WHERE ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getTrongLuong());
            pstmt.setDouble(3, sp.getGiaTri());
            pstmt.setDouble(4, sp.getGiaTri()/sp.getTrongLuong());
            pstmt.setString(5, sp.getMa());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<SanPham> LocSanPham(String maBalo){
        String sql = "select ma,ten,trongLuong,giaTri,phuongAn from sanpham3 where maBalo = ? and phuongAn<>0 ORDER BY CAST(SUBSTRING_INDEX(ma, '_', -1) AS SIGNED) ASC";
        try {
            Connection con  = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maBalo);
            ResultSet rs  = pstmt.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setTrongLuong(rs.getDouble(3));
                sp.setGiaTri(rs.getDouble(4));
                sp.setPhuongAn(rs.getInt(5));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean findSanPhamByID(String ma){
        String sql = "select * from sanpham3 where ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
