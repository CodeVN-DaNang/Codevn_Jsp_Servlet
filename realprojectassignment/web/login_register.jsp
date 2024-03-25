<%-- 
    Document   : login_register
    Created on : Mar 10, 2024, 11:07:33 AM
    Author     : miulan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login/Register</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <style>
            body {
                background-color: lightblue;
            }

            .login-box {
                position: relative;
                margin: 10px auto;
                width: 500px;
                height: auto;
                background-color: #fff;
                padding: 10px;
                border-radius: 3px;
                -webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.33);
                -moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.33);
                box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.33);
            }

            .lb-header {
                position: relative;
                color: #00415d;
                margin: 5px 5px 10px 5px;
                padding-bottom: 10px;
                border-bottom: 1px solid #eee;
                text-align: center;
                height: 28px;
            }

            .lb-header a {
                margin: 0 25px;
                padding: 0 20px;
                text-decoration: none;
                color: #666;
                font-weight: bold;
                font-size: 15px;
                -webkit-transition: all 0.1s linear;
                -moz-transition: all 0.1s linear;
                transition: all 0.1s linear;
            }

            .lb-header .active {
                color: #007bff;
                font-size: 18px;
            }

            .social-login {
                position: relative;
                float: left;
                width: 100%;
                height: auto;
                padding: 10px 0 15px 0;
                border-bottom: 1px solid #eee;
            }

            .social-login a {
                position: relative;
                float: left;
                width: calc(40% - 8px);
                text-decoration: none;
                color: #fff;
                border: 1px solid rgba(0, 0, 0, 0.05);
                padding: 12px;
                border-radius: 2px;
                font-size: 12px;
                text-transform: uppercase;
                margin: 0 3%;
                text-align: center;
            }

            .social-login a i {
                position: relative;
                float: left;
                width: 20px;
                top: 2px;
            }

            .social-login a:first-child {
                background-color: #49639F;
            }

            .social-login a:last-child {
                background-color: #DF4A32;
            }

            /* .email-login,.email-signup{
      position:relative;
      float: left;
      width: 100%;
      height:auto;
      margin-top: 20px;
      text-align:center;
    } */
            .u-form-group {
                width: 100%;
                margin-bottom: 10px;
            }

            .u-form-group input[type="email"],
            .u-form-group input[type="password"] {
                width: calc(50% - 22px);
                height: 45px;
                outline: none;
                border: 1px solid #ddd;
                padding: 0 10px;
                border-radius: 2px;
                color: #333;
                font-size: 0.8rem;
                -webkit-transition: all 0.1s linear;
                -moz-transition: all 0.1s linear;
                transition: all 0.1s linear;
            }

            .u-form-group input:focus {
                border-color: #358efb;
            }

            .u-form-group button {
                width: 50%;
                background-color: #007bff;
                border: none;
                outline: none;
                color: #fff;
                font-size: 14px;
                font-weight: normal;
                padding: 14px 0;
                border-radius: 2px;
                text-transform: uppercase;
            }

            .forgot-password {
                width: 50%;
                text-align: left;
                text-decoration: underline;
                color: #888;
                font-size: 0.75rem;
            }

            .container {
                max-width: 400px;
                margin: 100px auto;
                background-color: #fff;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                margin-bottom: 20px;
            }

            .btn-primary {
                background-color: #007bff;
                border: none;
            }

            .btn-primary:hover {
                background-color: #0056b3;
            }

            .alert-success {
                color: #155724;
                background-color: #d4edda;
                border-color: #c3e6cb;
                padding: 10px;
                margin-top: 20px;
                border-radius: 5px;
            }
            .email-signup{
                height: auto;
                overflow-y: auto;
            }
        </style>
    </head>

    <body>


        <div class="login-box">
            <div class="lb-header">
                <a href="#" class="active" id="login-box-link">Login</a>
                <a href="#" id="signup-box-link">Sign Up</a>
            </div>

            <form action="login" method="post" class="email-login">
                <div class="form-group">
                    <input name="username" type="text" class="form-control" placeholder="Username" />
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="Password" />
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Remember me</label>
                </div>
                <h4 style="color: red;">${requestScope.error}</h4>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                </div>
                <div class="form-group">
                    <a href="forgotPassword.jsp" class="forgot-password">Forgot password?</a>
                </div>
                <a class="nav-link" style="color: blue;" href="http://localhost:8080/realgroup2/home">Home</a>
            </form>
            <form method="post" action="signup" class="email-signup" id="signup-form">
                <div class="form-group">
                    <input name="fullname" type="text" id="form3Example1cg" class="form-control form-control-lg" placeholder="Fullname"/>
                </div>
                <div class="form-group">
                    <input name="user_phone" type="tel" id="form3Example4cg" class="form-control form-control-lg" placeholder="Phone"/>
                </div>
                <div class="form-group">
                    <input  name="user_email" type="email" id="form3Example3cg" class="form-control form-control-lg" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <input name="user_identity" type="text" id="form3Example4cg" class="form-control form-control-lg" placeholder="Identity"/>
                </div>
                <div class="form-group">
                    <input name="user_address" type="text" id="form3Example4cg" class="form-control form-control-lg" placeholder="Address"/>
                </div>
                <div class="form-group">
                    <input name="username" type="text" id="form3Example4cg" class="form-control form-control-lg" placeholder="Username"/>
                </div>
                <div class="form-group">
                    <input name="password" type="password" id="form3Example4cg" class="form-control form-control-lg" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <input name="repassword" type="password" id="form3Example4cg" class="form-control form-control-lg" placeholder="Repassword"/>
                </div>
                <div class="g-recaptcha" data-sitekey="6LcUJ5MpAAAAADvjgSDok_mxobzbUi7YoHWtmpYa"></div>
                <div id="error"></div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block" >Sign Up</button>
                </div>
                <a class="nav-link" style="color: blue;" href="http://localhost:8080/realgroup2/home">Home</a>
            </form>
        </div>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
            window.onload = function () {
                let isValid = false;
                const form = document.getElementById("signup-form");
                const error = document.getElementById("error");

                form.addEventListener("submit", function (event) {
                    event.preventDefault();
                    const response = grecaptcha.getResponse();
                    if (response) {
                        form.submit();
                    } else {
                        error.innerHTML = "Please check reCAPTCHA before you sign up!";
                    }
                });
            }
        </script>
        <!-- Bootstrap JS and dependencies -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
        <script>
            $(".email-signup").hide();
            $("#signup-box-link").click(function () {
                $(".email-login").fadeOut(100);
                $(".email-signup").delay(100).fadeIn(100);
                $("#login-box-link").removeClass("active");
                $("#signup-box-link").addClass("active");
            });
            $("#login-box-link").click(function () {
                $(".email-login").delay(100).fadeIn(100);
                ;
                $(".email-signup").fadeOut(100);
                $("#login-box-link").addClass("active");
                $("#signup-box-link").removeClass("active");
            });



        </script>

    </body>

</html>
