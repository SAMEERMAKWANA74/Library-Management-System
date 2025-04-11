<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <h2>Add a New Book</h2>
    <form action="AddBookServlet" method="post">
        <label>Book Title:</label>
        <input type="text" name="title" required><br><br>
        
        <label>Author:</label>
        <input type="text" name="author" required><br><br>
        
        <label>Publisher:</label>
        <input type="text" name="publisher"><br><br>
        
        <label>Quantity:</label>
        <input type="number" name="quantity" required><br><br>
        
        <input type="submit" value="Add Book">
    </form>
</body>
</html>
