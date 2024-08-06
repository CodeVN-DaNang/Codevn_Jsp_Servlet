<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Transaction</title>
</head>
<body>
    <h2>Enter Transaction Details</h2>
    <form method="post">
        ID: <input type="text" name="id"><br>
        Card Number: <input type="text" name="cardNumber"><br>
        Transaction Date: <input type="date" name="transactionDate"><br>
        Amount: <input type="text" name="amount"><br>
        Transaction Type: <input type="text" name="transactionType"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
