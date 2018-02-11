<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>发送邮件</h4>
	<form action="sendMail" method="post">
		<label for="from">发件人</label>
		<input type="text" name="from"><br>
		<label for="password">密码</label>
		<input type="password" name="password"><br>
		<label for="to">收件人</label>
		<input type="text" name="to">
		<label for="subject">标题</label>
		<input type="text" name="subject">
		<label for="content">正文</label>
		<input type="text" name="content">
		<input type="submit" value="发送">
	</form>
</body>
</html>