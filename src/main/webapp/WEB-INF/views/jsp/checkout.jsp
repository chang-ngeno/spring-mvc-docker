<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page import="com.clc.model.Item, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store :: KitchenApp</title>
<%@ include file="partials/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="partials/navbar.jsp"%>

		<h2 align="center">Items Selected</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Item ID</th>
						<th>Item Name</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Item> items = (List<Item>) request.getAttribute("itemsSelected");
					System.out.println(items.size());
					for (int i = 0; i < items.size(); i++) {
						out.println("<tr> <th scope=\"row\">" + (i + 1) + "</th><td>" + items.get(i).getItemId() + "</td><td>"
						+ items.get(i).getItemName().toUpperCase() + "</td></tr>");
					}
					%>
				</tbody>
			</table>
		</div>
		<form action="">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<%@ include file="partials/footer.jsp"%>
	</div>
</body>
</html>