<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#created" ).datepicker({
    	dateFormat: 'dd/mm/yy'		
    });
  } );
  </script>
<title>Insert title here</title>
</head>
<body>
	<a href="product">Back</a>

	<h1>Edit product</h1>

	<form method="post" action="product?action=edit"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${product.name }"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="${product.price }"></td>
			</tr>
			<tr>
				<td>quantity</td>
				<td>
					<input type="number" name="quantity" value="${product.quantity }">
				</td>
			</tr>
			<tr>
				<td>description</td>
				<td>
					<input type="text" name="description" value="${product.description }">
				</td>
			</tr>
			<tr>
				<td>created</td>
				<td>
				<f:formatDate value="${product.created }" pattern="dd/MM/yyyy" var="created"></f:formatDate>
					<input type="text" name="created" id="created" value="${product.created }" >
				</td>
			</tr>
			<tr>
				<td>photo</td>
				<td>
					<input type="file" name="file">
					<br>
					<img src="assets/images/${product.photo }" width ="70px" height="100px">
				</td>
			</tr>
			<tr>
				<td>status</td>
				<td>
					<input type="checkbox" name="status" ${product.status? 'checked' : '' }>
				</td>
			</tr>
			<tr>
				<td>category</td>
				<td>
				<select name="category">
					<c:forEach var="category" items="${categories }">
						<option value="${category.id }" ${category.id == product.category.id ? 'selected' : '' } >${category.name }</option>
					</c:forEach>
				</select>
					
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Update">
					<input type="hidden" name="id" value="${product.id}">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>