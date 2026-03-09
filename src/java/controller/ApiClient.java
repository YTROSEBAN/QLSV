package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

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

            if (!method.equals("GET")) {
                conn.setDoOutput(true);
            }

            if (jsonInput != null) {
                OutputStream os = conn.getOutputStream();
                os.write(jsonInput.getBytes());
                os.flush();
                os.close();
            }

            BufferedReader reader;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
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

    public static String getTaiKhoanByID(String id) {
        return callAPI("GET", "taikhoan&id=" + id, null);
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

        return callAPI("PUT", "taikhoan", json);
    }

    public static String deleteTaiKhoan(int id) {

        String json = "{\"ID\":" + id + "}";

        return callAPI("DELETE", "taikhoan", json);
    }

    // ================================
    // HOCSINH CRUD
    // ================================

    public static String getAllHocSinh() {
        return callAPI("GET", "sinhvien", null);
    }

    public static String getHocSinhByID(String id) {
        return callAPI("GET", "sinhvien&id=" + id, null);
    }

    public static String createHocSinh(String MaSV, String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"MaSV\":\"%s\",\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                MaSV, HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("POST", "sinhvien", json);
    }

    public static String updateHocSinh(int id, String MaSV, String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"ID\":%d,\"MaSV\":\"%s\",\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                id, MaSV, HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("PUT", "sinhvien", json);
    }

    public static String deleteHocSinh(int id) {

        String json = "{\"ID\":" + id + "}";

        return callAPI("DELETE", "sinhvien", json);
    }

}