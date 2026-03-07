/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
/**
 *
 * @author DEV-PC
 */
public class ApiClient {
    private static final String BASE_URL = "http://bktn.io.vn/qlsinhvien";

    // ================================
    // CORE METHOD - CALL API
    // ================================
    private static String callAPI(String method, String table, String jsonInput) {

        try {

            String urlString = BASE_URL + "?table=" + table;
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod(method);

            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);

            // gửi data nếu có
            if (jsonInput != null) {

                OutputStream os = conn.getOutputStream();

                os.write(jsonInput.getBytes());

                os.flush();

                os.close();
            }

            BufferedReader reader;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {

                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

            } else {

                reader = new BufferedReader(
                        new InputStreamReader(conn.getErrorStream())
                );
            }

            String line;

            StringBuilder result = new StringBuilder();

            while ((line = reader.readLine()) != null) {

                result.append(line);

            }

            reader.close();

            return result.toString();

        } catch (Exception e) {

            return "{\"status\":\"error\",\"message\":\"" + e.getMessage() + "\"}";

        }
    }

    // ================================
    // TAIKHOAN CRUD
    // ================================

    public static String getAllTaiKhoan() {

        return callAPI("GET", "taikhoan", null);

    }
    
    public static String getTaiKhoanByID(String ID) {
        return callAPI("GET", "taikhoan&id="+ID, null);

    }
    
    public static String createTaiKhoan(String ten, String pass, String quyen, String trangThai) {

        String json = String.format(
                "{\"TenTaiKhoan\":\"%s\",\"MatKhau\":\"%s\",\"Quyen\":\"%s\",\"TrangThai\":\"%s\"}",
                ten, pass, quyen, trangThai
        );

        return callAPI("POST", "taikhoan", json);
    }

    public static String updateTaiKhoan(int id, String ten, String pass, String quyen, String trangThai) {

        String json = String.format(
                "{\"ID\":%d,\"TenTaiKhoan\":\"%s\",\"MatKhau\":\"%s\",\"Quyen\":\"%s\",\"TrangThai\":\"%s\"}",
                id, ten, pass, quyen, trangThai
        );
        if(id == 1){
            return "{\"status\":\"error\",\"message\":\"Do not allow\"}";
        }
        return callAPI("PUT", "taikhoan", json);
    }

    public static String deleteTaiKhoan(int id) {

        String json = "{\"ID\":" + id + "}";
        if(id == 1){
            return "{\"status\":\"error\",\"message\":\"Do not allow\"}";
        }
        return callAPI("DELETE", "taikhoan", json);
    }


    // ================================
    // HOCSINH CRUD
    // ================================

    public static String getAllHocSinh() {

        return callAPI("GET", "sinhvien", null);

    }
    
    public static String getHocSinhByID(String ID) {
        return callAPI("GET", "sinhvien&id="+ID, null);

    }

    public static String createHocSinh(String ma, String ten, String NgaySinh,
        String GioiTinh, String DiaChi, String MaLop, String TaiKhoan_ID, String HinhAnh) {

    String json = String.format(
        "{\"MaSV\":\"%s\",\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":\"%s\",\"DiaChi\":\"%s\",\"MaLop\":\"%s\",\"TaiKhoan_ID\":\"%s\",\"HinhAnh\":\"%s\"}",
        ma, ten, NgaySinh, GioiTinh, DiaChi, MaLop, TaiKhoan_ID, HinhAnh
    );

    return callAPI("POST", "hocsinh", json);
}


    public static String updateHocSinh(int id, String ma, String ten, String NgaySinh,
        String GioiTinh, String DiaChi, String MaLop, String TaiKhoan_ID, String HinhAnh) {

    String json = String.format(
        "{\"ID\":%d,\"MaSV\":\"%s\",\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":\"%s\",\"DiaChi\":\"%s\",\"MaLop\":\"%s\",\"TaiKhoan_ID\":\"%s\",\"HinhAnh\":\"%s\"}",
        id, ma, ten, NgaySinh, GioiTinh, DiaChi, MaLop, TaiKhoan_ID, HinhAnh
    );

    return callAPI("PUT", "hocsinh", json);
}



    public static String deleteHocSinh(int id) {

        String json = "{\"ID\":" + id + "}";

        return callAPI("DELETE", "hocsinh", json);
    }


    // ================================
    // DIEM CRUD
    // ================================

    public static String getAllDiem() {

        return callAPI("GET", "diem", null);

    }

    public static String createDiem(String monHoc, double diem, int hocSinhID) {

        String json = String.format(
                "{\"MonHoc\":\"%s\",\"Diem\":%f,\"HocSinh_ID\":%d}",
                monHoc, diem, hocSinhID
        );

        return callAPI("POST", "diem", json);
    }
    
    public static String getDiemByID(String ID) {
        return callAPI("GET", "diem&id="+ID, null);

    }
    
    public static String updateDiem(int id, String monHoc, double diem, int hocSinhID) {

        String json = String.format(
                "{\"ID\":%d,\"MonHoc\":\"%s\",\"Diem\":%f,\"HocSinh_ID\":%d}",
                id, monHoc, diem, hocSinhID
        );

        return callAPI("PUT", "diem", json);
    }

    public static String deleteDiem(int id) {

        String json = "{\"ID\":" + id + "}";

        return callAPI("DELETE", "diem", json);
    }

    static void updateHocSinh(int id, String ma, String ten, String NgaySinh, String GioiTinh, String DiaChi, String MaLop, int taiKhoanID, String randomName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void createHocSinh(String ma, String ten, String NgaySinh, String GioiTinh, String DiaChi, String MaLop, int taiKhoanID, String randomName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
