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

            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");

            conn.setDoInput(true);

            if (!method.equals("GET")) {
                conn.setDoOutput(true);
            }

            if (jsonInput != null) {

                OutputStream os = conn.getOutputStream();
                os.write(jsonInput.getBytes("UTF-8"));
                os.flush();
                os.close();
            }

            BufferedReader reader;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getErrorStream(), "UTF-8"));
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
        return callAPI("GET", "hocsinh", null);
    }

    public static String getHocSinhByID(String id) {
        return callAPI("GET", "hocsinh&id=" + id, null);
    }

    public static String createHocSinh(String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("POST", "hocsinh", json);
    }

    public static String updateHocSinh(int id, String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"ID\":%d,\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                id, HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("PUT", "hocsinh", json);
    }

    public static String deleteHocSinh(int id) {

        String json = "{\"ID\":" + id + "}";

        return callAPI("DELETE", "hocsinh", json);
    }

    // ================================
    // SINHVIEN CRUD
    // ================================
    public static String getAllSinhVien() {
        return callAPI("GET", "sinhvien", null);
    }

    public static String getSinhVienByID(String id) {
        return callAPI("GET", "sinhvien&id=" + id, null);
    }

    public static String createSinhVien(String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("POST", "sinhvien", json);
    }

    public static String updateSinhVien(int id, String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"ID\":%d,\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                id, HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("PUT", "sinhvien", json);
    }

    public static String deleteSinhVien(int id) {

        String json = "{\"ID\":" + id + "}";

        return callAPI("DELETE", "sinhvien", json);
    }

    // ================================
    // DIEM CRUD
    // ================================
    public static String getAllDiem() {
        return callAPI("GET", "ketqua", null);
    }

    public static String getDiemByKey(int MaSV, String MonHoc) {

        return callAPI("GET", "ketqua&MaSV=" + MaSV + "&MonHoc=" + MonHoc, null);

    }

    public static String createDiem(int MaSV, String MonHoc, float Diem) {

        String json = String.format(
                "{\"MaSV\":%d,\"MonHoc\":\"%s\",\"Diem\":%f}",
                MaSV, MonHoc, Diem
        );

        return callAPI("POST", "ketqua", json);
    }

    public static String updateDiem(int MaSV, String MonHoc, float Diem) {

        String json = String.format(
                "{\"MaSV\":%d,\"MonHoc\":\"%s\",\"Diem\":%f}",
                MaSV, MonHoc, Diem
        );

        return callAPI("PUT", "ketqua", json);
    }

    public static String deleteDiem(int MaSV, String MonHoc) {

        String json = String.format(
                "{\"MaSV\":%d,\"MonHoc\":\"%s\"}",
                MaSV, MonHoc
        );

        return callAPI("DELETE", "ketqua", json);
    }

}