package model;

public class Diem {

    private int MaSV;
    private String MonHoc;
    private double Diem;

    public Diem(){}

    public Diem(int MaSV, String MonHoc, double Diem){
        this.MaSV = MaSV;
        this.MonHoc = MonHoc;
        this.Diem = Diem;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int MaSV) {
        this.MaSV = MaSV;
    }

    public String getMonHoc() {
        return MonHoc;
    }

    public void setMonHoc(String MonHoc) {
        this.MonHoc = MonHoc;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double Diem) {
        this.Diem = Diem;
    }

}