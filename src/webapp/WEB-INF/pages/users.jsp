<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center">
    <a href="/users/add">Добавить пользователя</a>
</h2>
<table border="1" align="center">
    <thead>
    <tr>
        <th colspan="5" align="center">Пользователи</th>
    </tr>
    </thead>
    <tr align="center">
        <td>ID</td>
        <td>Email</td>
        <td>Password</td>
        <td>Action</td>
    </tr>
    <c:forEach var="users" items="${list}">
        <tr>
            <td>${users.id}</td>
            <td>${users.email}</td>
            <td>${users.password}</td>
            <td>
                <a href="">Изменить</a>
                <a href="/users/delete?id=${users.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
