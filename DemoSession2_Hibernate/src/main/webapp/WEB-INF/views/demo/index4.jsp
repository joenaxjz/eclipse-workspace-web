<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Demo 3</h1>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Account Quantity</td>
		</tr>
		<c:forEach var="role" items="${roles }">
			<tr>
				<td>${role.id }</td>
				<td>${role.name }</td>
				<td>${role.accounts.size() }</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>