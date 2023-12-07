/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Balo;
import model.Balo;
import model.SanPham;
import model.SanPham;

/**
 *
 * @author OS
 */
public class OpenFile {
    public static Balo docTepBalo1(String tenFile, String maBalo) throws IOException {
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            //Tạo đối tượng Balo
            Balo balo = new Balo();
            
            List<SanPham> sanpham = new ArrayList<>();
            //Đọc các dòng còn lại.
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                SanPham sp = new SanPham();
                String[] data = line.split(",");
                if (data.length != 0) {
                    sp.setMa(maBalo+"_");
                    sp.setTrongLuong(Double.parseDouble(data[0].trim()));
                    sp.setGiaTri(Double.parseDouble(data[1].trim()));
                    sp.setTen(data[2].trim());
                    sp.setSoLuong(Integer.MAX_VALUE);
                    sp.setDonGia(Double.parseDouble(data[1].trim())/Double.parseDouble(data[0].trim()));
                }
                sanpham.add(sp);
            }
            balo.setDanhSachSanPham(sanpham);
            return balo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Balo docTepBalo2(String tenFile, String maBalo) throws IOException {
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            Balo balo = new Balo();
            
            List<SanPham> sanpham = new ArrayList<>();
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                SanPham sp = new SanPham();
                String[] data = line.split(",");
                if (data.length != 0) {
                    sp.setMa(maBalo+"_");
                    sp.setTrongLuong(Double.parseDouble(data[0].trim()));
                    sp.setGiaTri(Double.parseDouble(data[1].trim()));
                    sp.setSoLuong(Integer.parseInt(data[2].trim()));
                    sp.setTen(data[3].trim());
                    sp.setDonGia(Double.parseDouble(data[1].trim())/Double.parseDouble(data[0].trim()));
                }
                sanpham.add(sp);
            }
            balo.setDanhSachSanPham(sanpham);
            return balo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Balo docTepBalo3(String tenFile, String maBalo) throws IOException {
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            //Tạo đối tượng Balo
            Balo balo = new Balo();
            
            List<SanPham> sanpham = new ArrayList<>();
            //Đọc các dòng còn lại.
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                SanPham sp = new SanPham();
                String[] data = line.split(",");
                if (data.length != 0) {
                    sp.setMa(maBalo+"_");
                    sp.setTrongLuong(Double.parseDouble(data[0].trim()));
                    sp.setGiaTri(Double.parseDouble(data[1].trim()));
                    sp.setTen(data[2].trim());
                    sp.setSoLuong(Integer.MAX_VALUE);
                    sp.setDonGia(Double.parseDouble(data[1].trim())/Double.parseDouble(data[0].trim()));
                }
                sanpham.add(sp);
            }
            balo.setDanhSachSanPham(sanpham);
            return balo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        
    // Hàm swap để hoán đổi vị trí 2 phần tử trong danh sách
    public static void swap(List<SanPham> sanPhams, int i, int j) {
        SanPham temp = sanPhams.get(i);
        sanPhams.set(i, sanPhams.get(j));
        sanPhams.set(j, temp);
    }
    
    public static void Bubble_Sort(Balo balo) {
        int i, j;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        for (i = 0; i <= n - 2; i++) {
            for (j = n - 1; j >= i + 1; j--) {
                if (sanPhams.get(j).getDonGia() > sanPhams.get(j - 1).getDonGia()) {
                    swap(sanPhams, j, j - 1);
                }
            }
        }
    }
}
