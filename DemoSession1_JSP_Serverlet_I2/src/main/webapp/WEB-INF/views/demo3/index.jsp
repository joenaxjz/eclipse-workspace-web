<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="demo3?action=menu1">Menu 1|</a>
	<a href="demo3?action=menu2">Menu 2|</a>
	<a href="demo3?action=menu3">Menu 3</a>
	
	<br><br>
	<jsp:include page="a.jsp"></jsp:include>
	<jsp:include page="abc/b.jsp"></jsp:include>
	<jsp:include page="../demo2/c.jsp"></jsp:include>
</body>
</html>