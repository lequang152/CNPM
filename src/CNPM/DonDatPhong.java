/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNPM;

/**
 *
 * @author Admin
 */
public class DonDatPhong {
    private int MADP;
    private String NGAYDAT;
    private String NGAYNHAN;
    private String NGAYTRA;
    private String TINHTRANG;
    private String PTTT;
    private int MAKH;
    private int MAPHONG;

    public DonDatPhong(int MADP, String NGAYDAT, String NGAYNHAN, String NGAYTRA, String TINHTRANG, String PTTT, int MAKH, int MAPHONG) {
        this.MADP = MADP;
        this.NGAYDAT = NGAYDAT;
        this.NGAYNHAN = NGAYNHAN;
        this.NGAYTRA = NGAYTRA;
        this.TINHTRANG = TINHTRANG;
        this.PTTT = PTTT;
        this.MAKH = MAKH;
        this.MAPHONG = MAPHONG;
    }

    public int getMADP() {
        return MADP;
    }

    public void setMADP(int MADP) {
        this.MADP = MADP;
    }

    public String getNGAYDAT() {
        return NGAYDAT;
    }

    public void setNGAYDAT(String NGAYDAT) {
        this.NGAYDAT = NGAYDAT;
    }

    public String getNGAYNHAN() {
        return NGAYNHAN;
    }

    public void setNGAYNHAN(String NGAYNHAN) {
        this.NGAYNHAN = NGAYNHAN;
    }

    public String getNGAYTRA() {
        return NGAYTRA;
    }

    public void setNGAYTRA(String NGAYTRA) {
        this.NGAYTRA = NGAYTRA;
    }

    public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }

    public String getPTTT() {
        return PTTT;
    }

    public void setPTTT(String PTTT) {
        this.PTTT = PTTT;
    }

    public int getMAKH() {
        return MAKH;
    }

    public void setMAKH(int MAKH) {
        this.MAKH = MAKH;
    }

    public int getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(int MAPHONG) {
        this.MAPHONG = MAPHONG;
    }
    
    
    
    
}
