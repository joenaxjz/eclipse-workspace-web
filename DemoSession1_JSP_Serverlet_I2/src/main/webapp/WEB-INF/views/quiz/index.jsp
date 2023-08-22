<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Quiz</h1>

<form method="post" action="quiz">
	<ol>
		<c:forEach var="question" items="${questions }">
			<li>${question.content }</li>
			<ol type="a">
				<c:forEach var="answer" items="${question.answers }">
					<input type="radio" name="question_${question.id }" value="${answer.id }" >
					<li>${answer.content }</li>
				</c:forEach>
			</ol>
		</c:forEach>
	</ol>
	<input type="submit" value="SUBMIT">
</form>
</body>
</html>