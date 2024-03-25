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
                <th>Age</th>
               
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="student" varStatus="iterStats">
                <tr>
                    <td>${iterStats.index + 10 * (currentPage - 1) +1}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>
                        <button class="edit"><a href="/lab5/edit?id=${student.id}">Edit</a></button>
                        <button class="delete"><a href="/lab5/${student.id}">Delete</a></button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${numOfPages > 1}">
        <div class="pagination" >
                <c:set var="url" value="${pageContext.request.contextPath}/list"/>
                <c:choose>
                    <c:when test="${currentPage > 1}">
                        <a style="color: black;" href="${url}?page=1">First</a>
                        <a style="color: black;" href="${url}?page=${currentPage - 1}">Previous</a>
                    </c:when>
                    <c:otherwise>
                        <span style="color: black;">First</span>
                        <span style="color: black;">Previous</span>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="1" end="${numOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage == i}">
                            <span style="color: black;" class="current">${i}</span>
                        </c:when>
                        <c:otherwise>
                            <a style="color: black;" href="${url}?page=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${currentPage < numOfPages}">
                        <a style="color: black;" href="${url}?page=${currentPage + 1}">Next</a>
                        <a style="color: black;" href="${url}?page=${numOfPages}">Last</a>
                    </c:when>
                    <c:otherwise>
                        <span style="color: black;">Next</span>
                        <span style="color: black;">Last</span>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:if>
    <button class="add"><a href="http://localhost:8080/lab/add">Add new student</a></button>
</body>
</html>
