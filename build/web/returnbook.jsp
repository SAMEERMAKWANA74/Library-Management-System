<%-- 
    Document   : returnbook
    Created on : 10 Apr, 2025, 5:34:47 PM
    Author     : smaka
--%>
<%@ page import="java.sql.*" %>
<%
    String bookId = request.getParameter("book_id");
    String userId = request.getParameter("user_id");

    if(bookId != null && userId != null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");

            // 1. Delete from issues_book or update status
            String deleteQuery = "DELETE FROM issues_book WHERE book_id=? AND user_id=?";
            PreparedStatement ps1 = con.prepareStatement(deleteQuery);
            ps1.setInt(1, Integer.parseInt(bookId));
            ps1.setInt(2, Integer.parseInt(userId));
            int result1 = ps1.executeUpdate();

            // 2. Update availability in books table
            String updateQuery = "UPDATE books SET available=1 WHERE id=?";
            PreparedStatement ps2 = con.prepareStatement(updateQuery);
            ps2.setInt(1, Integer.parseInt(bookId));
            int result2 = ps2.executeUpdate();

            if(result1 > 0 && result2 > 0){
                out.println("<p style='color:green; font-weight:bold;'>Book returned successfully!</p>");
            } else {
                out.println("<p style='color:red;'>Error: Book return failed. Please check Book ID and User ID.</p>");
            }

            con.close();
        } catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
%>
<html>
    
    <head>
        <style>

                .form-container {
                    max-width: 450px;
                    margin: 50px auto;
                    background: #f7f9fc;
                    padding: 30px 40px;
                    border-radius: 12px;
                    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                }

                .form-container h2 {
                    text-align: center;
                    margin-bottom: 25px;
                    font-size: 24px;
                    color: #2c3e50;
                    font-weight: 600;
                }

                .form-container label {
                    display: block;
                    margin-bottom: 8px;
                    font-weight: bold;
                    color: #34495e;
                    font-size: 15px;
                }

                .form-container input[type="number"],
                .form-container input[type="text"],
                .form-container input[type="date"] {
                    width: 100%;
                    padding: 10px 12px;
                    margin-bottom: 20px;
                    border: 1px solid #ccc;
                    border-radius: 8px;
                    font-size: 15px;
                    transition: all 0.3s ease;
                }

                .form-container input:focus {
                    border-color: #007bff;
                    outline: none;
                    box-shadow: 0 0 4px rgba(0, 123, 255, 0.4);
                }

                .form-container input[type="submit"] {
                    width: 100%;
                    padding: 12px;
                    background-color: #28a745;
                    border: none;
                    color: white;
                    font-size: 16px;
                    border-radius: 8px;
                    cursor: pointer;
                    transition: background-color 0.3s ease;
                    font-weight: bold;
                }

                .form-container input[type="submit"]:hover {
                    background-color: #218838;
                }

                p {
                    text-align: center;
                    font-size: 16px;
                    font-weight: 500;
                    margin-top: 20px;
                }
                
                .backbutton{
                           position: absolute;
                        top: 10px;
                        right: 10px;
                        z-index: 1000;
                       }


        </style>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </heaa>
    <body>
         <button  type="button" onclick="location.href='index.jsp'" class="backbutton btn btn-secondary">Home</button>
         <div class="form-container">
    <h2>Return Book</h2>
    <form action="returnbook.jsp" method="post">
        <label for="book_id">Book ID</label>
        <input type="number" name="book_id" required />

        <label for="user_id">User ID</label>
        <input type="number" name="user_id" required />

        <input type="submit" value="Return Book" />
    </form>
</div>

    </body>
</html>