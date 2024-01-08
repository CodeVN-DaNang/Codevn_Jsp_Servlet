<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" object="${student}">
            <div>
                <span>Name</span>
                <input type="text" value="${student.name}" name="name" >
            </div>
            <div>
                <span>Age</span>
                <input type="number" value="${student.age}" name="age" >
            </div>
            <div>
                <span>Date of birth</span>
                <input type="text" value="${student.dateOfBirth}" name="dateOfBirth">
            </div>
            <div>
                <span>Country</span>
                <input type="text" value="${student.country}" name="country">
            </div>
            <div>
                <span>Gender</span>
                <select name="gender">
                    <option selected value="${student.gender}">${student.gender}</option>
                    <option value="male">male</option>
                    <option value="female">female</option>
                    <option value="other">other</option>
                </select>
            </div>
            <button type="submit">save</button>
            <button type="reset">reset</button>
        </form>
    </body>
</html>
