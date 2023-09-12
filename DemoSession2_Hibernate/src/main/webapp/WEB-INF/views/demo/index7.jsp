<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Sum</h1>
	Sum1:
	<span>${sum1 }</span>
	Sum2:
	<span>${sum2 }</span>
	Sum3:
	<span>${sum3 }</span>

	<h1>Count</h1>
	Count 1:
	<span>${count1 }</span>

	<h1>Min</h1>
	Min
	<span>${min }</span>
	
	<h1>Max</h1>
	Max
	<span>${max }</span>
	
	<h1>AVG</h1>
	Avg
	<span>${avg }</span>

</body>
</html>