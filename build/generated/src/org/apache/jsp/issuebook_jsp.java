package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class issuebook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Issue Book</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            padding: 30px;\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("        form {\n");
      out.write("            width: 400px;\n");
      out.write("            margin: auto;\n");
      out.write("            padding: 25px;\n");
      out.write("            background-color: #fff;\n");
      out.write("            box-shadow: 0 0 10px #ccc;\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("        input {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            background-color: #28a745;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .msg {\n");
      out.write("            text-align: center;\n");
      out.write("            color: green;\n");
      out.write("        }\n");
      out.write("        .error {\n");
      out.write("            text-align: center;\n");
      out.write("            color: red;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("                          .backbutton{\n");
      out.write("                           position: absolute;\n");
      out.write("                        top: 10px;\n");
      out.write("                        right: 10px;\n");
      out.write("                        z-index: 1000;\n");
      out.write("                       }\n");
      out.write("    </style>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h2>Issue Book to User</h2>\n");
      out.write("\n");

    String bookId = request.getParameter("book_id");
    String userId = request.getParameter("user_id");

    if (bookId != null && userId != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "sameer5092");

            String sql = "INSERT INTO issues_book (book_id, user_id, issue_date) VALUES (?, ?, NOW())";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(bookId));
            ps.setInt(2, Integer.parseInt(userId));

            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("<p class='msg'>Book issued successfully!</p>");
            } else {
                out.println("<p class='error'>Failed to issue book.</p>");
            }

            con.close();
        } catch(Exception e) {
            out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<form action=\"issuebook.jsp\" method=\"post\">\n");
      out.write("    <button  type=\"button\" onclick=\"location.href='index.jsp'\" class=\"backbutton btn btn-secondary\">Home</button>\n");
      out.write("\n");
      out.write("    <label>Book ID:</label>\n");
      out.write("    <input type=\"number\" name=\"book_id\" placeholder=\"Enter Book ID\" required />\n");
      out.write("\n");
      out.write("    <label>User ID:</label>\n");
      out.write("    <input type=\"number\" name=\"user_id\" placeholder=\"Enter User ID\" required />\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Issue Book\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
