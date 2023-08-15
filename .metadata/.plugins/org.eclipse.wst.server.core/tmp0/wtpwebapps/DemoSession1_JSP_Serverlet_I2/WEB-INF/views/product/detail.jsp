<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Product Detail</h3>
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
		<tr>
				<c:set var="total" value="0" ></c:set>
		
				<td>${product.id}</td>
				<td>${product.name}</td>
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
</table>