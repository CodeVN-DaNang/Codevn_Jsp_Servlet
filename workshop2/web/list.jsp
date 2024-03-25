<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Generator</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            background-color: #fff;
            padding: 20px;
            margin: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        div {
            display: flex;
            align-items: center;
        }

        span {
            margin-right: 10px;
        }

        input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 60px;
        }

        button {
            padding: 8px 15px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        table {
            width: 80%;
            margin: 20px;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4caf50;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <form method="POST">
        <div>
            <span>Number of students to generate:</span>
            <input type="number" name="amount">
            <button type="submit">Generate</button>
        </div>
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Date Of Birth</th>
        </tr>
        <c:forEach items="${list}" var="student">
            <tr>
                <td>${student.student_id}</td>
                <td>${student.student_name}</td>
                <td>${student.gender}</td>
                <td>${student.dateOfBirth}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
