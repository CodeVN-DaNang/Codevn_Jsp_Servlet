<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
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
            width: 300px;
        }

        div {
            margin-bottom: 15px;
        }

        span {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        p {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <form method="POST">
        <div>
            <span>USERNAME:</span>
            <input type="text" name="username" value="${user.username}" required>
        </div>
        <div>
            <span>PASSWORD:</span>
            <input type="password" name="password" value="${user.password}" required>
        </div>
        <button type="submit" onclick="notice('${msg}')">Login</button>
        <div>
            <p>${msg}</p>
        </div>
    </form>
    <script>
        function notice(a) {
            alert(a);
        }
    </script>
</body>
</html>
