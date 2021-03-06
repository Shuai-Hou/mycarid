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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("  \n");
      out.write("<!DOCTYPE html>  \n");
      out.write("<html>  \n");
      out.write("<head>  \n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">  \n");
      out.write("<link rel=\"stylesheet\" href=\"stylesheets/general_foundicons.css\">\n");
      out.write("\t<script src=\"jquery-1.8.3.js\"></script>\n");
      out.write("\t<script src=\"../resources/script/jquery-ui-latest.js\"></script>\n");
      out.write("\t<script src=\"../resources/script/jquery.layout-latest.js\"></script>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../resources/kindeditor-4.1.7/themes/default/default.css\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../resources/kindeditor-4.1.7/plugins/code/prettify.css\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../resources/css/layout-default-latest.css\" />\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/kindeditor-4.1.7/kindeditor.js\"></script>\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/kindeditor-4.1.7/lang/zh_CN.js\"></script>\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/kindeditor-4.1.7/plugins/code/prettify.js\"></script>\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/script/template.js\"></script>\n");
      out.write("\t<script charset=\"utf-8\" src=\"../resources/script/StackBlur.js\"></script>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\tbody, div, address, blockquote, iframe, ul, ol, dl, dt, \n");
      out.write("\tdd, li, dl, h1, h2, h3, h4, pre, table, caption, th, td, form, \n");
      out.write("\tlegend, fieldset, input, button, select, textarea {margin:0; padding:0;font-style: normal;font:12px/22px Arial, Helvetica, sans-serif;} \n");
      out.write("\tol, ul ,li{list-style: none;} \n");
      out.write("\timg {border: 0; vertical-align:middle;} \n");
      out.write("\tbody{color:#000000;background:#FFF;} \n");
      out.write("\t.clear{clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;} \n");
      out.write("\ta{color:#000000;text-decoration:none; }  \n");
      out.write("\ta:hover{color:#BA2636;text-decoration:underline;} \n");
      out.write("\t\n");
      out.write("\t.bottomPane{\n");
      out.write("\t\tposition: fixed;\n");
      out.write("\t\tbottom: 0px;\n");
      out.write("\t\twidth: 100%;\n");
      out.write("\t\tbackground-color: gray;\n");
      out.write("\t}\n");
      out.write("\t#messagelist{\n");
      out.write("\t\theight: 100%;\n");
      out.write("\t\tword-wrap: break-word;\n");
      out.write("\t\toverflow: auto;\n");
      out.write("\t\tlist-style: none;\n");
      out.write("\t\tpadding: 0 10px;\n");
      out.write("\t}\n");
      out.write("\t#messagelist li{\n");
      out.write("\t\twidth: 100%;\n");
      out.write("\t\toverflow: hidden;\n");
      out.write("\t\tclear: both;\n");
      out.write("\t\tborder-top: 1px solid rgba(0,0,0,0.13);\n");
      out.write("\t\tmargin: 0;\n");
      out.write("\t\tpadding: 0;\n");
      out.write("\t\tlist-style: none;\n");
      out.write("\t\t\n");
      out.write("\t\tbox-shadow: 0 1px 3px rgba(0,0,0,0.22);\n");
      out.write("\t\t-webkit-border-radius: 3px;\n");
      out.write("\t\tborder-radius: 3px;\n");
      out.write("\t}\n");
      out.write("\t#msgInput{\n");
      out.write("\t\twidth: 300px;\n");
      out.write("\t}\n");
      out.write("\t.avatar{\n");
      out.write("\t\tbox-shadow: 0 1px 1px rgba(255,255,255,0.75);\n");
      out.write("\t\tposition: relative;\n");
      out.write("\t\t-webkit-border-radius: 3px;\n");
      out.write("\t\tborder-radius: 3px;\n");
      out.write("\t\tbackground-color: #fff;\n");
      out.write("\t\tfloat: left;\n");
      out.write("\t}\n");
      out.write("\t.avatar img{\n");
      out.write("\t\tdisplay: block;\n");
      out.write("\t\twidth: 40px;\n");
      out.write("\t\theight: 40px;\n");
      out.write("\t\tmax-width: none;\n");
      out.write("\t\tbox-shadow: 0 1px 3px rgba(0,0,0,0.22);\n");
      out.write("\t\t-webkit-border-radius: 3px;\n");
      out.write("\t\tborder-radius: 3px;\n");
      out.write("\t}\n");
      out.write("\t.comment{\n");
      out.write("\t\tpadding-left: 50px;\n");
      out.write("\t}\n");
      out.write("\t.comment-head{\n");
      out.write("\t\tfloat: right;\n");
      out.write("\t\tposition: relative;\n");
      out.write("\t\ttop: -10px;\n");
      out.write("\t}\n");
      out.write("\t.comment-head span{\n");
      out.write("\t\tcolor: gray;\n");
      out.write("\t}\n");
      out.write("\t.comment-body{\n");
      out.write("\n");
      out.write("\t}\n");
      out.write("\t.comment-body p{\n");
      out.write("\t\tfont-size: 13px;\n");
      out.write("\t\tline-height: 1.5em;\n");
      out.write("\t\tmargin: .5em 0;\n");
      out.write("\t\tword-wrap: break-word;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.comment-stack{\n");
      out.write("\t\tposition: relative;\n");
      out.write("\t\tpadding: 5px 5px 15px 5px;\n");
      out.write("\t\tborder-top: 1px solid rgba(255,255,255,0.7);\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("<title>");
      out.print( request.getParameter("room")==null?"大厅":new String(request.getParameter("room")) );
      out.write("</title>  \n");
      out.write("\n");
      out.write("<script id=\"test\" type=\"text/html\">\n");
      out.write("\t<li>\n");
      out.write("\t\t<div class=\"comment-stack\">\n");
      out.write("\t\t\t<div class=\"avatar\"><img src=\"<!--[==avatar]-->\" alt=\"<!--[==name]-->\" title=\"<!--[==name]-->\"></div>\n");
      out.write("\t\t\t<div class=\"comment\">\n");
      out.write("\t\t\t\t<div class=\"comment-head\"><a href=\"#\"><!--[==name]--></a> <span><!--[==time]--></span></div>\n");
      out.write("\t\t\t\t<div class=\"comment-body\"><p><!--[==msg]--></p></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</li>\n");
      out.write("</script>\n");
      out.write("<script id=\"tem_user\" type=\"text/html\">\n");
      out.write("\t<!--[ for (var i=0;i<list.length;i++){ ]-->\n");
      out.write("        <li>\n");
      out.write("\t\t\t<div class=\"avatar\"><img src=\"<!--[=list[i].avatar]-->\" alt=\"<!--[=list[i].name]-->\"></div>\n");
      out.write("\t\t</li>\n");
      out.write("   <!--[ } ]-->\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">  \n");
      out.write("\ttemplate.openTag = '<!--[';\n");
      out.write("\ttemplate.closeTag = ']-->';\n");
      out.write("\tvar iconmap={'大厅':'foundicon-people',\n");
      out.write("\t\t\t'厨房':'foundicon-home',\n");
      out.write("\t\t\t'厕所':'foundicon-inbox',\n");
      out.write("\t\t\t'卧室':'foundicon-heart',\n");
      out.write("\t\t\t'二次元世界':'foundicon-globe',\n");
      out.write("\t\t\t'default:':'foundicon-smiley'\n");
      out.write("\t\t\t};\n");
      out.write("\tvar roomname=\"");
      out.print( request.getParameter("room")==null?"大厅":new String(request.getParameter("room")) );
      out.write("\";\n");
      out.write("\tvar ws = null;  \n");
      out.write("\t$(function(){\n");
      out.write("\t\tvar name=getCookie(\"name\");\n");
      out.write("\t\tvar avatar=getCookie(\"avatar\");\n");
      out.write("\t\tif(name){\n");
      out.write("\t\t\tinitLink(name);\n");
      out.write("\t\t\tinitUI();\n");
      out.write("\t\t}else{\n");
      out.write("\t\t\twhile(name==\"\" || name==null){\n");
      out.write("\t\t\t\tname = window.prompt(\"欢迎,请务必输入您的大名\",\"\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tif(name!=null){\n");
      out.write("\t\t\t\tavatar = window.prompt(\"最好配上你的头像地址\",\"\");\n");
      out.write("\t\t\t\tsetCoolie(\"name\",name);\n");
      out.write("\t\t\t\tsetCoolie(\"avatar\",avatar);\n");
      out.write("\t\t\t\tinitLink(name,avatar);\n");
      out.write("\t\t\t\tinitUI();\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\talert(\"求你了...\");\n");
      out.write("\t\t\t\twindow.location.href=window.location.href;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("\t  \n");
      out.write("\tfunction initLink(name,avatar){\n");
      out.write("\t\tvar url=\"ws://localhost:8080/socket.sk?name=\"+name+\"&room=\"+roomname+\"&avatar=\"+avatar;\n");
      out.write("\t    if ('WebSocket' in window){\n");
      out.write("\t        ws = new WebSocket(url);  \n");
      out.write("\t    }else if ('MozWebSocket' in window){\n");
      out.write("\t        ws = new MozWebSocket(url);  \n");
      out.write("\t    }else{\n");
      out.write("\t    \t$('#messagelist').append(\"<li>Your browser does not support WebSocket</li>\");\n");
      out.write("\t    }\n");
      out.write("\t    \n");
      out.write("\t    ws.onmessage = function(evt) {  \n");
      out.write("\t    \tconsole.log(evt.data);\n");
      out.write("\t       var data=eval(\"(\"+evt.data+\")\");\n");
      out.write("\t       console.log(data);\n");
      out.write("\t       var html = template.render('test', data);\n");
      out.write("\t       $('#messagelist').append(html);\n");
      out.write("\t       //$('#messagelist').append(\"<li>\"+evt.data+\"</li>\");\n");
      out.write("\t       var div=document.getElementById('messagelist'); \n");
      out.write("\t       div.scrollTop = div.scrollHeight;\n");
      out.write("\t    };  \n");
      out.write("\t    ws.onclose = function(evt) {  \n");
      out.write("\t    \t $('#messagelist').append(\"<li>主动断开了链接...</li>\");\n");
      out.write("\t    };  \n");
      out.write("\t    ws.onopen = function(evt) {  \n");
      out.write("\t    \t$('#messagelist').append(\"<li>链接成功...</li>\"); \n");
      out.write("\t    \tloadRoomUsers();\n");
      out.write("\t    };  \n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction initUI(){\n");
      out.write("\t\t$('.faceButton').click(function(){\n");
      out.write("\t\t\t$('.face').toggle(100);\n");
      out.write("\t\t});\n");
      out.write("\t\t$('.faces_list li').click(function(){\n");
      out.write("\t\t\t $('#msgInput').val($('#msgInput').val()+$(this).html());\n");
      out.write("\t\t});\n");
      out.write("\t\t//$('#msgInput').inputHistory({\n");
      out.write("\t\t//\t  size: 10\n");
      out.write("\t\t//});\n");
      out.write("\t\t$('#msgInput').bind('keydown', function(e) {\n");
      out.write("\t\t   if (e.keyCode == 13) {\n");
      out.write("\t\t     ws.send($(this).val()); \n");
      out.write("\t\t     $(this).val('');\n");
      out.write("\t\t   }\n");
      out.write("\t\t});\n");
      out.write("\t\t//var bgclass=iconmap[roomname];\n");
      out.write("\t\t//if(!bgclass)bgclass=\"foundicon-smiley\";\n");
      out.write("\t\t//$('.bg i').removeClass();\n");
      out.write("\t\t//$('.bg i').addClass(bgclass);\n");
      out.write("\t\t$('body').layout({ applyDemoStyles: true });\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction sendMsg() {  \n");
      out.write("\t\tvar msg=$('textarea[name=\"content1\"]');\n");
      out.write("\t\tif(msg.length > 0){\n");
      out.write("\t\t    ws.send(msg.val()); \n");
      out.write("\t\t    KindEditor.instances[0].html('');\n");
      out.write("\t\t}\n");
      out.write("\t}  \n");
      out.write("\tfunction clean(){\n");
      out.write("\t\t$('#messagelist').empty();\n");
      out.write("\t}\n");
      out.write("\tfunction loadRoomUsers(){\n");
      out.write("\t\t$.ajax({\n");
      out.write("            type: \"get\",\n");
      out.write("            dataType: \"json\",\n");
      out.write("            url: \"../spring/socket/\"+roomname+\"/users\",\n");
      out.write("            //data: \"pageIndex=\" + pageIndex,\n");
      out.write("            //complete :function(){$(\"#load\").hide();},\n");
      out.write("            success: function(msg){\n");
      out.write("            \tconsole.log(msg);\n");
      out.write("     \t        var html = template.render('tem_user', {list:msg});\n");
      out.write("    \t        $('#userlist').append(html);\n");
      out.write("            }\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\tfunction getCookie(name){\n");
      out.write("\t\t var arr = document.cookie.match(new RegExp(\"(^| )\"+name+\"=([^;]*)(;|$)\"));\n");
      out.write("\t\t if(arr != null) return unescape(arr[2]); return null;\n");
      out.write("\t};\t\n");
      out.write("\tfunction setCoolie(name,value){\n");
      out.write("\t\tvar Days = 30;\n");
      out.write("\t\tvar exp  = new Date();\n");
      out.write("\t\texp.setTime(exp.getTime() + Days*24*60*60*1000);\n");
      out.write("\t\tdocument.cookie = name + \"=\"+ escape(value) +\";expires=\"+ exp.toGMTString();\n");
      out.write("\t};\n");
      out.write("\tfunction delCookie(name){\n");
      out.write("\t  var exp = new Date();\n");
      out.write("\t  exp.setTime(exp.getTime() - 1);\n");
      out.write("\t  var cval=getCookie(name);\n");
      out.write("\t  if(cval!=null) document.cookie=name +\"=\"+cval+\";expires=\"+exp.toGMTString();\n");
      out.write("\t};\n");
      out.write("\tfunction loginout(){\n");
      out.write("\t\tws.close();\n");
      out.write("\t\tdelCookie('name');\n");
      out.write("\t\twindow.location.href=window.location.href;\n");
      out.write("\t}\n");
      out.write("\tKindEditor.ready(function(K) {\n");
      out.write("\t\tvar editor1 = K.create('textarea[name=\"content1\"]', {\n");
      out.write("\t\t\tcssPath : '../resources/kindeditor-4.1.7/plugins/code/prettify.css',\n");
      out.write("\t\t\tuploadJson : '../jsp/upload_json.jsp',\n");
      out.write("\t\t\tfileManagerJson : '../jsp/file_manager_json.jsp',\n");
      out.write("\t\t\tallowFileManager : true,\n");
      out.write("\t\t\tafterBlur : function() {\n");
      out.write("\t\t\t\tthis.sync();\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tafterCreate : function() {\n");
      out.write("\t\t\t\tvar self = this;\n");
      out.write("\t\t\t\tK.ctrl(document, 13, function() {\n");
      out.write("\t\t\t\t\tself.sync();\n");
      out.write("\t\t\t\t\tsendMsg();\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\tK.ctrl(self.edit.doc, 13, function() {\n");
      out.write("\t\t\t\t\tself.sync();\n");
      out.write("\t\t\t\t\tsendMsg();\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\tprettyPrint();\n");
      out.write("\t});\n");
      out.write("</script>  \n");
      out.write("\n");
      out.write("</head>  \n");
      out.write("<body>  \n");
      out.write("<img id=\"bgimg\" src=\"../../resources/img/dating.jpg\" style=\"width: 100%; height: 100%;display: none;\" onLoad=\"stackBlurImage('bgimg', 'canvas', 20, 0.1);\"></img>\n");
      out.write("<canvas id=\"canvas\" style=\"position: absolute;z-index: -1;top: 0px;width: 800px;height: 400px;\"></canvas>\n");
      out.write("<div class=\"ui-layout-center\">\n");
      out.write("\t<ul id=\"messagelist\" class=\"messagelist\">\n");
      out.write("\t\t<li>welcome</li>\n");
      out.write("\t\t<li>\n");
      out.write("\t\t\t<div class=\"comment-stack\">\n");
      out.write("\t\t\t\t<div class=\"avatar\"><img src=\"http://tp3.sinaimg.cn/2700830310/50/40012779595/1\" alt=\"guxuede\"></div>\n");
      out.write("\t\t\t\t<div class=\"comment\">\n");
      out.write("\t\t\t\t\t<div class=\"comment-head\"><a href=\"#\">guxuede</a> 2012-1-2</div>\n");
      out.write("\t\t\t\t\t<div class=\"comment-body\"><p>晚上哈</p></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t</ul>\n");
      out.write("</div>\n");
      out.write("<div class=\"ui-layout-south\">\n");
      out.write("\t<div >\n");
      out.write("\t\t<div style=\"float:right;display:none;\">\n");
      out.write("\t\t\t<input type=\"button\" value=\"send\" onclick=\"sendMsg();\"></input>  \n");
      out.write("\t\t\t<input type=\"button\" value=\"clean\" onclick=\"clean();\"></input>  \n");
      out.write("\t\t\t<input type=\"button\" value=\"注销\" onclick=\"loginout();\"></input>  \n");
      out.write("\t\t</div>\n");
      out.write("\t\t<textarea name=\"content1\" cols=\"10\" rows=\"8\" style=\"width:100%;height:30px;visibility:hidden;\"></textarea>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"ui-layout-east\">\n");
      out.write("\t<ul id=\"userlist\" class=\"userlist\">\n");
      out.write("\t</ul>\n");
      out.write("</div>\n");
      out.write("</body>  \n");
      out.write("</html>  ");
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
