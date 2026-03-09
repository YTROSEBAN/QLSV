package util;

import java.util.ArrayList;
import model.HocSinh;
import model.TaiKhoan;

public class JsonUtil {

    // ===============================
    // PARSE HOC SINH
    // ===============================
    public static ArrayList<HocSinh> parseHocSinh(String json) {

        ArrayList<HocSinh> list = new ArrayList<>();

        if (json == null || json.isEmpty()) return list;

        if (json.contains("\"data\":[")) {

            json = getDataArray(json);

            String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

            for (String obj : objects) {

                obj = cleanObject(obj);

                String maStr = getValue(obj, "MaSV");
                int ma = maStr.isEmpty() ? 0 : Integer.parseInt(maStr);

                String ten = decodeUnicode(getValue(obj, "HoTen"));
                String ngaySinh = getValue(obj, "NgaySinh");
                String diaChi = decodeUnicode(getValue(obj, "DiaChi"));

                String maLopStr = getValue(obj, "MaLop");
                int maLop = maLopStr.isEmpty() ? 0 : Integer.parseInt(maLopStr);

                String gioiTinhStr = getValue(obj, "GioiTinh");
                int gioiTinh = gioiTinhStr.isEmpty() ? 0 : Integer.parseInt(gioiTinhStr);

                String hinhAnh = getValue(obj, "HinhAnh");

                list.add(new HocSinh(
                        ma,
                        ten,
                        ngaySinh,
                        gioiTinh,
                        diaChi,
                        maLop,
                        hinhAnh
                ));
            }

        } else {

            json = getDataObject(json);
            json = cleanObject(json);

            String maStr = getValue(json, "MaSV");
            int ma = maStr.isEmpty() ? 0 : Integer.parseInt(maStr);

            String ten = decodeUnicode(getValue(json, "HoTen"));
            String ngaySinh = getValue(json, "NgaySinh");
            String diaChi = decodeUnicode(getValue(json, "DiaChi"));

            String maLopStr = getValue(json, "MaLop");
            int maLop = maLopStr.isEmpty() ? 0 : Integer.parseInt(maLopStr);

            String gioiTinhStr = getValue(json, "GioiTinh");
            int gioiTinh = gioiTinhStr.isEmpty() ? 0 : Integer.parseInt(gioiTinhStr);

            String hinhAnh = getValue(json, "HinhAnh");

            list.add(new HocSinh(
                    ma,
                    ten,
                    ngaySinh,
                    gioiTinh,
                    diaChi,
                    maLop,
                    hinhAnh
            ));
        }

        return list;
    }

    // ===============================
    // PARSE TAI KHOAN
    // ===============================
    public static ArrayList<TaiKhoan> parseTaiKhoan(String json) {

        ArrayList<TaiKhoan> list = new ArrayList<>();

        if (json == null || json.isEmpty()) return list;

        if (json.contains("\"data\":[")) {

            json = getDataArray(json);

            String[] objects = json.substring(1, json.length() - 1).split("\\},\\{");

            for (String obj : objects) {

                obj = cleanObject(obj);

                String id = getValue(obj, "id");
                String username = getValue(obj, "TenTaiKhoan");
                String password = getValue(obj, "MatKhau");
                String quyen = getValue(obj, "Quyen");
                String trangThai = getValue(obj, "TrangThai");

                list.add(new TaiKhoan(id, username, password, quyen, trangThai));
            }
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

            if (end == -1) {
                end = json.indexOf("}", start);
            }

            return json.substring(start, end);
        }
    }

    private static String getDataArray(String json) {

        int start = json.indexOf("[");
        int end = json.lastIndexOf("]");

        return json.substring(start, end + 1);
    }

    private static String cleanObject(String json) {

        if (!json.startsWith("{")) {
            json = "{" + json;
        }

        if (!json.endsWith("}")) {
            json = json + "}";
        }

        return json;
    }

    private static String getDataObject(String json) {

        int start = json.indexOf("{", json.indexOf("data"));
        int end = json.lastIndexOf("}");

        return json.substring(start, end + 1);
    }

    private static String decodeUnicode(String text) {
        return text;
    }
}