<%-- 
    Document   : normalSuccess
    Created on : Mar 1, 2024, 10:56:13 PM
    Author     : vannhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Normal!</h1>
        <div>
            Name: ${username}
        </div>
        <div>
            Password: ${password}
        </div>
        <div>
            Role: ${role}
        </div>
        
        
        <button><a href="http://localhost:8080/demo_login/LoginServlet/logout" style="text-decoration: none">LOGOUT</a></button>
    </body>
</html>
