<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, model.Lop"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">

            <h1 class="mt-4">Dashboard</h1>

            <div class="row">
                <div class="card mb-4">

                    <!-- HEADER -->
                    <div class="card-header d-flex justify-content-between align-items-center">
                        <div>
                            <i class="fas fa-table me-1"></i>
                            Danh sách lớp
                        </div>

                        <a class="btn btn-primary"
                           href="<%=request.getContextPath()%>/admin/themlop.jsp">
                            Thêm lớp
                        </a>
                    </div>

                    <!-- BODY -->
                    <div class="card-body">
                        <table id="datatablesSimple" class="table table-bordered">

                            <thead>
                                <tr>
                                    <th>Mã lớp</th>
                                    <th>Tên lớp</th>
                                    <th>Mã khoa</th>
                                    <th>Hành động</th>
                                </tr>
                            </thead>

                            <tbody>
<%
ArrayList<Lop> ds = (ArrayList<Lop>)request.getAttribute("dsLop");

if(ds != null && !ds.isEmpty()){
    for(Lop l : ds){
%>

                                <tr>
                                    <td><%= l.getMaLop() %></td>
                                    <td><%= l.getTenLop() %></td>
                                    <td><%= l.getMaKhoa() %></td>

                                    <!-- Hành động -->
                                    <td>
                                        <div class="btn-group">

                                            <!-- Sửa -->
                                            <a href="<%=request.getContextPath()%>/lop?action=edit&MaLop=<%=l.getMaLop()%>"
                                               class="btn btn-sm btn-warning">
                                               Sửa
                                            </a>

                                            <!-- Xóa -->
                                            <a href="<%=request.getContextPath()%>/lop?action=delete&MaLop=<%=l.getMaLop()%>"
                                               class="btn btn-sm btn-danger"
                                               onclick="return confirm('Bạn chắc chắn muốn xóa lớp này?');">
                                               Xóa
                                            </a>

                                        </div>
                                    </td>
                                </tr>

<%
    }
} else {
%>
                                <tr>
                                    <td colspan="4" class="text-center">
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

        </div>
    </main>
</div>

<%@include file="layout/footer.jsp"%>