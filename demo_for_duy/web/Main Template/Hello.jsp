
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entity.TimeSession"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">


        <title>profile edit data and skills - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Title -->
        <title>hello</title>


        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Main Template/css/bootstrap.min.css">

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
            }
            .section-title h2 {
                color: #333;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            .btn {
                display: inline-block;
                padding: 8px 16px;
                border: none;
                background-color: #007bff;
                color: white;
                text-align: center;
                text-decoration: none;
                font-size: 14px;
                cursor: pointer;
                border-radius: 4px;
            }
            .btn:hover {
                background-color: #0056b3;
            }
        </style>

    </head>
    <body>


        <!-- Start Doctor Calendar Area -->
        <section class="doctor-calendar-area section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Determine Your Date to Come</h2>


                        </div>
                    </div>
                </div>
                <section class="doctor-calendar-area section">
                    <div class="container">

                        <div class="row">
                            <div class="col-12">
                                <div class="doctor-calendar-table table-responsive">
                                    <table class="table">

                                        <thead>
                                            <tr>
                                                <th>Time</th>
                                                    <c:forEach items="${dayOfWeeks}" var="day">
                                                    <th>${day}</th>
                                                    </c:forEach>
                                            </tr>

                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><span class="time" c:out="${timeSession.timeStart}"></span></td>
                                                    <c:forEach items="${timeSlots}" var="timeSlot">
                                                <tr>
                                                    <td><span class="time">${timeSlot}:00</span></td>
                                                    <c:forEach items="${dayOfWeeks}" var="day">
                                                        <td>
                                                            <c:forEach items="${timeSessions}" var="timeSession">
                                                                <c:if test="${timeSession.day.getDayOfWeek() == day && timeSession.timeStart.equals(timeSlot)}">
                                                                    <h3><a href="/duy/time/edit?id=${timeSession.timeSessionId}">${timeSession.user.getName()}</a></h3>
                                                                    <span c:out="">${timeSession.user.getMajorId()}</span>
                                                                    <span><a href="/duy/time/delete?id=${timeSession.timeSessionId}">delete</a></span>
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                    </c:forEach>
                                                </tr>
                                            </c:forEach>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <form method="post" action="/duy/time/add" object="timeSession" class="col-md-8 mx-auto">
                                <div class="form-group">
                                    <label for="dayOfWeek">Day of week:</label>
                                    <select name="day" id="dayOfWeek" class="form-control">
                                        <option value="2">Monday</option>
                                        <option value="3">Tuesday</option>
                                        <option value="4">Wednesday</option>
                                        <option value="5">Thursday</option>
                                        <option value="6">Friday</option>
                                        <option value="7">Saturday</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="timeStart">Time start:</label>
                                    <select name="timeStart" id="timeStart" class="form-control">
                                        <option value="09">09:00 AM</option>
                                        <option value="12">12:00 PM</option>
                                        <option value="15">03:00 PM</option>
                                        <option value="18">06:00 PM</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Save</button>
                                    <button type="reset" class="btn btn-alert">Cancel</button>
                                </div>
                            </form>
                        </div>

                    </div>
            </div>


    </body>
</html>