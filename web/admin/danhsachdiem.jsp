<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Diem"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>
<%@page import="java.net.URLEncoder"%>

<div id="layoutSidenav_content">
<main>

<div class="container-fluid px-4">

<h1 class="mt-4">Quản Lý Sinh Viên</h1>

<div class="card mb-4">

<div class="card-header">

<i class="fas fa-table me-1"></i>
Danh sách Điểm của học sinh

<div class="d-flex align-items-center justify-content-between mt-3">
<a class="btn btn-primary"
href="<%=request.getContextPath()%>/diem?action=add">
Thêm Điểm cho học sinh
</a>
</div>

</div>

<div class="card-body">

<table id="datatablesSimple" class="table table-bordered">

<thead>
<tr>
<th>Mã Sinh Viên</th>
<th>Môn Học</th>
<th>Điểm</th>
<th>Hành động</th>
</tr>
</thead>

<tbody>

<%

ArrayList<Diem> ds = (ArrayList<Diem>)request.getAttribute("ds");

if(ds != null){

for(Diem d : ds){

%>

<tr>

<td><%= d.getMaSV() %></td>

<td><%= d.getMonHoc() %></td>

<td><%= d.getDiem() %></td>

<td>

<div class="btn-group">

<a href="<%=request.getContextPath()%>/diem?action=edit&MaSV=<%=d.getMaSV()%>&MonHoc=<%=URLEncoder.encode(d.getMonHoc(), "UTF-8")%>"
class="btn btn-sm btn-warning">
Sửa
</a>

<a href="<%=request.getContextPath()%>/diem?action=delete&MaSV=<%=d.getMaSV()%>&MonHoc=<%=URLEncoder.encode(d.getMonHoc(), "UTF-8")%>"
class="btn btn-sm btn-danger"
onclick="return confirm('Bạn chắc chắn muốn xóa điểm này?');">
Xóa
</a>

</div>

</td>

</tr>

<%

}

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