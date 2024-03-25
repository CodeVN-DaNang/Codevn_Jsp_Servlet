<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST">
            <div>
                <span>
                    Username: 
                </span>
                <input type="username" name="username" >
                <span>
                    Password 
                </span>
                <input type="password" name="password" >
            </div>
            <div>
                <button type="submit" >Login</button>
            </div>
        </form>
    </body>
</html>
