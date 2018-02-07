<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>

<html>
  <head>
   	<meta charset="utf-8" />
   	<title>登录</title>
  </head>
  
  <body>
	<form action="login" method="post">
		用户名：<input type="text" name="username" /><br /><br />
		密码：&nbsp;<input type="password" name="password" /><br /><br />
		<input type="submit" name="submit" value="登录" />
	</form>
  </body>
</html>
