<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Student</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 15px;
            text-align: center;
            width: 100%;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin-top: 20px;
        }

        div {
            margin-bottom: 15px;
        }

        span {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input,
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        select {
            cursor: pointer;
        }

        button {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        button[type="reset"] {
            background-color: #dc3545;
        }
    </style>
</head>
<body>
    <header>
        <h1>Student Management System</h1>
    </header>

    <form action="add" method="POST" object="student">
        <div>
            <span>Input name:</span>
            <input name="name" required>
        </div>
        <div>
            <span>Input age:</span>
            <input name="age" type="number" required>
        </div>
        <div>
            <span>Input country:</span>
            <input name="country" required>
        </div>
        <div>
            <span>Input date of birth:</span>
            <input name="dateOfBirth" type="date" required>
        </div>
        <div>
            <span>Gender:</span>
            <select name="gender" required>
                <option value="" disabled selected>Select Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        <button type="submit">Add</button>
        <button type="reset">Reset</button>
    </form>
</body>
</html>
