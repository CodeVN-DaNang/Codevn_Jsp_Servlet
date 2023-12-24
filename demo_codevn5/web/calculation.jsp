<%-- 
    Document   : calculation
    Created on : Dec 20, 2023, 10:56:05 AM
    Author     : vannhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
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
        }

        div {
            margin-bottom: 15px;
        }

        span {
            display: inline-block;
            width: 150px;
        }

        input, select, button {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
            margin-top: 5px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        div[name="result"] {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #f9f9f9;
        }
    </style>
    <title>Beautiful Calculation</title>
</head>
<body>

    <form action="calculation" method="GET">
        <div>
            <span>Input a:</span>
            <input name="a" placeholder="Input a number" type="number" value="${a}">
        </div>
        <div>
            <span>Input b:</span>
            <input name="b" placeholder="Input a number" type="number">
        </div>
        <div>
            <span>Select operator:</span>
            <select name="operator">
                <option value="+">Sum</option>
                <option value="-">Subtract</option>
                <option value="*">Multiply</option>
                <option value="/">Divide</option>
            </select>
        </div>
        <div>
            <span>Result:</span>
            <div name="result">${result}</div>
        </div>
        <button type="submit">Calculate</button>
    </form>


    </body>
</html>
