<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="label.title" /></title>
</head>
<body>

    <a href="/cars?locale=en">English</a>
    <a href="/cars?locale=ru">Ru</a>

<table border="1" align="center">
    <thead>
    <tr>
        <th colspan="3" align="center"><spring:message code="label.title" /></th>
    </tr>
    </thead>
    <tr>
        <td>ID</td>
        <td>name</td>
        <td>series</td>
    </tr>
    <c:forEach var="cars" items="${cars}">
    <tr>
        <td>${cars.id}</td>
        <td>${cars.name}</td>
        <td>${cars.series}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
