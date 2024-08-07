<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Manager</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            padding: 20px;
            background-color: #f8f9fa;
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .task {
            background-color: #fff;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .task p {
            margin: 0;
            color: #007bff;
        }
    </style>
</head>
<body>
    <h1>Task Manager</h1>

    <!-- Form to add a new task -->
    <form method="POST" >
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="4" required></textarea>

        <button type="submit">Add Task</button>
    </form>

    <!-- Form to search for tasks -->
    <form method="POST" action="search">
        <label for="search">Search Tasks:</label>
        <input type="text" id="search" name="search">
        <button type="submit">Search</button>
    </form>

    <!-- Displaying tasks using JSTL forEach -->
    <h2>Tasks:</h2>
    <c:forEach var="task" items="${taskList}">
        <div class="task">
            <p><strong>${task.title}</strong>: ${task.content} - ${task.dateCreate}</p>
            <button><a href="/demo_codevn6/edit?id=${task.id}">Edit</a></button>
            <button><a href="/demo_codevn6/delete?id=${task.id}">Delete</a></button>
        </div>
    </c:forEach>
</body>
</html>
