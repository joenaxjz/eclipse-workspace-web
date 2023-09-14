<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<h1>Add new product</h1>

	<form method="post" action="product?action=add"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>quantity</td>
				<td>
					<input type="number" name="quantity">
				</td>
			</tr>
			<tr>
				<td>description</td>
				<td>
					<input type="text" name="description">
				</td>
			</tr>
			<tr>
				<td>created</td>
				<td>
					<input type="text" name="created" id="created">
				</td>
			</tr>
			<tr>
				<td>photo</td>
				<td>
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<td>status</td>
				<td>
					<input type="checkbox" name="status">
				</td>
			</tr>
			<tr>
				<td>category</td>
				<td>
				<select name="category">
					<c:forEach var="category" items="${categories }">
						<option value="${category.id }">${category.name }</option>
					</c:forEach>
				</select>
					
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="ADD">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>