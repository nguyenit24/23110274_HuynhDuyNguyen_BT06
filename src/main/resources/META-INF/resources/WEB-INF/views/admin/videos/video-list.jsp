<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Video</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<form class="d-flex mb-3" action="${pageContext.request.contextPath}/admin/categories/videos/${category.id}" method="get">
    <input class="form-control me-2" type="search" placeholder="Search by title" aria-label="Search" name="keyword">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>

<h2 class="mb-3">Danh sách Video</h2>
<a href="${pageContext.request.contextPath}/admin/videos/add"
   class="btn btn-primary mb-3">+ Thêm Video</a>


<table class="table table-bordered table-striped text-center align-middle">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>

        <th>Danh mục</th>
        <th>Video</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="v" items="${videos}">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>${v.category.categoryName}</td>
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
