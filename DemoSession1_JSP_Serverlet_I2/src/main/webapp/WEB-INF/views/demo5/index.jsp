<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Demo 5</h1>
	id: ${sessionScope.id }
	<br> username: ${sessionScope.username }

	<h3>Product Info</h3>
	Product ID: ${sessionScope.product.id }
	Product Name:${sessionScope.product.name } 
	Category ID:${sessionScope.product.category.id }
	Category Name:${sessionScope.product.category.name }

	<h3>Product List</h3>
	<table>
			<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Category ID</th>
			<th>Category Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:forEach var="product" items="${sessionScope.products }">
		<tr>
		<td>${product.id}</td>
				<td>
				<a href="product?action=detail&id=${product.id}">
				${product.name}
				</a>
				</td>
				<td><img src="assets/images/${product.photo}" width="70px"height="100px"></td>
				<td>${product.category.id}</td>
				<td>${product.category.name}</td>
				<td>${product.price}</td>
				<td>${product.quantity}
					<c:if test="${product.quantity < 10 }">
					<br>
					<span style="color: red">Gần Hết</span>
					</c:if>
				</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>