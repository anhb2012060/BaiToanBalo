/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import model.SanPham;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Balo;

public class QuyHoachDong {
    
    public static void TaoBang1(Balo balo, int[][] F, int[][] X) {
        int xk, yk, k;
        int FMax, XMax, V;
        List<SanPham> sanPham = balo.getDanhSachSanPham();
        int n = sanPham.size();
        int W = balo.getTrongLuongQDH();

        for (V = 0; V <= W; V++) {
            X[0][V] = V / (int)sanPham.get(0).getTrongLuong();
            F[0][V] = X[0][V] *(int) sanPham.get(0).getGiaTri();
        }

        for (k = 1; k < n; k++) {
            for (V = 0; V <= W; V++) {
                FMax = F[k - 1][V];
                XMax = 0;
                yk = V / (int)sanPham.get(k).getTrongLuong();

                for (xk = 1; xk <= yk; xk++) {
                    if (F[k - 1][(V - xk * (int)sanPham.get(k).getTrongLuong())] + xk * sanPham.get(k).getGiaTri() > FMax) {
                        FMax = F[k - 1][(V - xk * (int)sanPham.get(k).getTrongLuong())] + xk * (int)sanPham.get(k).getGiaTri();
                        XMax = xk;
                    }
                }

                F[k][V] = FMax;
                X[k][V] = XMax;
            }
        }
    }

    public static void TaoBang2(Balo balo, int[][] F, int[][] X) {
        int xk, yk, k;
        int FMax, XMax, V;
        List<SanPham> sanPham = balo.getDanhSachSanPham();
        int n = sanPham.size();
        int W = balo.getTrongLuongQDH();

        for (V = 0; V <= W; V++) {
            X[0][V] = Math.min((int)sanPham.get(0).getSoLuong(), V / (int)sanPham.get(0).getTrongLuong());
            F[0][V] = X[0][V] *(int) sanPham.get(0).getGiaTri();
        }

        for (k = 1; k < n; k++) {
            for (V = 0; V <= W; V++) {
                FMax = F[k - 1][V];
                XMax = 0;
                yk = Math.min((int)sanPham.get(k).getSoLuong(), V / (int)sanPham.get(k).getTrongLuong());

                for (xk = 1; xk <= yk; xk++) {
                    if (F[k - 1][(V - xk * (int)sanPham.get(k).getTrongLuong())] + xk * sanPham.get(k).getGiaTri() > FMax) {
                        FMax = F[k - 1][(V - xk * (int)sanPham.get(k).getTrongLuong())] + xk * (int)sanPham.get(k).getGiaTri();
                        XMax = xk;
                    }
                }

                F[k][V] = FMax;
                X[k][V] = XMax;
            }
        }
    }
    
    public static void TaoBang3(Balo balo, int[][] F, int[][] X) {
        int xk, yk, k;
        int FMax, XMax, V;
        List<SanPham> sanPham = balo.getDanhSachSanPham();
        int n = sanPham.size();
        int W = balo.getTrongLuongQDH();

        for (V = 0; V <= W; V++) {
            X[0][V] = Math.min(1, V / (int)sanPham.get(0).getTrongLuong());
            F[0][V] = X[0][V] *(int) sanPham.get(0).getGiaTri();
        }

        for (k = 1; k < n; k++) {
            for (V = 0; V <= W; V++) {
                FMax = F[k - 1][V];
                XMax = 0;
                yk = Math.min(1, V / (int)sanPham.get(k).getTrongLuong());

                for (xk = 1; xk <= yk; xk++) {
                    if (F[k - 1][(V - xk * (int)sanPham.get(k).getTrongLuong())] + xk * sanPham.get(k).getGiaTri() > FMax) {
                        FMax = F[k - 1][(V - xk * (int)sanPham.get(k).getTrongLuong())] + xk * (int)sanPham.get(k).getGiaTri();
                        XMax = xk;
                    }
                }

                F[k][V] = FMax;
                X[k][V] = XMax;
            }
        }
    }

    public static void TraBang(Balo balo, int [][] X) {
        int k;
        int n = balo.getDanhSachSanPham().size();
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int V =(int) balo.getTrongLuongQDH();
        for (k = n - 1; k >= 0; k--) {
            sanPhams.get(k).setPhuongAn(X[k][V]);
            V = V - X[k][V] * (int)sanPhams.get(k).getTrongLuong();
        }
    }
    
    public static void runQuyHoachDong1(Balo balo){
        int n = balo.getDanhSachSanPham().size();
        
        int[][] X = new int[n][400], F = new int[n][400];
        QuyHoachDong.TaoBang1(balo, F, X);
        QuyHoachDong.TraBang(balo, X);
    }
    
    public static void runQuyHoachDong2(Balo balo){
        int n = balo.getDanhSachSanPham().size();
        
        int[][] X = new int[n][400], F = new int[n][400];
        QuyHoachDong.TaoBang2(balo, F, X);
        QuyHoachDong.TraBang(balo, X);
    }
    
    public static void runQuyHoachDong3(Balo balo){
        int n = balo.getDanhSachSanPham().size();
        
        int[][] X = new int[n][400], F = new int[n][400];
        QuyHoachDong.TaoBang3(balo, F, X);
        QuyHoachDong.TraBang(balo, X);
    }
}
