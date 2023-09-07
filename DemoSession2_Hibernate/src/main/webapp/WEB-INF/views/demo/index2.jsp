<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Demo 2</h1>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>category</td>
			<td>name</td>
			<td>price</td>
			<td>quantity</td>
			<td>status</td>
			<td>description</td>
			<td>created</td>
			<td>photo</td>
		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.id }</td>
				<td>${product.category.name }</td>
        		<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.quantity }</td>
				<td>${product.status }</td>
				<td>${product.description }</td>
				<td><f:formatDate value="${product.created }" pattern="dd/MM/yyyy" var="created"></f:formatDate>
				${created }</td>
				<td>
				<img src="assets/images/${product.photo }" width ="70px" height="100px">
				
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>