  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Balo;
import model.SanPham;

/**
 *
 * @author OS
 */
public class ThamAn {
    public static void Greedly1(Balo balo){
        int i;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        for(i=0;i<n;i++){
            sanPhams.get(i).setPhuongAn((int) (balo.getTrongLuongBalo()/sanPhams.get(i).getTrongLuong()));
            balo.setTrongLuongBalo(balo.getTrongLuongBalo()-(sanPhams.get(i).getPhuongAn()*sanPhams.get(i).getTrongLuong()));
        }
    }
    
    public static void Greedly2(Balo balo){
        int i;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        for(i=0;i<n;i++){
            sanPhams.get(i).setPhuongAn((int) (balo.getTrongLuongBalo()/sanPhams.get(i).getTrongLuong()));
            if(sanPhams.get(i).getPhuongAn()>sanPhams.get(i).getSoLuong()){
                sanPhams.get(i).setPhuongAn(sanPhams.get(i).getSoLuong());
            }
            balo.setTrongLuongBalo(balo.getTrongLuongBalo()-(sanPhams.get(i).getPhuongAn()*sanPhams.get(i).getTrongLuong()));
        }
    }
    
    public static void Greedly3(Balo balo){
        int i;
        List<SanPham> sanPhams = balo.getDanhSachSanPham();
        int n = sanPhams.size();
        for(i=0;i<n;i++){
            sanPhams.get(i).setPhuongAn((int) (balo.getTrongLuongBalo()/sanPhams.get(i).getTrongLuong()));
            if(sanPhams.get(i).getPhuongAn()>1){
                sanPhams.get(i).setPhuongAn(1);
            }
            balo.setTrongLuongBalo(balo.getTrongLuongBalo()-(sanPhams.get(i).getPhuongAn()*sanPhams.get(i).getTrongLuong()));
        }
    }
    
    public static void RunThamAn1(Balo balo){
        OpenFile.Bubble_Sort(balo);
        Greedly1(balo);
    }
        
    public static void RunThamAn2(Balo balo){
        OpenFile.Bubble_Sort(balo);
        Greedly2(balo);
    }
        
    public static void RunThamAn3(Balo balo){
        OpenFile.Bubble_Sort(balo);
        Greedly3(balo);
    }

}
