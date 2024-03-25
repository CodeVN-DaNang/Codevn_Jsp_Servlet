<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pinterest Clone</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">


    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <!-- Logo -->
                    <a class="navbar-brand" href="#">
                        <img src="https://i.pinimg.com/564x/c0/fb/a0/c0fba0961d1b9a0b0d5f63a85979bb08.jpg" alt="Pinterest Logo" class="logo-img">
                    </a>
                    <!-- Search Bar -->
                    <form class="form-inline my-2 my-lg-0 mx-auto">
                        <input class="form-control mr-lg-2 search-input" oninput="searchInput(this)" value="${txtS}" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-primary my-2 my-sm-0 search-button"  type="submit">Search</button>
                    </form>
                    <!-- Navigation Links -->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/demo_manh/home">Home <span class="sr-only">(current)</span></a>
                            </li>
                            
                            <c:if test="${sessionScope.account == null}">
                                <li class="nav-item">
                                    <a class="btn btn-primary search-button ml-2 nav-link" data-toggle="modal" data-target="#loginModal" style="color: white">Login</a>

                                </li>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                                <a class="nav-link" href="http://localhost:8080/demo_manh/addPost">Add</a>
                                <li class="nav-item">
                                    <a class="nav-link" href="http://localhost:8080/demo_manh/logout">Logout</a>
                                </li>
                                <li class="nav-item active">
                                    <div class="ml-2">
                                        <a class="nav-link" href="http://localhost:8080/demo_manh/profile?user_id=${sessionScope.account.user_id}" style="font-weight: bolder">Welcome, ${sessionScope.account.user_fullname}</a>
                                    </div>
                                </li>
                                <li class="nav-item">
                                
                            </li>
                            </c:if>

                            <!-- Add more navigation links as needed -->
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="loginModalLabel">Login</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Your login form goes here -->
                        <form action="/demo_manh/login" method="post">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" name="username" placeholder="Enter username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" placeholder="Password">
                            </div>
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" name="rem">
                                <label class="form-check-label" for="rememberMe">Remember me</label>
                            </div>
                            <h4 style="color: red;">${requestScope.error}</h4>
                            <button type="submit" class="btn btn-primary search-button">Login</button>
                            <a class="btn btn-primary search-button" href="http://localhost:8080/demo_manh/signup">SignUp</a>
                            <div class="form-group">
                                <a href="forgotPassword.jsp" class="forgot-password">Forgot password?</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Your other HTML content goes here -->
        <!-- Bootstrap JS and jQuery (place at the end of the body for faster page load) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
