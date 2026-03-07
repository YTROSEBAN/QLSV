<%-- 
    Document   : danhsach
    Created on : Jan 21, 2026, 10:02:02 AM
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
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Danh sách tài khoản
                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/admin/themtaikhoan.jsp">Thêm tài khoản</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>Tên tài khoản</th>
                                    <th>Quyền</th>
                                    <th>Trạng thái</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Tên tài khoản</th>
                                    <th>Quyền</th>
                                    <th>Trạng thái</th>
                                    <th>Hành động</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <%
                                    ArrayList<TaiKhoan> ds = (ArrayList<TaiKhoan>)request.getAttribute("ds");
                                    for(TaiKhoan tk : ds){
                                %>
                                    <tr>
                                        <td><%= tk.getTenTaiKhoan()%></td> 
                                        <td><%= tk.getQuyen()%></td> 
                                        <td><%= tk.getTrangThai()%></td>
                                       <td>
                                            <% if (!tk.getID().equals("1")) { %>
                                                <div class="btn-group">
                                                    <a href="<%=request.getContextPath()%>/taikhoan?action=edit&id=<%=tk.getID()%>" 
                                                       class="btn btn-sm btn-warning">Sửa</a>

                                                    <a href="<%=request.getContextPath()%>/taikhoan?action=delete&id=<%=tk.getID()%>" 
                                                       class="btn btn-sm btn-danger"
                                                       onclick="return confirm('Bạn chắc chắn muốn xóa tài khoản này?');">
                                                       Xóa
                                                    </a>
                                                </div>
                                            <% } else { %>
                                                <span class="text-muted">Admin hệ thống</span>
                                            <% } %>
                                        </td>
                                    </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<%@include file="layout/footer.jsp"%>
