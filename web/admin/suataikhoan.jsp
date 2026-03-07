<%-- 
    Document   : themhocsinh
    Created on : Jan 21, 2026, 9:02:58 AM
    Author     : DEV-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Dashboard</h1>
            <div class="row">
                <h2>Sửa tài khoản</h2>
                <div class="col-lg-5">
                    <div class="card border-0 rounded-lg mt-5">
                    <div class="card-body">
                        <form action="<%=request.getContextPath()%>/taikhoan" method="post">
                            <div class="form-floating mb-3">
                                <input class="form-control" id="username" required value="${tk.getTenTaiKhoan()}" type="text" name="username" placeholder="Tên tài khoản" />
                                <label for="username">Tên tài khoản</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" id="password"  type="password" name="password" placeholder="Mật khẩu" />
                                <label for="ten">Mật khẩu mới</label>
                            </div>
                            
                            <!-- Quyền -->
                            <div class="form-floating mb-3">
                                <select class="form-select" id="quyen" name="quyen"  required>
                                    <option value="">-- Chọn quyền --</option>
                                    <option value="admin" 
                                        ${tk.getQuyen() == 'admin' ? 'selected' : ''}>
                                        Admin
                                    </option>

                                    <option value="teacher"
                                        ${tk.getQuyen() == 'teacher' ? 'selected' : ''}>
                                        Giáo viên
                                    </option>

                                    <option value="student"
                                        ${tk.getQuyen() == 'student' ? 'selected' : ''}>
                                        Học sinh
                                    </option>
                                </select>
                                <label for="quyen">Quyền</label>
                            </div>

                            <!-- Trạng thái -->
                            <div class="form-floating mb-3">
                                <select class="form-select" id="trangthai" name="trangthai" value="${tk.getTrangThai()}" required>
                                    <option value="">-- Chọn trạng thái --</option>
                                    <option value="on"
                                        ${tk.getTrangThai() == 'on' ? 'selected' : ''}>
                                        Hoạt động
                                    </option>

                                    <option value="off"
                                        ${tk.getTrangThai() == 'off' ? 'selected' : ''}>
                                        Khóa
                                    </option>
                                </select>
                                <label for="trangthai">Trạng thái</label>
                            </div>
                            <input type="hidden" name="action" value="edit"/>
                            <input type="hidden" name="id" value="${tk.getID()}"/>
                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                <a class="small" href="<%=request.getContextPath()%>/taikhoan">Quay lại</a>
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
