<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="assets/js/jquery-3.7.0.min.js"></script>

<script>
	$(document).ready(function() {
		$('#keyword').keyup(function() {
			var keyword = $(this).val();
			$.ajax({
				type : 'GET',
				url : 'searchwithajax',
				data : {
					action : 'searchByKeyword',
					keyword : keyword
				},
				success : function(products) {
					fillDatatoTable(products);
				}
			});
		});

		function fillDatatoTable(products) {
			var s = '';
			for (var i = 0; i < products.length; i++) {
				s += '<tr>';
				s += '<td>' + products[i].id + '</td>';
				s += '<td>' + products[i].name + '</td>';
				s += '<td>' + products[i].category.id + '</td>';
				s += '<td>' + products[i].category.name + '</td>';
				s += '</tr>';
			}
			$('#mytable tbody').html(s)
		}

	})
</script>

<h3>Product List</h3>
<table border="1" id="mytable">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name <input type="text" id="keyword">
			</th>
			<th>Photo</th>
			<th>Category ID</th>
			<th>Category Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="product" items="${products }">
			<c:set var="total"
				value="${total + product.price * product.quantity }"></c:set>
			<tr>
				<td>${product.id}</td>
				<td><a href="product?action=detail&id=${product.id}">
						${product.name} </a></td>
				<td><img src="assets/images/${product.photo}" width="70px"
					height="100px"></td>
				<td>${product.category.id}</td>
				<td>${product.category.name}</td>
				<td>${product.price}</td>
				<td>${product.quantity}<c:if test="${product.quantity < 10 }">
						<br>
						<span style="color: red">Gần Hết</span>
					</c:if>
				</td>
				<td>${product.price * product.quantity}</td>
				<td><a href="cart?action=buy&id=${product.id }">Buy Now</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="8" align="right">Total</th>
			<td>${total }</td>
		</tr>
	</tfoot>
</table>