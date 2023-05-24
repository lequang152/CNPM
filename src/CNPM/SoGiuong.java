/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNPM;

/**
 *
 * @author Admin
 */
public class SoGiuong {
    private int MASG;
    private String TENLOAI;
    private int GIA;
    private String CHUTHICH;

    public SoGiuong(int MASG, String TENLOAI, int GIA, String CHUTHICH) {
        this.MASG = MASG;
        this.TENLOAI = TENLOAI;
        this.GIA = GIA;
        this.CHUTHICH = CHUTHICH;
    }

    public int getMASG() {
        return MASG;
    }

    public void setMASG(int MASG) {
        this.MASG = MASG;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }

    public int getGIA() {
        return GIA;
    }

    public void setGIA(int GIA) {
        this.GIA = GIA;
    }

    public String getCHUTHICH() {
        return CHUTHICH;
    }

    public void setCHUTHICH(String CHUTHICH) {
        this.CHUTHICH = CHUTHICH;
    }
    
    
}
