<%-- 
    Document   : Personal
    Created on : Mar 17, 2024, 10:32:46 AM
    Author     : vannhat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pinterest Clone</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }

            #container {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
                margin: 20px auto;
                max-width: 1200px;
            }

            .pin {
                width: calc(20% - 20px);
                margin: 5px;
                background-color: #fff;
                box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
                overflow: hidden;
            }

            .pin img {
                width: 100%;
                display: block;
                border-radius: 5px 5px 0 0;
            }

            .pin .info {
                padding: 10px;
            }

            .pin .info h3 {
                font-size: 16px;
                margin: 5px 0;
            }

            .pin .info p {
                font-size: 14px;
                margin: 5px 0;
                color: #666;
            }

            /* Responsive */
            @media screen and (max-width: 992px) {
                .pin {
                    width: calc(25% - 20px);
                }
            }

            @media screen and (max-width: 768px) {
                .pin {
                    width: calc(33.33% - 20px);
                }
            }

            @media screen and (max-width: 576px) {
                .pin {
                    width: calc(50% - 20px);
                }
            }

            @media screen and (max-width: 480px) {
                .pin {
                    width: calc(100% - 20px);
                }
            }

            #loader {
                text-align: center;
                display: none;
            }

            #loader img {
                width: 50px;
                height: 50px;
            }
            /* Add styles for the dropdown menu */
            .share-btn {
                background-color: #e60023;
                color: #fff;
                border: none;
                padding: 10px 20px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
            }

            .share-btn:hover {
                background-color: #c7001d;
            }

            /* Font Awesome Icons */
            .fa-share {
                margin-right: 5px;
            }
            .dropdown-menu {
                display: none;
                position: absolute;
                background-color: #fff;
                min-width: 100px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-item {
                color: #333;
                padding: 10px;
                text-decoration: none;
                display: block;
            }

            .dropdown-item:hover {
                background-color: #f1f1f1;
            }

            .report-btn {
                background-color: #e60023;
                color: #fff;
                border: none;
                padding: 10px;
                font-size: 16px;
                border-radius: 50%;
                cursor: pointer;
            }

        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container" style="justify-content:center">
                <div style="justify-content:center">
                    <div style="text-align: center; font-weight: bolder">
                        <h1>
                        ${fullname}
                    </h1>

                </div>
                <div style="text-align: center; font-weight: bolder">
                    <img src="https://i.pinimg.com/564x/c0/fb/a0/c0fba0961d1b9a0b0d5f63a85979bb08.jpg" style="width: 40px;"/> ${username} 
                </div>
                <div style="text-align: center; font-weight: bolder">
                    <a>${user_website}</a>.${user_about}.${user_country}
                </div>
                <div style="text-align: center; font-weight: bolder">
                    ${count_comment}M monthly views
                </div>
            </div>
            <div class="row" style="justify-content:center">
                <div class="dropdown" >
                    <button class="share-btn" onclick="toggleShareMenu()">
                        <i class="fas fa-share"></i> Share
                    </button>
                    <div class="dropdown-menu" id="shareMenu">
                        <a class="dropdown-item" href="#" onclick="shareOnFacebook()">Facebook</a>
                        <a class="dropdown-item" href="#" onclick="shareOnTwitter()">Twitter</a>
                        <!-- Add more share options as needed -->
                    </div>
                </div>
                <div class="dropdown" style="margin-left: 20px">
                    <button class="share-btn" onclick="toggleReportMenu()">
                        Report
                    </button>
                    <div class="dropdown-menu" id="reportMenu">
                        <a class="dropdown-item" href="#" onclick="reportAsSpam()">Report as Spam</a>
                        <a class="dropdown-item" href="#" onclick="reportAsInappropriate()">Report as Inappropriate</a>
                        <!-- Add more report options as needed -->
                    </div>
                </div>
                <c:if test="${user_id == sessionScope.account.user_id}">
                    <a class="btn btn-danger" href="http://localhost:8080/demo_manh/editProfile">Edit</a>
                </c:if>

            </div>

            <hr>

        </div>

        <div class="container-fluid">
            <div id="container" class="row">
                <!-- Pins will be dynamically added here -->
            </div>
            <div id="loader">
                <img src="https://cdnjs.cloudflare.com/ajax/libs/galleriffic/2.0.1/css/loader.gif" alt="Loading...">
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
                            let page = 1;
                            let loading = false;
                            function getParameterByName(name, url) {
                                if (!url)
                                    url = window.location.href;
                                name = name.replace(/[\[\]]/g, '\\$&');
                                var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
                                        results = regex.exec(url);
                                if (!results)
                                    return null;
                                if (!results[2])
                                    return '';
                                return decodeURIComponent(results[2].replace(/\+/g, ' '));
                            }
                            function fetchPins() {
                                let user_id = getParameterByName('user_id', window.location.href);
                                if (loading)
                                    return;
                                loading = true;
                                document.getElementById('loader').style.display = 'block';
                                $.ajax({
                                    url: 'LoadMorePrfile?user_id=' + user_id,
                                    type: 'GET',
                                    data: {page: page},
                                    success: function (data) {
                                        $('#container').append(data);
                                        page++;
                                        loading = false;
                                        document.getElementById('loader').style.display = 'none';
                                    },
                                    error: function (xhr, status, error) {
                                        console.error('Error:', error);
                                        loading = false;
                                        document.getElementById('loader').style.display = 'none';
                                    }
                                });
                            }

                            function handleScroll() {
                                if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
                                    fetchPins();
                                }
                            }

                            window.addEventListener('scroll', handleScroll);
                            fetchPins(); // Load initial pins
                            function toggleShareMenu() {
                                var shareMenu = document.getElementById("shareMenu");
                                if (shareMenu.style.display === "block") {
                                    shareMenu.style.display = "none";
                                } else {
                                    shareMenu.style.display = "block";
                                }
                            }

                            function shareOnFacebook() {
                                // Replace with actual share functionality for Facebook
                                alert("Sharing on Facebook...");
                            }

                            function shareOnTwitter() {
                                // Replace with actual share functionality for Twitter
                                alert("Sharing on Twitter...");
                            }

                            function toggleReportMenu() {
                                var reportMenu = document.getElementById("reportMenu");
                                if (reportMenu.style.display === "block") {
                                    reportMenu.style.display = "none";
                                } else {
                                    reportMenu.style.display = "block";
                                }
                            }

                            function reportAsSpam() {
                                // Replace with actual report functionality for spam
                                alert("Reporting as Spam...");
                            }

                            function reportAsInappropriate() {
                                // Replace with actual report functionality for inappropriate content
                                alert("Reporting as Inappropriate...");
                            }


        </script>
</html>
