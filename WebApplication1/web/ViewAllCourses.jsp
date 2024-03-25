<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>View All Courses</title>
    </head>
    <body>
        <h1>All Courses</h1>
        <table border="1">
            <tr>
                <th>Course ID</th>
                <th>Subject</th>
                <th>Lecturer Name</th>
                <th>Credits</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.subject}</td>
                    <td>${course.lecturerName}</td>
                    <td>${course.credits}</td>
                </tr>
            </c:forEach>
        </table>
        <button><a href="http://localhost:8080/WebApplication1/AddCourseServlet">Add course</a></button>
        <footer>
            Total Requests: <%= getServletContext().getAttribute("requestCount")%>
        </footer>
    </body>
</html>
