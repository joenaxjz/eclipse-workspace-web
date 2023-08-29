<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="ct" uri="http://customtags.com"%>
<%@ taglib prefix="ct2" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Demo 6</h1>
	<ct:Hello />
	<br>
	<ct:Hello />
	<br>
	<ct:tag1 fullName="Tuan Anh" />
	<br>
	<ct:tag1 fullName="Thai Anh" />
	<br>
	<ct:add number1="15" number2="25" />
	<br>
	<ct:add number1="95" number2="25" />
	<br>
	<ct:upper>abc</ct:upper>
	<ct:category />

	<h3>JSP Tag</h3>
	<ct2:hello></ct2:hello>
	<br>
	<ct2:hi fullName="Tuan Anh"></ct2:hi>
	<br>
	<ct2:add num1="1" num2="6"></ct2:add>
	<br>
	
	<ct2:addressInfo>
		<jsp:attribute name="content">
		<h3>Address Info</h3>
			<table>
				<tr>
				<td>Street</td>
				<td>St1</td>
				</tr>
				
			</table>
		</jsp:attribute>
	</ct2:addressInfo>
</body>
</html>