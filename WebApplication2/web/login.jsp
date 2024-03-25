<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Invalid username or password</p>
    <% } %>
    <form action="login" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        Role: <select name="role">
                <option value="user">User</option>
                <option value="admin">Admin</option>
              </select><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
