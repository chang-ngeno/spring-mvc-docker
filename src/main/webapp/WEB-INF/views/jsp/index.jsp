<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome :: KitchenApp</title>
<%@ include file="partials/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="partials/navbar.jsp"%>
		<h2>Welcome</h2>
		<div class="container" align="center">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active" href="open-orders">Open Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="shipping">In Shipping</a></li>
				<li class="nav-item"><a class="nav-link" href="closed-orders">Closed Orders</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">Disabled</a></li>
			</ul>
		</div>
		<%@ include file="partials/footer.jsp"%>
	</div>
</body>
</html>
