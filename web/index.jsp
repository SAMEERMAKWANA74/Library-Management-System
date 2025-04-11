<%-- 
    Document   : index.jsp
    Created on : 29 Mar, 2025, 9:49:24 PM
    Author     : sameer makwana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Management By Sameer_Makwana</title>
        <style>


                .button-container {
                  display: flex;
                  justify-content: center;
                  margin-top: 20px;
                }

                .button-container ul {
                  display: flex;
                  gap: 20px;
                  padding: 0;
                  list-style: none;
                }

                .button-container ul li button {
                  width: 150px;
                  padding: 10px;
                  text-align: center;
                }
                
                h1{
                    margin-left: 25vh;
                    font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;

                  }
                .imageset{
                          display: flex;
                          align-items: center;
                          
                }  
                img{
                        width:95%;
                        height: 75vh;
                        object-fit: contain;
                }
                
                .logbutton{
                        position: absolute;
                        top: 10px;
                        right: 10px;
                        z-index: 1000;
                }

        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Smart Library Management - Track, Issue, And Return Books</h1>
        <div class="imageset">
                    <img src="lms.png" alt="Responsive image">
                    <button  type="button" onclick="location.href='addbook.jsp'" class="logbutton btn btn-outline-danger">logout</button>
        </div>
            
        <div class="button-container">
                <ul>
                  <li><button type="button" onclick="location.href='addbook.jsp'" class="btn btn-warning">Add Book</button></li>
                  <li><button type="button" onclick="location.href='viewbook.jsp'" class="btn btn-warning">View Book</button></li>
                  <li><button type="button" onclick="location.href='issuebook.jsp'" class="btn btn-warning">Issue Book</button></li>
                  <li><button type="button" onclick="location.href='returnbook.jsp'" class="btn btn-warning">Return Book</button></li>
                </ul>
        </div>
           
    </body>
</html>
