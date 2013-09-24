<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<link rel="stylesheet" href="stylesheets/general_foundicons.css">
<script src="jquery-1.8.3.js"></script>
<script src="jquery.inputHistory.js"></script>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	body{

	}
	.bottomPane{
		position: fixed;
		bottom: 0px;
		width: 100%;
		background-color: gray;
		padding-left: 15px;
	}
	#messagelist{
		height: 500px;
		word-wrap: break-word;
		overflow: auto;
		list-style: none;
		padding-left: 15px;
	}
	#messagelist li{
		
	}
	#msgInput{
		width: 300px;
	}
	.face{
		background-color: gray;
		position: absolute;
		bottom: 32px;
		z-index: 1000;
		width: 400px;
		display: none;
		padding-left: 15px;
		/*height: 400px;*/
	}
	.faces_list li{
		list-style-type: none;
		border: 1px solid transparent;
		float: left;
		cursor: pointer;
	}
	.faces_list li:hover{
		border: 1px solid burlyWood;
	}
	.bg{
		font-size: 400px;
		color: #FAFAFA;
		position: absolute;
		z-index: -1;
		right: 0;
	}
</style>
<title><%= request.getParameter("room")==null?"大厅":new String(request.getParameter("room").getBytes("iso-8859-1")) %></title>  
<script type="text/javascript">  
	var iconmap={'大厅':'foundicon-people',
			'厨房':'foundicon-home',
			'厕所':'foundicon-inbox',
			'卧室':'foundicon-heart',
			'二次元世界':'foundicon-globe',
			'default:':'foundicon-smiley'
			};
	var roomname="<%= request.getParameter("room")==null?"大厅":new String(request.getParameter("room").getBytes("iso-8859-1")) %>";
	var ws = null;  
	$(function(){
		var name=getCookie("name");
		if(name){
			initLink(name);
			initUI();
		}else{
			while(name=="" || name==null){
				name = window.prompt("欢迎,请务必输入您的大名","");
			}
			if(name!=null){
				setCoolie("name",name);
				initLink(name);
				initUI();
			}else{
				alert("求你了...");
				window.location.href=window.location.href;
			}
		}
	});
	  
	function initLink(name){
		var url="ws://localhost:8080/socket.sk?name="+name+"&room="+roomname;
	    if ('WebSocket' in window){
	        ws = new WebSocket(url);  
	    }else if ('MozWebSocket' in window){
	        ws = new MozWebSocket(url);  
	    }else{
	    	$('#messagelist').append("<li>Your browser does not support WebSocket</li>");
	    }
	    
	    ws.onmessage = function(evt) {  
	       $('#messagelist').append("<li>"+evt.data+"</li>");
	       var div=document.getElementById('messagelist'); 
	       div.scrollTop = div.scrollHeight;
	    };  
	    ws.onclose = function(evt) {  
	    	 $('#messagelist').append("<li>主动断开了链接...</li>");
	    };  
	    ws.onopen = function(evt) {  
	    	$('#messagelist').append("<li>链接成功...</li>"); 
	    };  
	}
	
	function initUI(){
		$('.faceButton').click(function(){
			$('.face').toggle(100);
		});
		$('.faces_list li').click(function(){
			 $('#msgInput').val($('#msgInput').val()+$(this).html());
		});
		$('#msgInput').inputHistory({
			  size: 10
		});
		$('#msgInput').bind('keydown', function(e) {
		   if (e.keyCode == 13) {
		     ws.send($(this).val()); 
		     $(this).val('');
		   }
		});
		var bgclass=iconmap[roomname];
		if(!bgclass)bgclass="foundicon-smiley";
		$('.bg i').removeClass();
		$('.bg i').addClass(bgclass);
	}
	
	function sendMsg() {  
		if($('#msgInput').val().length > 0){
		    ws.send($('#msgInput').val()); 
		    $('#msgInput').val('');
		}
	}  
	function clean(){
		$('#messagelist').empty();
	}
	function getCookie(name){
		 var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
		 if(arr != null) return unescape(arr[2]); return null;
	};	
	function setCoolie(name,value){
		var Days = 30;
		var exp  = new Date();
		exp.setTime(exp.getTime() + Days*24*60*60*1000);
		document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
	};
	function delCookie(name){
	  var exp = new Date();
	  exp.setTime(exp.getTime() - 1);
	  var cval=getCookie(name);
	  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
	};
	function loginout(){
		ws.close();
		delCookie('name');
		window.location.href=window.location.href;
	}
</script>  
</head>  
<body>  
<div class="bg"><i class="foundicon-smiley"></i></div>
<ul id="messagelist">
	<li>welcome</li>
