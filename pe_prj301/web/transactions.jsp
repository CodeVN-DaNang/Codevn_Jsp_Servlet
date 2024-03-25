<%-- 
    Document   : transactions
    Created on : Mar 19, 2024, 3:56:28 PM
    Author     : vannhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Transactions</h1>
        <form action="/pe_prj301/transactionFilterDate" method="POST">
            <div>
                <span>
                    Input date to search: 
                </span>
                <input name="filter_date" />
                <button type="submit">search</button>
            </div>
            
        </form>
        <form action="/pe_prj301/transactionFilterNumber" method="POST">
            <div>
                <span>
                    Input card number to search: 
                </span>
                <input name="card_number" />
                <button type="submit">search</button>
            </div>
        </form>
        <table>
            <tr>
                <td>id</td>
                <td>card number</td>
                <td>transaction date</td>
                <td>amount</td>
                <td>transaction type</td>
            </tr>
            <c:forEach items="${transList}" var="trans">
                <tr>
                    <td>${trans.id}</td>
                    <td>${trans.card.card_number}</td>
                    <td>${trans.transaction_date}</td>
                    <td>${trans.amount}</td>
                    <td>${trans.transaction_type}</td>
                </tr>

            </c:forEach>
        </table>
        <div>
            Count footer: ${count}
        </div>
    </body>
</html>
