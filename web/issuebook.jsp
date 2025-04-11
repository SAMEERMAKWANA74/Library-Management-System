<%@ page import="java.sql.*" %>
<%
    String bookId = request.getParameter("book_id");
    String userId = request.getParameter("user_id");
    String issueDate = request.getParameter("issue_date");
    String returnDate = request.getParameter("return_date");

    if(bookId != null && userId != null && issueDate != null && returnDate != null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "sameer5092");

            // Check if book is available
            String checkQuery = "SELECT available FROM books WHERE id = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, Integer.parseInt(bookId));
            ResultSet rs = checkStmt.executeQuery();

            if(rs.next() && rs.getBoolean("available")) {
                // Insert issue record
                String insertQuery = "INSERT INTO issues_book (book_id, user_id, issue_date, return_date) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setInt(1, Integer.parseInt(bookId));
                ps.setInt(2, Integer.parseInt(userId));
                ps.setString(3, issueDate);
                ps.setString(4, returnDate);

                int result = ps.executeUpdate();

                // If insert successful, update book availability
                if(result > 0){
                    String updateBook = "UPDATE books SET available = 0 WHERE id = ?";
                    PreparedStatement updateStmt = con.prepareStatement(updateBook);
                    updateStmt.setInt(1, Integer.parseInt(bookId));
                    updateStmt.executeUpdate();

                    out.println("<p>Book issued successfully!</p>");
                } else {
                    out.println("Failed to issue book.");
                }
            } else {
                out.println("<p class=nocolor>Book is Not Available.<p>");
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
            p{
                color: green;
                z-index: 1000;
                position: absolute;
                left: 10px;
                top:10px;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                font-size: 20px;
                line-height: 1.7;
                margin: 15px 0;
                font-weight: 500;
                text-align: justify;
            }
            
                    
            
            .nocolor{
                color: red;
                z-index: 1000;
                position: absolute;
                left: 10px;
                top:10px;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                font-size: 20px;
                line-height: 1.7;
                margin: 15px 0;
                font-weight: 500;
                text-align: justify;
            }
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f1f1f1;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    min-height: 100vh;
                }

                .form-container {
                    background-color: white;
                    padding: 30px;
                    border-radius: 15px;
                    box-shadow: 0 0 15px rgba(0,0,0,0.1);
                    width: 350px;
                }

                .form-container h2 {
                    text-align: center;
                    margin-bottom: 20px;
                    color: #333;
                }

                .form-container input[type="number"],
                .form-container input[type="date"],
                .form-container input[type="submit"] {
                    width: 100%;
                    padding: 12px;
                    margin: 10px 0;
                    border: 1px solid #ccc;
                    border-radius: 8px;
                    box-sizing: border-box;
                }

                .form-container input[type="submit"] {
                    background-color: #28a745;
                    color: white;
                    border: none;
                    cursor: pointer;
                    font-weight: bold;
                    transition: background-color 0.3s ease;
                }

                .form-container input[type="submit"]:hover {
                    background-color: #218838;
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
 
   <div class="form-container">
    <h2>Issue Book</h2>
    <form action="issuebook.jsp" method="post">
        <input type="number" name="book_id" placeholder="Enter Book ID" required />
        <input type="number" name="user_id" placeholder="Enter User ID" required />
        <input type="date" name="issue_date" required />
        <input type="date" name="return_date" required />
        <input type="submit" value="Issue Book" />
    </form>
</div>

    </body>
</html>

