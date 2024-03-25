<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pinterest Pin Clone</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>
            body {
                margin: 0;
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
            }

            .pin-container {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: auto;
                padding: 20px;
            }

            .pin {
                display: flex; /* Use flexbox */
                max-width: 90%;
                width: 100%;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                overflow: hidden;
            }

            .pin img {
                width: 50%; /* Adjust image width */
                border-radius: 10px 0 0 10px;
                object-fit: cover;
                object-position: center;
            }

            .pin-info {
                flex: 1; /* Use remaining space */
                padding: 20px;
            }

            .pin-info h2 {
                margin-top: 0;
                font-size: 24px;
                color: #333;
            }

            .pin-info p {
                margin-bottom: 20px;
                font-size: 16px;
                color: #555;
            }

            .btn {
                display: inline-block;
                padding: 10px 20px;
                background-color: #e60023;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .btn:hover {
                background-color: #c7001d;
            }

            ul {
                margin: 0;
                padding: 0;
                list-style: none;
            }

            ul li {
                font-size: 14px;
                color: #666;
                margin-bottom: 5px;
            }

            ul li:first-child {
                font-weight: bold;
                color: #333;
            }

            /* Style for user comments */
            .user-comments {

                margin-bottom: 0px ;
            }

            .user-comments h3 {

                font-size: 20px;
                color: #333;
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="pin-container">
                <div class="pin">
                    <img src="${post_img}" alt="Pinned Image">
                <div class="pin-info">
                    <h2>${post_title}          <a href="#" class="btn btn-outline-danger" style="margin-right: 60px">Save</a>  <c:if test="${(sessionScope.account.user_id == post_user_id)}"><a href="http://localhost:8080/demo_manh/deletePost?post_id=${post_id}" class="btn btn-outline-danger">Delete</a>  <a href="http://localhost:8080/demo_manh/editPost?post_id=${post_id}" class="btn btn-outline-danger">Edit</a></c:if></h2>
                    <p>${post_description}</p>
                    <h3><a style="text-decoration: none;" href="http://localhost:8080/demo_manh/profile?user_id=${post_user_id}">${user_fullname}</a></h3>
                    <div class="reviews" id="reviews">
                        <c:forEach items="${listAllComment}" var="cmt">

                            <div class="media mt-3 mb-4">
                                <img class="d-flex mr-3 z-depth-1" src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg"
                                     width="10px;" alt="Generic placeholder image">
                                <div class="media-body">
                                    <div class="d-flex justify-content-between">
                                        <p class="mt-1 mb-2">

                                            <strong>${cmt.user.user_fullname } </strong>

                                            <span>– </span><span>${cmt.cmt_time }</span>


                                        </p>
                                    </div>
                                    <p class="mb-0">${cmt.cmt_content }</p>

                                    <c:if test="${(sessionScope.account.user_id == cmt.user.user_id) || (sessionScope.account.user_id == post_user_id)}">

                                        <div>
                                            <span><a class="btn btn-outline-danger" href="http://localhost:8080/demo_manh/deleteComment?cmt_id=${cmt.cmt_id}">delete</a></span>
                                        </div>
                                    </c:if>

                                </div>
                            </div>
                            <hr>    

                        </c:forEach>
                    </div>

                    <div>
                        <!-- Your review -->
                        <div class="md-form md-outline">
                            <textarea id="form76" class="md-textarea form-control pr-6" rows="4"></textarea>

                        </div>
                        <div class="text-right pb-2">
                            <button type="button" class="btn btn-danger" onclick="addReview()">Add a review</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div >
            <div class="row" style="justify-content: center">
                <h2>More to explore</h2>
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
                                function addReview() {
                                    let cntReview = document.getElementById("form76").value;
                                    let post_id = getParameterByName('post_id', window.location.href);
                                    $.ajax({
                                        url: "/demo_manh/addReview",
                                        type: "post", //send it through get method
                                        data: {
                                            post_id: post_id,
                                            contentReview: cntReview
                                        },
                                        success: function (data) {
                                            var row = document.getElementById("reviews");
                                            row.innerHTML += data;
                                        },
                                        error: function (xhr) {
                                            console.error('Error adding review:', xhr.responseText);
                                        }
                                    });
                                }
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
                                    let post_id = getParameterByName('post_id', window.location.href);
                                    if (loading)
                                        return;
                                    loading = true;
                                    document.getElementById('loader').style.display = 'block';
                                    $.ajax({
                                        url: 'loadRelatedPost?post_id=' + post_id,
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
        </div>
    </body>
</html>
