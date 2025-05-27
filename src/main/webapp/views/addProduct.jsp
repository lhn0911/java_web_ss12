<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 7:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/products/add" modelAttribute="productDTO">
    Tên: <input type="text" name="name" value="${productDTO.name}"/><br/>
    Giá: <input type="number" step="0.01" name="price" value="${productDTO.price}"/><br/>
    Số lượng: <input type="number" name="quantity" value="${productDTO.quantity}"/><br/>
    Hình ảnh (URL): <input type="text" name="image" value="${productDTO.image}"/><br/>
    <button type="submit">Lưu</button>
</form>

</body>
</html>
