/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import java.io.IOException;
import java.util.List;
import model.Balo;
import model.SanPham;

public class NhanhCan {
    public static void Tao_Nut_Goc(double W, double[] V, double[] CT, double[] GLNTT, double[] TGT, double DV_Max) {
        TGT[0] = 0.0;
        V[0] = W;
        CT[0] = V[0] * DV_Max;
        GLNTT[0] = 0.0;
    }

    public static void Cap_Nhat_CLNTT(double TGT, double[] GLNTT, int[] x, Balo balo) {
        int i;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        if (GLNTT[0] < TGT) {
            GLNTT[0] = TGT;
            for (i = 0; i < n; i++) {
                sanPhams.get(i).setPhuongAn(x[i]);
            }
        }
    }

    public static void Nhanh_Can1(int i, double[] TGT, double[] CT, double[] V, double[] GLNTT, int[] x, Balo balo) {
        int j, yk;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        yk = (int)(V[0] / sanPhams.get(i).getTrongLuong());

        for (j = yk; j >= 0; j--) {
            TGT[0] = TGT[0] + j * sanPhams.get(i).getGiaTri();
            V[0] = V[0] - j * sanPhams.get(i).getTrongLuong();
            if (i < n - 1) {
                CT[0] = TGT[0] + V[0] * sanPhams.get(i + 1).getDonGia();
            } else {
                CT[0] = TGT[0];
            }

            if (CT[0] > GLNTT[0]) {
                x[i] = j;
                if (i == n - 1 || V[0] == 0) {
                    Cap_Nhat_CLNTT(TGT[0], GLNTT, x, balo);
                } else {
                    Nhanh_Can1(i + 1, TGT, CT, V, GLNTT, x, balo);
                }
            }
            x[i] = 0;
            TGT[0] = TGT[0] - j * sanPhams.get(i).getGiaTri();
            V[0] = V[0] + j * sanPhams.get(i).getTrongLuong();
        }
    }
    
    public static void Nhanh_Can2(int i, double[] TGT, double[] CT, double[] V, double[] GLNTT, int[] x, Balo balo) {
        int j, yk;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        yk = (int) Math.min(sanPhams.get(i).getSoLuong(), (V[0] / sanPhams.get(i).getTrongLuong()));

        for (j = yk; j >= 0; j--) {
            TGT[0] = TGT[0] + j * sanPhams.get(i).getGiaTri();
            V[0] = V[0] - j * sanPhams.get(i).getTrongLuong();
            if (i < n - 1) {
                CT[0] = TGT[0] + V[0] * sanPhams.get(i + 1).getDonGia();
            } else {
                CT[0] = TGT[0];
            }

            if (CT[0] > GLNTT[0]) {
                x[i] = j;
                if (i == n - 1 || V[0] == 0) {
                    Cap_Nhat_CLNTT(TGT[0], GLNTT, x, balo);
                } else {
                    Nhanh_Can2(i + 1, TGT, CT, V, GLNTT, x, balo);
                }
            }
            x[i] = 0;
            TGT[0] = TGT[0] - j * sanPhams.get(i).getGiaTri();
            V[0] = V[0] + j * sanPhams.get(i).getTrongLuong();
        }
    }
    
    public static void Nhanh_Can3(int i, double[] TGT, double[] CT, double[] V, double[] GLNTT, int[] x, Balo balo) {
        int j, yk;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        yk = Math.min(1,(int)(V[0] / sanPhams.get(i).getTrongLuong()));

        for (j = yk; j >= 0; j--) {
            TGT[0] = TGT[0] + j * sanPhams.get(i).getGiaTri();
            V[0] = V[0] - j * sanPhams.get(i).getTrongLuong();
            if (i < n - 1) {
                CT[0] = TGT[0] + V[0] * sanPhams.get(i + 1).getDonGia();
            } else {
                CT[0] = TGT[0];
            }
            if (CT[0] > GLNTT[0]) {
                x[i] = j;
                if (i == n - 1 || V[0] == 0) {
                    Cap_Nhat_CLNTT(TGT[0], GLNTT, x, balo);
                } else {
                    Nhanh_Can3(i + 1, TGT, CT, V, GLNTT, x, balo);
                }
            }
            x[i] = 0;
            TGT[0] = TGT[0] - j * sanPhams.get(i).getGiaTri();
            V[0] = V[0] + j * sanPhams.get(i).getTrongLuong();
        }
    }
    public static void runNhanhCan1(Balo balo){
        int n = balo.getDanhSachSanPham().size();
        int[] x = new int[n];
        OpenFile.Bubble_Sort(balo);
        double W = balo.getTrongLuongBalo();
        double[] CT = new double[1];
        double[] TGT = new double[1];
        double[] V = new double[1];
        double[] GLNTT = new double[1];

        Tao_Nut_Goc(W, V, CT, GLNTT, TGT, balo.getDanhSachSanPham().get(0).getDonGia());

        Nhanh_Can1(0, TGT, CT, V, GLNTT, x, balo);
    }
    
    public static void runNhanhCan2(Balo balo){
        int n = balo.getDanhSachSanPham().size();
        int[] x = new int[n];
        OpenFile.Bubble_Sort(balo);
        double W = balo.getTrongLuongBalo();
        double[] CT = new double[1];
        double[] TGT = new double[1];
        double[] V = new double[1];
        double[] GLNTT = new double[1];

        Tao_Nut_Goc(W, V, CT, GLNTT, TGT, balo.getDanhSachSanPham().get(0).getDonGia());

        Nhanh_Can2(0, TGT, CT, V, GLNTT, x, balo);
    }
        
    public static void runNhanhCan3(Balo balo){
        int n = balo.getDanhSachSanPham().size();
        int[] x = new int[n];
        OpenFile.Bubble_Sort(balo);
        double W = balo.getTrongLuongBalo();
        double[] CT = new double[1];
        double[] TGT = new double[1];
        double[] V = new double[1];
        double[] GLNTT = new double[1];

        Tao_Nut_Goc(W, V, CT, GLNTT, TGT, balo.getDanhSachSanPham().get(0).getDonGia());

        Nhanh_Can3(0, TGT, CT, V, GLNTT, x, balo);
    }
}
