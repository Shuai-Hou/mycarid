<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<script charset="utf-8" src="../resources/script/jquery-1.8.3.js"></script>
	<script charset="utf-8" src="../resources/script/jquery-ui-latest.js"></script>
	
	<link rel="stylesheet" href="../resources/css/layout-default-latest.css" />
	<script charset="utf-8" src="../resources/script/jquery.layout-latest.js"></script>
	
	<link rel="stylesheet" href="../resources/kindeditor-4.1.7/themes/default/default.css" />
	<link rel="stylesheet" href="../resources/kindeditor-4.1.7/plugins/code/prettify.css" />
	<script charset="utf-8" src="../resources/kindeditor-4.1.7/kindeditor.js"></script>
	<script charset="utf-8" src="../resources/kindeditor-4.1.7/lang/zh_CN.js"></script>
	<script charset="utf-8" src="../resources/kindeditor-4.1.7/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="../resources/script/template.js"></script>
	<script charset="utf-8" src="../resources/script/StackBlur.js"></script>
	<script src="../resources/script/system.js"></script>
	
<style>
	body, div, address, blockquote, iframe, ul, ol, dl, dt, 
	dd, li, dl, h1, h2, h3, h4, pre, table, caption, th, td, form, 
	legend, fieldset, input, button, select, textarea {margin:0; padding:0;font-style: normal;font:12px/22px Arial, Helvetica, sans-serif;} 
	ol, ul ,li{list-style: none;} 
	img {border: 0; vertical-align:middle;} 
	body{color:#000000;background:#FFF;} 
	.clear{clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px;} 
	a{color:#000000;text-decoration:none; }  
	a:hover{color:#BA2636;text-decoration:underline;} 
	
	.bottomPane{
		position: fixed;
		bottom: 0px;
		width: 100%;
		background-color: gray;
	}
	#messagelist{
		height: 100%;
		word-wrap: break-word;
		overflow: auto;
		list-style: none;
		padding: 0 10px;
	}
	#messagelist li{
		width: 100%;
		overflow: hidden;
		clear: both;
		border-top: 1px solid rgba(0,0,0,0.13);
		margin: 0;
		padding: 0;
		list-style: none;
		
		box-shadow: 0 1px 3px rgba(0,0,0,0.22);
		-webkit-border-radius: 3px;
		border-radius: 3px;
	}
	#msgInput{
		width: 300px;
	}
	.avatar{
		box-shadow: 0 1px 1px rgba(255,255,255,0.75);
		position: relative;
		-webkit-border-radius: 3px;
		border-radius: 3px;
		background-color: #fff;
		float: left;
	}
	.avatar img{
		display: block;
		width: 40px;
		height: 40px;
		max-width: none;
		box-shadow: 0 1px 3px rgba(0,0,0,0.22);
		-webkit-border-radius: 3px;
		border-radius: 3px;
	}
	.comment{
		padding-left: 50px;
	}
	.comment-head{
		float: right;
		position: relative;
		top: -10px;
	}
	.comment-head span{
		color: gray;
	}
	.comment-body{

	}
	.comment-body p{
		font-size: 13px;
		line-height: 1.5em;
		margin: .5em 0;
		word-wrap: break-word;
	}
	
	.comment-stack{
		position: relative;
		padding: 5px 5px 15px 5px;
		border-top: 1px solid rgba(255,255,255,0.7);
	}
</style>
<title><%= request.getParameter("room")==null?"大厅":new String(request.getParameter("room")) %></title>  

<script id="test" type="text/html">
	<li>
		<div class="comment-stack">
			<div class="avatar"><img src="<!--[==user.avatar]-->" alt="<!--[==user.name]-->" title="<!--[==user.name]-->"></div>
			<div class="comment">
				<div class="comment-head"><a href="#"><!--[==user.name]--></a> <span><!--[==time]--></span></div>
				<div class="comment-body"><p><!--[==msg]--></p></div>
			</div>
		</div>
	</li>
</script>
<script id="tem_user" type="text/html">
	<!--[ for (var i=0;i<list.length;i++){ ]-->
        <li>
			<div class="avatar"><img src="<!--[=list[i].avatar]-->" alt="<!--[=list[i].name]-->"></div>
		</li>
   <!--[ } ]-->
