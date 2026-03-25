package model;

public class Lop {

    private int MaLop;
    private String TenLop;
    private int MaKhoa;

    public Lop() {
    }

    public Lop(int MaLop, String TenLop, int MaKhoa) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.MaKhoa = MaKhoa;
    }

    public int getMaLop() {
        return MaLop;
    }

    public void setMaLop(int MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public int getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(int MaKhoa) {
        this.MaKhoa = MaKhoa;
    }
}