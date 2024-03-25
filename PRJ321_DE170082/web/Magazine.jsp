<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Magazine</title>
</head>
<body>
    <h1>Add New Magazine</h1>
    <form action="AddMagazineServlet" method="post">
        <label for="maz_id">Magazine ID:</label>
        <input type="text" id="maz_id" name="maz_id" value="${magazine.maz_id}"><br>
        
        <label for="magazine_title">Magazine Title:</label>
        <input type="text" id="magazine_title" name="magazine_title" value="${magazine.magazine_title}"><br>
        
        <label for="publisher">Publisher:</label>
        <input type="text" id="publisher" name="publisher" value="${magazine.publisher}"><br>
        
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="${magazine.price}"><br>
        
        <input type="submit" value="Add Magazine">
    </form>
        
</body>
</html>
