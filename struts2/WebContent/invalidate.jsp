<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="user" method="post">
		<s:textfield name="userName" label="Name" size="20" />
		<s:textfield name="age" label="Age" size="20"/>
		<s:submit label="提交" align="center"></s:submit>
	</s:form>
</body>
</html>