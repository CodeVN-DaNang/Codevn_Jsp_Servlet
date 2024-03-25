<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Teacher</title>
</head>
<body>
    <h2>Add New Teacher</h2>
    <form action="addTeacher" method="post">
        Teacher ID: <input type="text" name="teacherId"><br>
        Name: <input type="text" name="name"><br>
        Date of Birth: <input type="text" name="dob"><br>
        Telephone: <input type="text" name="tel"><br>
        User ID: <input type="text" name="userId"><br>
        <input type="submit" value="Add Teacher">
    </form>
</body>
</html>
