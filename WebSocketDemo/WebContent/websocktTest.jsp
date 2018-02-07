<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	你好，<input type="text" id="text">
	<button onclick="send()">发送消息</button>
	<br>
	<button onblur="closeWebSocket()">关闭连接</button>
	<br>
	<div id="message"></div>
</body>
<script type="text/javascript">
	var webSocket = null;
	if('WebSocket' in window){
		webSocket = new WebSocket("ws://localhost:8080/WebSocketDemo/webSocket");
	}else {
		alert("当前浏览器不支持webSocket");
	}
	
	//连接发生错误的回调方法
	webSocket.onerror = function(){
		setMessage("WebSocket连接错误");
	}
	
	//连接成功的回调函数
	webSocket.onopen = function(){
		setMessage("WebSocket连接成功");
	}
	
	//接收到消息的回调函数
	webSocket.onmessage = function(event){
		setMessage(event.data);
	}
	
	//连接关闭的回调函数
	webSocket.onclose = function(){
		setMessage("连接关闭");
	}
	
	//监测到窗口关闭将连接关闭,如果连接未关闭，但是窗口关闭，server端会抛异常
	window.onbeforeunload = function(){
		webSocket.close();
	}
	
	//设置连接状态
	function setMessage(inner){
		document.getElementById("message").innerHTML += inner + '<br/>';
	}
	
	//发送消息
	function send(){
		var message = document.getElementById("text").value;
		webSocket.send(message);
	}
	
	//关闭连接
	function closeWebSocket(){
		webSocket.close();
	}
</script>
</html>