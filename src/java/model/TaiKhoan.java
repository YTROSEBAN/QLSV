/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DEV-PC
 */
public class TaiKhoan {
    public String id;
    public String TenTaiKhoan;
    public String MatKhau;
    public String Quyen;
    public String TrangThai;
    public TaiKhoan(String id, String TenTaiKhoan, String MatKhau, String Quyen, String TrangThai){
        this.id = id;
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
    }
    public String getTenTaiKhoan(){return TenTaiKhoan;}
    public String getMatKhau(){return MatKhau;}
    public String getQuyen(){return Quyen;}
    public String getTrangThai(){return TrangThai;}
    public String getID(){return id;}
    
    public void setTenTaiKhoan(String TenTaiKhoan){this.TenTaiKhoan = TenTaiKhoan;}
    public void setMatKhau(String MatKhau){this.MatKhau = MatKhau;}
    public void setQuyen(String Quyen){this.Quyen = Quyen;}
    public void setTrangThai(String TrangThai){this.TrangThai = TrangThai;}
    public void setID(String id){this.id = id;}
}
