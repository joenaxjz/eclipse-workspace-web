<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Demo 4</h1>
	<form action="demo4" method="get">
		Keyword <input type="text" name="keyword"> <br> <input
			type="submit" value="Search"> <input type="hidden"
			name="action" value="demo1">
	</form>

	<h1>Index Demo 4 - 2</h1>
	<form action="demo4?action=demo2" method="post">
		Username <input type="text" name="username"> <br>
		Password <input type="password" name="password"> <br>
		<input type="submit" value="Login">
	</form>
	
	<h1>Index Demo 4 - 3</h1>
	<form action="demo4?action=update" method="post">
		Email 1 <input type="text" name="emails"> <br>
		Email 2 <input type="text" name="emails"> <br>
		Email 3 <input type="text" name="emails"> <br>
		<input type="submit" value="Update">
	</form>
	
	<h1>Index Demo 4 - 4</h1>
	<form action="demo4?action=upload" method="post" enctype="multipart/form-data">
		File <input type="file" name="file"> <br>
		<input type="submit" value="Upload">
	</form>
	
	<h1>Index Demo 4 - 5</h1>
	<form action="demo4?action=uploads" method="post" enctype="multipart/form-data">
		File <input type="file" name="file" multiple="multiple"> <br>
		<input type="submit" value="Upload">
	</form>
</body>
</html>