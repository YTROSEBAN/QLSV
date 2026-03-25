package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.util.ArrayList;

import model.Khoa;
import util.JsonUtil;

@WebServlet("/khoa")
public class KhoaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String makhoa = request.getParameter("MaKhoa");

        // ===== XÓA =====
        if ("delete".equals(action) && makhoa != null) {

            ApiClient.deleteKhoa(Integer.parseInt(makhoa));
            response.sendRedirect("khoa");
            return;
        }

        // ===== TRANG SỬA =====
        if ("edit".equals(action) && makhoa != null) {

            String json = ApiClient.getKhoaById(Integer.parseInt(makhoa));

            ArrayList<Khoa> ds = JsonUtil.parseKhoa(json);

            if (ds != null && ds.size() > 0) {
                request.setAttribute("khoa", ds.get(0));
            }

            request.getRequestDispatcher("admin/suakhoa.jsp")
                    .forward(request, response);
            return;
        }

        // ===== TRANG THÊM =====
        if ("add".equals(action)) {

            request.getRequestDispatcher("admin/themkhoa.jsp")
                    .forward(request, response);
            return;
        }

        // ===== DANH SÁCH =====
        String json = ApiClient.getAllKhoa();

        ArrayList<Khoa> ds = JsonUtil.parseKhoa(json);

        request.setAttribute("ds", ds);

        request.getRequestDispatcher("admin/Khoa.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        String makhoaStr = request.getParameter("MaKhoa");
        String tenkhoa = request.getParameter("TenKhoa");

        int makhoa = 0;

        if (makhoaStr != null && !makhoaStr.equals("")) {
            makhoa = Integer.parseInt(makhoaStr);
        }

        // ===== THÊM =====
        if ("add".equals(action)) {

            ApiClient.createKhoa(makhoa, tenkhoa);
        }

        // ===== SỬA =====
        if ("edit".equals(action)) {

            ApiClient.updateKhoa(makhoa, tenkhoa);
        }

        response.sendRedirect("khoa");
    }
}