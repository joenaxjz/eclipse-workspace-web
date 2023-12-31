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
<a href="demo2?id=123&username=acc1">Menu 1</a>


	<h1>Index</h1>
	<%
	int id = Integer.parseInt(request.getAttribute("id").toString());
	String username = request.getAttribute("username").toString();
	String price = request.getAttribute("price").toString();
	String quantity = request.getAttribute("quantity").toString();
	String status = request.getAttribute("status").toString();
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>Total</th>
			<th>Photo</th>
			<th>Category ID</th>
			<th>Category Name</th>



		</tr>
		<tr>
			<td><%=id%></td>
			<td><%=username%></td>
			<td><%=price%></td>
			<td><%=quantity%></td>
			<td><%=status%></td>
			<td>${quantity * price}</td>
			<td><img src="assets/images/${product.photo}" width="70px"
				height="100px"></td>
			<td>${product.category.id}</td>
			<td>${product.category.name}</td>
		</tr>
	</table>

	<h1>Expression Language (EL)</h1>
	id: ${ id }

	<h3>Names</h3>
	<ul>
		<c:forEach var="name" items="${names }">
			<li>${name }</li>
		</c:forEach>
	</ul>

	<h3>Product List</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Category ID</th>
			<th>Category Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		
		<c:set var="total" value="0" ></c:set>
		<c:forEach var="product" items="${products }">
		<c:set var="total" value="${total + product.price * product.quantity }" ></c:set>
			<tr>
				<td>${product.id}</td>
				<td>
				<a href="details?id=${product.id}">
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
				<td>${product.price * product.quantity}</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="7" align="right">Total</th>
			<td>${total }</td>
		</tr>
	</table>
</body>
</html>