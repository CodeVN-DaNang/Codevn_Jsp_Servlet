<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>cards list</h1>
        <table>
            <tr>
                <td>card number</td>
                <td>account number</td>
                <td>customer name</td>
                <td>release date</td>
                <td>expiration date</td>
            </tr>
            <c:forEach items="${cardList}" var="card">
                <tr>
                    <td>${card.card_number}</td>
                    <td>${card.account_number}</td>
                    <td>${card.customer_name}</td>
                    <td>${card.release_date}</td>
                    <td>${card.expiration_date}</td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
