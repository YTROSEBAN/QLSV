<%-- 
    Document   : sidebar
    Created on : Jan 15, 2026, 8:44:12 AM
    Author     : DEV-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Home</div>
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Quản lý sinh viên
                    </a>
                    <div class="sb-sidenav-menu-heading">Danh sách</div>
                    <a class="nav-link" href="<%=request.getContextPath()%>/taikhoan">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                        Tài Khoản
                    </a>
                    <a class="nav-link" href="<%=request.getContextPath()%>/hocsinh">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Sinh Viên
                    </a>
                        
                    <a class="nav-link" href="<%=request.getContextPath()%>/diem">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Kết Qủa
                    </a>
                        <a class="nav-link" href="<%=request.getContextPath()%>/diem">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Lớp
                    </a>
                        <a class="nav-link" href="<%=request.getContextPath()%>/diem">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Khoa
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">CNTT</div>
                CIT2431
            </div>
        </nav>
</div>
                   

