/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DEV-PC
 */
public class HocSinh {

    public String id;
    public String ma;
    public String ten;
    public String NgaySinh;
    public String GioiTinh;
    public String DiaChi;
    public String MaLop;
    public String TaiKhoan_ID;
    public String HinhAnh;

    public HocSinh(String id, String ma, String ten, String NgaySinh,
                   String GioiTinh, String DiaChi, String MaLop,
                   String TaiKhoan_ID, String HinhAnh) {

        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.MaLop = MaLop;
        this.TaiKhoan_ID = TaiKhoan_ID;
        this.HinhAnh = HinhAnh;
    }



    public String getMa(){return ma;}
    public String getTen(){return ten;}
    public String getNgaySinh(){return NgaySinh;}
    public String getGioiTinh(){return GioiTinh;}
    public String getDiaChi(){return DiaChi;}
    public String getMaLop(){return MaLop;}
    public String getID(){return id;}
    public String getTaiKhoan_ID(){return TaiKhoan_ID;}
    public String getHinhAnh(){return HinhAnh;}
    
    public void setMa(String ma){this.ma = ma;}
    public void setTen(String ten){this.ten = ten;}
    public void setNgaySinh(String ngaySinh){
    this.NgaySinh = ngaySinh;
}

    public void setGioiTinh(String gioiTinh){
    this.GioiTinh = gioiTinh;
}

    public void setDiaChi(String DiaChi){this.DiaChi = DiaChi;}
    public void setMaLop(String MaLop){this.MaLop = MaLop;}
    public void setID(String id){this.id = id;}
    public void setTaiKhoan_ID(String TaiKhoan_ID){this.TaiKhoan_ID = TaiKhoan_ID;}
    public void setHinhAnh(String HinhAnh){this.HinhAnh = HinhAnh;}
}
