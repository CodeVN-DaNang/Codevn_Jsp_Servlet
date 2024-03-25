<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Order</title>
        <style>
            /* Add custom CSS styles here */
            body {
                font-family: 'Roboto', sans-serif;
                background-color: #f8f9fa;
            }
            #logreg-forms {
                width: 100%;
                max-width: 600px;
                margin: auto;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 10px;
                box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            }
            .form-signin label {
                font-weight: 500;
            }
            .form-signin input[type="text"], .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-radius: 5px;
            }
            .btn-signup {
                background-color: #28a745;
                border: none;
            }
            #shopping-cart {
                background-color: #ffffff;
                border-radius: 10px;
                padding: 20px;
            }
            #cart-items {
                list-style: none;
                padding: 0;
            }
            #cart-items img {
                max-width: 50px;
                margin-right: 10px;
                border-radius: 5px;
            }
            #cart-items .product-info {
                display: inline-block;
                vertical-align: top;
            }
            #cart-total {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div id="logreg-forms">
                            <form class="form-signin" action="order" method="post" object="${account}">
                            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Order</h1>
                            <c:if test="${error!=null }">
                                <div class="alert alert-danger" role="alert">
                                    ${error}
                                </div>
                            </c:if>
                            <c:if test="${mess!=null }">
                                <div class="alert alert-success" role="alert">
                                    ${mess}
                                </div>
                            </c:if>
                            <label for="name" >Name</label>
                            <input name="name" type="text" id="name" class="form-control" placeholder="Name" required="" autofocus="" >
                            <label for="phoneNumber">Phone number</label>
                            <input name="phoneNumber" type="tel" id="phoneNumber" class="form-control" placeholder="Phone number" required="" autofocus="" >
                            <label for="email">Email</label>
                            <input name="email" type="email" id="email" class="form-control" placeholder="email" required="" autofocus="" value="${account.user_email}">
                            <label for="deliveryAddress">Delivery Address</label>
                            <input name="deliveryAddress" type="text" id="deliveryAddress" class="form-control" placeholder="Delivery Address" required="" autofocus="">

                            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-american-sign-language-interpreting"></i>Dat Hang</button>

                        </form>


                    </div>
                </div>
                <br>
                <div class="col-md-6">
                    <div id="shopping-cart">
                        <h2>Cart</h2>
                        <c:forEach items="${cart}" var="order">
                            <ul id="cart-items">
                                <img src="${order.product.image}" alt="Product Image">
                                <div class="product-info">
                                    <h3>${order.product.name}</h3>
                                    <p>${order.product.price} - <b>x ${order.quantity}</b></p>
                                </div>
                            </ul>
                        </c:forEach>

                        <p id="cart-total">Total: $ ${totalMoneyVAT}</p>
                    </div>
                </div>
            </div>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            <script>
                function toggleResetPswd(e) {
                    e.preventDefault();
                    $('#logreg-forms .form-signin').toggle() // display:block or none
                    $('#logreg-forms .form-reset').toggle() // display:block or none
                }

                function toggleSignUp(e) {
                    e.preventDefault();
                    $('#logreg-forms .form-signin').toggle(); // display:block or none
                    $('#logreg-forms .form-signup').toggle(); // display:block or none
                }

                $(() => {
                    // Login Register Form
                    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                    $('#logreg-forms #btn-signup').click(toggleSignUp);
                    $('#logreg-forms #cancel_signup').click(toggleSignUp);
                })

                window.addEventListener("load", function loadAmountCart() {
                    $.ajax({
                        url: "/realgroup2/loadAllAmountCart",
                        type: "get", //send it through get method
                        data: {

                        },
                        success: function (responseData) {
                            document.getElementById("amountCart").innerHTML = responseData;
                        }
                    });
                }, false);
            </script>
    </body>
</html>