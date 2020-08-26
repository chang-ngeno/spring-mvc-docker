<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@ include file="partials/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="partials/navbar.jsp"%>

		<h2 align="center" class="form-heading">REGISTER</h2>
		<form action="register" method="post">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					name="username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					name="password" class="form-control" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" class="btn btn-primary" value="REGISTER" />
		</form>
		<%@ include file="partials/footer.jsp"%>
	</div>
</body>
</html>