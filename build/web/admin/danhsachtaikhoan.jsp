<%-- 
    Document   : danhsach
    Created on : Jan 21, 2026
    Author     : DEV-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, model.TaiKhoan"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">

            <h1 class="mt-4">Dashboard</h1>

            <div class="row">
                <div class="card mb-4">

                    <!-- HEADER -->
                    <div class="card-header d-flex justify-content-between align-items-center">
                        <div>
                            <i class="fas fa-table me-1"></i>
                            Danh sách tài khoản
                        </div>

                        <a class="btn btn-primary"
                           href="<%=request.getContextPath()%>/admin/themtaikhoan.jsp">
                            Thêm tài khoản
                        </a>
                    </div>

                    <!-- BODY -->
                    <div class="card-body">
                        <table id="datatablesSimple" class="table table-bordered">

                            <thead>
                                <tr>
                                    <th>Tên tài khoản</th>
                                    <th>Mã SV</th>
                                    <th>Quyền</th>
                                    <th>Trạng thái</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>

                            <tbody>
<%
ArrayList<TaiKhoan> ds = (ArrayList<TaiKhoan>)request.getAttribute("ds");

if(ds != null && !ds.isEmpty()){
    for(TaiKhoan tk : ds){
%>

                                <tr>
                                    <td><%= tk.getTenDangNhap() %></td>
                                    <td><%= tk.getMaSV() %></td>
                                    <td><%= tk.getQuyen() %></td>

                                    <!-- Trạng thái -->
                                    <td>
                                        <span class="badge bg-success">Hoạt động</span>
                                    </td>

                                    <!-- Hành động -->
                                    <td>
                                        <div class="btn-group">

                                            <!-- Sửa -->
                                            <a href="<%=request.getContextPath()%>/taikhoan?action=edit&TenDangNhap=<%=tk.getTenDangNhap()%>"
                                               class="btn btn-sm btn-warning">
                                               Sửa
                                            </a>

                                            <!-- Xóa -->
                                            <a href="<%=request.getContextPath()%>/taikhoan?action=delete&TenDangNhap=<%=tk.getTenDangNhap()%>"
                                               class="btn btn-sm btn-danger"
                                               onclick="return confirm('Bạn chắc chắn muốn xóa tài khoản này?');">
                                               Xóa
                                            </a>

                                        </div>
                                    </td>
                                </tr>

<%
    }
} else {
%>
                                <tr>
                                    <td colspan="5" class="text-center">
                                        Không có dữ liệu
                                    </td>
                                </tr>
<%
}
%>

                            </tbody>

                        </table>
                    </div>

                </div>
            </div>

        </div>
    </main>
</div>

<%@include file="layout/footer.jsp"%>