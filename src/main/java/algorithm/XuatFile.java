/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import dao.SanPhamDao1;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import model.SanPham;

/**
 *
 * @author trand
 */
public class XuatFile {

    public static void exportToTxt(List<SanPham> sanPhamList, List<SanPham> sanPhamListTA, List<SanPham> sanPhamListNC, List<SanPham> sanPhamListQHD, String duongDanVaTenFile, String soLuongSP, String trongLuongBalo) {
        try {
            // Kiểm tra và điều chỉnh đường dẫn nếu cần
            String duongDan = "";
            String tenFileXuat = "";

            if (!duongDanVaTenFile.isEmpty()) {
                File file = new File(duongDanVaTenFile);
                duongDan = file.getParent();
                tenFileXuat = file.getName();
            }

            if (!duongDan.isEmpty() && (duongDan.endsWith("/") || duongDan.endsWith("\\"))) {
                duongDan = duongDan.substring(0, duongDan.length() - 1);
            }

            // Tạo BufferedWriter với đường dẫn đã điều chỉnh
            BufferedWriter bw = new BufferedWriter(new FileWriter(duongDan + File.separator + tenFileXuat)); // Sử dụng File.separator để tạo đường dẫn chéo độc lập
            bw.write("""
                     DỮ LIỆU CHI TIẾT VỀ KẾT QUẢ QUÁ TRÌNH CHẠY CÁC GIẢI THUẬT ĐỂ GIẢI BÀI TOÁN BALO
                                     -------------------------------------------------
                     """);
            bw.newLine();
            // Lấy ngày giờ hiện tại
            Date date = new Date();
            bw.write("Ngày in : " + date);
            bw.write("\n");
            bw.newLine();
            printAll(bw, sanPhamList, soLuongSP);
            bw.write("""
                    2. DANH SÁCH CÁC SẢN PHẨM ĐƯỢC CHỌN
                             """);
            bw.newLine();
            bw.write("Trọng lượng Balo của bạn là : " + trongLuongBalo);
            bw.write("\n");
            bw.newLine();
            bw.newLine();
            printThamAn(bw, sanPhamListTA, soLuongSP);
            printNhanhCan(bw, sanPhamListNC, soLuongSP);
            printQuyHoachDong(bw, sanPhamListQHD, soLuongSP);
            bw.write("""
                                                           HẾT
                     """);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printQuyHoachDong(BufferedWriter bw, List<SanPham> sanPhamList, String soLuongSP) throws IOException {
        bw.write("""
                    ******************************QUY HOẠCH ĐỘNG******************************
                             """);
        bw.newLine();
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        String ma3 = String.format("%-17s", "Mã");
        String ten3 = String.format("%-10s", "Tên");
        String trongLuong3 = String.format("%-15s", "Trọng lượng");
        String giaTri3 = String.format("%-10s", "Giá trị");
        String soLuong3 = String.format("%-10s", "Số lượng");
        String phuongAn3 = String.format("%-10s", "Phương án");

        String line3 = ma3 + ten3 + trongLuong3 + giaTri3 + soLuong3 + phuongAn3;

        bw.write(line3);
        bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        double tongTL = 0;
        double tongGT = 0;
        for (SanPham sanPham : sanPhamList) {
            String ma = String.format("%-17s", sanPham.getMa());
            String ten = String.format("%-10s", sanPham.getTen());
            String trongLuong = String.format("%-15s", sanPham.getTrongLuong());
            String giaTri = String.format("%-10s", sanPham.getGiaTri());
            String soLuong = String.format("%-10s", soLuongSP);
            String phuongAn = String.format("%-10s", sanPham.getPhuongAn());
            String line = ma + ten + trongLuong + giaTri + soLuong + phuongAn;

            tongTL += sanPham.getTrongLuong() * sanPham.getPhuongAn();
            tongGT += sanPham.getGiaTri() * sanPham.getPhuongAn();
            bw.write(line);
            bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        }
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        bw.write("Tổng giá trọng lượng: " + tongTL);
        bw.newLine();
        bw.write("Tổng giá giá trị: " + tongGT);
        bw.newLine();
        bw.write("\n");
        bw.newLine();
    }

    public static void printNhanhCan(BufferedWriter bw, List<SanPham> sanPhamList, String soLuongSP) throws IOException {
        bw.write("""
                    ********************************NHÁNH CẬN********************************
                             """);
        bw.newLine();
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        String ma2 = String.format("%-17s", "Mã");
        String ten2 = String.format("%-10s", "Tên");
        String trongLuong2 = String.format("%-15s", "Trọng lượng");
        String giaTri2 = String.format("%-10s", "Giá trị");
        String soLuong2 = String.format("%-10s", "Số lượng");
        String phuongAn2 = String.format("%-10s", "Phương án");

        String line2 = ma2 + ten2 + trongLuong2 + giaTri2 + soLuong2 + phuongAn2;

        bw.write(line2);
        bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        double tongTL = 0;
        double tongGT = 0;
        for (SanPham sanPham : sanPhamList) {
            String ma = String.format("%-17s", sanPham.getMa());
            String ten = String.format("%-10s", sanPham.getTen());
            String trongLuong = String.format("%-15s", sanPham.getTrongLuong());
            String giaTri = String.format("%-10s", sanPham.getGiaTri());
            String soLuong = String.format("%-10s", soLuongSP);
            String phuongAn = String.format("%-10s", sanPham.getPhuongAn());

            String line = ma + ten + trongLuong + giaTri + soLuong + phuongAn;
            tongTL += sanPham.getTrongLuong() * sanPham.getPhuongAn();
            tongGT += sanPham.getGiaTri() * sanPham.getPhuongAn();
            bw.write(line);
            bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        }
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        bw.write("Tổng giá trọng lượng: " + tongTL);
        bw.newLine();
        bw.write("Tổng giá giá trị: " + tongGT);
        bw.newLine();
        bw.write("\n");
        bw.newLine();
    }

    public static void printThamAn(BufferedWriter bw, List<SanPham> sanPhamList, String soLuongSP) throws IOException {
        bw.write("""
                    ********************************THAM ĂN********************************
                         """);
        bw.newLine();
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        String ma1 = String.format("%-17s", "Mã");
        String ten1 = String.format("%-10s", "Tên");
        String trongLuong1 = String.format("%-15s", "Trọng lượng");
        String giaTri1 = String.format("%-10s", "Giá trị");
        String soLuong1 = String.format("%-10s", "Số lượng");
        String phuongAn1 = String.format("%-10s", "Phương án");

        String line1 = ma1 + ten1 + trongLuong1 + giaTri1 + soLuong1 + phuongAn1;

        bw.write(line1);
        bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        double tongTL = 0;
        double tongGT = 0;
        for (SanPham sanPham : sanPhamList) {
            String ma = String.format("%-17s", sanPham.getMa());
            String ten = String.format("%-10s", sanPham.getTen());
            String trongLuong = String.format("%-15s", sanPham.getTrongLuong());
            String giaTri = String.format("%-10s", sanPham.getGiaTri());
            String soLuong = String.format("%-10s", soLuongSP);
            String phuongAn = String.format("%-10s", sanPham.getPhuongAn());

            String line = ma + ten + trongLuong + giaTri + soLuong + phuongAn;
            tongTL += sanPham.getTrongLuong() * sanPham.getPhuongAn();
            tongGT += sanPham.getGiaTri() * sanPham.getPhuongAn();
            bw.write(line);
            bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        }
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        bw.write("Tổng giá trọng lượng: " + tongTL);
        bw.newLine();
        bw.write("Tổng giá giá trị: " + tongGT);
        bw.newLine();
        bw.write("\n");
        bw.newLine();
    }

    public static void printAll(BufferedWriter bw, List<SanPham> sanPhamList, String soLuongSP) throws IOException {
        bw.write("""
                    1. DANH SÁCH TẤT CẢ CÁC SẢN PHẨM:
                         """);
        bw.newLine();
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        String ma1 = String.format("%-17s", "Mã");
        String ten1 = String.format("%-10s", "Tên");
        String trongLuong1 = String.format("%-15s", "Trọng lượng");
        String giaTri1 = String.format("%-10s", "Giá trị");
        String soLuong1 = String.format("%-10s", "Số lượng");

        String line1 = ma1 + ten1 + trongLuong1 + giaTri1 + soLuong1;

        bw.write(line1);
        bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        for (SanPham sanPham : sanPhamList) {
            String ma = String.format("%-17s", sanPham.getMa());
            String ten = String.format("%-10s", sanPham.getTen());
            String trongLuong = String.format("%-15s", sanPham.getTrongLuong());
            String giaTri = String.format("%-10s", sanPham.getGiaTri());
            String soLuong = String.format("%-10s", soLuongSP);

            String line = ma + ten + trongLuong + giaTri + soLuong;

            bw.write(line);
            bw.newLine(); // Thêm dòng mới sau mỗi sản phẩm
        }
        bw.write("------------------------------------------------------------------------");
        bw.newLine();
        bw.write("\n");
        bw.newLine();
    }
}
