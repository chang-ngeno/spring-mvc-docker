<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Occurred</title>
<%@ include file="../partials/head.jsp"%>
</head>
<body>
	<div class="container" >
		<%@ include file="../partials/navbar.jsp"%>
		<h2 class="text-danger" align="center">Error</h2>
		<div class="text-danger"  align="center">
			${message}
			<br/>
			<img alt="Error" src="resources/images/3675500.jpg" class="img img-fluid">
		</div>

		<%@ include file="../partials/footer.jsp"%>
	</div>
</body>
</html>