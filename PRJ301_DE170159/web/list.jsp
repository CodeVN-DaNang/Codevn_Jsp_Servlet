<%-- 
    Document   : list
    Created on : Feb 27, 2024, 4:15:17 PM
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
        <form action="search" method="POST" object="teacher">
            <div>
                <span>Input year to search</span>
                <input name="year" value="${year}">
            </div>
            <button type="submit">Search</button>
        </form>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Tel</th>
                    <th>Position</th>
                </tr>
                <c:forEach items="${list}" var="teacher">
                    <tr>
                        <td>${teacher.teachr_id}</td>
                        <td>${teacher.teacher_name}</td>
                        <td>${teacher.teacher_dob}</td>
                        <td>${teacher.teacher_tel}</td>
                        <td>${teacher.teacher_position}</td>
                    </tr>
                </c:forEach>z
            </table>
        </div>
        <div>
            <button ><a href="/PRJ301_DE170159/add">Add</a></button>
        </div>

    </body>
</html>
