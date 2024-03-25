<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Teachers</title>
</head>
<body>
    <h2>List of Teachers</h2>
    <table border="1">
        <tr>
            <th>Teacher ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Telephone</th>
            <th>User ID</th>
        </tr>
        <c:forEach items="${teachers}" var="teacher">
            <tr>
                <td>${teacher.teacherId}</td>
                <td>${teacher.name}</td>
                <td>${teacher.dob}</td>
                <td>${teacher.tel}</td>
                <td>${teacher.userId}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
