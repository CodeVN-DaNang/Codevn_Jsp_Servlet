<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Access Denied</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .container {
            margin-top: 100px;
        }

        .error-message {
            background-color: #f1f1f1;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }

        h1 {
            color: #dc3545;
        }

        p {
            font-size: 18px;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-message">
            <h1>Access Denied</h1>
            <p>You do not have permission to access this page.</p>
            <p><a href="http://localhost:8080/demohung/home">Back to Home</a></p>
        </div>
    </div>
</body>
</html>
