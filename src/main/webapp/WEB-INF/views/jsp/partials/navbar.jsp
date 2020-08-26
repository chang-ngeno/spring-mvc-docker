<nav class="navbar navbar-dark|light bg-inverse|primary style="
	background-color:="background-color:" #e3f2fd;""="#e3f2fd;""">
	<!-- Navbar content -->
	<ul class="nav nav-pills">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<li class="nav-item"><a href="home" class="nav-link">Home</a></li>
			<li class="nav-item"><a href="order" class="nav-link">Order</a></li>
			<li class="nav-item"><a class="nav-link" onclick="document.forms['logoutForm'].submit()" href="#">Logout</a></li>
			<form action="logout" method="post" class="form" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<li class="nav-item"><a href="register" class="nav-link">Register</a></li>
			<li class="nav-item"><a href="login" class="nav-link">Log In</a></li>
		</c:if>
	</ul>

</nav>