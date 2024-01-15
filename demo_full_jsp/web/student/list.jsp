<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
         form {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }

        input[type="text"] {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-right: 5px;
            font-size: 16px;
        }

        button[type="submit"] {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #2980b9;
        }
        

        button:hover {
            background-color: #45a049;
        }

        a {
            text-decoration: none;
            color: white;
        }

        button a {
            color: white;
        }

        button.edit {
            background-color: #3498db;
        }

        button.edit:hover {
            background-color: #2980b9;
        }

        button.delete {
            background-color: #e74c3c;
        }

        button.delete:hover {
            background-color: #c0392b;
        }

        button.add {
            background-color: #3498db;
            margin-top: 20px;
            margin-bottom: 10px;
        }

        button.add:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h2>Student List</h2>
    <form action="/codevn5/student/search" method="get">
        <input type="text" name="query" placeholder="Enter search criteria">
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Country</th>
                <th>Gender</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.country}</td>
                    <td>${student.gender}</td>
                    <td>
                        <button class="edit"><a href="/codevn5/student/edit?id=${student.id}">Edit</a></button>
                        <button class="delete"><a href="/codevn5/student/delete?id=${student.id}">Delete</a></button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <button class="add"><a href="http://localhost:8080/codevn5/student/add">Add new student</a></button>
</body>
</html>
