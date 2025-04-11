<%@ page import="java.sql.*" %>
<%
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String available = request.getParameter("available");

    if(title != null && author != null && available != null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "sameer5092");
            String query = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, Integer.parseInt(available));

            int result = ps.executeUpdate();
            if(result > 0){
                out.println("Book added successfully!");
            } else {
                out.println("Failed to add book.");
            }

            con.close();
        } catch(Exception e){
            out.println("Error: " + e.getMessage());
        }
    }
%>

<!-- Simple Form -->
<html>
    <head>  
        <style>
                        .imageset{
                          display: flex;
                          align-items: center;
                          
                }  
                img{
                        width:95%;
                        height: 75vh;
                        object-fit: contain;
                }
                
                                .imageset{
                          display: flex;
                          align-items: center;
                          
                }  
                
                .backbutton{
                           position: absolute;
                        top: 10px;
                        right: 10px;
                        z-index: 1000;
                }
                
                .allinpu{
                     height: 20%;
                     display: flex;
            justify-content: center;
           
                }
                
                .form-floating{
                        width: 50%;
            padding: 10px;
            border-radius: 15px;
                }
                
                .lastinpu {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: -35px;
                }
                .coppyinpu{
                           width: 50vh;

                padding: 8px;
                border-radius: 6px;
                border: 3px solid #ccc;
                            }
                
                
    </style>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="addbook.jsp" method="post">
    <div class="imageset"> <img src="books.jpg" alt="Responsive image">
         <button  type="button" onclick="location.href='index.jsp'" class="backbutton btn btn-secondary">Home</button>
</div> 
    <div class="allinpu">
        <div class="form-floating">
            <textarea class="form-control"  placeholder="Enter Book Name" name="title" id="floatingTextarea" required ></textarea>
            <label for="floatingTextarea">Enter book Name</label>
        </div>
    <br>
        <div class="form-floating">
            <textarea class="form-control" name="author" placeholder="Enter Author Name" id="floatingTextarea" required></textarea>
            <label for="floatingTextarea"> Enter Author Name</label>
        </div>
        </div>
    <div class="lastinpu">
    <input type="number" class="coppyinpu" name="available" placeholder="Available Copies" required />
    <br>
    <br>
    <input type="submit" class="btn btn-success" value="Add Book" />
    </div>
</form>
</body>
</html>