<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
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
	<h1>Lich Su Kham Benh Cua Benh nhan </h1>
	<fieldset>
		<legend>TIM KIEM</legend>
		<form method="get" action ="benhnhanuser">
		Ma benh nhan <input type="text" placeholder="ID" name="mabn" value="${benhnhan.mabn }">
		<input type="submit" value="Search">
		<input type="hidden" name="action" value="findLichsukham">
		</form>
	</fieldset>
	<a href="user?action=timlichsukham">Refresh</a>
	<br>
	<table class="table table-dark">
		<tr>
			<th>Ma So Bac Si</th>
			<th>Ten Bac Si</th>
			<th>Ngay Kham</th>
			<th>Noi Dung</th>
		</tr>
		<c:forEach var="lichkham" items="${lichkhams }">
			<tr>
				<td>${lichkham.bacsi.mabs }</td>
				<td>${lichkham.bacsi.tenbs }</td>
				<td><f:formatDate value="${lichkham.ngaykham }"
						pattern="dd/MM/yyyy" var="ngaykham"></f:formatDate>${ngaykham }</td>
				<td>${lichkham.noidung }</td>
			</tr>
		</c:forEach>
	</table>
		<a href="user">Back</a>
</body>
</html>