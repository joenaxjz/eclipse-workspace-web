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
	<a href="admin">Back</a>
	<h1>Lich Kham</h1>
	<table class="table table-dark">
		<tr>
			<th>ID</th>
			<th>Ma So Bac Si</th>
			<th>Ten Bac Si</th>
			<th>Ma So Benh Nhan</th>
			<th>Ten Benh Nhan</th>
			<th>Ngay Kham</th>
			<th>Noi Dung</th>
		</tr>
		<c:forEach var="lichkham" items="${lichkhams }">
			<tr>
				<td>${lichkham.id }</td>
				<td>${lichkham.bacsi.mabs }</td>
				<td>${lichkham.bacsi.tenbs }</td>
				<td>${lichkham.benhnhan.mabn }</td>
				<td>${lichkham.benhnhan.tenbn }</td>
				<td><f:formatDate value="${lichkham.ngaykham }"
						pattern="dd/MM/yyyy" var="ngaykham"></f:formatDate>${ngaykham }</td>
				<td>${lichkham.noidung }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>