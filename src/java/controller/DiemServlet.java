package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.util.ArrayList;

import model.Diem;
import model.HocSinh;
import util.JsonUtil;

@WebServlet("/diem")
public class DiemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String masv = request.getParameter("MaSV");
        String monhoc = request.getParameter("MonHoc");

        // ===== XÓA =====
        if ("delete".equals(action) && masv != null && monhoc != null) {

            ApiClient.deleteDiem(Integer.parseInt(masv), monhoc);

            response.sendRedirect("diem");
            return;
        }

        // ===== TRANG SỬA =====
        if ("edit".equals(action) && masv != null && monhoc != null) {

            String json = ApiClient.getDiemByKey(Integer.parseInt(masv), monhoc);

            ArrayList<Diem> ds = JsonUtil.parseDiem(json);

            if (!ds.isEmpty()) {
                request.setAttribute("diem", ds.get(0));
            }

            request.getRequestDispatcher("admin/suadiem.jsp")
                    .forward(request, response);
            return;
        }

        // ===== TRANG THÊM =====
        if ("add".equals(action)) {

            // Lấy danh sách học sinh từ API
            String jsonHS = ApiClient.getAllHocSinh();

            ArrayList<HocSinh> dsHS = JsonUtil.parseHocSinh(jsonHS);

            // gửi sang JSP
            request.setAttribute("dsHS", dsHS);

            request.getRequestDispatcher("admin/themdiem.jsp")
                    .forward(request, response);
            return;
        }

        // ===== DANH SÁCH =====
        String json = ApiClient.getAllDiem();

        ArrayList<Diem> ds = JsonUtil.parseDiem(json);

        request.setAttribute("ds", ds);

        request.getRequestDispatcher("admin/danhsachdiem.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        int masv = Integer.parseInt(request.getParameter("MaSV"));
        String monhoc = request.getParameter("MonHoc");
        float diem = Float.parseFloat(request.getParameter("Diem"));

        // ===== THÊM =====
        if ("add".equals(action)) {

            ApiClient.createDiem(masv, monhoc, diem);
        }

        // ===== SỬA =====
        if ("edit".equals(action)) {

            ApiClient.updateDiem(masv, monhoc, diem);
        }

        response.sendRedirect("diem");
    }
}