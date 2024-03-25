<%-- 
    Document   : add
    Created on : Mar 5, 2024, 10:11:48 AM
    Author     : vannhat
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <td><button><a href="http://localhost:8080/demo_codevn7/">back to list</a></button></td>
        <form object="${hello}" method="POST">
            <div>
                id: 
                <input name="id" />
            </div>
            <div>
                name: 
                <input name="name" />
            </div>
            <div>
                <button type="submit" >submit</button>
            </div>
        </form>
    </body>
</html>