</ul>
<div class="bottomPane">
	<a href="javaScript:;" class="faceButton"><i class="foundicon-smiley"></i>表情</a>
	<input type="text" id="msgInput" placeholder="说点什么吧..."></input>  
	<input type="button" value="send" onclick="sendMsg();"></input>  
	<input type="button" value="clean" onclick="clean();"></input>  
	<input type="button" value="注销" onclick="loginout();"></input>  
</div>
<div class="face">
	<ul class="faces_list clearfix" node-type="inner"><li action-type="insert" action-data="text=[草泥马]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7a/shenshou_thumb.gif" alt="草泥马" title="草泥马"></li><li action-type="insert" action-data="text=[神马]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/60/horse2_thumb.gif" alt="神马" title="神马"></li><li action-type="insert" action-data="text=[浮云]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/bc/fuyun_thumb.gif" alt="浮云" title="浮云"></li><li action-type="insert" action-data="text=[给力]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c9/geili_thumb.gif" alt="给力" title="给力"></li><li action-type="insert" action-data="text=[围观]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f2/wg_thumb.gif" alt="围观" title="围观"></li><li action-type="insert" action-data="text=[威武]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/70/vw_thumb.gif" alt="威武" title="威武"></li><li action-type="insert" action-data="text=[熊猫]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/panda_thumb.gif" alt="熊猫" title="熊猫"></li><li action-type="insert" action-data="text=[兔子]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/81/rabbit_thumb.gif" alt="兔子" title="兔子"></li><li action-type="insert" action-data="text=[奥特曼]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/bc/otm_thumb.gif" alt="奥特曼" title="奥特曼"></li><li action-type="insert" action-data="text=[囧]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/15/j_thumb.gif" alt="囧" title="囧"></li><li action-type="insert" action-data="text=[互粉]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/89/hufen_thumb.gif" alt="互粉" title="互粉"></li><li action-type="insert" action-data="text=[礼物]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c4/liwu_thumb.gif" alt="礼物" title="礼物"></li><li action-type="insert" action-data="text=[呵呵]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ac/smilea_thumb.gif" alt="呵呵" title="呵呵"></li><li action-type="insert" action-data="text=[嘻嘻]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/tootha_thumb.gif" alt="嘻嘻" title="嘻嘻"></li><li action-type="insert" action-data="text=[哈哈]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh.gif" alt="哈哈" title="哈哈"></li><li action-type="insert" action-data="text=[可爱]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/14/tza_thumb.gif" alt="可爱" title="可爱"></li><li action-type="insert" action-data="text=[可怜]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/af/kl_thumb.gif" alt="可怜" title="可怜"></li><li action-type="insert" action-data="text=[挖鼻屎]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a0/kbsa_thumb.gif" alt="挖鼻屎" title="挖鼻屎"></li><li action-type="insert" action-data="text=[吃惊]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f4/cj_thumb.gif" alt="吃惊" title="吃惊"></li><li action-type="insert" action-data="text=[害羞]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/shamea_thumb.gif" alt="害羞" title="害羞"></li><li action-type="insert" action-data="text=[挤眼]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c3/zy_thumb.gif" alt="挤眼" title="挤眼"></li><li action-type="insert" action-data="text=[闭嘴]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/29/bz_thumb.gif" alt="闭嘴" title="闭嘴"></li><li action-type="insert" action-data="text=[鄙视]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/71/bs2_thumb.gif" alt="鄙视" title="鄙视"></li><li action-type="insert" action-data="text=[爱你]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6d/lovea_thumb.gif" alt="爱你" title="爱你"></li><li action-type="insert" action-data="text=[泪]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9d/sada_thumb.gif" alt="泪" title="泪"></li><li action-type="insert" action-data="text=[偷笑]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/19/heia_thumb.gif" alt="偷笑" title="偷笑"></li><li action-type="insert" action-data="text=[亲亲]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/8f/qq_thumb.gif" alt="亲亲" title="亲亲"></li><li action-type="insert" action-data="text=[生病]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/sb_thumb.gif" alt="生病" title="生病"></li><li action-type="insert" action-data="text=[太开心]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/58/mb_thumb.gif" alt="太开心" title="太开心"></li><li action-type="insert" action-data="text=[懒得理你]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/17/ldln_thumb.gif" alt="懒得理你" title="懒得理你"></li><li action-type="insert" action-data="text=[右哼哼]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/98/yhh_thumb.gif" alt="右哼哼" title="右哼哼"></li><li action-type="insert" action-data="text=[左哼哼]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6d/zhh_thumb.gif" alt="左哼哼" title="左哼哼"></li><li action-type="insert" action-data="text=[嘘]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a6/x_thumb.gif" alt="嘘" title="嘘"></li><li action-type="insert" action-data="text=[衰]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/af/cry.gif" alt="衰" title="衰"></li><li action-type="insert" action-data="text=[委屈]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/73/wq_thumb.gif" alt="委屈" title="委屈"></li><li action-type="insert" action-data="text=[吐]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9e/t_thumb.gif" alt="吐" title="吐"></li><li action-type="insert" action-data="text=[打哈欠]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f3/k_thumb.gif" alt="打哈欠" title="打哈欠"></li><li action-type="insert" action-data="text=[抱抱]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/27/bba_thumb.gif" alt="抱抱" title="抱抱"></li><li action-type="insert" action-data="text=[怒]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7c/angrya_thumb.gif" alt="怒" title="怒"></li><li action-type="insert" action-data="text=[疑问]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/yw_thumb.gif" alt="疑问" title="疑问"></li><li action-type="insert" action-data="text=[馋嘴]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a5/cza_thumb.gif" alt="馋嘴" title="馋嘴"></li><li action-type="insert" action-data="text=[拜拜]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/70/88_thumb.gif" alt="拜拜" title="拜拜"></li><li action-type="insert" action-data="text=[思考]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e9/sk_thumb.gif" alt="思考" title="思考"></li><li action-type="insert" action-data="text=[汗]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/24/sweata_thumb.gif" alt="汗" title="汗"></li><li action-type="insert" action-data="text=[困]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7f/sleepya_thumb.gif" alt="困" title="困"></li><li action-type="insert" action-data="text=[睡觉]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6b/sleepa_thumb.gif" alt="睡觉" title="睡觉"></li><li action-type="insert" action-data="text=[钱]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/90/money_thumb.gif" alt="钱" title="钱"></li><li action-type="insert" action-data="text=[失望]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0c/sw_thumb.gif" alt="失望" title="失望"></li><li action-type="insert" action-data="text=[酷]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/cool_thumb.gif" alt="酷" title="酷"></li><li action-type="insert" action-data="text=[花心]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/8c/hsa_thumb.gif" alt="花心" title="花心"></li><li action-type="insert" action-data="text=[哼]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/49/hatea_thumb.gif" alt="哼" title="哼"></li><li action-type="insert" action-data="text=[鼓掌]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/36/gza_thumb.gif" alt="鼓掌" title="鼓掌"></li><li action-type="insert" action-data="text=[晕]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d9/dizzya_thumb.gif" alt="晕" title="晕"></li><li action-type="insert" action-data="text=[悲伤]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1a/bs_thumb.gif" alt="悲伤" title="悲伤"></li><li action-type="insert" action-data="text=[抓狂]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/62/crazya_thumb.gif" alt="抓狂" title="抓狂"></li><li action-type="insert" action-data="text=[黑线]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/91/h_thumb.gif" alt="黑线" title="黑线"></li><li action-type="insert" action-data="text=[阴险]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6d/yx_thumb.gif" alt="阴险" title="阴险"></li><li action-type="insert" action-data="text=[怒骂]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/89/nm_thumb.gif" alt="怒骂" title="怒骂"></li><li action-type="insert" action-data="text=[心]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/hearta_thumb.gif" alt="心" title="心"></li><li action-type="insert" action-data="text=[伤心]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ea/unheart.gif" alt="伤心" title="伤心"></li><li action-type="insert" action-data="text=[猪头]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/58/pig.gif" alt="猪头" title="猪头"></li><li action-type="insert" action-data="text=[ok]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d6/ok_thumb.gif" alt="ok" title="ok"></li><li action-type="insert" action-data="text=[耶]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d9/ye_thumb.gif" alt="耶" title="耶"></li><li action-type="insert" action-data="text=[good]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d8/good_thumb.gif" alt="good" title="good"></li><li action-type="insert" action-data="text=[不要]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c7/no_thumb.gif" alt="不要" title="不要"></li><li action-type="insert" action-data="text=[赞]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d0/z2_thumb.gif" alt="赞" title="赞"></li><li action-type="insert" action-data="text=[来]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/come_thumb.gif" alt="来" title="来"></li><li action-type="insert" action-data="text=[弱]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d8/sad_thumb.gif" alt="弱" title="弱"></li><li action-type="insert" action-data="text=[蜡烛]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/91/lazu_thumb.gif" alt="蜡烛" title="蜡烛"></li><li action-type="insert" action-data="text=[钟]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d3/clock_thumb.gif" alt="钟" title="钟"></li><li action-type="insert" action-data="text=[话筒]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1b/m_thumb.gif" alt="话筒" title="话筒"></li><li action-type="insert" action-data="text=[蛋糕]"><img src="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/cake.gif" alt="蛋糕" title="蛋糕"></li></ul>
</div>
</body>  
</html>  