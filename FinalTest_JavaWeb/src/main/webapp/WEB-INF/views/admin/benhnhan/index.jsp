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
	<a href="admin">Back</a>
	<h1>Benh Nhan</h1>
	<table class="table table-dark">
		<tr>
			<th>ID</th>
			<th>Ten Benh Nhan</th>
			<th>Ngay Sinh</th>
			<th>Gioi Tinh</th>
			<th>Tuy Chon</th>
		</tr>
		<c:forEach var="benhnhan" items="${benhnhans }">
			<tr>
				<td>${benhnhan.mabn }</td>
				<td>${benhnhan.tenbn }</td>
				<td><f:formatDate value="${benhnhan.ngaysinh }"
						pattern="dd/MM/yyyy" var="ngaysinh"></f:formatDate>${ngaysinh }</td>
				<td>${benhnhan.gioitinh }</td>
				<td>
				
				<a href="benhnhan?action=history&id=${benhnhan.mabn }">Lich su kham benh</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>