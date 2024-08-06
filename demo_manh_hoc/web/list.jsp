<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f8ff;
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 20px;
        }
        .actions {
            text-align: center;
            margin-bottom: 20px;
        }
        .actions button, .actions input[type="submit"] {
            background-color: #2980b9;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            margin: 5px;
        }
        .actions button:hover, .actions input[type="submit"]:hover {
            background-color: #3498db;
        }
        .search-box {
            text-align: center;
            margin-bottom: 20px;
        }
        .search-box input[type="text"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            margin-right: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0 auto;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table, th, td {
            border: 1px solid #bdc3c7;
        }
        th, td {
            padding: 15px;
            text-align: center;
            font-size: 16px;
        }
        th {
            background-color: #2980b9;
            color: #ffffff;
            text-transform: uppercase;
        }
        tr:nth-child(even) {
            background-color: #ecf0f1;
        }
        tr:hover {
            background-color: #d0e4f7;
        }
        .action-buttons button {
            background-color: #e74c3c;
            color: #ffffff;
            border: none;
            padding: 5px 10px;
            font-size: 14px;
            cursor: pointer;
            margin: 2px;
        }
        .action-buttons button:hover {
            background-color: #c0392b;
        }
        .action-buttons .edit {
            background-color: #f39c12;
        }
        .action-buttons .edit:hover {
            background-color: #e67e22;
        }
        @media (max-width: 600px) {
            table, th, td {
                display: block;
                width: 100%;
            }
            th, td {
                text-align: left;
                padding: 10px;
            }
            tr {
                display: flex;
                flex-direction: column;
                margin-bottom: 10px;
            }
            th {
                background-color: #3498db;
                color: #fff;
                text-align: left;
            }
        }
    </style>
</head>
<body>
    <h1>Student List</h1>
    <div class="actions">
        <button onclick="window.location.href='addStudent.jsp'">Add</button>
    </div>
    <div class="search-box">
        <form action="searchStudent.jsp" method="get">
            <input type="text" name="query" placeholder="Search by name" />
            <input type="submit" value="Search" />
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td class="action-buttons">
                        <button class="edit" onclick="window.location.href='editStudent.jsp?id=${student.id}'">Edit</button>
                        <button onclick="if(confirm('Are you sure you want to delete this student?')) window.location.href='deleteStudent.jsp?id=${student.id}'">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>