<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page import="com.clc.model.Item, java.util.List, com.clc.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kitchen Place</title>
<%@ include file="partials/head.jsp"%>
</head>
<body>
<body>
	<div class="container">
		<%@ include file="partials/navbar.jsp"%>

		<h2 align="center">Select Items</h2>
		${user.getUsername()}
		<form action="checkout" method="post">
			<!-- <label for="items">Choose your items:</label> <select name="items"
				id="items" multiple="multiple">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="opel">Opel</option>
				<option value="audi">Audi</option>
			</select>  -->
			<%
				List<Item> items = (List<Item>) request.getAttribute("items");
			for (int i = 0; i < items.size(); i++) {
				out.println("<input type=\"checkbox\" id=\"" + items.get(i).getItemName() + "\" name=\"item\" value=\""
				+ items.get(i).getItemId() + "\">");
				out.println("<label for=\"" + items.get(i).getItemName() + "\">" + items.get(i).getItemName().toUpperCase() + "</label><br>");
			}
			%>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="ORDER" class="btn btn-primary" />
		</form>
		<%@ include file="partials/footer.jsp"%>
	</div>
</body>
</html>