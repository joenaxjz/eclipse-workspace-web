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
			<td>Username</td>
			<td>Full Name</td>
			<td>Email</td>
			<td>Status</td>
			<td>Roles</td>
		</tr>
		<c:forEach var="account" items="${accounts }">
			<tr>
				<td>${account.id }</td>
				<td>${account.username }</td>
				<td>${account.fullName }</td>
				<td>${account.email }</td>
				<td>${account.status }</td>
				<td>
					<ul>
						<c:forEach var="role" items="${account.roles }">
							<li>${role.name }</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>