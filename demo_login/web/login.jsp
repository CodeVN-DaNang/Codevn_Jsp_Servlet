<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" >
            <div>
                <span>Username:</span>
                <input type="text" name="username" >
            </div>
            <div>
                <span>Password: </span>
                <input type="password" name="password" >
            </div>
            <div>
                <input type="checkbox" name="saveLogin" value="save">  Save account
            </div>
            <button type="submit">Login</button>
              <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/demo_login/login-google&response_type=code
    &client_id=1037591538096-9qm6qp8vu779jolan0eb2o02an27r1f3.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
            <div>${msg}</div>

        </form>
    </body>
</html>
