<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>


<div id="layoutSidenav_content">
<main>
<div class="container-fluid px-4">

<h2 class="mt-4">Sửa Điểm</h2>

<div class="row">
<div class="col-lg-5">

<div class="card border-0 rounded-lg mt-5">
<div class="card-body">

<form action="<%=request.getContextPath()%>/diem" method="post">

<!-- Mã sinh viên (HIỂN THỊ) -->
<div class="form-floating mb-3">
<input class="form-control"
type="number"
value="${diem.maSV}"
readonly>
<label>Mã sinh viên</label>
</div>

<!-- Môn học (HIỂN THỊ) -->
<div class="form-floating mb-3">
<input class="form-control"
type="text"
value="${diem.monHoc}"
readonly>
<label>Môn học</label>
</div>

<!-- HIDDEN (QUAN TRỌNG) -->
<input type="hidden" name="MaSV" value="${diem.maSV}">
<input type="hidden" name="MonHoc" value="${diem.monHoc}">

<!-- Điểm -->
<div class="form-floating mb-3">
<input class="form-control"
type="number"
step="any"
name="Diem"
value="<fmt:formatNumber value='${diem.diem}' maxFractionDigits='2'/>"
required>
<label>Điểm</label>
</div>

<input type="hidden" name="action" value="edit"/>

<div class="d-flex align-items-center justify-content-between mt-4 mb-0">

<a class="small" href="<%=request.getContextPath()%>/diem">
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