/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-08-25 00:57:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>userDetail</title>\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js\"></script>\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        *{\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("        }\r\n");
      out.write("        a{\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        body html{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("        }\r\n");
      out.write("        #tab{\r\n");
      out.write("            padding: 0 160px;\r\n");
      out.write("            background-color: rgb(247,247,247);\r\n");
      out.write("        }\r\n");
      out.write("        #container{\r\n");
      out.write("            height: 700px;\r\n");
      out.write("            background-color: rgb(247, 247, 247);\r\n");
      out.write("            padding: 0 160px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #imgArea{\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            width: 20%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            /*background-color: lightskyblue;*/\r\n");
      out.write("            position: relative;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        #imgArea #top{\r\n");
      out.write("            height: 40%;\r\n");
      out.write("            background-color: rgb(244, 244, 244);\r\n");
      out.write("            position: relative;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        #top div{\r\n");
      out.write("            width: 50%;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top:165px;\r\n");
      out.write("            left: 25%;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("        }\r\n");
      out.write("        #imgArea #bottom{\r\n");
      out.write("            height: 60%;\r\n");
      out.write("            background-color: rgb(255, 255, 255);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #bottom div{\r\n");
      out.write("            height: 20%;\r\n");
      out.write("            line-height: 80px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #imgArea img{\r\n");
      out.write("            display: block;\r\n");
      out.write("            width:50%;\r\n");
      out.write("            height: 60%;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 25%;\r\n");
      out.write("            border-radius: 100px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #userArea{\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            width: 45%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            margin-left: 30px;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("        #details{\r\n");
      out.write("            padding: 0 50px;\r\n");
      out.write("            margin-top: 50px;\r\n");
      out.write("        }\r\n");
      out.write("        #details select{\r\n");
      out.write("            width: 150px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        #details p{\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("        }\r\n");
      out.write("        #userArea p{\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div>\r\n");
      out.write("        <div id=\"tab\">\r\n");
      out.write("            <a href=\"/lost/showPartLosts\" >首页</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"container\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <div id=\"imgArea\">\r\n");
      out.write("                <div id=\"top\">\r\n");
      out.write("                    <img src=\"/image/user/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userimg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("                    <div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("                    <div style=\"top: 195px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.usertel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"bottom\">\r\n");
      out.write("                    <div><a href=\"/user/goUserDetailChild\" target=\"iframe\">个人信息</a></div>\r\n");
      out.write("                    <div><a href=\"/lost/getLostsByUserId\" target=\"iframe\">我发布的丢失物品信息</a></div>\r\n");
      out.write("                    <div><a>隐私中心</a></div>\r\n");
      out.write("                    <div><a>绑定授权</a></div>\r\n");
      out.write("                    <div><a>帮助中心</a></div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"userArea\">\r\n");
      out.write("                <iframe height=\"700px\" width=\"1000px\" name=\"iframe\" src=\"/user/goUserDetailChild\">\r\n");
      out.write("\r\n");
      out.write("                </iframe>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}