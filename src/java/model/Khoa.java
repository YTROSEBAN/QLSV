package model;

public class Khoa {

    private int MaKhoa;
    private String TenKhoa;

    public Khoa(){}

    public Khoa(int MaKhoa, String TenKhoa){
        this.MaKhoa = MaKhoa;
        this.TenKhoa = TenKhoa;
    }

    public int getMaKhoa(){ return MaKhoa; }
    public String getTenKhoa(){ return TenKhoa; }

    public void setMaKhoa(int MaKhoa){ this.MaKhoa = MaKhoa; }
    public void setTenKhoa(String TenKhoa){ this.TenKhoa = TenKhoa; }
}