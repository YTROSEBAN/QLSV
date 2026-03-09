<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.HocSinh"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>

<div class="container-fluid px-4">

<h1 class="mt-4">QUẢN LÝ SINH VIÊN</h1>

<div class="card mb-4">

<div class="card-header">

Danh sách sinh viên

<div class="mt-3">
<a class="btn btn-primary"
href="<%=request.getContextPath()%>/hocsinh?action=add">
Thêm sinh viên
</a>
</div>

</div>

<div class="card-body">

<table class="table table-bordered">

<thead>
<tr>
<th>Mã sinh viên</th>
<th>Họ tên</th>
<th>Ngày sinh</th>
<th>Giới tính</th>
<th>Địa chỉ</th>
<th>Mã lớp</th>
<th>Hành động</th>
</tr>
</thead>

<tbody>

<%
ArrayList<HocSinh> ds = (ArrayList<HocSinh>) request.getAttribute("ds");

if(ds != null && ds.size() > 0){

for(HocSinh hs : ds){
%>

<tr>

<td><%= hs.getMaSV() %></td>
<td><%= hs.getHoTen() %></td>
<td><%= hs.getNgaySinh() %></td>

<td>
<%= hs.getGioiTinh() == 1 ? "Nam" : "Nữ" %>
</td>

<td><%= hs.getDiaChi() %></td>
<td><%= hs.getMaLop() %></td>

<td>

<a href="<%=request.getContextPath()%>/hocsinh?action=edit&MaSV=<%=hs.getMaSV()%>"
class="btn btn-info btn-sm">
Sửa
</a>

<a href="<%=request.getContextPath()%>/hocsinh?action=delete&MaSV=<%=hs.getMaSV()%>"
class="btn btn-danger btn-sm"
onclick="return confirm('Bạn có chắc muốn xóa không?')">
Xóa
</a>

</td>

</tr>

<%
}

}else{
%>

<tr>
<td colspan="7" style="text-align:center;">
Không có dữ liệu
</td>
</tr>

<%
}
%>

</tbody>

</table>

</div>
</div>
</div>

</main>
</div>

<%@include file="layout/footer.jsp"%>