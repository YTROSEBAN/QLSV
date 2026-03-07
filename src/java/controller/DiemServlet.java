/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Diem;
import model.HocSinh;
import util.JsonUtil;
import util.PasswordUtil;

/**
 *
 * @author DEV-PC
 */
@WebServlet(name = "DiemServlet", urlPatterns = {"/diem"})
public class DiemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        // MỞ TRANG THÊM
        if ("add".equals(action)) {

            // load danh sách học sinh
            String jsonHS = ApiClient.getAllHocSinh();
            ArrayList<HocSinh> dsHS = JsonUtil.parseHocSinh(jsonHS);
            request.setAttribute("dsHS", dsHS);
            request.getRequestDispatcher("admin/themdiem.jsp")
                    .forward(request, response);

            return;
        }
        // DELETE
        if ("delete".equals(action) && id != null) {

            ApiClient.deleteDiem(Integer.parseInt(id));

            response.sendRedirect("diem");
            return;
        }

        // EDIT - LOAD 1 RECORD
        if ("edit".equals(action) && id != null) {

            String json = ApiClient.getDiemByID(id);

            ArrayList<Diem> ds = JsonUtil.parseDiem(json);

            request.setAttribute("tk", ds.get(0));
            // load danh sách học sinh
            String jsonHS = ApiClient.getAllHocSinh();
            ArrayList<HocSinh> dsHS = JsonUtil.parseHocSinh(jsonHS);
            request.setAttribute("dsHS", dsHS);
            request.getRequestDispatcher("admin/suadiem.jsp")
                    .forward(request, response);

            return;
        }

        // LOAD DANH SÁCH
        String json = ApiClient.getAllDiem();

        ArrayList<Diem> ds = JsonUtil.parseDiem(json);

        request.setAttribute("ds", ds);
        // load danh sách học sinh
        String jsonHS = ApiClient.getAllHocSinh();
        ArrayList<HocSinh> dsHS = JsonUtil.parseHocSinh(jsonHS);
        request.setAttribute("dsHS", dsHS);
        request.getRequestDispatcher("admin/danhsachdiem.jsp")
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        String monhoc = request.getParameter("monhoc");
        String diem = request.getParameter("diem");
        String hocsinh_id = request.getParameter("hocsinhID");

        // ADD
        if ("add".equals(action)) {
            ApiClient.createDiem(
                    monhoc,
                    Double.parseDouble(diem),
                    Integer.parseInt(hocsinh_id)
            );
        }

        // UPDATE
        if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            ApiClient.updateDiem(
                    id,
                    monhoc,
                    Double.parseDouble(diem),
                    Integer.parseInt(hocsinh_id)
            );
        }

        response.sendRedirect("diem");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
