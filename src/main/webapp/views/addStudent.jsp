<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/23/2025
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students/add" method="post" modelAttribute="studentDTO">
    Tên: <input type="text" name="name" value="${studentDTO.name}"/>
    <form:errors path="name" cssClass="error"/><br/>

    Email: <input type="text" name="email" value="${studentDTO.email}"/>
    <form:errors path="email" cssClass="error"/><br/>

    Ngày sinh: <input type="date" name="dob" value="${studentDTO.dob}"/>
    <form:errors path="dob" cssClass="error"/><br/>

    <button type="submit">Thêm</button>
</form>

</body>
</html>
