<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
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
            padding: 8px;
            box-sizing: border-box;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
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
            margin-right: 10px;
            cursor: pointer;
            border-radius: 4px;
        }

        button[type="reset"] {
            background-color: #ccc;
        }
    </style>
</head>
<body>
        <button><a href="http://localhost:8080/codevn5/student/" style="text-decoration: none;">Back to menu</a></button>

    <form method="POST" object="${student}">
        <div>
            <span>Name</span>
            <input type="text" value="${student.name}" name="name">
        </div>
        <div>
            <span>Age</span>
            <input type="number" value="${student.age}" name="age">
        </div>
        <div>
            <span>Date of Birth</span>
            <input type="date" value="${student.dateOfBirth}" name="dateOfBirth">
        </div>
        <div>
            <span>Country</span>
            <input type="text" value="${student.country}" name="country">
        </div>
        <div>
            <span>Gender</span>
            <select name="gender">
                <option selected value="${student.gender}">${student.gender}</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        <button type="submit">Save</button>
        <button type="reset">Reset</button>
    </form>
</body>
</html>
