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
	<a href="admin?action=bacsi">Back</a>
	<fieldset>
		<legend>Search By Date</legend>
		<form method="get" action ="bacsi">
		From <input type="text" placeholder="from" name="from"  value="${from }">
		To <input type="text" placeholder="to" name="to"  value="${to }">
		<input type="submit" value="Search">
		<input type="hidden" name="action" value="lichkhamfromto">
		<input type="hidden" name="id" value="${bacsi.mabs }">
		
		</form>
	</fieldset>
	<h1>Lich Kham Benh Cua Bac Si </h1>
	<a href="bacsi?action=history&id=${bacsi.mabs }">Refresh</a>
	<table class="table table-dark">
		<tr>
			<th>ID</th>
			<th>Ma So Benh Nhan</th>
			<th>Ten Benh Nhan</th>
			<th>Ngay Kham</th>
			<th>Noi Dung</th>
		</tr>
		<c:forEach var="lichkham" items="${lichkhams }">
			<tr>
				<td>${lichkham.id }</td>
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