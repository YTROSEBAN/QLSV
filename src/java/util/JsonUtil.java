/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import model.HocSinh;
import model.Diem;
import model.TaiKhoan;
import java.util.ArrayList;
/**
 *
 * @author DEV-PC
 */
public class JsonUtil {
    // ===============================
    // HÀM CHUNG
    // ===============================

    private static String removeArray(String json) {

        if (json == null || json.length() < 2)
            return "";

        return json.substring(1, json.length() - 1);
    }

    private static String[] splitObjects(String json) {

        if (json.trim().isEmpty())
            return new String[0];

        return json.split("\\},\\{");
    }

    private static String cleanObject(String obj) {

        return obj.replace("{", "")
                  .replace("}", "")
                  .replace("\"", "");
    }

    private static String getValue(String obj, String key) {

        String[] fields = obj.split(",");

        for (String field : fields) {

            String[] pair = field.split(":", 2);

            String k = pair[0].trim();

            if (k.equals(key))
                return pair[1].trim();
        }

        return "";
    }
    private static String getDataArray(String json) {

        int start = json.indexOf("\"data\"");

        if (start == -1) return "[]";

        start = json.indexOf("[", start);

        int end = json.lastIndexOf("]");

        if (start == -1 || end == -1) return "[]";

        return json.substring(start, end + 1);
    }
    private static String decodeUnicode(String text) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (c == '\\' && i + 5 < text.length() && text.charAt(i + 1) == 'u') {

                String hex = text.substring(i + 2, i + 6);

                try {
                    int code = Integer.parseInt(hex, 16);
                    result.append((char) code);
                    i += 5;
                } catch (Exception e) {
                    result.append(c);
                }

            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    
    private static String getDataObject(String json) {

        int start = json.indexOf("\"data\"");

        if (start == -1) return "";

        start = json.indexOf("{", start);

        int end = json.indexOf("}", start);

        if (start == -1 || end == -1) return "";

        return json.substring(start, end + 1);
    }
    
    // ===============================
    // HOC SINH
    // ===============================
    
    public static ArrayList<HocSinh> parseHocSinh(String json) {

        ArrayList<HocSinh> list = new ArrayList<>();

        if (json.contains("\"data\":[")) {

            // ARRAY
            json = getDataArray(json);
            json = removeArray(json);
            String[] objects = splitObjects(json);

            for (String obj : objects) {

                obj = cleanObject(obj);

                String id = getValue(obj, "ID");
                String ma = decodeUnicode(getValue(obj, "MaSV"));
                String ten = decodeUnicode(getValue(obj, "HoTen"));

                String NgaySinh = getValue(obj, "NgaySinh"); 
String DiaChi = decodeUnicode(getValue(obj, "DiaChi"));
String MaLop = getValue(obj, "MaLop");
String Hinhanh = decodeUnicode(getValue(obj, "HinhAnh"));
String taikhoan = decodeUnicode(getValue(obj, "TaiKhoan_ID"));
String HinhAnh = decodeUnicode(getValue(obj, "HinhAnh"));

// 2. Xử lý Giới tính: 1 -> Nam, khác -> Nữ
String GioiTinhRaw = getValue(obj, "GioiTinh");
String GioiTinh = "1".equals(GioiTinhRaw) ? "Nam" : "Nữ";

                
                list.add(new HocSinh(id, ma, ten, NgaySinh, GioiTinh, DiaChi, MaLop, taikhoan, HinhAnh));


            }

        } else {

            // OBJECT
            json = getDataObject(json);
            json = cleanObject(json);

            String id = getValue(json, "ID");
String ma = decodeUnicode(getValue(json, "MaSV"));
String ten = decodeUnicode(getValue(json, "HoTen"));

String NgaySinh = getValue(json, "NgaySinh");
String GioiTinh = getValue(json, "GioiTinh");
String DiaChi = decodeUnicode(getValue(json, "DiaChi"));
String MaLop = getValue(json, "MaLop");
String taikhoan = decodeUnicode(getValue(json, "TaiKhoan_ID"));
String HinhAnh = decodeUnicode(getValue(json, "HinhAnh"));

list.add(new HocSinh(id, ma, ten, NgaySinh, GioiTinh, DiaChi, MaLop, taikhoan, HinhAnh));

        }

        return list;
    }
    
    // ===============================
    // Tai Khoan
    // ===============================
    
    public static ArrayList<TaiKhoan> parseTaiKhoan(String json) {

        ArrayList<TaiKhoan> list = new ArrayList<>();

        if (json.contains("\"data\":[")) {

            // ARRAY
            json = getDataArray(json);
            json = removeArray(json);
            String[] objects = splitObjects(json);

            for (String obj : objects) {

                obj = cleanObject(obj);

                String id = getValue(obj, "ID");
                String tentaikhoan = decodeUnicode(getValue(obj, "TenTaiKhoan"));
                String matkhau = decodeUnicode(getValue(obj, "MatKhau"));
                String quyen = decodeUnicode(getValue(obj, "Quyen"));
                String trangthai = decodeUnicode(getValue(obj, "TrangThai"));
                
                list.add(new TaiKhoan(id, tentaikhoan, matkhau, quyen, trangthai));
            }

        } else {

            // OBJECT
            json = getDataObject(json);
            json = cleanObject(json);

            String id = getValue(json, "ID");
            String tentaikhoan = decodeUnicode(getValue(json, "TenTaiKhoan"));
            String matkhau = decodeUnicode(getValue(json, "MatKhau"));
            String quyen = decodeUnicode(getValue(json, "Quyen"));
            String trangthai = decodeUnicode(getValue(json, "TrangThai"));

            list.add(new TaiKhoan(id, tentaikhoan, matkhau, quyen, trangthai));
        }

        return list;
    }
    
    // ===============================
    // Diem
    // ===============================
    
    public static ArrayList<Diem> parseDiem(String json) {

        ArrayList<Diem> list = new ArrayList<>();

        if (json.contains("\"data\":[")) {

            // ARRAY
            json = getDataArray(json);
            json = removeArray(json);
            String[] objects = splitObjects(json);

            for (String obj : objects) {

                obj = cleanObject(obj);

                String id = getValue(obj, "ID");
                String monhoc = decodeUnicode(getValue(obj, "MonHoc"));

                String hocsinh_id = getValue(obj, "HocSinh_ID");
                double diem = Double.parseDouble(getValue(obj, "Diem"));
                
                list.add(new Diem(id, monhoc, diem, hocsinh_id));
            }

        } else {

            // OBJECT
            json = getDataObject(json);
            json = cleanObject(json);

            String id = getValue(json, "ID");
            String monhoc = decodeUnicode(getValue(json, "MonHoc"));

            String hocsinh_id = getValue(json, "HocSinh_ID");
            double diem = Double.parseDouble(getValue(json, "Diem"));

            list.add(new Diem(id, monhoc, diem, hocsinh_id));
        }

        return list;
    }

}
