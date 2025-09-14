<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Video</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<h2 class="mb-3">Danh sách Video</h2>
<a href="${pageContext.request.contextPath}/admin/videos/add"
   class="btn btn-primary mb-3">+ Thêm Video</a>

<table class="table table-bordered table-striped text-center align-middle">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Video</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="v" items="${videos}">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>
                <video width="200" controls>
                    <source src="${pageContext.request.contextPath}/uploads/${v.videopath}" type="video/mp4">
                </video>
                <div>
                    <a href="${pageContext.request.contextPath}/uploads/${v.videopath}">tại đây</a>
                </div>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/videos/edit/${v.id}"
                   class="btn btn-warning btn-sm">Sửa</a>
                <a href="${pageContext.request.contextPath}/admin/videos/delete/${v.id}"
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Bạn chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
