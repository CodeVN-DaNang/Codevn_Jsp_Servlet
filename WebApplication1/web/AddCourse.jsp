<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add New Course</title>
    </head>
    <body>
        <h1>Add New Course</h1>
        <form action="AddCourseServlet" method="post">
            Course ID: <input type="text" name="courseId"><br>
            Subject: <input type="text" name="subject"><br>
            Lecturer Name: <input type="text" name="lecturerName"><br>
            Credits: <input type="number" name="credits"><br>
            <input type="submit" value="Add Course">
        </form>
        <footer>
            Total Requests: <%= getServletContext().getAttribute("requestCount")%>
        </footer>
    </body>
</html>
