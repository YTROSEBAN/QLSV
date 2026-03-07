/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.HocSinh;
import controller.ApiClient;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import model.TaiKhoan;
import util.JsonUtil;
import util.FileUtil;
/**
 *
 * @author DEV-PC
 */
@WebServlet(name = "HocSinhServlet", urlPatterns = {"/hocsinh"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 5,   // 5MB
    maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class HocSinhServlet extends HttpServlet {
    //public ArrayList<HocSinh> ds = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HocSinhServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HocSinhServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // ================================
    // GET - HIỂN THỊ DANH SÁCH / DELETE / EDIT
    // ================================
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

        // EDIT - lấy dữ liệu từ API
        if ("edit".equals(action) && id != null) {
            String json = ApiClient.getHocSinhByID(id);
            ArrayList<HocSinh> ds = JsonUtil.parseHocSinh(json);
            request.setAttribute("hs", ds.get(0));
            // load danh sách tài khoản
            String jsonTK = ApiClient.getAllTaiKhoan();

            ArrayList<TaiKhoan> dsTK = JsonUtil.parseTaiKhoan(jsonTK);

            request.setAttribute("dsTK", dsTK);
            
            request.getRequestDispatcher("admin/suahocsinh.jsp")
                    .forward(request, response);

            return;
        }
        // MỞ TRANG THÊM
        if ("add".equals(action)) {

            // load danh sách tài khoản
            String jsonTK = ApiClient.getAllTaiKhoan();

            ArrayList<TaiKhoan> dsTK = JsonUtil.parseTaiKhoan(jsonTK);

            request.setAttribute("dsTK", dsTK);
            request.getRequestDispatcher("admin/themhocsinh.jsp")
                    .forward(request, response);

            return;
        }
        // LOAD DANH SÁCH
        String json = ApiClient.getAllHocSinh();
        ArrayList<HocSinh> ds = JsonUtil.parseHocSinh(json);
        request.setAttribute("ds", ds);
        
        // load danh sách tài khoản
        String jsonTK = ApiClient.getAllTaiKhoan();
        ArrayList<TaiKhoan> dsTK = JsonUtil.parseTaiKhoan(jsonTK);

        request.setAttribute("dsTK", dsTK);
        request.getRequestDispatcher("admin/danhsach.jsp")
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
    // ================================
    // POST - ADD / UPDATE
    // ================================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");


String ma = request.getParameter("ma");
String ten = request.getParameter("ten");
String NgaySinh = request.getParameter("NgaySinh");
String DiaChi = request.getParameter("DiaChi");
String MaLop = request.getParameter("MaLop");

String GioiTinhRaw = request.getParameter("GioiTinh");
String GioiTinh = "1".equals(GioiTinhRaw) ? "Nam" : "Nữ";

String taikhoan = request.getParameter("taikhoan_ID");

int taiKhoanID = 1;

if(taikhoan != null && !taikhoan.equals("")){
    taiKhoanID = Integer.parseInt(taikhoan);
}

        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        String randomName = "";
        
        Part filepart = request.getPart("hinhanh");
        if(filepart != null){
            String TenHinhAnh = filepart.getSubmittedFileName();
            randomName = FileUtil.getRandomFileName(TenHinhAnh);
            String rootPath = getServletContext().getRealPath("");
            File imagesDir = new File(rootPath, "images");

            if (!imagesDir.exists()) {
                imagesDir.mkdirs();
            }
            String fullPath = new File(imagesDir, randomName).getAbsolutePath();
            filepart.write(fullPath);
            System.out.println("Saved: " + fullPath);
        }
        
        // ADD
        if ("add".equals(action)) {

    ApiClient.createHocSinh(
        ma,
        ten,
        NgaySinh,
        GioiTinh,
        DiaChi,
        MaLop,
        taiKhoanID,
        randomName
);


}


        // UPDATE
        if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String json = ApiClient.getHocSinhByID(request.getParameter("id"));
            ArrayList<HocSinh> hs = JsonUtil.parseHocSinh(json);
            if(randomName.isEmpty()){
                randomName = hs.get(0).getHinhAnh();
            }
            ApiClient.updateHocSinh(
        id,
        ma,
        ten,
        NgaySinh,
        GioiTinh,
        DiaChi,
        MaLop,
        taiKhoanID,
        randomName
);
}

        response.sendRedirect("hocsinh");
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
