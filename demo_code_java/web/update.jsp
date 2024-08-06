<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="http://localhost:8080/demo_servlet">Back to home</a>
        <form method="POST">
            <div>
                <span>Input name:</span>
                <input type="text" name="name" value="${student.name}" />
            </div>
            <div>
                <span>Input dob:</span>
                <input type="date" name="dob" value="${student.dob}" />
            </div>
            <div>
                <span>Input age</span>
                <input type="number" name="age" value="${student.age}"/>
            </div>
            <div>
                <span>Input country</span>
                <input type="text" name="country" value="${student.country}"/>
            </div>
            <div>
                <span>Input gender</span>
                <select name="gender">
                    <option selected value="${student.gender}" >${student.gender}</option>
                    <option value="male" >male</option>
                    <option value="female" >female</option>
                    <option value="other" >other</option>
                </select>
            </div>
            <div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
