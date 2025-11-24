<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="GestionCliente">
</head>

<body>
	<header>
		<img src="" alt="logo">
		<nav>
			<ul>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="https://www.tiktok.com/@valuckyyy">Tik Tok</a></li>
				<li><a href="https://www.instagram.com/simply_val._/">Instagram</a></li>
				<li><a href="">Mail</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<form action="${pageContext.request.contextPath}/servletUsuarios" method="post">
			<label for="txtMail">Ingrese el mail</label>
			<input type="email" id="txtMail" name="txtMail">
			<label for="txtContra">Ingrese la contraseña</label>
			<input type="password" id="txtContra" name="txtContra">
			<button type="submit" id="login" name="login">Ingresar</button>
		</form>
		<div>
			<label><%= request.getAttribute("mensaje_error") %></label>
		</div>
	</main>
	<footer>
		<div>
			<img src="" alt="logo">
		</div>
		<div>
			<p>Gestión Clientes | Derechos reservados © 2025</p>
		</div>
	</footer>
</body>
</html>