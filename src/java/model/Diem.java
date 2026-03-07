/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DEV-PC
 */
public class Diem {
    public String id;
    public String MonHoc;
    public double DiemTB;
    public String HocSinh_ID;
    public Diem(String id, String MonHoc, double DiemTB, String HocSinh_ID){
        this.id = id;
        this.MonHoc = MonHoc;
        this.DiemTB = DiemTB;
        this.HocSinh_ID = HocSinh_ID;
    }
    public String getMonHoc(){return MonHoc;}
    public double getDiemTB(){return DiemTB;}
    public String getHocSinh_ID(){return HocSinh_ID;}
    public String getID(){return id;}
    
    public void setMonHoc(String MonHoc){this.MonHoc = MonHoc;}
    public void setHocSinh_ID(String HocSinh_ID){this.HocSinh_ID = HocSinh_ID;}
    public void setDiemTB(double DiemTB){this.DiemTB = DiemTB;}
    public void setID(String id){this.id = id;}
}
