<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Statistic</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 


        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
        <!-- Material Design Bootstrap Ecommerce -->
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
        <!-- Your custom styles (optional) -->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- Custom CSS -->
        <style>
            body {
                margin: 0;
                padding: 0;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"><link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&amp;display=swap"><link rel="stylesheet" type="text/css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb5/3.8.1/compiled.min.css"><link rel="stylesheet" type="text/css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css"><style>body {
                background-color: #fbfbfb;
            }
            @media (min-width: 991.98px) {
                main {
                    padding-left: 240px;
                }
            }

            /* Sidebar */
            .sidebar {
                position: fixed;
                top: 0;
                bottom: 0;
                left: 0;
                padding: 58px 0 0; /* Height of navbar */
                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
                width: 240px;
                z-index: 600;
            }

            @media (max-width: 991.98px) {
                .sidebar {
                    width: 100%;
                }
            }
            .sidebar .active {
                border-radius: 5px;
                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
            }

            .sidebar-sticky {
                position: relative;
                top: 0;
                height: calc(100vh - 48px);
                padding-top: 0.5rem;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
            }</style>
    </head>
    <body>

        <!--Main Navigation-->
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="#">Admin Panel</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/realgroup2/admin">Dashboard</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/realgroup2/manager">Products</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/realgroup2/managerAccount">User</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/realgroup2/home">Exits</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>


        </header>
        <!--Main Navigation-->

        <!--Main layout-->
        <main>
            <div class="container pt-4">
                <div class="container mt-5">
                    <h2>Welcome to Admin Panel</h2>
                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header bg-primary text-white">
                                    Recent Orders
                                </div>
                                <div class="card-body">
                                    <!-- Table for displaying recent orders -->
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Customer</th>
                                                <th>Date</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Populate this table with recent orders data -->
                                            <c:forEach items="${listAllInvoice}" var="i">
                                                <tr>
                                                    <td>${i.maHD }</td>
                                                    <c:forEach items="${listAllAccount}" var="a">
                                                        <c:if test="${i.accountID==a.user_id }">
                                                            <td>${a.fullname }</td>
                                                        </c:if>
                                                    </c:forEach>
                                                    <td>${i.ngayXuat }</td> 
                                                    <td>${String.format("%.02f",i.tongGia) }</td>
                                                </tr>
                                            </c:forEach>

                                            <!-- More rows -->
                                        </tbody>
                                    </table>
                                </div>






                                <!--Section: Top 10 san pham ban chay-->


                                <div class="card-header py-3">
                                    <h5 class="mb-0 text-center"><strong>Top 10 sản phẩm bán chạy nhất</strong></h5>
                                </div>

                                
                                <c:if test="${mess!=null }">
                                    <div class="alert alert-success" role="alert">
                                        ${mess}
                                    </div>
                                </c:if>

                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Image</th>
                                                    <th scope="col">Price</th>
                                                    <th scope="col">SoLuongDaBan</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listTop10Product}" var="t">
                                                    <c:forEach items="${listAllProduct}" var="o">
                                                        <c:if test="${t.productID==o.id }">
                                                            <tr>
                                                                <td>${o.id}</td>
                                                                <td>${o.name}</td>
                                                                <td>
                                                                    <img src="${o.image}">
                                                                </td>
                                                                <td>${o.price} $</td>
                                                                <td>${t.soLuongDaBan }</td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                            </tbody>
                                        </table>



                                    </div>
                                </div>

                                <div class="card-header py-3">
                                    <h5 class="mb-0 text-center"><strong>Top 5 khách hàng mua nhiều nhất</strong></h5>
                                </div>

                               

                                <c:if test="${mess!=null }">
                                    <div class="alert alert-success" role="alert">
                                        ${mess}
                                    </div>
                                </c:if>

                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Username</th> 
                                                    <th scope="col">Email</th>
                                                    <th scope="col">Tổng chi tiêu</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listTop5KhachHang}" var="t">
                                                    <c:forEach items="${listAllAccount}" var="o">
                                                        <c:if test="${t.userID==o.id }">
                                                            <c:if test="${t.tongChiTieu!=0.0 }">
                                                                <tr>
                                                                    <td>${o.id}</td>
                                                                    <td>${o.user}</td>
                                                                    <td>${o.email}</td>
                                                                    <td>${t.tongChiTieu}</td>    
                                                                </tr>
                                                            </c:if>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="card-header py-3">
                                    <h5 class="mb-0 text-center"><strong>Top 5 nhân viên bán hàng xuất sắc</strong></h5>
                                </div>

                                

                                <c:if test="${mess!=null }">
                                    <div class="alert alert-success" role="alert">
                                        ${mess}
                                    </div>
                                </c:if>

                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Username</th>
                                                    <th scope="col">Email</th>
                                                    <th scope="col">Tổng bán hàng</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listTop5NhanVien}" var="t">
                                                    <c:forEach items="${listAllAccount}" var="o">
                                                        <c:if test="${t.userID==o.id }">
                                                            <c:if test="${t.tongBanHang!=0.0 }">
                                                                <tr>
                                                                    <td>${o.id}</td>
                                                                    <td>${o.user}</td>
                                                                    <td>${o.email}</td>
                                                                    <td>${t.tongBanHang}</td>
                                                                </tr>
                                                            </c:if>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header bg-success text-white">
                                    Monthly Revenue
                                </div>
                                <div class="card-body">
                                    <section class="mb-4" id="doanhThuThang">
                                        <div class="card">
                                            <div class="card-header py-3">
                                                <h5 class="mb-0 text-center"><strong>Doanh thu theo tháng</strong></h5>
                                            </div>
                                            <div class="card-body">
                                                <canvas id="horizontalBar"></canvas>
                                            </div>
                                        </div>
                                    </section>
                                    <section class="mb-4" id="doanhThuThu">
                                        <div class="card">
                                            <div class="card-header py-3">
                                                <h5 class="mb-0 text-center"><strong>Doanh thu theo thứ</strong></h5>
                                            </div>
                                            <div class="card-body">
                                                <canvas class="my-4 w-100" id="pieChart" height="380"></canvas>
                                            </div>
                                        </div>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>







            </div>
        </main>

        <!-- Footer -->
        <footer class="footer bg-dark text-white text-center py-3 mt-5">
            <div class="container">
                &copy; 2024 Your Company. All Rights Reserved.
            </div>
        </footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!--Main layout-->
        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
        <!-- MDB Ecommerce JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>
        <script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <script>// Graph
            //pie
            var ctxP = document.getElementById("pieChart").getContext('2d');

            var myPieChart = new Chart(ctxP, {
                type: 'pie',
                data: {
                    labels: ["Sunday", "Saturday", "Friday", "Thursday", "Wednesday", "Tuesday", "Monday"],
                    datasets: [{
                            data: [${totalMoney1}, ${totalMoney7}, ${totalMoney6}, ${totalMoney5}, ${totalMoney4}, ${totalMoney3}, ${totalMoney2}],
                            backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360", "#1874CD", "#CDB5CD"],
                            hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774", "#1E90FF", "#FFE1FF"]
                        }]
                },
                options: {
                    responsive: true
                }
            });

        </script>
        <script>// Graph
            //Horizontal Bar Chart
            new Chart(document.getElementById("horizontalBar"), {
                "type": "horizontalBar",
                "data": {
                    "labels": ["Tháng 12", "Tháng 11", "Tháng 10", "Tháng 9", "Tháng 8", "Tháng 7", "Tháng 6", "Tháng 5", "Tháng 4", "Tháng 3", "Tháng 2", "Tháng 1"],
                    "datasets": [{
                            "label": "Doanh thu $",
                            "data": [${totalMoneyMonth12}, ${totalMoneyMonth11}, ${totalMoneyMonth10}, ${totalMoneyMonth9}, ${totalMoneyMonth8}, ${totalMoneyMonth7}, ${totalMoneyMonth6}, ${totalMoneyMonth5}, ${totalMoneyMonth4}, ${totalMoneyMonth3}, ${totalMoneyMonth2}, ${totalMoneyMonth1}],
                            "fill": false,
                            "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
                                "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
                                "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
                            ],
                            "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                                "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)", "	#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
                            ],
                            "borderWidth": 1
                        }]
                },
                "options": {
                    "scales": {
                        "xAxes": [{
                                "ticks": {
                                    "beginAtZero": true
                                }
                            }]
                    }
                }
            });
        </script>
        <script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>
    </body>
</html>