<%-- 
    Document   : list
    Created on : Dec 27, 2023, 10:30:04 AM
    Author     : vannhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Country</th>
                <th>Male</th>
            </tr>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.country}</td>
                    <td>${student.gender}</td>
                    <td>
                        <button name="id"><a href="/demo_delete/delete?id=<c:out value='${student.id}'/>" style="text-decoration: none; color: black" href="">delete</a></button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
