<%-- 
    Document   : list
    Created on : Dec 27, 2023, 10:30:04 AM
    Author     : vannhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 15px;
            text-align: center;
            width: 100%;
        }

        nav {
            background-color: #343a40;
            padding: 10px;
            width: 100%;
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px 15px;
            margin: 0 10px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        nav a:hover {
            background-color: #555;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            margin-top: 20px;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #e0e0e0;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        button {
            background-color: #dc3545;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #c82333;
        }

        a {
            text-decoration: none;
            color: #343a40;
        }
    </style>
</head>
<body>
    <header>
        <h1>Student List</h1>
    </header>

    <nav>
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
    </nav>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>Male</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.country}</td>
                <td>${student.gender}</td>
                <td>
                    <button name="id"><a href="/demo_delete/delete?id=<c:out value='${student.id}'/>">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
