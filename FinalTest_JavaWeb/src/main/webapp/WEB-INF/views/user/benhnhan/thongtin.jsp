<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>THONG TIN BENH NHAN</h1>
	<fieldset>
		<legend>TIM KIEM</legend>
		<form method="get" action ="benhnhanuser">
		Ma benh nhan <input type="text" placeholder="ID" name="mabn" value="${benhnhan.mabn }">
		<input type="submit" value="Search">
		<input type="hidden" name="action" value="findBenhnhan">
		</form>
	</fieldset>
	<a href="user?action=timlichsukham">Refresh</a>
	<h1>Benh Nhan</h1>
	<table class="table table-dark">
		<tr>
			<th>ID</th>
			<th>Ten Benh Nhan</th>
			<th>Ngay Sinh</th>
			<th>Gioi Tinh</th>
		</tr>
			<tr>
				<td>${benhnhan.mabn }</td>
				<td>${benhnhan.tenbn }</td>
				<td><f:formatDate value="${benhnhan.ngaysinh }"
						pattern="dd/MM/yyyy" var="ngaysinh"></f:formatDate>${ngaysinh }</td>
				<td>${benhnhan.gioitinh }</td>

			</tr>
	</table>
		<a href="user">Back</a>
</body>
</html>