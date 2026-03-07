<%-- 
    Document   : danhsach
    Created on : Jan 21, 2026, 10:02:02 AM
    Author     : DEV-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, model.Diem, model.HocSinh"%>
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
                        Danh sách Điểm của học sinh
                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/diem?action=add">Thêm Điểm cho học sinh</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>Môn học</th>
                                    <th>Điểm</th>
                                    <th>Học sinh</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Môn học</th>
                                    <th>Điểm</th>
                                    <th>Học sinh</th>
                                    <th>Hành động</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <%
                                    ArrayList<Diem> ds = (ArrayList<Diem>)request.getAttribute("ds");
                                    for(Diem d : ds){
                                %>
                                    <tr>
                                        <td><%= d.getMonHoc()%></td> 
                                        <td><%= d.getDiemTB()%></td> 
                                        <td>
                                            <%
                                                ArrayList<HocSinh> dshs = (ArrayList<HocSinh>)request.getAttribute("dsHS");
                                                for(HocSinh hs : dshs){
                                                    boolean selected = d.getHocSinh_ID().equals(String.valueOf(hs.getID()));
                                                %>

                                                <%if(selected){%>Mã HS: <%=hs.getMa()%> - Tên: <%=hs.getTen()%><%}%>

                                                <%
                                                }
                                                %>
                                        </td>
                                       <td>
                                            <div class="btn-group">
                                                <a href="<%=request.getContextPath()%>/diem?action=edit&id=<%=d.getID()%>" 
                                                   class="btn btn-sm btn-warning">Sửa</a>

                                                <a href="<%=request.getContextPath()%>/diem?action=delete&id=<%=d.getID()%>" 
                                                   class="btn btn-sm btn-danger"
                                                   onclick="return confirm('Bạn chắc chắn muốn xóa môn học này?');">
                                                   Xóa
                                                </a>
                                            </div>
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
