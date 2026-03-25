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

        request.setCharacterEncoding("UTF-8");

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

            int m = Integer.parseInt(masv);

            String json = ApiClient.getDiemByKey(m, monhoc);

            ArrayList<Diem> ds = JsonUtil.parseDiem(json);

            Diem diemChon = null;

            if (ds != null) {
                for (Diem d : ds) {
                    if (d.getMaSV() == m && d.getMonHoc().equals(monhoc)) {
                        diemChon = d;
                        break;
                    }
                }
            }

            request.setAttribute("diem", diemChon);

            request.getRequestDispatcher("admin/suadiem.jsp")
                    .forward(request, response);
            return;
        }

        // ===== TRANG THÊM =====
        if ("add".equals(action)) {

            String jsonHS = ApiClient.getAllHocSinh();

            ArrayList<HocSinh> dsHS = JsonUtil.parseHocSinh(jsonHS);

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
        double diem = Double.parseDouble(request.getParameter("Diem"));

        // ===== THÊM =====
        if ("add".equals(action)) {
            ApiClient.createDiem(masv, monhoc, (float) diem);
        }

        // ===== SỬA =====
        if ("edit".equals(action)) {
            ApiClient.updateDiem(masv, monhoc, (float) diem);
        }

        response.sendRedirect("diem");
    }
}