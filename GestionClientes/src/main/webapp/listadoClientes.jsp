<%@ page import="Entidades.usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<% usuario u = (usuario) session.getAttribute("usuario");%>
	
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
		<label>Usuario ingresado: <%= u.getNombre()%></label>
	</header>
	<main>
		<div>
			<table>
				<thead>
				<tr>
                    <th>DNI</th>
                    <th>CUIL</th>
                    <th>Nombre y Apellido</th>
                    <th>Sexo</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Dirección</th>
                    <th>Nacionalidad</th>
                    <th>Localidad</th>
                    <th>Provincia</th>
                </tr>
                </thead>
                <tbody>
                
                </tbody>
			</table>
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