<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="content" fragment="true" %>

<html>
<head>

<title>${title }</title>


</head>

<body>
	<a href="trangchu">Trang Chu</a> |
	<a href="gioithieu">Gioi Thieu</a> |
	<br>
	<br> 
	
	<jsp:invoke fragment="content"></jsp:invoke>
	
	<br>
	<br> 
	Copyright
</body>
</html>