<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa;
            }

            #logreg-forms {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 0px 15px 5px #0000001a;
                margin-top: 50px;
            }

            .form-signin {
                max-width: 400px;
                margin: auto;
            }

            .form-signin .form-group {
                margin-bottom: 20px;
            }

            .form-signin label {
                font-weight: bold;
            }

            .form-signin input[type="text"],
            .form-signin input[type="password"],
            .form-signin textarea {
                border-radius: 20px;
            }

            .form-signin button[type="submit"] {
                border-radius: 20px;
            }

            .btn-success {
                background-color: #28a745;
                border-color: #28a745;
                padding: 10px 20px;
                font-weight: bold;
                transition: background-color 0.3s ease;
            }

            .btn-success:hover {
                background-color: #218838;
                border-color: #1e7e34;
            }

            .form-title {
                text-align: center;
                font-size: 24px;
                margin-bottom: 30px;
            }
        </style>
    </head>
    <body>
<!--            private int user_id;
    private String user_fullname;
    private String user_dob;
    private String user_about;
    private String user_website;
    private String user_country;
    private String user_gender;
    private String username;
    private String password;-->
<jsp:include page="header.jsp"></jsp:include>
        <div id="logreg-forms" class="container">
            <form class="form-signin" action="editProfile" method="post">
                <h1 class="form-title">Edit Profile</h1>
                <div class="form-group">
                    <label for="fullname">Full Name</label>
                    <input name="user_fullname" type="text" id="fullname" class="form-control" value="${sessionScope.account.user_fullname}" required autofocus>
                </div>
                <div class="form-group">
                    <label for="user_dob">Date Of Birth</label>
                    <input name="user_dob" type="text" id="fullname" class="form-control" value="${sessionScope.account.user_dob}" required autofocus>
                </div>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name="username" type="text" id="username" class="form-control" value="${sessionScope.account.username}" required autofocus>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name="password" type="password" id="password" class="form-control" value="${sessionScope.account.password}" required autofocus>
                </div>
                <div class="form-group">
                    <label for="about">About</label>
                    <textarea id="user_about" name="user_about" class="form-control" rows="5" autofocus>${sessionScope.account.user_about}</textarea>
                </div>
                <div class="form-group">
                    <label for="website">Website</label>
                    <input name="user_website" type="text" id="website" class="form-control" value="${sessionScope.account.user_website}" autofocus>
                </div>
                <div class="form-group">
                    <label for="country">Country</label>
                    <input name="user_country" type="text" id="website" class="form-control" value="${sessionScope.account.user_country}" required autofocus>
                </div>
                <button class="btn btn-danger btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Edit</button>
            </form>
        </div>

    </body>
</html>
