package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.util.ArrayList;
import model.Lop;
import util.JsonUtil;

@WebServlet("/lop")
public class LopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String MaLop = request.getParameter("MaLop");

        // DELETE
        if ("delete".equals(action) && MaLop != null) {
            ApiClient.deleteLop(Integer.parseInt(MaLop));
            response.sendRedirect("lop");
            return;
        }

        // EDIT PAGE
        if ("edit".equals(action) && MaLop != null) {

            String json = ApiClient.getLopByID(MaLop);
            ArrayList<Lop> ds = JsonUtil.parseLop(json);

            if (!ds.isEmpty()) {
                request.setAttribute("lop", ds.get(0));
            }

            request.getRequestDispatcher("admin/sualop.jsp")
                    .forward(request, response);
            return;
        }

        // ADD PAGE
        if ("add".equals(action)) {
            request.getRequestDispatcher("admin/themlop.jsp")
                    .forward(request, response);
            return;
        }

        // LIST
        String json = ApiClient.getAllLop();
        ArrayList<Lop> ds = JsonUtil.parseLop(json);

        request.setAttribute("ds", ds);

        request.getRequestDispatcher("admin/lop.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        int MaLop = request.getParameter("MaLop") == null || request.getParameter("MaLop").isEmpty()
                ? 0 : Integer.parseInt(request.getParameter("MaLop"));

        String TenLop = request.getParameter("TenLop");
        int MaKhoa = Integer.parseInt(request.getParameter("MaKhoa"));

        // ADD
        if ("add".equals(action)) {
            ApiClient.createLop(TenLop, MaKhoa);
        }

        // EDIT
        if ("edit".equals(action)) {
            ApiClient.updateLop(MaLop, TenLop, MaKhoa);
        }

        response.sendRedirect("lop");
    }
}