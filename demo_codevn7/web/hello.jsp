<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            color: #333;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        .button a {
            color: white;
            text-decoration: none;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Student List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="student" varStatus="iterStat">
                <tr>
                    <td>${iterStat.index + 1}</td>
                    <td>${student.name}</td>
                    <td>${student.typeHello.typeHelloName}</td>
                    <td>
                        <button class="button"><a href="http://localhost:8080/demo_codevn7/delete?id=${student.id}">Delete</a></button>
                        <button class="button"><a href="http://localhost:8080/demo_codevn7/update?id=${student.id}">Edit</a></button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <button class="button"><a href="http://localhost:8080/demo_codevn7/add">Add New</a></button>
</body>
</html>
