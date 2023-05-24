/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNPM;

/**
 *
 * @author Admin
 */
public class LoaiPhong {
    private int MALP;
    private String TENLP;
    private int GIAPHONG;
    private String CHUTHICH;

    public LoaiPhong(int MALP, String TENLP, int GIAPHONG, String CHUTHICH) {
        this.MALP = MALP;
        this.TENLP = TENLP;
        this.GIAPHONG = GIAPHONG;
        this.CHUTHICH = CHUTHICH;
    }

    public int getMALP() {
        return MALP;
    }

    public void setMALP(int MALP) {
        this.MALP = MALP;
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

    public String getCHUTHICH() {
        return CHUTHICH;
    }

    public void setCHUTHICH(String CHUTHICH) {
        this.CHUTHICH = CHUTHICH;
    }
    
    
}
