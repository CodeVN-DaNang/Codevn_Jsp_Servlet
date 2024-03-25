<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
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

            function searchInput(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: "/demo_manh/searchTitle",
                    type: "get", //send it through get method
                    data: {
                        txt: txtSearch
                    },
                    success: function (data) {
                        var row = document.getElementById("container");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        console.log(xhr)
                    }
                });
            }

            function fetchPins() {
                if (loading)
                    return;
                loading = true;
                document.getElementById('loader').style.display = 'block';
                $.ajax({
                    url: 'LoadMoreServlet?page=' + page,
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
        </script>
    </body>
</html>

