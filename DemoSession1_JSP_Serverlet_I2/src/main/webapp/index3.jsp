<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.demo.entities.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index 3</title>
</head>
<body>
	<h1>INDEX3</h1>
	<% Product product = new Product(1, "name 1", 4.5, 2, true); %>
	<h3>Product Info</h3>
	<table>
	<tr>
		<td>ID</td>
		<td>
			<%= product.getId() %>
		</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>
			<%= product.getName() %>
		</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>
			<%= product.getPrice() %>
		</td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td>
			<%= product.getQuantity() %>
		</td>
	</tr>
	<tr>
		<td>Total</td>
		<td>
			<%= product.getPrice() * product.getQuantity() %>
		</td>
	</tr>
	<tr>
		<td>Status</td>
		<td>
			<%= product.isStatus() %>
		</td>
	</tr>
	</table>
	<%
		List<String> names = new ArrayList<String>();
		names.add("Name 1");
		names.add("Name 2");
		names.add("Name 3");
		names.add("Name 4");
	%>
	<br>
	<ol>
		<% for(String name: names) { %>
		<li> <%= name %> </li>
		<% } %>
	</ol>
</body>
</html>