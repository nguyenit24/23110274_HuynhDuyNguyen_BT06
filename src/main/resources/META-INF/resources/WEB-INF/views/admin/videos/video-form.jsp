<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm/Sửa Video</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<h2 class="mb-3">Thêm/Sửa Video</h2>

<form:form action="${pageContext.request.contextPath}/admin/videos/save"
           method="post" modelAttribute="video"
           enctype="multipart/form-data" class="form">
    <form:hidden path="id"/>

    <div class="mb-3">
        <label class="form-label">Tiêu đề</label>
        <form:input path="title" cssClass="form-control"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Chọn video</label>
        <input type="file" name="file" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-success">Lưu</button>
    <a href="${pageContext.request.contextPath}/admin/videos" class="btn btn-secondary">Hủy</a>
</form:form>

</body>
</html>
