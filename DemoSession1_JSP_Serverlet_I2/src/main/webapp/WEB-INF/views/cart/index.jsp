<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Cart</h1>
<form method="post" action="cart?action=update">
	<table border="1">
		<tr>
			<th>Action</th>
			<th>ID</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity
				<input type="submit" value="UPDATE">
			</th>
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }" varStatus="i">
			<c:set var="total"
				value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
				<td><a href="cart?action=remove&index=${i.index }">X</a> |</td>
				<td>${item.product.id}</td>
				<td><a href="product?action=detail&id=${item.product.id}">
						${item.product.name} </a></td>
				<td><img src="assets/images/${item.product.photo}" width="70px"
					height="100px"></td>
				<td>${item.product.price}</td>
				<td><input type="number" value="${item.quantity}"
					name="quantities" style="width: 70px" min="1"></td>
				<td>${item.product.price * item.quantity}</td>

			</tr>
		</c:forEach>
	</table>
</form>