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
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 20px;
            margin-bottom: 20px;
            width: 100%;
        }

        h1 {
            margin: 0;
            font-size: 24px;
        }

        form {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            padding: 20px;
            box-sizing: border-box;
        }

        div {
            margin-bottom: 15px;
            text-align: left;
        }

        span {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input,
        select {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-right: 10px;
            cursor: pointer;
            border-radius: 4px;
        }

        button[type="reset"] {
            background-color: #ccc;
        }

        a {
            text-decoration: none;
            color: white;
        }

        button a {
            color: white;
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
            <input name="name">
        </div>
        <div>
            <span>Input age:</span>
            <input name="age" type="number">
        </div>
        <div>
            <span>Input country:</span>
            <input name="country">
        </div>
        <div>
            <span>Input date of birth:</span>
            <input name="dateOfBirth" type="date">
        </div>
        <div>
            <span>Gender:</span>
            <select name="gender">
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
