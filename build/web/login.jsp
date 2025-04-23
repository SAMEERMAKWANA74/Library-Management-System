<%-- 
    Document   : login
    Created on : 23 Apr, 2025, 11:22:30 PM
    Author     : smaka
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .login-container {
            width: 350px;
            padding: 20px;
            margin: 100px auto;
            background-color: white;
            box-shadow: 0px 0px 10px gray;
            border-radius: 8px;
        }
        h2 {
            text-align: center;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            color: white;
            font-weight: bold;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <!-- On submit, go to index.jsp directly -->
    <form action="index.jsp" method="get">
        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <input type="submit" value="Sign In">
    </form>
</div>

</body>
</html>
