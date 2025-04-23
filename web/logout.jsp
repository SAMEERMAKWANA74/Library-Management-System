<%-- 
    Document   : logout
    Created on : 23 Apr, 2025, 11:25:01 PM
    Author     : smaka
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Destroy the session if it exists
    session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Logout Successful</title>
    <style>
        body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
        }
        .logout-container {
            width: 400px;
            margin: 100px auto;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            text-align: center;
            border-radius: 10px;
        }
        h2 {
            color: #4CAF50;
        }
        p {
            margin-top: 10px;
            color: #555;
        }
        .login-btn {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            border: none;
            color: white;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .login-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="logout-container">
    <h2>You have been logged out!</h2>
    <p>Thank you for visiting.</p>
    <a class="login-btn" href="login.jsp">Back to Login</a>
</div>

</body>
</html>
