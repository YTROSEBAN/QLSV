<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>
<%@include file="layout/sidebar.jsp"%>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">

            <h1 class="mt-4">Thêm lớp</h1>

            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-plus"></i>
                    Thêm lớp mới
                </div>

                <div class="card-body">

                    <form action="<%=request.getContextPath()%>/lop" method="post">

                        <!-- action -->
                        <input type="hidden" name="action" value="create"/>

                        <!-- Mã lớp -->
                        <div class="mb-3">
                            <label class="form-label">Mã lớp</label>
                            <input type="number" name="MaLop" class="form-control" required>
                        </div>

                        <!-- Tên lớp -->
                        <div class="mb-3">
                            <label class="form-label">Tên lớp</label>
                            <input type="text" name="TenLop" class="form-control" required>
                        </div>

                        <!-- Mã khoa -->
                        <div class="mb-3">
                            <label class="form-label">Mã khoa</label>
                            <input type="number" name="MaKhoa" class="form-control" required>
                        </div>

                        <!-- Nút -->
                        <button type="submit" class="btn btn-success">
                            Thêm
                        </button>

                        <a href="<%=request.getContextPath()%>/lop" class="btn btn-secondary">
                            Quay lại
                        </a>

                    </form>

                </div>
            </div>

        </div>
    </main>
</div>

<%@include file="layout/footer.jsp"%>