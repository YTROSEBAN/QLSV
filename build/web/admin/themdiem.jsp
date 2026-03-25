<%-- 
    Document   : themhocsinh
    Created on : Jan 21, 2026, 9:02:58 AM
    Author     : DEV-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList, model.HocSinh"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>
<div class="container-fluid px-4">

<h1 class="mt-4">Dashboard</h1>

<div class="row">
<h2>Thêm Điểm</h2>

<div class="col-lg-5">
<div class="card border-0 rounded-lg mt-5">
<div class="card-body">

<form action="<%=request.getContextPath()%>/diem" method="post">
    <div class="form-floating mb-3">


</div>


<div class="form-floating mb-3">
<input class="form-control" id="monhoc" required type="text" name="MonHoc" placeholder="Môn học" />
<label for="monhoc">Môn học</label>
</div>

<div class="form-floating mb-3">
<input class="form-control" id="diem" required type="number" step="0.1" name="Diem" placeholder="Điểm trung bình" />
<label for="diem">Điểm</label>
</div>

<!-- Học sinh -->
<div class="form-floating mb-3">

<select name="MaSV" class="form-control" required>
    <option value="" disabled selected>-- Chọn học sinh --</option>

<%
ArrayList<HocSinh> ds = (ArrayList<HocSinh>)request.getAttribute("dsHS");

if(ds != null){
for(HocSinh hs : ds){
%>

<option value="<%=hs.getMaSV()%>">
Mã SV: <%=hs.getMaSV()%> - Tên: <%=hs.getHoTen()%>
</option>

<%
}
}
%>


</select>

</div>

<input type="hidden" name="action" value="add"/>

<div class="d-flex align-items-center justify-content-between mt-4 mb-0">
<a class="small" href="<%=request.getContextPath()%>/diem">Quay lại</a>
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