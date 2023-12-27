<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/datatables.min.css" rel="stylesheet">
        <link rel="icon" href="path/to/favicon.ico" type="image/x-icon">

        <style>
            body, html {
                background: linear-gradient(rgba(255, 255, 255, 0.8), rgba(255, 255, 255, 0.8)), url("your-background-image.jpg") center center fixed;
                background-size: cover;
            }

            .custom-container {
                margin-top: 30px;
            }

            .table th, .table td {
                text-align: center;
                vertical-align: middle;
            }

            .table th {
                background-color: #343a40;
                color: #fff;
            }

            .table-striped tbody tr:nth-of-type(odd) {
                background-color: #f8f9fa;
            }

            .card {
                border-radius: 15px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            .card-header {
                background-color: #007bff;
                color: #fff;
            }

        </style>
    </head>
    <body>

        <div class="container mt-4 custom-container">
            <div class="row">
                <div class="col">

                    <div class="card">
                        <div class="card-header bg-primary text-white">
                            Candidate List
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="candidateTypeFilter">Filter by Candidate Type:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="bi bi-funnel-fill"></i> <!-- You can use an appropriate icon -->
                                        </span>
                                    </div>
                                    <select id="candidateTypeFilter" class="custom-select" name="command">
                                        <option selected value="">All</option>
                                        <option value="LIST-EXPERIENCE">Experience</option>
                                        <option value="LIST-INTERN">Intern</option>
                                        <option value="LIST-FRESHER">Fresher</option>
                                    </select>
                                </div>
                            </div>
                            <table id="candidateTable" class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Index</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Type</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="candidate" items="${candidateList}">
                                        <tr>
                                            <td>${candidate.candidateId}</td>
                                            <td>${candidate.candidateFirstName}</td>
                                            <td>${candidate.candidateLastName}</td>
                                            <td>${candidate.candidateType.getTypeName()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#candidateTypeFilter').change(function () {
                    var selectedType = $(this).val();
                    $('#candidateTable tbody tr').each(function () {
                        var rowType = $(this).find('td:nth-child(4)').text(); // Assuming Type column is the 4th column
                        if (selectedType === '' || rowType === selectedType) {
                            $(this).show();
                        } else {
                            $(this).hide();
                        }
                    });
                });
            });
        </script>
    </body>
</html>
