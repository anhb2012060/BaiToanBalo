/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author trand
 */
public class PhuongAnDao3 {
    public static boolean addPhuongAnThamAn(String maSanPham){
        String sql = "INSERT INTO phuongan3 (maSanPham, thamAn, nhanhCan, quyHoachDong) VALUES (?, 0, 0, 0)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSanPham);
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateThamAn(String ma, int phuongAn){
        String sql = "UPDATE phuongan3 SET thamAn = ? WHERE maSanPham = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, phuongAn);
            pstmt.setString(2, ma);
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateNhanhCan(String ma, int phuongAn){
        String sql = "UPDATE phuongan3 SET nhanhCan = ? WHERE maSanPham = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, phuongAn);
            pstmt.setString(2, ma);
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateQuyHoachDong(String ma, int phuongAn){
        String sql = "UPDATE phuongan3 SET quyHoachDong = ? WHERE maSanPham = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, phuongAn);
            pstmt.setString(2, ma);
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static List<SanPham> findThamAn(String ma){
        String sql ="select s.ma, s.ten, s.trongLuong, s.giaTri, thamAn from sanpham3 s inner join phuongan3 p on s.ma = p.maSanPham where p.thamAn<>0 and s.ma like ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs =  pstmt.executeQuery();
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
    
    public static List<SanPham> findNhanhCan(String ma){
        String sql ="select s.ma, s.ten, s.trongLuong, s.giaTri, nhanhCan from sanpham3 s inner join phuongan3 p on s.ma = p.maSanPham where p.nhanhCan<>0 and s.ma like ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs =  pstmt.executeQuery();
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
    
    public static List<SanPham> findQuyHoachDong(String ma){
        String sql ="select s.ma, s.ten, s.trongLuong, s.giaTri, quyHoachDong from sanpham3 s inner join phuongan3 p on s.ma = p.maSanPham where p.quyHoachDong<>0 and s.ma like ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs =  pstmt.executeQuery();
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
}
