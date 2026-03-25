<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>

<div class="container-fluid px-4">

<h2 class="mt-4">THÊM KHOA</h2>

<form action="<%=request.getContextPath()%>/khoa" method="post">

<input type="hidden" name="action" value="add">

<div class="mb-3">
<label>Mã khoa</label>
<input type="number" name="MaKhoa" class="form-control" required>
</div>

<div class="mb-3">
<label>Tên khoa</label>
<input type="text" name="TenKhoa" class="form-control" required>
</div>

<button type="submit" class="btn btn-success">
Thêm khoa
</button>

<a href="<%=request.getContextPath()%>/khoa" class="btn btn-secondary">
Quay lại
</a>

</form>

</div>

</main>
</div>

<%@include file="layout/footer.jsp"%>