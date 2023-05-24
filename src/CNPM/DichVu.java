package CNPM;

public class DichVu {
    private String MADP;
    private String TENKH;
    private String TENPHONG;
    private String MALDV;
    private String LOAIDV;
    private int SOLUONG;
    private int SONGAY;
    private int GIATHANH;

    public DichVu(String MADP, String TENKH, String TENPHONG, String MALDV, String LOAIDV, int SOLUONG, int SONGAY, int GIATHANH) {
        this.MADP = MADP;
        this.TENKH = TENKH;
        this.TENPHONG = TENPHONG;
        this.MALDV = MALDV;
        this.LOAIDV = LOAIDV;
        this.SOLUONG = SOLUONG;
        this.SONGAY = SONGAY;
        this.GIATHANH = GIATHANH;
    }

    public String getMADP() {
        return MADP;
    }

    public void setMADP(String MADP) {
        this.MADP = MADP;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getTENPHONG() {
        return TENPHONG;
    }

    public void setTENPHONG(String TENPHONG) {
        this.TENPHONG = TENPHONG;
    }

    public String getMALDV() {
        return MALDV;
    }

    public void setMALDV(String MALDV) {
        this.MALDV = MALDV;
    }

    public String getLOAIDV() {
        return LOAIDV;
    }

    public void setLOAIDV(String LOAIDV) {
        this.LOAIDV = LOAIDV;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getSONGAY() {
        return SONGAY;
    }

    public void setSONGAY(int SONGAY) {
        this.SONGAY = SONGAY;
    }

    public int getGIATHANH() {
        return GIATHANH;
    }

    public void setGIATHANH(int GIATHANH) {
        this.GIATHANH = GIATHANH;
    }

    
}
