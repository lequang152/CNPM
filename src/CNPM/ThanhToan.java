/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNPM;

/**
 *
 * @author Admin
 */
public class ThanhToan {
    private int STT;
    private int TENPHONG;
    private int SONGAY;
    private String TENLP;
    private int GIAPHONG;
    private String TENLOAI;
    private int GIA;

    public ThanhToan(int STT, int TENPHONG, int SONGAY, String TENLP, int GIAPHONG, String TENLOAI, int GIA) {
        this.STT = STT;
        this.TENPHONG = TENPHONG;
        this.SONGAY = SONGAY;
        this.TENLP = TENLP;
        this.GIAPHONG = GIAPHONG;
        this.TENLOAI = TENLOAI;
        this.GIA = GIA;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getTENPHONG() {
        return TENPHONG;
    }

    public void setTENPHONG(int TENPHONG) {
        this.TENPHONG = TENPHONG;
    }

    public int getSONGAY() {
        return SONGAY;
    }

    public void setSONGAY(int SONGAY) {
        this.SONGAY = SONGAY;
    }

    public String getTENLP() {
        return TENLP;
    }

    public void setTENLP(String TENLP) {
        this.TENLP = TENLP;
    }

    public int getGIAPHONG() {
        return GIAPHONG;
    }

    public void setGIAPHONG(int GIAPHONG) {
        this.GIAPHONG = GIAPHONG;
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
    
    
}
