<%-- 
    Document   : themhocsinh
    Created on : Jan 21, 2026, 9:02:58 AM
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
                <h2>Thêm học sinh</h2>
                <div class="alert alert-danger" role="alert">
                    ${thongbao}
                </div>
                <div class="col-lg-5">
                    <div class="card border-0 rounded-lg mt-5">
                    <div class="card-body">
                        <form action="<%=request.getContextPath()%>/hocsinh" method="post" enctype="multipart/form-data">
                            <input class="form-control" name="ma" type="text" placeholder="Mã học sinh"/>
                                <input class="form-control" name="ten" type="text" placeholder="Tên học sinh"/>

                                <input class="form-control" name="ngaySinh" type="date"/>

                                <select class="form-control" name="gioiTinh">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                </select>

                                <input class="form-control" name="diaChi" type="text" placeholder="Địa chỉ"/>
                                <input class="form-control" name="maLop" type="text" placeholder="Mã lớp"/>

                                <input class="form-control" type="file" name="hinhanh"/>

                            <div class="form-floating mb-3">
                                <select name="taikhoanID" class="form-control">

                                    <option value="">-- Chọn tài khoản --</option>

                                    <%
                                        ArrayList<TaiKhoan> ds = (ArrayList<TaiKhoan>)request.getAttribute("dsTK");
                                        for(TaiKhoan tk : ds){
                                    %>
                                        <option value="<%=tk.getID()%>">
                                            Tài khoản: <%=tk.getTenTaiKhoan()%> - Quyền: <%=tk.getQuyen()%>
                                        </option>
                                    <%}%>

                                </select>
                            </div>
                            <input type="hidden" name="action" value="add"/>
                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                <a class="small" href="<%=request.getContextPath()%>/hocsinh">Quay lại</a>
                                <button type="submit" class="btn btn-primary">Lưu</button>
                            </div>
                        </form>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </main>
</div>
<%@include file="layout/footer.jsp"%>
