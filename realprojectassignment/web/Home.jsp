<%-- 
    Document   : home.jsp
    Created on : Mar 10, 2024, 8:48:00 PM
    Author     : vannhat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="./css/reset.min.css">

        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
            <section id="home">
                <div id="homeCarousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://imgwebikevn-8743.kxcdn.com/kyYa2f7OqthWgozo4tCGFt-sf4E=/1200x482/banner/20200511_new_arrival_1200_482.jpg" class="d-block w-100" alt="Slide 1">
                            <div class="carousel-caption d-none d-md-block">
                                <h2 class="text-white">Welcome to Motorbike Shop</h2>
                                <p class="text-white">Your destination for quality motorbikes.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://imgwebikevn-8743.kxcdn.com/ql0jK2MzMBcAmnOcQXaQbMpjKiE=/1200x482/banner/20220422_landing_page_1200_482.png" class="d-block w-100" alt="Slide 2">
                            
                        </div>

                        <!-- Add more carousel items with images from another website as needed -->
                    </div>
                    <a class="carousel-control-prev" href="#homeCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#homeCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </section>


            <section id="about">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-3">
                            <div class="about-item text-center">
                                <i class="fas fa-shipping-fast fa-3x mb-3 text-primary"></i>
                                <h4>Giao hàng uy tín</h4>
                                <p>Chúng tôi cam kết giao hàng đến tay khách hàng một cách nhanh chóng và uy tín nhất.</p>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="about-item text-center ">
                                <i class="fas fa-exchange-alt fa-3x mb-3 text-primary"></i>
                                <h4>Miễn phí đổi trả</h4>
                                <p>Chúng tôi cam kết đổi trả sản phẩm miễn phí trong vòng 30 ngày nếu có bất kỳ lỗi kỹ thuật nào.</p>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="about-item text-center">
                                <i class="fas fa-check-circle fa-3x mb-3 text-primary"></i>
                                <h4>Chính hãng cam kết</h4>
                                <p>Chúng tôi đảm bảo cung cấp sản phẩm chính hãng với chất lượng tốt nhất cho khách hàng.</p>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="about-item text-center">
                                <i class="fas fa-truck fa-3x mb-3 text-primary"></i>
                                <h4>Free shipping</h4>
                                <p>Chúng tôi cung cấp dịch vụ giao hàng miễn phí cho mọi đơn hàng trên 1.000.000 đ.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>




            <section id="products">
                <div class="container">
                    <h2>Top Sale</h2>

                    <div id="productCarousel" class="carousel slide" data-ride="carousel">
                        <a class="carousel-control-prev" href="#productCarousel" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#productCarousel" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                        <div class="carousel-inner">
                        <c:forEach var="product" items="${listCC}" varStatus="status">
                            <c:if test="${status.index % 3 == 0}">
                                <div class="carousel-item${status.index == 0 ? ' active' : ''}">
                                    <div class="row">
                                    </c:if>
                                    <div class="col-md-4">
                                        <div class="product">
                                            <img src="${product.image}" alt="${product.name}">
                                            <h3>${product.name}</h3>
                                            <p>${product.description}</p>
                                            <p>${product.price}</p>
                                            <button class="btn btn-primary" onclick="addToCart(${product.id})">Add to Cart</button>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 3 == 2}">
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>

        <!-- xe yamaha -->
        <section id="products">
            <div class="container">
                <h2>YAMAHA</h2>

                <div id="productCarousel1" class="carousel slide" data-ride="carousel">
                    <a class="carousel-control-prev" href="#productCarousel1" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#productCarousel1" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    <div class="carousel-inner">
                        <c:forEach var="product" items="${list4Yamaha}" varStatus="status">
                            <c:if test="${status.index % 3 == 0}">
                                <div class="carousel-item${status.index == 0 ? ' active' : ''}">
                                    <div class="row">
                                    </c:if>
                                    <div class="col-md-4">
                                        <div class="product">
                                            <img src="${product.image}" alt="${product.name}">
                                            <h3>${product.name}</h3>
                                            <p>${product.description}</p>
                                            <p>${product.price}</p>
                                            <button class="btn btn-primary" onclick="addToCart(${product.id})">Add to Cart</button>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 3 == 2}">
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>

        <!-- xe honda -->
        <section id="products">
            <div class="container">
                <h2>HONDA</h2>

                <div id="productCarousel2" class="carousel slide" data-ride="carousel">
                    <a class="carousel-control-prev" href="#productCarousel2" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#productCarousel2" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    <div class="carousel-inner">
                        <c:forEach var="product" items="${list4Honda}" varStatus="status">
                            <c:if test="${status.index % 3 == 0}">
                                <div class="carousel-item${status.index == 0 ? ' active' : ''}">
                                    <div class="row">
                                    </c:if>
                                    <div class="col-md-4">
                                        <div class="product">
                                            <img src="${product.image}" alt="${product.name}">
                                            <h3>${product.name}</h3>
                                            <p>${product.description}</p>
                                            <p>${product.price}</p>
                                            <button class="btn btn-primary" onclick="addToCart(${product.id})">Add to Cart</button>
                                        </div>
                                    </div>
                                    <c:if test="${status.index % 3 == 2}">
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
    <script>
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
        function addToCart(productId) {

            $.ajax({
                url: "/realgroup2/addCart?pid=" + productId + "&quantity=1",
                type: "get", //send it through get method
                data: {

                },
                success: function (responseData) {
                    alert("Add success");
                }
            });
        }
    </script>
</html>
