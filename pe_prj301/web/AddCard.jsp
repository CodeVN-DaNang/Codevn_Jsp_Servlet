
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add card</h1>
        <form action="/pe_prj301/addCard" method="POST">
            <div>
                <span>card number</span>
                <input name="card_number" />
            </div>
            <div>
                <span>account number</span>
                <input name="account_number" />
            </div>
            <div>
                <span>customer name</span>
                <input name="customer_name" />
            </div>
            <div>
                <span>release date</span>
                <input name="release_date" />
            </div>
            <div>
                <span>expiration date</span>
                <input name="expiration_date" />
            </div>
            <button type="submit">Add</button>
        </form>

    </body>
</html>
