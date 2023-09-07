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
	<h1>Demo 1</h1>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Products</td>
		</tr>
		<c:forEach var="category" items="${categories }">
			<tr>
				<td>${category.id }</td>
				<td>${category.name }</td>
				<td>${category.products.size() }</td>
			</tr>
			<tr>
				<td colspan="3">
					<table border="1">
						<tr>
							<td>ID</td>
							<td>Name</td>
							<td>Price</td>
						</tr>
						<c:forEach var="product" items="${category.products }">
							<tr>
								<td>${product.id }</td>
								<td>${product.name }</td>
								<td>${product.price }</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>