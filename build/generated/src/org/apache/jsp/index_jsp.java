package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Library Management By Sameer_Makwana</title>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("\n");
      out.write("                .button-container {\n");
      out.write("                  display: flex;\n");
      out.write("                  justify-content: center;\n");
      out.write("                  margin-top: 20px;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .button-container ul {\n");
      out.write("                  display: flex;\n");
      out.write("                  gap: 20px;\n");
      out.write("                  padding: 0;\n");
      out.write("                  list-style: none;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                .button-container ul li button {\n");
      out.write("                  width: 150px;\n");
      out.write("                  padding: 10px;\n");
      out.write("                  text-align: center;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                h1{\n");
      out.write("                    margin-left: 25vh;\n");
      out.write("                    font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("\n");
      out.write("                  }\n");
      out.write("                .imageset{\n");
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
      out.write("                .logbutton{\n");
      out.write("                        position: absolute;\n");
      out.write("                        top: 10px;\n");
      out.write("                        right: 10px;\n");
      out.write("                        z-index: 1000;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Smart Library Management - Track, Issue, And Return Books</h1>\n");
      out.write("        <div class=\"imageset\">\n");
      out.write("                    <img src=\"lms.png\" alt=\"Responsive image\">\n");
      out.write("                    <button  type=\"button\" onclick=\"location.href='logout.jsp'\" class=\"logbutton btn btn-outline-danger\">logout</button>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <div class=\"button-container\">\n");
      out.write("                <ul>\n");
      out.write("                  <li><button type=\"button\" onclick=\"location.href='addbook.jsp'\" class=\"btn btn-warning\">Add Book</button></li>\n");
      out.write("                  <li><button type=\"button\" onclick=\"location.href='viewbook.jsp'\" class=\"btn btn-warning\">View Book</button></li>\n");
      out.write("                  <li><button type=\"button\" onclick=\"location.href='issuebook.jsp'\" class=\"btn btn-warning\">Issue Book</button></li>\n");
      out.write("                  <li><button type=\"button\" onclick=\"location.href='returnbook.jsp'\" class=\"btn btn-warning\">Return Book</button></li>\n");
      out.write("                </ul>\n");
      out.write("        </div>\n");
      out.write("           \n");
      out.write("    </body>\n");
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
