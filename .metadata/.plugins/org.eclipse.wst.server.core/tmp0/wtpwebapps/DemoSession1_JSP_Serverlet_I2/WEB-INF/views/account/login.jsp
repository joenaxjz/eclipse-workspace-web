<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<br>
	<br>
	${msg}
	<form method="post" action="account?action=login">
		Username <input type="text" name="username"> <br>
		Password <input type="password" name="password"> <br>
		 <input type="submit" name="password" value="Login">
	</form>
</body>
</html>