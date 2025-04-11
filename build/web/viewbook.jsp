<%-- 
    Document   : viewbook
    Created on : 10 Apr, 2025, 4:03:51 PM
    Author     : smaka
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 30px;
            background-color: #f4f4f4;
            
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            margin: auto;
            width: 80%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px #ccc;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
            border: 2px solid #ddd;
        }
        th {
            background-color: #28a745;
            color: white;
        }
        
        tr:hover {
            background-color: #f1f1f1;
        }
        
                        .backbutton{
                           position: absolute;
                        top: 10px;
                        right: 10px;
                        z-index: 1000;
                       }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<button  type="button" onclick="location.href='index.jsp'" class="backbutton btn btn-secondary">Home</button>
<h2>Library Book List</h2>

<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "sameer5092");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM books");
%>

<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Available</th>
    </tr>

<%
        while(rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("title") %></td>
        <td><%= rs.getString("author") %></td>
        <td><%= rs.getBoolean("available") ? "Yes" : "No" %></td>
    </tr>
<%
        }
        con.close();
    } catch(Exception e) {
%>
    <p style="color:red; text-align:center;">Error: <%= e.getMessage() %></p>
<%
    }
%>

</table>

</body>
</html>
