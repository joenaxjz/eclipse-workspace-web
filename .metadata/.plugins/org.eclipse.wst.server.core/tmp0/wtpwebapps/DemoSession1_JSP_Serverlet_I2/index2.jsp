<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
   <%@ page import="java.text.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index 2 Page</title>
</head>
<body>
	<h3> Index 2</h3>
	<!-- Scriptless -->
	
	<%
		int id = 123;
		String username = "tuananh";
		double price = 4.8;
		int quantity = 8;
		boolean sta = false;
		out.print("id" + id);
		out.print("<b>username<b>" + username);
	%>
	<br>
	<br>
	Id: <%= id %>
	<br>
	Username: <%= username %>
	<br>
	Price: <%= price %>
	<br>
	Quantity <%= quantity %>
	<br>
	Status: <%= sta %>
	<br>
	Total: <%= price * quantity %>
	<br>
	Status: <%= sta ? "show" : "hide" %>
	
	<% 
	Date today = new Date();
	SimpleDateFormat simpleDateFomart = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	%>
	
	<br>
	Today: <%= simpleDateFomart.format(today) %>
</body>
</html>