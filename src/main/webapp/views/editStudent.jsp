<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/27/2025
  Time: 7:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sửa Sinh Viên</h2>
<form:form action="/students/edit" method="post" modelAttribute="studentDTO">
    <form:hidden path="id"/>

    <label>Tên:</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/><br/>

    <label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/><br/>

    <label>Ngày sinh:</label>
    <form:input path="dob" type="date"/>
    <form:errors path="dob" cssClass="error"/><br/>

    <input type="submit" value="Cập nhật"/>
</form:form>
</body>
</html>
