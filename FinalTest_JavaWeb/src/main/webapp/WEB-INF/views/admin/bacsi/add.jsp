<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
 <!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#ngaysinh" ).datepicker({
    	dateFormat: 'dd/mm/yy'		
    });
  } );
  </script>
<title>Insert title here</title>
</head>
<body>
	<h1>Them Bac Si</h1>
	<form method="post" action="bacsi?action=add">
		Ten Bac Si: <input type="text" name="tenbs">
		<br>
		Ngay Sinh: <input type="text" name="ngaysinh" id="ngaysinh">
		<br>
		Ma Khoa <select name=khoa>
					<c:forEach var="khoa" items="${khoas }">
						<option value="${khoa.makhoa }">${khoa.tenkhoa }</option>
					</c:forEach>
				</select>
				<br>
		 <input type="submit" valaue="Add">
	</form>
</body>
</html>