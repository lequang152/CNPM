package CNPM;

import java.util.Date;


public class HoaDon {
    private String MAHD;
    private Date NGAY;
    private double GIAHD;
    private String TINHTRANG;
    private String MADP;

    public HoaDon(String MAHD, Date NGAY, double GIAHD, String TINHTRANG, String MADP) {
        this.MAHD = MAHD;
        this.NGAY = NGAY;
        this.GIAHD = GIAHD;
        this.TINHTRANG = TINHTRANG;
        this.MADP = MADP;
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public Date getNGAY() {
        return NGAY;
    }

    public void setNGAY(Date NGAY) {
        this.NGAY = NGAY;
    }

    public double getGIAHD() {
        return GIAHD;
    }

    public void setGIAHD(double GIAHD) {
        this.GIAHD = GIAHD;
    }

    public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }

    public String getMADP() {
        return MADP;
    }

    public void setMADP(String MADP) {
        this.MADP = MADP;
    }
    
    
}
