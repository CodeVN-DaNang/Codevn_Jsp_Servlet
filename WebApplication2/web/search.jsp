<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Teacher</title>
</head>
<body>
    <h2>Search Teacher</h2>
    <!-- Add your content for admin here -->
    <form action="searchTeacher" method="get">
        Search by Year of DOB: <input type="text" name="dobYear"><br>
        Keywords: <input type="text" name="keywords"><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
