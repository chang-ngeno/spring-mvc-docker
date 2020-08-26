<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<%@ include file="partials/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="partials/navbar.jsp"%>
		<c:if test="${message != null}">
			<div class="alert alert-info" role="alert">${message}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<h2 align="center" class="form-heading">Login</h2>

		<form action="login" method="post" class="form">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					name="username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					name="password" class="form-control" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" class="btn btn-primary" value="LOGIN" />
		</form>

		<%@ include file="partials/footer.jsp"%>
	</div>
</body>
</html>