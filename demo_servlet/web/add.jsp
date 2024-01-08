<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="POST" object="student">
            <div>
                <span>Input name: </span>
                <input name="name">
            </div>
            <div>
                <span>Input age: </span>
                <input name="age" type="number">
            </div>
            <div>
                <span>Input country: </span>
                <input name="country">
            </div>
            <div>
                <span>Input date of birth: </span>
                <input name="dateOfBirth">
            </div>
            <div>
                <span>Gender: </span>
                <select name="gender">
                    <option value="male">Male</option>
                    <option value="Female">female</option>
                    <option value="other">Other</option>
                </select>
            </div>
            <button type="submit">Add</button>
            <button type="reset">reset</button>
        </form>
    </body>
</html>