</script>
<script type="text/javascript">  
	template.openTag = '<!--[';
	template.closeTag = ']-->';
	var iconmap={'大厅':'foundicon-people',
			'厨房':'foundicon-home',
			'厕所':'foundicon-inbox',
			'卧室':'foundicon-heart',
			'二次元世界':'foundicon-globe',
			'default:':'foundicon-smiley'
			};
	var roomname="<%= request.getParameter("room")==null?"大厅":new String(request.getParameter("room")) %>";
	var ws = null;  
	$(function(){
		var name=getCookie("name");
		var avatar=getCookie("avatar");
		if(name){
			initLink(name);
			initUI();
		}else{
			while(name=="" || name==null){
				name = window.prompt("欢迎,请务必输入您的大名","");
			}
			if(name!=null){
				avatar = window.prompt("最好配上你的头像地址","");
				setCoolie("room",roomname);
				setCoolie("name",name);
				setCoolie("avatar",avatar);
				initLink();
				initUI();
			}else{
				alert("求你了...");
				window.location.href=window.location.href;
			}
		}
	});
	  
	function initLink(){
		var url='ws://' + window.location.host+"/socket.do";
	    if ('WebSocket' in window){
	        ws = new WebSocket(url);  
	    }else if ('MozWebSocket' in window){
	        ws = new MozWebSocket(url);  
	    }else{
	    	$('#messagelist').append("<li>Your browser does not support WebSocket</li>");
	    }
	    
	    ws.onmessage = function(evt) {  
	    	console.log(evt.data);
	       var data=eval("("+evt.data+")");
	       console.log(data);
	       var html = template.render('test', data);
	       $('#messagelist').append(html);
	       //$('#messagelist').append("<li>"+evt.data+"</li>");
	       var div=document.getElementById('messagelist'); 
	       div.scrollTop = div.scrollHeight;
	    };  
	    ws.onclose = function(evt) {  
	    	 $('#messagelist').append("<li>主动断开了链接...</li>");
	    };  
	    ws.onopen = function(evt) {  
	    	$('#messagelist').append("<li>链接成功...</li>"); 
	    	loadRoomUsers();
	    };  
	}
	
	function initUI(){
		$('.faceButton').click(function(){
			$('.face').toggle(100);
		});
		$('.faces_list li').click(function(){
			 $('#msgInput').val($('#msgInput').val()+$(this).html());
		});
		//$('#msgInput').inputHistory({
		//	  size: 10
		//});
		$('#msgInput').bind('keydown', function(e) {
		   if (e.keyCode == 13) {
		     ws.send($(this).val()); 
		     $(this).val('');
		   }
		});
		//var bgclass=iconmap[roomname];
		//if(!bgclass)bgclass="foundicon-smiley";
		//$('.bg i').removeClass();
		//$('.bg i').addClass(bgclass);
		$('body').layout({ applyDemoStyles: true });
	}
	
	function sendMsg() {  
		var msg=$('textarea[name="content1"]');
		if(msg.length > 0){
		    ws.send(msg.val()); 
		    KindEditor.instances[0].html('');
		}
	}  
	function clean(){
		$('#messagelist').empty();
	}
	function loadRoomUsers(){
		$.ajax({
            type: "get",
            dataType: "json",
            url: "../mycarid/socket/"+roomname+"/users",
            //data: "pageIndex=" + pageIndex,
            //complete :function(){$("#load").hide();},
            success: function(msg){
            	console.log(msg);
     	        var html = template.render('tem_user', {list:msg});
    	        $('#userlist').append(html);
            }
		});
	}
	function loginout(){
		ws.close();
		delCookie('name');
		window.location.href=window.location.href;
	}
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath : '../resources/kindeditor-4.1.7/plugins/code/prettify.css',
			uploadJson : '../jsp/upload_json.jsp',
			fileManagerJson : '../jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterBlur : function() {
				this.sync();
			},
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					sendMsg();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					sendMsg();
				});
			}
		});
		prettyPrint();
	});
</script>  

</head>  
<body>  
<img id="bgimg" src="../resources/img/dating.jpg" style="width: 100%; height: 100%;display: none;" onLoad="stackBlurImage('bgimg', 'canvas', 20, 0.1);"></img>
<canvas id="canvas" style="position: absolute;z-index: -1;top: 0px;width: 800px;height: 400px;"></canvas>
<div class="ui-layout-center">
	<ul id="messagelist" class="messagelist">
		<li>welcome</li>
		<li>
			<div class="comment-stack">
				<div class="avatar"><img src="http://tp3.sinaimg.cn/2700830310/50/40012779595/1" alt="guxuede"></div>
				<div class="comment">
					<div class="comment-head"><a href="#">guxuede</a> 2012-1-2</div>
					<div class="comment-body"><p>晚上哈</p></div>
				</div>
			</div>
		</li>
	</ul>
</div>
<div class="ui-layout-south">
	<div >
		<div style="float:right;display:none;">
			<input type="button" value="send" onclick="sendMsg();"></input>  
			<input type="button" value="clean" onclick="clean();"></input>  
			<input type="button" value="注销" onclick="loginout();"></input>  
		</div>
		<textarea name="content1" cols="10" rows="8" style="width:100%;height:30px;visibility:hidden;"></textarea>
	</div>
</div>
<div class="ui-layout-east">
	<ul id="userlist" class="userlist">
	</ul>
</div>
</body>  
</html>  