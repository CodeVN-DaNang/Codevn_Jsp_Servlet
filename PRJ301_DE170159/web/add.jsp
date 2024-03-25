<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Student</title>
</head>
<body>
    <header>
        <h1>Teacher Management System</h1>
    </header>

    <form action="add" method="POST" object="teacher">
        <div>
            <span>Input id:</span>
            <input name="teacher_id" required>
        </div>
        <div>
            <span>Input name:</span>
            <input name="teacher_name" type="text" required>
        </div>
        <div>
            <span>Input date of birth:</span>
            <input name="teacher_dob" type="date" required>
        </div>
        <div>
            <span>Input tel</span>
            <input name="teacher_tel" required>
        </div>
        <div>
            <span>Select position</span>
            <select name="teacher_position" required>
                <option value="" disabled selected>Select position</option>
                <option value="Chairman">Chairman</option>
                <option value="Lecture">Lecture</option>
                <option value="Staff">Staff</option>
            </select>
        </div>
        <button type="submit">Add</button>
        <button type="reset">Reset</button>
    </form>
</body>
</html>
