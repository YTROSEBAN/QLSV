package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import model.HocSinh;
import util.JsonUtil;

@WebServlet("/hocsinh")
public class HocSinhServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String MaSV = request.getParameter("MaSV");

        // ========================
        // XÓA SINH VIÊN
        // ========================
        if ("delete".equals(action) && MaSV != null) {

            ApiClient.deleteSinhVien(Integer.parseInt(MaSV));
            response.sendRedirect("hocsinh");
            return; 
        }

        // ========================
        // TRANG SỬA
        // ========================
        if ("edit".equals(action) && MaSV != null) {

            String json = ApiClient.getSinhVienByID(MaSV);

            ArrayList<HocSinh> ds = JsonUtil.parseHocSinh(json);

            if (!ds.isEmpty()) {
                request.setAttribute("hs", ds.get(0));
            }

            request.getRequestDispatcher("admin/suahocsinh.jsp")
                    .forward(request, response);
            return;
        }

        // ========================
        // TRANG THÊM
        // ========================
        if ("add".equals(action)) {

            request.getRequestDispatcher("admin/themhocsinh.jsp")
                    .forward(request, response);
            return;
        }

        // ========================
        // DANH SÁCH SINH VIÊN
        // ========================
        String json = ApiClient.getAllSinhVien();

        ArrayList<HocSinh> ds = JsonUtil.parseHocSinh(json);

        request.setAttribute("ds", ds);

        request.getRequestDispatcher("admin/danhsach.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

int MaSV = Integer.parseInt(request.getParameter("MaSV"));
String HoTen = request.getParameter("HoTen");
String NgaySinh = request.getParameter("NgaySinh");
String DiaChi = request.getParameter("DiaChi");
int GioiTinh = Integer.parseInt(request.getParameter("GioiTinh"));
int MaLop = Integer.parseInt(request.getParameter("MaLop"));


// ========================
// THÊM SINH VIÊN
// ========================
if ("add".equals(action)) {

    ApiClient.createSinhVien(
            MaSV,
            HoTen,
            NgaySinh,
            GioiTinh,
            DiaChi,
            MaLop
    );
}


// ========================
// SỬA SINH VIÊN
// ========================
if ("edit".equals(action)) {


    ApiClient.updateSinhVien(
            
            HoTen,
            NgaySinh,
            MaSV,
            DiaChi,
            GioiTinh,
            MaLop
    );
}


        response.sendRedirect("hocsinh");
    }
}