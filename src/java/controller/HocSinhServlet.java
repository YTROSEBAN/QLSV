
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

@WebServlet(name = "HocSinhServlet", urlPatterns = {"/hocsinh"})
public class HocSinhServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        // DELETE
        if ("delete".equals(action) && id != null) {

            ApiClient.deleteHocSinh(Integer.parseInt(id));
            response.sendRedirect("hocsinh");
            return;
        }

        // EDIT PAGE
        if ("edit".equals(action) && id != null) {

            String json = ApiClient.getHocSinhByID(id);

            ArrayList<HocSinh> ds = JsonUtil.parseHocSinh(json);

            if (!ds.isEmpty()) {
                request.setAttribute("hs", ds.get(0));
            }

            request.getRequestDispatcher("admin/suahocsinh.jsp")
                    .forward(request, response);
            return;
        }

        // ADD PAGE
        if ("add".equals(action)) {

            request.getRequestDispatcher("admin/themhocsinh.jsp")
                    .forward(request, response);
            return;
        }

        // LIST
        String json = ApiClient.getAllHocSinh();

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

        
        String MaSV = request.getParameter("MaSV");
        String HoTen = request.getParameter("HoTen");
        String NgaySinh = request.getParameter("NgaySinh");
        int GioiTinh = Integer.parseInt(request.getParameter("GioiTinh"));
        String DiaChi = request.getParameter("DiaChi");
        int MaLop = Integer.parseInt(request.getParameter("MaLop"));
   


System.out.println("MaSV: " + MaSV);
System.out.println("HoTen: " + HoTen);
System.out.println("NgaySinh: " + NgaySinh);
System.out.println("GioiTinh: " + GioiTinh);
System.out.println("DiaChi: " + DiaChi);
System.out.println("MaLop: " + MaLop);

        // ADD
        if ("add".equals(action)) {

            ApiClient.createHocSinh(
                    MaSV,
                    HoTen,
                    NgaySinh,
                    GioiTinh,
                    DiaChi,
                    MaLop
            );
        }
        Object id = null;

        // UPDATE
        if ("edit".equals(action) && id != null) {

            ApiClient.updateHocSinh(
                    Integer.parseInt((String) id),
                    MaSV,
                    HoTen,
                    NgaySinh,
                    GioiTinh,
                    DiaChi,
                    MaLop
            );
        }

        response.sendRedirect("hocsinh");
    }
}
