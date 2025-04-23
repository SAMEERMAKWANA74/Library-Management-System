package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class addbook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String available = request.getParameter("available");

    if(title != null && author != null && available != null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "Sameer@2005");
            String query = "INSERT INTO books (title, author, availabe) VALUES (?, ?, ?)";
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

      out.write("\n");
      out.write("\n");
      out.write("<!-- Simple Form -->\n");
      out.write("<html>\n");
      out.write("    <head>  \n");
      out.write("        <style>\n");
      out.write("                        .imageset{\n");
      out.write("                          display: flex;\n");
      out.write("                          align-items: center;\n");
      out.write("                          \n");
      out.write("                }  \n");
      out.write("                img{\n");
      out.write("                        width:95%;\n");
      out.write("                        height: 75vh;\n");
      out.write("                        object-fit: contain;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                                .imageset{\n");
      out.write("                          display: flex;\n");
      out.write("                          align-items: center;\n");
      out.write("                          \n");
      out.write("                }  \n");
      out.write("                \n");
      out.write("                .backbutton{\n");
      out.write("                           position: absolute;\n");
      out.write("                        top: 10px;\n");
      out.write("                        right: 10px;\n");
      out.write("                        z-index: 1000;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .allinpu{\n");
      out.write("                     height: 20%;\n");
      out.write("                     display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("           \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .form-floating{\n");
      out.write("                        width: 50%;\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                .lastinpu {\n");
      out.write("    display: flex;\n");
      out.write("    flex-direction: column;\n");
      out.write("    align-items: center;\n");
      out.write("    margin-top: -35px;\n");
      out.write("                }\n");
      out.write("                .coppyinpu{\n");
      out.write("                           width: 50vh;\n");
      out.write("\n");
      out.write("                padding: 8px;\n");
      out.write("                border-radius: 6px;\n");
      out.write("                border: 3px solid #ccc;\n");
      out.write("                            }\n");
      out.write("                \n");
      out.write("                \n");
      out.write("    </style>\n");
      out.write("            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form action=\"addbook.jsp\" method=\"post\">\n");
      out.write("    <div class=\"imageset\"> <img src=\"books.jpg\" alt=\"Responsive image\">\n");
      out.write("         <button  type=\"button\" onclick=\"location.href='index.jsp'\" class=\"backbutton btn btn-secondary\">Home</button>\n");
      out.write("</div> \n");
      out.write("    <div class=\"allinpu\">\n");
      out.write("        <div class=\"form-floating\">\n");
      out.write("            <textarea class=\"form-control\"  placeholder=\"Enter Book Name\" name=\"title\" id=\"floatingTextarea\" required ></textarea>\n");
      out.write("            <label for=\"floatingTextarea\">Enter book Name</label>\n");
      out.write("        </div>\n");
      out.write("    <br>\n");
      out.write("        <div class=\"form-floating\">\n");
      out.write("            <textarea class=\"form-control\" name=\"author\" placeholder=\"Enter Author Name\" id=\"floatingTextarea\" required></textarea>\n");
      out.write("            <label for=\"floatingTextarea\"> Enter Author Name</label>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("    <div class=\"lastinpu\">\n");
      out.write("    <input type=\"number\" class=\"coppyinpu\" name=\"availabe\" placeholder=\"Available Copies\" required />\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <input type=\"submit\" class=\"btn btn-success\" value=\"Add Book\" />\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
