<%-- 
    Document   : TotalAmountResult
    Created on : Jul 17, 2024, 10:38:50 AM
    Author     : vannhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Query Transaction Total</title>
</head>
<body>
    <h2>Enter Card Details to Get Total Transaction Amount</h2>
    <form method="post" action="">
        Card Number: <input type="text" name="cardNumber"><br>
        Transaction Type: <input type="text" name="transactionType"><br>
        <input type="submit" value="Submit">
    </form>
    <h2>Total Amount for Card Number: ${cardNumber} and Transaction Type: ${transactionType}</h2>
    <p>Total Amount: ${totalAmount}</p>
</body>
</html>
