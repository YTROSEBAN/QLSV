package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import model.TaiKhoan;
import util.JsonUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    String username = request.getParameter("TenDangNhap");
    String password = request.getParameter("MatKhau");
    String role = request.getParameter("role");

    String json = ApiClient.getAllTaiKhoan();
    ArrayList<TaiKhoan> dsTK = JsonUtil.parseTaiKhoan(json);

    for (TaiKhoan tk : dsTK) {

    if (tk.getTenDangNhap().equals(username)
            && tk.getMatKhau().equals(password)) {

        HttpSession session = request.getSession();
        session.setAttribute("user", username);

        response.sendRedirect("admin/index.jsp");
        return;
    }
}

    response.sendRedirect("index.html");
}
}