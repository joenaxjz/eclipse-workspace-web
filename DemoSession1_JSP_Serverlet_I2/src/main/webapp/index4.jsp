<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="com.demo.entities.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Product> products = new ArrayList<>();
products.add(new Product(1, "Product 1", true, 10.0, 1));
products.add(new Product(2, "Product 2", true, 20.0, 2));
products.add(new Product(3, "Product 3", true, 30.0, 3));
%>
	
	<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Status</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Sub Total</th>
			</tr>
			<% for(Product product : products) { %>
			<tr>
				<td>
					<%= product.getId() %>
				</td>
				<td>
					<%= product.getName() %>
				</td>
				<td>
					<%= product.isStatus() %>
				</td>
				<td>
					<%= product.getPrice() %>
				</td>
				<td>
					<%= product.getQuantity() %>
				</td>
				<td>
					<%= product.getPrice() * product.getQuantity() %>
				</td>
			</tr>
			<% } %>
		</table>
</body>
</html>