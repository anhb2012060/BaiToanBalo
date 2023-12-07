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
public class SanPhamDao2 {
    public static boolean insertSanPham(SanPham sanPham, String maBalo){
        String sql = "insert into sanpham2(ma,ten,trongLuong,giaTri,donGia,soLuong,phuongAn,maBalo) values (?,?,?,?,?,?,null,?)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sanPham.getMa());
            pstmt.setString(2, sanPham.getTen());
            pstmt.setDouble(3, sanPham.getTrongLuong());
            pstmt.setDouble(4, sanPham.getGiaTri());
            pstmt.setDouble(5, sanPham.getGiaTri()/sanPham.getTrongLuong());
            pstmt.setInt(6, sanPham.getSoLuong());
            pstmt.setString(7, maBalo);
            PhuongAnDao2.addPhuongAnThamAn(sanPham.getMa());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static SanPham findById(String maSanPham){
        String sql = "select ma,ten,trongLuong,giaTri,soLuong from sanpham2 where ma = ?";
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
                sp.setSoLuong(rs.getInt(5));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean searchByID(String maBalo){
        String sql = "select ma from balo2 where ma = ?";
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
        String sql = "select ma,ten,trongLuong,giaTri,soLuong,phuongAn from sanpham2";
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
                sp.setSoLuong(rs.getInt(5));
                sp.setPhuongAn(rs.getInt(6));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<SanPham> findByIdBalo(String maBalo){
        String sql = "select ma,ten,trongLuong,giaTri,donGia,soLuong,phuongAn from sanpham2 where maBalo = ? ORDER BY CAST(SUBSTRING_INDEX(ma, '_', -1) AS SIGNED) ASC";
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
                sp.setSoLuong(rs.getInt(6));
                sp.setPhuongAn(rs.getInt(7));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean deleteById(String maSanPham){
        String sql = "delete from sanpham2 where ma = ? ";
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
        String sql = "UPDATE sanpham2  SET ten = ?, trongLuong = ?, giaTri = ?, phuongAn = ?, soLuong = ? WHERE ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getTrongLuong());
            pstmt.setDouble(3, sp.getGiaTri());
            pstmt.setInt(4, sp.getPhuongAn());
            pstmt.setInt(5, sp.getSoLuong());
            pstmt.setString(6, sp.getMa());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean UpdateSanPham1(SanPham sp){
        String sql = "UPDATE sanpham2  SET ten = ?, trongLuong = ?, giaTri = ? , soLuong = ?, donGia = ? WHERE ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sp.getTen());
            pstmt.setDouble(2, sp.getTrongLuong());
            pstmt.setDouble(3, sp.getGiaTri());
            pstmt.setInt(4, sp.getSoLuong());
            pstmt.setDouble(5, sp.getGiaTri()/sp.getTrongLuong());
            pstmt.setString(6, sp.getMa());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<SanPham> LocSanPham(String maBalo){
        String sql = "select ma,ten,trongLuong,giaTri,soLuong,phuongAn from sanpham2 where maBalo = ? and phuongAn<>0 ORDER BY CAST(SUBSTRING_INDEX(ma, '_', -1) AS SIGNED) ASC";
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
                sp.setSoLuong(rs.getInt(5));
                sp.setPhuongAn(rs.getInt(6));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean findSanPhamByID(String ma){
        String sql = "select * from sanpham2 where ma = ?";
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
