package model;

public class TaiKhoan {

    private String TenDangNhap;
    private String MatKhau;
    private String Quyen;
    private int MaSV;

    public TaiKhoan(String TenDangNhap, String MatKhau, String Quyen, int MaSV) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
        this.MaSV = MaSV;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int MaSV) {
        this.MaSV = MaSV;
    }
}