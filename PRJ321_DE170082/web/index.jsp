<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Magazines</title>
    </head>
    <body>
        <h1>Magazines</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Magazine ID</th>
                    <th>Title</th>
                    <th>Publisher</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <!-- Loop through the list of magazines and display each one -->
                <c:forEach var="magazine" items="${magazines}">
                    <tr>
                        <td>${magazine.maz_id}</td>
                        <td>${magazine.magazine_title}</td>
                        <td>${magazine.publisher}</td>
                        <td>${magazine.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Button to Add New Magazine -->
        <a href="Magazine.jsp">Add New Magazine</a>
        <div>
            <p>Total requests to Magazine.jsp: ${sessionScope.count}</p>
        </div>
    </body>
</html>
