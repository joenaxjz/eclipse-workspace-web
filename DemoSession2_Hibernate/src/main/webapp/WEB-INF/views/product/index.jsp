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
	<fieldset>
		<legend>Search By Keyword</legend>
		<form method="get" action ="product">
		Keyword <input type="text" placeholder="type keyword here" name="keyword" value="${keyword }">
		<br>
		<input type="submit" value="Search">
		<input type="hidden" name="action" value="findByKeyword">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>Search By Prices</legend>
		<form method="get" action ="product">
		Price From <input type="text" placeholder="type price here" name="from"  value="${from }">
		To <input type="text" placeholder="type price here" name="to"  value="${to }">
		<input type="submit" value="Search">
		<input type="hidden" name="action" value="findByPrice">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>Search By Category</legend>
		<form method="get" action ="product">
		Category <select name="categoryId">
		<c:forEach var="category" items="${categories }">
		<option value="${category.id }" ${category.id == categoryId ? ' selected ' : '' }>${category.name }</option>
		</c:forEach>
		</select>
		<input type="submit" value="Search">
		<input type="hidden" name="action" value="findByCategory">
		</form>
	</fieldset>

	<h1>Product List</h1>
	
	<a href="product?action=add">Add Product</a>

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
			<td>action</td>
			
		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.id }</td>
				<td>${product.category.name }</td>
        		<td>
        		<a href="product?action=details&id=${product.id }">
        				${product.name }
        		</a>
        		</td>
				<td>${product.price }</td>
				<td>${product.quantity }</td>
				<td>${product.status }</td>
				<td>${product.description }</td>
				<td><f:formatDate value="${product.created }" pattern="dd/MM/yyyy" var="created"></f:formatDate>
				${created }</td>
				<td>
				<a href="product?action=details&id=${product.id }">
				<img src="assets/images/${product.photo }" width ="70px" height="100px">
				</a>
				</td>
				<td>
				<a>Update</a>
				|
				<a href="product?action=delete&id=${product.id }" onclick="return confirm('r u sure ?')">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>