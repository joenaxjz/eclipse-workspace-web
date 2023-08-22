<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="home">Home</a> |
	<a href="aboutus">About Us</a> |
	<a href="news">News</a> |
	<a href="cart">Cart(${sessionScope.cart != null ? sessionScope.cart.size() : 0  })</a> |
	<a href="product?action=index">Products</a>
	<br>
	<br>
	<jsp:include page="${p }"></jsp:include>
	<br>
	<br> Coppyright
</body>
</html>