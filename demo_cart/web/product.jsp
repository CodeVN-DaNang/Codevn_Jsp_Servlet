<%-- 
    Document   : product
    Created on : Mar 4, 2024, 3:24:41 AM
    Author     : vannhat
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product!</h1>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productPrice}</td>
                        <td>${product.productAmount}</td>
                        <td>
                            
                            <button class="edit"><a href="/demo_cart/addCart?productId=${product.productId}">Add Cart</a></button>
                            
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
