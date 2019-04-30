<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="form" action="/token!formSub.do" method="post" enctype="multipart/form-data">
		<input name="userName" type="text">
		<input name="password" type="password">
		<input name="file" type="file">
		<input name="title" type="text">
		<input name="token" type="hidden" value="${token }">
		<input name="submit" type="submit">
	</form>	
	
	=======>   ${param.zcid }
</body>
</html>