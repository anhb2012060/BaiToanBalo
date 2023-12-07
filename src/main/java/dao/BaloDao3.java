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
import model.Balo;

/**
 *
 * @author OS
 */
public class BaloDao3 {
    public static boolean insertBalo (Balo balo){
        String sql = "insert into balo3(ma,trongLuongBalo) values (?,null)";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, balo.getMa());
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateBalo(double trongLuongBalo, String maBalo){
        String sql = "update balo3 set trongLuongBalo = ? where ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, trongLuongBalo);
            pstmt.setString(2, maBalo);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateSttBalo(String ma, int stt){
        String sql = "update balo3 set soThuTu = ? where ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, stt);
            pstmt.setString(2, ma);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    
    public static Balo findById(String maBalo){
        String sql = "select trongLuongBalo,soThuTu from balo3 where ma = ?";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maBalo);
            ResultSet rs = pstmt.executeQuery();
            Balo balo = new Balo();
            while(rs.next()){
                balo.setTrongLuongBalo(rs.getDouble(1));
                balo.setSoThuTu(rs.getInt(2));
                return balo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> findAllIdBalo(){
        String sql = "select ma from balo3";
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<String> list = new ArrayList<>();
            while(rs.next()){
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
