<%-- 
    Document   : info
    Created on : Jan 15, 2026, 10:09:54 AM
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
                <strong>Diện tích: ${dientich} </strong><br>
                <strong>Chu vi: ${chuvi} </strong><br>
                <a href="<%=request.getContextPath()%>/admin">Quay lại</a>
            </div>
        </div>
    </main>
</div>
<%@include file="layout/footer.jsp"%>
