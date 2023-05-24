/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNPM;

/**
 *
 * @author Admin
 */
public class LoaiDichVu {
    private int MALDV;
    private String TENLOAIDV;
    private int GIALDV;
    private String CHUTHICH;

    public LoaiDichVu(int MALDV, String TENLOAIDV, int GIALDV, String CHUTHICH) {
        this.MALDV = MALDV;
        this.TENLOAIDV = TENLOAIDV;
        this.GIALDV = GIALDV;
        this.CHUTHICH = CHUTHICH;
    }

    public int getMALDV() {
        return MALDV;
    }

    public void setMALDV(int MALDV) {
        this.MALDV = MALDV;
    }

    public String getTENLOAIDV() {
        return TENLOAIDV;
    }

    public void setTENLOAIDV(String TENLOAIDV) {
        this.TENLOAIDV = TENLOAIDV;
    }

    public int getGIALDV() {
        return GIALDV;
    }

    public void setGIALDV(int GIALDV) {
        this.GIALDV = GIALDV;
    }

    public String getCHUTHICH() {
        return CHUTHICH;
    }

    public void setCHUTHICH(String CHUTHICH) {
        this.CHUTHICH = CHUTHICH;
    }

    
    
}
