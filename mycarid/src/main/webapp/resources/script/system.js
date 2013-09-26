	function getCookie(name){
		 var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
		 if(arr != null) return arr[2]; return null;
	};	
	function setCoolie(name,value){
		var Days = 30;
		var exp  = new Date();
		exp.setTime(exp.getTime() + Days*24*60*60*1000);
		document.cookie = name + "="+ value +";expires="+ exp.toGMTString();
	};
	function delCookie(name){
	  var exp = new Date();
	  exp.setTime(exp.getTime() - 1);
	  var cval=getCookie(name);
	  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
	};