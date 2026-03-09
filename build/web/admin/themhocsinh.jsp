<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>

<div class="container-fluid px-4">

<h2 class="mt-4">THÊM SINH VIÊN</h2>

<form action="<%=request.getContextPath()%>/hocsinh" method="post">
<input type="hidden" name="action" value="add">

<div class="mb-3">
<label>Mã sinh viên</label>
<input type="number" name="MaSV" class="form-control" required>
</div>

<div class="mb-3">
<label>Họ tên</label>
<input type="text" name="HoTen" class="form-control" required>
</div>

<div class="mb-3">
<label>Ngày sinh</label>
<input type="date" name="NgaySinh" class="form-control">
</div>

<div class="mb-3">
<label>Giới tính</label>
<select name="GioiTinh" class="form-control">
<option value="1">Nam</option>
<option value="0">Nữ</option>
</select>
</div>

<div class="mb-3">
<label>Địa chỉ</label>
<input type="text" name="DiaChi" class="form-control">
</div>

<div class="mb-3">
<label>Mã lớp</label>
<input type="number" name="MaLop" class="form-control">
</div>

<button type="submit" class="btn btn-success">
Them sinh viên
</button>

<a href="<%=request.getContextPath()%>/hocsinh" class="btn btn-secondary">
Quay lại
</a>

</form>

</div>

</main>
</div>

<%@include file="layout/footer.jsp"%>