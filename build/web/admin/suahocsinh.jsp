<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.HocSinh"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>

<div class="container-fluid px-4">

<h1 class="mt-4">Dashboard</h1>

<div class="row">

<h2>Sửa Sinh Viên</h2>

<div class="alert alert-danger" role="alert">
${thongbao}
</div>

<div class="col-lg-5">

<div class="card border-0 rounded-lg mt-5">

<div class="card-body">

<form action="<%=request.getContextPath()%>/hocsinh" method="post">

<div class="form-floating mb-3">
<input class="form-control" id="ma" value="${hs.maSV}" readonly type="text" name="MaSV"/>
<label for="ma">Mã sinh viên</label>
</div>

<div class="form-floating mb-3">
<input class="form-control" id="ten" value="${hs.hoTen}" required type="text" name="HoTen"/>
<label for="ten">Tên sinh viên</label>
</div>

<div class="form-floating mb-3">
<input class="form-control" id="NgaySinh" value="${hs.ngaySinh}" type="date" name="NgaySinh"/>
<label for="NgaySinh">Ngày sinh</label>
</div>

<div class="form-floating mb-3">

<select name="GioiTinh" class="form-control">

<option value="1" ${hs.gioiTinh==1?"selected":""}>Nam</option>

<option value="0" ${hs.gioiTinh==0?"selected":""}>Nữ</option>

</select>

<label>Giới tính</label>

</div>

<div class="form-floating mb-3">
<input class="form-control" id="diachi" value="${hs.diaChi}" type="text" name="DiaChi"/>
<label for="diachi">Địa chỉ</label>
</div>

<div class="form-floating mb-3">
<input class="form-control" id="malop" value="${hs.maLop}" type="number" name="MaLop"/>
<label for="malop">Mã lớp</label>
</div>

<input type="hidden" name="action" value="edit"/>

<input type="hidden" name="MaSV" value="${hs.maSV}"/>

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