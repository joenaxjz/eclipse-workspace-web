<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script> 
<title>Doctos Page</title>
</head>
<body>
	<a href="admin">Back</a>
	<h1>Bac Si</h1>
	<a href="bacsi?action=add">Add new</a>
	<table class="table table-dark">
		<tr>
			<th>Doctor Id </th>
			<th>Name </th>
			<th>DoB </th>
			<th>Ma Khoa</th>
			<th>Ten Khoa</th>
			<th>Tuy Chon</th>
		</tr>
		<c:forEach var="doctor" items="${doctors }">
		<tr>
			<td>
				${doctor.mabs }
			</td>
			
			<td>
				${doctor.tenbs }
			</td>
			
			<td>
			<f:formatDate value="${doctor.ngaysinh }" pattern="dd/MM/yyyy" var="ngaysinh"></f:formatDate>${ngaysinh }
			</td>
			<td>
				${doctor.khoa.makhoa }
			</td>
			<td>
				${doctor.khoa.tenkhoa }
			</td>
			<td>
				<a href="bacsi?action=delete&id=${doctor.mabs }" onclick="return confirm('r u sure ?')" >Xoa</a> |
				<a href="bacsi?action=update&id=${doctor.mabs }">Cap nhat</a> |
				<a href="bacsi?action=history&id=${doctor.mabs }">Lich kham benh</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>