<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chỉnh sửa Xe khách</h2>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<form:form method="post" modelAttribute="bus" action="${pageContext.request.contextPath}/bus/edit">

    <form:hidden path="id" />

    <p>
        <form:label path="licensePlate">Biển số xe:</form:label><br/>
        <form:input path="licensePlate" />
        <form:errors path="licensePlate" cssClass="error" />
    </p>

    <p>
        <form:label path="busType">Loại xe:</form:label><br/>
        <form:select path="busType">
            <form:option value="" label="-- Chọn loại xe --" />
            <form:option value="VIP" label="VIP" />
            <form:option value="LUXURY" label="LUXURY" />
            <form:option value="NORMAL" label="NORMAL" />
        </form:select>
        <form:errors path="busType" cssClass="error" />
    </p>

    <p>
        <form:label path="rowSeat">Số hàng ghế:</form:label><br/>
        <form:input path="rowSeat" type="number" min="1" />
        <form:errors path="rowSeat" cssClass="error" />
    </p>

    <p>
        <form:label path="colSeat">Số cột ghế:</form:label><br/>
        <form:input path="colSeat" type="number" min="1" />
        <form:errors path="colSeat" cssClass="error" />
    </p>

    <p>
        <form:label path="image">URL hình ảnh:</form:label><br/>
        <form:input path="image" />
    </p>

    <p>
        <button type="submit">Cập nhật</button>
        <a href="${pageContext.request.contextPath}/bus/list">Quay lại danh sách</a>
    </p>

</form:form>
</body>
</html>
