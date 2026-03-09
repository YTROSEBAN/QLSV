package model;

public class HocSinh {

    private int MaSV;
    private String HoTen;
    private String NgaySinh;
    private int GioiTinh;
    private String DiaChi;
    private int MaLop;
    private String HinhAnh;

    public HocSinh(){}

    public HocSinh(int MaSV, String HoTen, String NgaySinh,
                   int GioiTinh, String DiaChi, int MaLop, String HinhAnh){

        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.MaLop = MaLop;
        this.HinhAnh = HinhAnh;
    }

    public int getMaSV(){ return MaSV; }
    public String getHoTen(){ return HoTen; }
    public String getNgaySinh(){ return NgaySinh; }
    public int getGioiTinh(){ return GioiTinh; }
    public String getDiaChi(){ return DiaChi; }
    public int getMaLop(){ return MaLop; }
    public String getHinhAnh(){ return HinhAnh; }

    public void setMaSV(int MaSV){ this.MaSV = MaSV; }
    public void setHoTen(String HoTen){ this.HoTen = HoTen; }
    public void setNgaySinh(String NgaySinh){ this.NgaySinh = NgaySinh; }
    public void setGioiTinh(int GioiTinh){ this.GioiTinh = GioiTinh; }
    public void setDiaChi(String DiaChi){ this.DiaChi = DiaChi; }
    public void setMaLop(int MaLop){ this.MaLop = MaLop; }
    public void setHinhAnh(String HinhAnh){ this.HinhAnh = HinhAnh; }
}