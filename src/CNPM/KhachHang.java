
package CNPM;


public class KhachHang {
    private String MAKH;
    private String TENKH;
    private String CMND;
    private String SDT;
    private String QUOCTICH;
    private String GIOITINH;
    private int tuoi;

    public KhachHang(String MAKH, String TENKH, String CMND, String SDT, String QUOCTICH, String GIOITINH, int tuoi) {
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.CMND = CMND;
        this.SDT = SDT;
        this.QUOCTICH = QUOCTICH;
        this.GIOITINH = GIOITINH;
        this.tuoi = tuoi;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getQUOCTICH() {
        return QUOCTICH;
    }

    public void setQUOCTICH(String QUOCTICH) {
        this.QUOCTICH = QUOCTICH;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    

    
    
}
