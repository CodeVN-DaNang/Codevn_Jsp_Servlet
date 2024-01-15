<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stylish Calculator</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            text-align: center;
            margin: 50px;
        }

        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            display: inline-block;
            max-width: 400px;
            margin: 0 auto;
        }

        h2 {
            color: #333;
            font-size: 28px;
            margin-bottom: 20px;
        }

        span {
            display: block;
            margin-bottom: 10px;
            color: #555;
            font-size: 14px;
        }

        input, select, button {
            margin-bottom: 15px;
            padding: 12px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 6px;
            box-sizing: border-box;
            width: 100%;
            transition: border-color 0.3s;
        }

        input:focus, select:focus {
            outline: none;
            border-color: #4caf50;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        input[readonly] {
            background-color: #eee;
            cursor: not-allowed;
        }

        input[type="number"]::-webkit-inner-spin-button,
        input[type="number"]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        input[type="number"] {
            -moz-appearance: textfield;
        }
    </style>
</head>
<body>
    <form method="POST">
        <h2>Stylish Calculator</h2>
        <span>Input a:</span>
        <input type="number" name="a" value="${a}" required>
        <span>Input b:</span>
        <input type="number" name="b" value="${b}" required>
        <span>Select operator:</span>
        <select name="operator" required>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value=":">/</option>
        </select>
        <button type="submit">Calculate</button>
        <span>Result:</span>
        <input readonly type="number" name="result" value="${result}" required>
    </form>
</body>
</html>
