package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.TaiKhoan;
import util.JsonUtil;
import util.PasswordUtil;

@WebServlet("/taikhoan")
public class TaiKhoanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String TenDangNhap = request.getParameter("TenDangNhap");

        // DELETE
        if ("delete".equals(action) && TenDangNhap != null) {

            ApiClient.deleteTaiKhoan(TenDangNhap);
            response.sendRedirect("taikhoan");
            return;
        }

        // EDIT
        if ("edit".equals(action) && TenDangNhap != null) {

            String json = ApiClient.getTaiKhoanByID(TenDangNhap);

            ArrayList<TaiKhoan> ds = JsonUtil.parseTaiKhoan(json);

            if (!ds.isEmpty()) {
                request.setAttribute("taikhoan", ds.get(0));
            }

            request.getRequestDispatcher("admin/suataikhoan.jsp")
                    .forward(request, response);

            return;
        }

        // LOAD LIST
        String json = ApiClient.getAllTaiKhoan();

        ArrayList<TaiKhoan> ds = JsonUtil.parseTaiKhoan(json);

        request.setAttribute("list", ds);

        request.getRequestDispatcher("admin/danhsachtaikhoan.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        String TenDangNhap = request.getParameter("TenDangNhap");
        String MatKhau = request.getParameter("MatKhau");
        String Quyen = request.getParameter("Quyen");

        int MaSV = 0;

        try {
            MaSV = Integer.parseInt(request.getParameter("MaSV"));
        } catch (Exception e) {
            MaSV = 0;
        }

        String hash = PasswordUtil.hashPassword(MatKhau);

        if ("add".equals(action)) {

            ApiClient.createTaiKhoan(
                    TenDangNhap,
                    hash,
                    Quyen,
                    MaSV
            );

        } else if ("edit".equals(action)) {

            ApiClient.updateTaiKhoan(
                    TenDangNhap,
                    hash,
                    Quyen,
                    MaSV
            );
        }

        response.sendRedirect("taikhoan");
    }
}