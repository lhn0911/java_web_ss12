<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="/products/add">Thêm mới</a>
<table border="1">
    <tr>
        <th>ID</th><th>Tên</th><th>Giá</th><th>Số lượng</th><th>Hình ảnh</th><th>Hành động</th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td><img src="${p.image}" width="50"/></td>
            <td>
                <a href="/products/edit/${p.id}">Sửa</a> |
                <a href="/products/delete/${p.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
