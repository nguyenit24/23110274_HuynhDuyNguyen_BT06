<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm/Sửa Video</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<h2 class="mb-3">Thêm/Sửa Video</h2>

<form action="${pageContext.request.contextPath}/admin/videos/save"
      method="post" enctype="multipart/form-data" class="form">

    <!-- ẩn id khi edit -->
    <input type="hidden" name="id" value="${video.id}"/>

    <div class="mb-3">
        <label class="form-label">Tiêu đề</label>
        <input type="text" name="title" value="${video.title}" class="form-control" required/>
    </div>

    <div class="mb-3">
        <label class="form-label">Danh mục</label>
        <select name="categoryId" class="form-select" required>
            <c:forEach var="c" items="${categories}">
                <option value="${c.id}"
                        <c:if test="${video.category != null && video.category.id == c.id}">selected</c:if>>
                        ${c.categoryName}
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Chọn video</label>
        <input type="file" name="file" class="form-control"/>
        <c:if test="${not empty video.videopath}">
            <div class="mt-2">
                <video width="320" height="240" controls>
                    <source src="${pageContext.request.contextPath}/uploads/${video.videopath}" type="video/mp4">
                    Trình duyệt không hỗ trợ video.
                </video>
            </div>
        </c:if>
    </div>

    <button type="submit" class="btn btn-success">Lưu</button>
    <a href="${pageContext.request.contextPath}/admin/videos" class="btn btn-secondary">Hủy</a>
</form>

</body>
</html>
