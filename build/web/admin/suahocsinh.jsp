<%-- 
    Document   : themhocsinh
    Created on : Jan 21, 2026, 9:02:58 AM
    Author     : DEV-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.HocSinh"%>

<%@page import="java.util.ArrayList, model.TaiKhoan"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Dashboard</h1>
            <div class="row">
                <h2>Sửa học sinh</h2>
                <div class="alert alert-danger" role="alert">
                    ${thongbao}
                </div>
                <div class="col-lg-5">
                    <div class="card border-0 rounded-lg mt-5">
                    <div class="card-body">
                        <form action="<%=request.getContextPath()%>/hocsinh" method="post" enctype="multipart/form-data">
                            <div class="form-floating mb-3">
                                <input class="form-control" id="ma" value="${hs.getMa()}" required type="text" name="ma" placeholder="Mã học sinh" />
                                <label for="ma">Mã học sinh</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="ten" value="${hs.getTen()}" required type="text" name="ten" placeholder="Tên học sinh" />
                                <label for="ten">Tên học sinh</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="NgaySinh" required value="${hs.getNgaySinh()}" type="number" name="NgaySinh" placeholder="Tuổi" />
                                <label for="tuoi">Ngày Sinh</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="diem" required type="number" value="${hs.getDiem()}" name="diem" placeholder="Điểm" />
                                <label for="diem">Điểm</label>
                            </div>
                                <div class="form-floating mb-3">
                                <input class="form-control" id="hinhanh" type="file" name="hinhanh" placeholder="Hình ảnh" />
                                <label for="hinhanh">Hình ảnh</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select name="taikhoanID" class="form-control">

                                    <option value="">-- Chọn tài khoản --</option>

                                    <%
                                        HocSinh hs = (HocSinh) request.getAttribute("hs");
                                        ArrayList<TaiKhoan> ds = (ArrayList<TaiKhoan>)request.getAttribute("dsTK");
                                        for(TaiKhoan tk : ds){
                                            boolean selected = hs.getTaiKhoan_ID().equals(String.valueOf(tk.getID()));
                                        %>

                                        <option value="<%=tk.getID()%>" <%= selected ? "selected" : "" %>>
                                            Tài khoản: <%=tk.getTenTaiKhoan()%> - Quyền: <%=tk.getQuyen()%>
                                        </option>

                                        <%
                                        }
                                        %>

                                </select>
                            </div>
                            <input type="hidden" name="action" value="edit"/>
                            <input type="hidden" name="id" value="${hs.getID()}"/>
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
