<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<script src="assets/js/jquery-3.7.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(document)
			.ready(
					function() {

						// search by keyword
						$('#keyword').keyup(function() {
							var keyword = $(this).val();
							$.ajax({
								type : 'GET',
								url : 'searchajax',
								data : {
									action : 'searchByKeyword',
									keyword : keyword
								},
								success : function(products) {
									fillDataToTable(products);
								}
							});
						});
						

						var dialog = $('#dialogProductDetails').dialog({
							autoOpen : false,
							modal : true,
							
						});

						$('#tableProduct').on('click', '.preview', function() {
							var id = $(this).attr('data-id');
							$.ajax({
								type : 'GET',
								url : 'searchajax',
								data : {
									action : 'searchByProductId',
									id : id
								},
								success : function(product) {
									$('#dialogProductDetails #productId').html(product.id);
									$('#dialogProductDetails #productName').html(product.name);
									dialog.dialog("open");
								}
							});
						});

						// filter categories
						$('#comboboxCategory').change(function() {
							var categoryId = $(this).val();
							$.ajax({
								type : 'GET',
								url : 'searchajax',
								data : {
									action : 'searchByCategory',
									categoryId : categoryId
								},
								success : function(products) {
									fillDataToTable(products);
								}
							});
						});

						
						$('#keyword2').autocomplete({
							source: 'searchajax?action=autocomplete'
						});
						
						
						function fillDataToTable(products) {
							var s = '';
							var total = 0;
							for (var i = 0; i < products.length; i++) {
								total += (parseInt(products[i].quantity) * parseFloat(products[i].price));
								s += '<tr>';
								s += '<td><a href="cart?action=buy&id='+ products[i].id + '">Buy Now</a> |  <a href="#" data-id="'+ products[i].id +'" class="preview">Preview</a></td>';
								s += '<td>' + products[i].id + '</td>';
								s += '<td>' + products[i].name + '</td>';
								s += '<td><img src="assets/images/' + products[i].photo + '" width="70" height="70"></td>';
								s += '<td>' + products[i].category.id + '</td>';
								s += '<td>' + products[i].category.name
										+ '</td>';
								s += '<td>' + products[i].price + '</td>';
								s += '<td>' + products[i].quantity + '</td>';
								s += '<td>'
										+ (parseInt(products[i].quantity) * parseFloat(products[i].price))
										+ '</td>';
								// xxxxxx
								s += '</tr>';
							}
							$('table tfoot #total').html(total);
							$('table tbody').html(s);
						}

					});
</script>

<h3>Auto Complete</h3>
<input type="text" id="keyword2">

<h3>Product List</h3>
<table border="1" id="tableProduct">
	<thead>
		<tr>
			<th>Action</th>
			<th>Id</th>
			<th>Name <br> <input type="text" id="keyword"
				autocomplete="off">
			</th>
			<th>Photo</th>
			<th>Category Id</th>
			<th>Category Name <br> <select id="comboboxCategory">
					<option value="-1">All</option>
					<option value="1">Cate 1</option>
					<option value="2">Cate 2</option>
					<option value="3">Cate 3</option>

			</select>
			</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="product" items="${products }">
			<c:set var="total"
				value="${total + product.price * product.quantity }"></c:set>
			<tr>
				<td align="center"><a href="cart?action=buy&id=${product.id }">Buy
						Now</a> | <a href="#" data-id="${product.id }" class="preview">Preview</a>

				</td>
				<td>${product.id }</td>
				<td><a href="product?action=details&id=${product.id }">${product.name }</a></td>
				<td><img src="assets/images/${product.photo }" width="70"
					height="70"></td>
				<td>${product.category.id }</td>
				<td>${product.category.name }</td>
				<td>${product.price }</td>
				<td>${product.quantity }<c:if test="${product.quantity < 10 }">
						<br>
						<span style="color: red">Gan Het Hang</span>
					</c:if>
				</td>
				<td>${product.price * product.quantity }</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8" align="right">Total</td>
			<td><span id="total">${total }</span></td>
		</tr>
	</tfoot>
</table>

<div id="dialogProductDetails" title="Product Details">
	ID <span id="productId"></span>
	<br>
	Name <span id="productName"></span>
</div>


