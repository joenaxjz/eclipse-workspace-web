<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cap Nhat Khoa</h1>
	<form action="khoa">
		Ten Khoa: <input type="text" name="tenkhoa" value="${khoa.tenkhoa }">
		<br>
		 <input type="submit" value="Save">
		  <input type="hidden" name="action" value=save>
		  <input type="hidden" name="id" value="${khoa.makhoa }">
		  
	</form>
</body>
</html>