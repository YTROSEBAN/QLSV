package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.TaiKhoan;
import util.JsonUtil;
import util.PasswordUtil;

@WebServlet(name = "TaiKhoanServlet", urlPatterns = {"/taikhoan"})
public class TaiKhoanServlet extends HttpServlet {

    // ================================
    // GET - LOAD / DELETE / EDIT
    // ================================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        // DELETE
        if ("delete".equals(action) && id != null) {

            ApiClient.deleteTaiKhoan(Integer.parseInt(id));

            response.sendRedirect("taikhoan");
            return;
        }

        // EDIT - LOAD 1 RECORD
        if ("edit".equals(action) && id != null) {

            String json = ApiClient.getTaiKhoanByID(id);

            ArrayList<TaiKhoan> ds = JsonUtil.parseTaiKhoan(json);

            request.setAttribute("tk", ds.get(0));

            request.getRequestDispatcher("admin/suataikhoan.jsp")
                    .forward(request, response);

            return;
        }

        // LOAD DANH SÁCH
        String json = ApiClient.getAllTaiKhoan();

        ArrayList<TaiKhoan> ds = JsonUtil.parseTaiKhoan(json);

        request.setAttribute("ds", ds);

        request.getRequestDispatcher("admin/danhsachtaikhoan.jsp")
                .forward(request, response);
    }

    // ================================
    // POST - ADD / UPDATE
    // ================================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String quyen = request.getParameter("quyen");
        String trangthai = request.getParameter("trangthai");

        // ADD
        if ("add".equals(action)) {
            String hashMatKhau = PasswordUtil.hashPassword(password);
            ApiClient.createTaiKhoan(
                    username,
                    hashMatKhau,
                    quyen,
                    trangthai
            );
        }

        // UPDATE
        if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String hashMatKhau = "";
            if(!password.isEmpty()){
                hashMatKhau = PasswordUtil.hashPassword(password);
            }else{
                String json = ApiClient.getTaiKhoanByID(request.getParameter("id"));
                ArrayList<TaiKhoan> ds = JsonUtil.parseTaiKhoan(json);
                hashMatKhau = ds.get(0).getMatKhau();
            }
            ApiClient.updateTaiKhoan(
                    id,
                    username,
                    hashMatKhau,
                    quyen,
                    trangthai
            );
        }

        response.sendRedirect("taikhoan");
    }

}