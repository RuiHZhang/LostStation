/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-08-25 01:03:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>login</title>\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\" id=\"app\" style=\"width: 40%;height: 100px ;margin: 0 auto\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-6 col-md-offset-3\" style=\"height: 410px;border: 1px solid black;margin-top: 80px; border-radius: 8px; \">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\" style=\"text-align: center;font-size: 50px;font-weight: bold;margin-top: 50px;\">\r\n");
      out.write("                    用户登录\r\n");
      out.write("                </div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("                <form class=\"layui-form\" action=\"/user/login\" method=\"post\">\r\n");
      out.write("                    <div class=\"layui-form-item\" style=\"width: 60%;margin: 15px auto\">\r\n");
      out.write("                        <label class=\"layui-form-label\">用户名</label>\r\n");
      out.write("                        <div class=\"layui-input-block\">\r\n");
      out.write("                            <input type=\"text\" name=\"username\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-form-item\" style=\"width: 60%;margin: 15px auto\">\r\n");
      out.write("                        <label class=\"layui-form-label\">密码框</label>\r\n");
      out.write("                        <div class=\"layui-input-block\">\r\n");
      out.write("                            <input type=\"password\" name=\"userpass\" required lay-verify=\"required\" placeholder=\"请输入密码\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-form-item\" align=\"center\" >\r\n");
      out.write("                        <div class=\"layui-input-block\" style=\"left: -55px\">\r\n");
      out.write("                            <button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\" type=\"submit\">登录</button>\r\n");
      out.write("                            <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("                            <button class=\"layui-btn\"><a href=\"/user/goRegister\" style=\"color: white\">前往注册</a></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    //Demo\r\n");
      out.write("    layui.use('form', function(){\r\n");
      out.write("        var form = layui.form;\r\n");
      out.write("\r\n");
      out.write("        //监听提交\r\n");
      out.write("        form.on('', function(data){\r\n");
      out.write("            layer.msg(JSON.stringify(data.field));\r\n");
      out.write("            return false;\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
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