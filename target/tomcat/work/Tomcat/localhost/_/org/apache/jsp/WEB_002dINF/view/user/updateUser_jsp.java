/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-08-24 09:58:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>updateUser</title>\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/layui/2.7.6/layui.js\"></script>\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("    #details{\r\n");
      out.write("        padding: 0 50px;\r\n");
      out.write("        margin-top: 50px;\r\n");
      out.write("    }\r\n");
      out.write("    #details select{\r\n");
      out.write("        width: 150px;\r\n");
      out.write("        height: 30px;\r\n");
      out.write("    }\r\n");
      out.write("    #details p{\r\n");
      out.write("        margin: 30px auto;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"details\">\r\n");
      out.write("    <form action=\"/user/updateUser\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("        <p><label for=\"userimg\">用户头像：</label><input type=\"file\" name=\"userimg\" id=\"userimg\"></p>\r\n");
      out.write("        <p><label for=\"userid\">用户id：</label><input type=\"text\" name=\"userid\" id=\"userid\" readonly value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></p>\r\n");
      out.write("        <p><label for=\"username\">用户姓名：</label></font><input id=\"username\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" /></p>\r\n");
      out.write("        <p><label for=\"username\">用户密码：</label></font><input id=\"userpass\" name=\"userpass\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userpass}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"password\" /></p>\r\n");
      out.write("        <p><label>用户性别：</label></font><input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.usergender}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" name=\"usergender\"/></p>\r\n");
      out.write("        <p><label>用户联系方式：</label></font><input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.usertel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text\" name=\"usertel\"/></p>\r\n");
      out.write("        <p><label>用户所在年级：</label></font><select name=\"usergrade\" id=\"grade\"></select></p>\r\n");
      out.write("        <p><label>用户所在校区：</label></font><select name=\"userlocation\" id=\"location\"></select></p>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"submit\"  value=\"点击保存\" id=\"btn\">\r\n");
      out.write("    </form>\r\n");
      out.write("    <button class=\"button btn-danger\" id=\"cancel\" >取消编辑</button>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            //动态给用户年级select添加值\r\n");
      out.write("            type: \"get\",\r\n");
      out.write("            url: \"/grade/getAllGrades\",\r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            async:false,\r\n");
      out.write("            success:function(data) {\r\n");
      out.write("                // console.log(data)\r\n");
      out.write("                $(\"#grade\").empty(); //select置空\r\n");
      out.write("                $(\"#grade\").append(new Option(\"请选择您的年级\"));\r\n");
      out.write("                // console.log(data)\r\n");
      out.write("                var data1 = data.data;  //每一项的数据data\r\n");
      out.write("                if (data1.length>0){\r\n");
      out.write("                    $.each(data1, function (index, item) {\r\n");
      out.write("                        $(\"#grade\").append(new Option(item.gradename,item.gradeid));\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("                layui.form.render();    //一定要最后重新渲染一下\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            //动态给select添加值\r\n");
      out.write("            type: \"get\",\r\n");
      out.write("            url: \"/location/getAllLocations\",\r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            async:false,\r\n");
      out.write("            success:function(data) {\r\n");
      out.write("                $(\"#location\").empty(); //select置空\r\n");
      out.write("                $(\"#location\").append(new Option(\"请选择您的校区\"));\r\n");
      out.write("                // console.log(data)\r\n");
      out.write("                var data1 = data.data;  //每一项的数据data\r\n");
      out.write("                if (data1.length>0){\r\n");
      out.write("                    $.each(data1, function (index, item) {\r\n");
      out.write("                        $(\"#location\").append(new Option(item.locationname,item.locationid));\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("                layui.form.render();    //一定要最后重新渲染一下\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    $(\"#btn\").click(function (){\r\n");
      out.write("        parent.window.location.reload();\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    $(\"#cancel\").click(function () {\r\n");
      out.write("        window.location.href = \"/user/goUserDetailChild\"\r\n");
      out.write("    })\r\n");
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
