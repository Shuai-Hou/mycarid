package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Home</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../resources/kindeditor-4.1.7/themes/default/default.css\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../resources/kindeditor-4.1.7/plugins/code/prettify.css\" />\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/kindeditor-4.1.7/kindeditor.js\"></script>\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/kindeditor-4.1.7/lang/zh_CN.js\"></script>\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/kindeditor-4.1.7/plugins/code/prettify.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>\n");
      out.write("\tHello world! - \n");
      out.write("</h1>\n");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${controllerMessage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<a href=\"person/list\">Go to the person list</a>\n");
      out.write("<br/>\n");
      out.write("<textarea name=\"content1\" cols=\"100\" rows=\"8\" style=\"width:700px;height:200px;visibility:hidden;\"></textarea>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<!-- Duoshuo Comment BEGIN -->\n");
      out.write("\t<div class=\"ds-thread\"></div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var duoshuoQuery = {short_name:\"guxuede\"};\n");
      out.write("\t(function() {\n");
      out.write("\t\tvar ds = document.createElement('script');\n");
      out.write("\t\tds.type = 'text/javascript';ds.async = true;\n");
      out.write("\t\tds.src = 'http://static.duoshuo.com/embed.js';\n");
      out.write("\t\tds.charset = 'UTF-8';\n");
      out.write("\t\t(document.getElementsByTagName('head')[0] \n");
      out.write("\t\t|| document.getElementsByTagName('body')[0]).appendChild(ds);\n");
      out.write("\t})();\n");
      out.write("\t</script>\n");
      out.write("\t<script>\n");
      out.write("\t\tKindEditor.ready(function(K) {\n");
      out.write("\t\t\tvar editor1 = K.create('textarea[name=\"content1\"]', {\n");
      out.write("\t\t\t\tcssPath : '../resources/kindeditor-4.1.7/plugins/code/prettify.css',\n");
      out.write("\t\t\t\tuploadJson : '../jsp/upload_json.jsp',\n");
      out.write("\t\t\t\tfileManagerJson : '../jsp/file_manager_json.jsp',\n");
      out.write("\t\t\t\tallowFileManager : true,\n");
      out.write("\t\t\t\tafterCreate : function() {\n");
      out.write("\t\t\t\t\tvar self = this;\n");
      out.write("\t\t\t\t\tK.ctrl(document, 13, function() {\n");
      out.write("\t\t\t\t\t\tself.sync();\n");
      out.write("\t\t\t\t\t\tdocument.forms['example'].submit();\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t\tK.ctrl(self.edit.doc, 13, function() {\n");
      out.write("\t\t\t\t\t\tself.sync();\n");
      out.write("\t\t\t\t\t\tdocument.forms['example'].submit();\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tprettyPrint();\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("<!-- Duoshuo Comment END -->\n");
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
