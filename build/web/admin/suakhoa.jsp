<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">

<main>

<div class="container-fluid px-4">

<h2 class="mt-4">Sửa Khoa</h2>

<div class="row">

<div class="col-lg-5">

<div class="card border-0 rounded-lg mt-5">

<div class="card-body">

<form action="<%=request.getContextPath()%>/khoa" method="post">

<!-- Mã khoa -->

<div class="form-floating mb-3">

<input class="form-control"
type="text"
name="MaKhoa"
value="${k.MaKhoa}"
readonly>

<label>Mã khoa</label>

</div>


<!-- Tên khoa -->

<div class="form-floating mb-3">

<input class="form-control"
type="text"
name="TenKhoa"
value="${k.TenKhoa}">

<label>Tên khoa</label>

</div>


<input type="hidden" name="action" value="edit"/>

<div class="d-flex align-items-center justify-content-between mt-4 mb-0">

<a class="small"
href="<%=request.getContextPath()%>/khoa">
Quay lại
</a>

<button type="submit" class="btn btn-primary">
Cập nhật
</button>

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