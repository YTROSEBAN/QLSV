<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Khoa"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
<main>

<div class="container-fluid px-4">

<h1 class="mt-4">QUẢN LÝ KHOA</h1>

<div class="card mb-4">

<div class="card-header">

Danh sách khoa

<div class="mt-3">
<a class="btn btn-primary"
href="<%=request.getContextPath()%>/khoa?action=add">
Thêm khoa
</a>
</div>

</div>

<div class="card-body">

<table class="table table-bordered">

<thead>
<tr>
<th>Mã khoa</th>
<th>Tên khoa</th>
<th>Hành động</th>
</tr>
</thead>

<tbody>

<%
ArrayList<Khoa> ds = (ArrayList<Khoa>) request.getAttribute("ds");

if(ds != null && ds.size() > 0){

for(Khoa k : ds){
%>

<tr>

<td><%= k.getMaKhoa() %></td>
<td><%= k.getTenKhoa() %></td>

<td>

<a href="<%=request.getContextPath()%>/khoa?action=edit&MaKhoa=<%=k.getMaKhoa()%>"
class="btn btn-info btn-sm">
Sửa
</a>

<a href="<%=request.getContextPath()%>/khoa?action=delete&MaKhoa=<%=k.getMaKhoa()%>"
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
<td colspan="3" style="text-align:center;">
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