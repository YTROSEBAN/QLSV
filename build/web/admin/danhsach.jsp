<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, model.HocSinh, model.TaiKhoan"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>
<div class="container-fluid px-4">

<h1 class="mt-4">QUẢN LÝ SINH VIÊN</h1>

<div class="card mb-4">

<div class="card-header">
<i class="fas fa-table me-1"></i>
Danh sách sinh viên

<div class="mt-3">
<a class="btn btn-primary"
href="<%=request.getContextPath()%>/hocsinh?action=add">
Thêm sinh viên
</a>
</div>

</div>

<div class="card-body">

<table class="table table-bordered" id="datatablesSimple">

<thead>
<tr>
<th>Mã sinh viên</th>
<th>Tên sinh viên</th>
<th>Ngày sinh</th>
<th>Giới tính</th>
<th>Địa chỉ</th>
<th>Hình ảnh</th>
<th>Tài khoản</th>
<th>Hành động</th>
</tr>
</thead>

<tbody>

<%
ArrayList<HocSinh> ds =
(ArrayList<HocSinh>)request.getAttribute("ds");

ArrayList<TaiKhoan> tks =
(ArrayList<TaiKhoan>)request.getAttribute("dsTK");

for(HocSinh hs : ds){
%>

<tr>

<td><%=hs.getMa()%></td>
<td><%=hs.getTen()%></td>
<td><%=hs.getNgaySinh()%></td>
<td><%=hs.getGioiTinh()%></td>
<td><%=hs.getDiaChi()%></td>

<td>
<img src="<%=request.getContextPath()%>/images/<%=hs.getHinhAnh()%>" width="60">
</td>

<td>

<%
for(TaiKhoan tk : tks){

boolean selected =
hs.getTaiKhoan_ID().equals(String.valueOf(tk.getID()));

if(selected){
%>

Tài khoản: <%=tk.getTenTaiKhoan()%>
<br>
Quyền: <%=tk.getQuyen()%>

<%
}
}
%>

</td>

<td>

<a href="<%=request.getContextPath()%>/hocsinh?action=edit&id=<%=hs.getID()%>"
class="btn btn-info btn-sm">
Sửa
</a>

<a href="<%=request.getContextPath()%>/hocsinh?action=delete&id=<%=hs.getID()%>"
class="btn btn-danger btn-sm">
Xóa
</a>

</td>

</tr>

<% } %>

</tbody>

</table>

</div>
</div>
</div>
</main>
</div>

<%@include file="layout/footer.jsp"%>