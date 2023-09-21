<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script> 
<title>Insert title here</title>
</head>
<body>
	<a href="user">Back</a>
	<h1>Danh Sach Khoa</h1>
	<table class="table table-striped">
		<tr>
			<th>Ma Khoa</th>
			<th>Ten Khoa</th>
			<th>Tuy Chon</th>
		</tr>
		<c:forEach var="khoa" items="${khoas }">
			<tr>
				<td>
					${khoa.makhoa }
				</td>
				
				<td>
					${khoa.tenkhoa }
				</td>
				<td>
				<a href="khoauser?action=list&id=${khoa.makhoa }">Danh sach bac si</a>
				</td>
			</tr>
		
		</c:forEach>
	</table>
</body>
</html>