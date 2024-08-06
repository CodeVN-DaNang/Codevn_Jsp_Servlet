<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello List!</h1>
        <ahref="http://localhost:8080/demo_servlet/add">add new student</a>
        <form action="search" method="GET">
            <input type="text" name="search" />
            <button type="submit">Search</button>
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <td>Age</td>
                <th>Country</th>
            </tr>
            <c:forEach items="${list}" var="student" >
                <tr>
                    <th>${student.id}</th>
                    <th>${student.name}</th>
                    <th>${student.age}</th>
                    <th>${student.country}</th>
                    <th>
                        <button><a href="http://localhost:8080/demo_servlet/update?id=${student.id}">EDIT</a></button>
                        <button><a href="http://localhost:8080/demo_servlet/delete?id=${student.id}">DELETE</a></button>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
