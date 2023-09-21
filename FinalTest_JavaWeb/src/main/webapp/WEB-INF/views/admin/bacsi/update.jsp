<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<form method="post" action="bacsi?action=save">
		<table>
		<tr>
			<th>Ten Bac Si</th>
			<td col="1"><input type="text" name="tenbs" value="${bacsi.tenbs }"></td>
		</tr>
		<tr>
			<th>Ngay Sinh </th>
			<td col="1">
			<f:formatDate value="${bacsi.ngaysinh }" pattern="dd/MM/yyyy" var="ngaysinh"></f:formatDate>
			<input type="text" name="ngaysinh" id="ngaysinh" value="${bacsi.ngaysinh }">
			</td>
		</tr>
		<tr>
			<th>Ma Khoa</th>
			<td col="1">
				<select name=khoa>
					<c:forEach var="khoa" items="${khoas }">
						<option value="${khoa.makhoa }" ${khoa.makhoa == bacsi.khoa.makhoa ? 'selected' : '' }>${khoa.tenkhoa }</option>
					</c:forEach>
				</select>
		<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Update">
					<input type="hidden" name="id" value="${bacsi.mabs}">
				</td>
			</tr>
			</td>
		</tr>
		</table>
	
	</form>
</body>
</html>