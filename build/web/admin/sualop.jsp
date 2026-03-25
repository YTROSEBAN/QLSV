<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Lop, java.util.ArrayList, model.Khoa"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<%
    Lop lop = (Lop) request.getAttribute("lop");
    ArrayList<Khoa> dsKhoa = (ArrayList<Khoa>) request.getAttribute("dsKhoa");
%>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">

            <h1 class="mt-4">Sửa lớp</h1>

            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-edit"></i> Cập nhật lớp
                </div>

                <div class="card-body">

                    <form action="<%=request.getContextPath()%>/lop" method="post">

                        <input type="hidden" name="action" value="update"/>

                        <!-- Mã lớp (KHÔNG CHO SỬA) -->
                        <div class="mb-3">
                            <label class="form-label">Mã lớp</label>
                            <input type="number" name="MaLop"
                                   class="form-control"
                                   value="<%=lop.getMaLop()%>" readonly>
                        </div>

                        <!-- Tên lớp -->
                        <div class="mb-3">
                            <label class="form-label">Tên lớp</label>
                            <input type="text" name="TenLop"
                                   class="form-control"
                                   value="<%=lop.getTenLop()%>" required>
                        </div>

                        <!-- Khoa -->
                        <div class="mb-3">
                            <label class="form-label">Khoa</label>
                            <select name="MaKhoa" class="form-control" required>

                                <%
                                    if(dsKhoa != null){
                                        for(Khoa k : dsKhoa){
                                            String selected = (k.getMaKhoa() == lop.getMaKhoa()) ? "selected" : "";
                                %>
                                    <option value="<%=k.getMaKhoa()%>" <%=selected%>>
                                        <%=k.getTenKhoa()%>
                                    </option>
                                <%
                                        }
                                    }
                                %>

                            </select>
                        </div>

                        <!-- BUTTON -->
                        <button type="submit" class="btn btn-warning">
                            Cập nhật
                        </button>

                        <a href="<%=request.getContextPath()%>/lop"
                           class="btn btn-secondary">
                           Quay lại
                        </a>

                    </form>

                </div>
            </div>

        </div>
    </main>
</div>

<%@include file="layout/footer.jsp"%>