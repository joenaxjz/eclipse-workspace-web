<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="assets/js/jquery-3.7.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#buttonDemo1').click(function() {
			$.ajax({
				type : 'GET',
				url : 'ajax1',
				success : function(data) {
					$('#result1').html(data)
				}
			});
		});

		$('#buttonDemo2').click(function() {
			var fullName = $('#fullName').val();
			$.ajax({
				type : 'GET',
				url : 'ajax2',
				data : {
					fullName : fullName
				},
				success : function(data) {
					$('#result2').html(data)
				}
			});
		});

		$('#buttonDemo3').click(function() {
			var userName = $('#userName').val();
			var passWord = $('#passWord').val();
			$.ajax({
				type : 'POST',
				url : 'ajax2',
				data : {
					userName : userName,
					passWord : passWord
				},
				success : function(data) {
					$('#result3').html(data)
				}
			});
		})

		$('#buttonDemo4').click(function() {
			$.ajax({
				type : 'POST',
				url : 'ajax3',
				success : function(product) {
					var s = 'id: ' + product.id;
					s += '<br> name: ' + product.name;
					s += '<br> quantity: ' + product.quantity;
					s += '<br> status: ' + product.status;
					s += '<br> photo: ' + product.photo;
					s += '<br> category id: ' + product.category.id;
					s += '<br> category name: ' + product.category.name;
					$('#result4').html(s)
				}
			});
		});

		$('#buttonDemo5').click(function() {
			$.ajax({
				type : 'POST',
				url : 'ajax4',
				success : function(products) {
					var s = '';
					for (var i = 0; i < products.length; i++) {
						s += '<tr>';
						s += '<td>' + products[i].id + '</td>';
						s += '<td>' + products[i].name + '</td>';
						s += '<td><img src="assets/images' + products[i].photo + '"width="70px"
						height="100px"></td>';
						s += '<td>' + products[i].category.id + '</td>';
						s += '<td>' + products[i].category.name + '</td>';
						s += '</tr>';
					}
					$('#mytable tbody').html(s)
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>AJAX</h1>
	<input type="button" value="Demo 1" id="buttonDemo1">
	<br>
	<span id="result1"></span>

	<h3>AJAX 2</h3>
	Full Name
	<input type="text" id="fullName">
	<input type="button" value="Demo 2" id="buttonDemo2">
	<br>
	<span id="result2"></span>

	<h3>AJAX 3</h3>
	UserName
	<input type="text" id="userName"> Password
	<input type="password" id="passWord">
	<input type="button" value="Login" id="buttonDemo3">
	<br>
	<span id="result3"></span>


	<h1>AJAX 4</h1>
	<input type="button" value="Demo 4" id="buttonDemo4">
	<br>
	<span id="result4"></span>

	<h1>AJAX 5</h1>
	<input type="button" value="Demo 5" id="buttonDemo5">

	<table id="mytable" border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Category ID</th>
				<th>Category Name</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>