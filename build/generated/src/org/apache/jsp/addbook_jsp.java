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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
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

      out.write("\n");
      out.write("\n");
      out.write("<!-- Simple Form -->\n");
      out.write("<form action=\"addbook.jsp\" method=\"post\">\n");
      out.write("    <input type=\"text\" name=\"title\" placeholder=\"Book Title\" required />\n");
      out.write("    <input type=\"text\" name=\"author\" placeholder=\"Author\" required />\n");
      out.write("    <input type=\"number\" name=\"available\" placeholder=\"Available Copies\" required />\n");
      out.write("    <input type=\"submit\" value=\"Add Book\" />\n");
      out.write("</form>\n");
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
