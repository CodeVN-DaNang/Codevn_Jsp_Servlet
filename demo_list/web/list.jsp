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
        <table id="candidateTable" class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Index</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="candidate" items="${candidateList}">
                    <tr>
                        <td>${candidate.candidateId}</td>
                        <td>${candidate.candidateFirstName}</td>
                        <td>${candidate.candidateLastName}</td>
                        <td>${candidate.candidateType.getTypeName()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
