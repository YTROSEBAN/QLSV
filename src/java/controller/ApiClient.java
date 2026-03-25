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

            // gửi JSON
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

    public static String createTaiKhoan(String TenDangNhap, String MatKhau, String Quyen, int MaSV) {

    String json = String.format(
            "{\"TenDangNhap\":\"%s\",\"MatKhau\":\"%s\",\"Quyen\":\"%s\",\"MaSV\":%d}",
            TenDangNhap, MatKhau, Quyen, MaSV
    );

    return callAPI("POST", "taikhoan", json);
}

    public static String updateTaiKhoan(String TenDangNhap, String MatKhau, String Quyen, int MaSV) {

    String json = String.format(
            "{\"TenDangNhap\":\"%s\",\"MatKhau\":\"%s\",\"Quyen\":\"%s\",\"MaSV\":%d}",
            TenDangNhap, MatKhau, Quyen, MaSV
    );

    return callAPI("PUT", "taikhoan", json);
}

   public static String deleteTaiKhoan(String TenDangNhap) {

    String json = String.format(
            "{\"TenDangNhap\":\"%s\"}",
            TenDangNhap
    );

    return callAPI("DELETE", "taikhoan", json);
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

    public static String createSinhVien(int MaSV, String HoTen,
            String NgaySinh, int GioiTinh, String DiaChi, int MaLop) {

        String json = String.format(
                "{\"MaSV\":%d,\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                MaSV, HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("POST", "sinhvien", json);
    }

    public static String updateSinhVien(String HoTen, String NgaySinh, int MaSV, String DiaChi, int GioiTinh, int MaLop) {

        String json = String.format(
                "{\"MaSV\":%d,\"HoTen\":\"%s\",\"NgaySinh\":\"%s\",\"GioiTinh\":%d,\"DiaChi\":\"%s\",\"MaLop\":%d}",
                MaSV, HoTen, NgaySinh, GioiTinh, DiaChi, MaLop
        );

        return callAPI("PUT", "sinhvien", json);
    }

    // SỬA LẠI DELETE
    public static String deleteSinhVien(int MaSV) {

        String json = "{\"MaSV\":" + MaSV + "}";

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

    // TẠM THỜI (để không crash)
static String getAllHocSinh() {
    return getAllSinhVien(); 
}
    
// ================================
// KHOA CRUD
// ================================

public static String getAllKhoa() {
    return callAPI("GET", "khoa", null);
}

public static String getKhoaById(int MaKhoa) {

    return callAPI("GET", "khoa&MaKhoa=" + MaKhoa, null);
}

public static String createKhoa(int MaKhoa, String TenKhoa) {

    String json = String.format(
            "{\"MaKhoa\":%d,\"TenKhoa\":\"%s\"}",
            MaKhoa, TenKhoa
    );

    return callAPI("POST", "khoa", json);
}

public static String updateKhoa(int MaKhoa, String TenKhoa) {

    String json = String.format(
            "{\"MaKhoa\":%d,\"TenKhoa\":\"%s\"}",
            MaKhoa, TenKhoa
    );

    return callAPI("PUT", "khoa", json);
}

public static String deleteKhoa(int MaKhoa) {

    String json = "{\"MaKhoa\":" + MaKhoa + "}";

    return callAPI("DELETE", "khoa", json);
}

    // ================================
// LOP CRUD
// ================================

public static String getAllLop() {
    return callAPI("GET", "lop", null);
}

public static String getLopByID(String MaLop) {
    return callAPI("GET", "lop&MaLop=" + MaLop, null);
}

public static String createLop(String TenLop, int MaKhoa) {

    String json = String.format(
            "{\"TenLop\":\"%s\",\"MaKhoa\":%d}",
            TenLop, MaKhoa
    );

    return callAPI("POST", "lop", json);
}

public static String updateLop(int MaLop, String TenLop, int MaKhoa) {

    String json = String.format(
            "{\"MaLop\":%d,\"TenLop\":\"%s\",\"MaKhoa\":%d}",
            MaLop, TenLop, MaKhoa
    );

    return callAPI("PUT", "lop", json);
}

public static String deleteLop(int MaLop) {

    String json = "{\"MaLop\":" + MaLop + "}";

    return callAPI("DELETE", "lop", json);
}
}
