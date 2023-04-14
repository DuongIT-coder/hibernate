<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/14/2023
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <button class="button" onclick="window.location.href='ServletAddNewEmployee'" style="background-color: cyan">Add new ?</button>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${employee_list}">
        <tr>
            <td><c:out value="${list.id}"></c:out></td>
            <td><c:out value="${list.name}"></c:out></td>
            <td><c:out value="${list.age}"></c:out></td>
            <td>
                <a href="ServletDeleteEmployee?id=${list.id}">Delete</a>
                <a href="ServletUpdateEmployee?id=${list.id}">Edit</a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
