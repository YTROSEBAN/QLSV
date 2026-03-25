package util;

import java.util.ArrayList;
import model.HocSinh;
import model.TaiKhoan;
import model.Diem;
import model.Khoa;
import model.Lop;

public class JsonUtil {

    // ===============================
    // PARSE HOC SINH
    // ===============================
    public static ArrayList<HocSinh> parseHocSinh(String json) {

        ArrayList<HocSinh> list = new ArrayList<>();

        if (json == null || json.isEmpty()) return list;

        try {

            if (json.contains("\"data\":[")) {
                json = getDataArray(json);
            }

            String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

            for (String obj : objects) {

                obj = cleanObject(obj);

                int masv = Integer.parseInt(getValue(obj, "MaSV"));
                String hoten = decodeUnicode(getValue(obj, "HoTen"));
                String ngaysinh = getValue(obj, "NgaySinh");
                int gioitinh = Integer.parseInt(getValue(obj, "GioiTinh"));
                String diachi = decodeUnicode(getValue(obj, "DiaChi"));
                int malop = Integer.parseInt(getValue(obj, "MaLop"));
                String hinhanh = getValue(obj, "HinhAnh");

                list.add(new HocSinh(masv, hoten, ngaysinh, gioitinh, diachi, malop, hinhanh));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===============================
    // PARSE TAI KHOAN
    // ===============================
    public static ArrayList<TaiKhoan> parseTaiKhoan(String json) {

        ArrayList<TaiKhoan> list = new ArrayList<>();

        if (json == null || json.isEmpty()) return list;

        try {

            if (json.contains("\"data\":[")) {
                json = getDataArray(json);
            }

            String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

            for (String obj : objects) {

                obj = cleanObject(obj);

                String username = decodeUnicode(getValue(obj, "TenDangNhap"));
                String pass = getValue(obj, "MatKhau");
                String quyen = getValue(obj, "Quyen");

                int masv = 0;
                try {
                    masv = Integer.parseInt(getValue(obj, "MaSV"));
                } catch (Exception e) {
                    masv = 0;
                }

                list.add(new TaiKhoan(username, pass, quyen, masv));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===============================
    // PARSE DIEM
    // ===============================
    public static ArrayList<Diem> parseDiem(String json) {

        ArrayList<Diem> list = new ArrayList<>();

        if (json == null || json.isEmpty()) return list;

        try {

            if (json.contains("\"data\":[")) {
                json = getDataArray(json);
            }

            String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

            for (String obj : objects) {

                obj = cleanObject(obj);

                int masv = Integer.parseInt(getValue(obj, "MaSV"));
                String monhoc = decodeUnicode(getValue(obj, "MonHoc"));
                float diem = Float.parseFloat(getValue(obj, "Diem"));

                list.add(new Diem(masv, monhoc, diem));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===============================
    // PARSE KHOA
    // ===============================
    public static ArrayList<Khoa> parseKhoa(String json) {

        ArrayList<Khoa> list = new ArrayList<>();

        if (json == null || json.isEmpty()) return list;

        try {

            if (json.contains("\"data\":[")) {
                json = getDataArray(json);
            }

            String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

            for (String obj : objects) {

                obj = cleanObject(obj);

                int makhoa = Integer.parseInt(getValue(obj, "MaKhoa"));
                String tenkhoa = decodeUnicode(getValue(obj, "TenKhoa"));

                list.add(new Khoa(makhoa, tenkhoa));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===============================
    // JSON HELPER
    // ===============================
    private static String getValue(String json, String key) {

        String search = "\"" + key + "\":";
        int start = json.indexOf(search);

        if (start == -1) return "";

        start += search.length();

        if (json.charAt(start) == '"') {

            start++;
            int end = json.indexOf("\"", start);
            return json.substring(start, end);

        } else {

            int end = json.indexOf(",", start);

            if (end == -1) end = json.indexOf("}", start);

            return json.substring(start, end);
        }
    }

    private static String getDataArray(String json) {

        int start = json.indexOf("[");
        int end = json.lastIndexOf("]");

        return json.substring(start, end + 1);
    }

    private static String cleanObject(String json) {

        if (!json.startsWith("{")) json = "{" + json;
        if (!json.endsWith("}")) json = json + "}";

        return json;
    }

    // ===============================
    // DECODE UNICODE
    // ===============================
    private static String decodeUnicode(String text) {

        if (text == null) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '\\' && i + 5 < text.length() && text.charAt(i + 1) == 'u') {

                String hex = text.substring(i + 2, i + 6);

                try {
                    int code = Integer.parseInt(hex, 16);
                    sb.append((char) code);
                    i += 5;
                } catch (Exception e) {
                    sb.append(text.charAt(i));
                }

            } else {
                sb.append(text.charAt(i));
            }
        }

        return sb.toString();
    }

    public static ArrayList<Lop> parseLop(String json) {

    ArrayList<Lop> list = new ArrayList<>();

    if (json == null || json.isEmpty()) return list;

    try {

        if (json.contains("\"data\":[")) {
            json = getDataArray(json);
        }

        String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

        for (String obj : objects) {

            obj = cleanObject(obj);

            int malop = Integer.parseInt(getValue(obj, "MaLop"));
            String tenlop = decodeUnicode(getValue(obj, "TenLop"));
            int makhoa = Integer.parseInt(getValue(obj, "MaKhoa"));

            list.add(new Lop(malop, tenlop, makhoa));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
}