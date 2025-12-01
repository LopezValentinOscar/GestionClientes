<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/AñadirStyles.css">
</head>
<body>
<div class="contenedor">
	<header>
		<img src="" alt="logo">
		<nav>
			<ul>
				<li><a href="login.jsp">Cerrar Sesión</a></li>
				<li><a href="https://www.tiktok.com/@valuckyyy">Tik Tok</a></li>
				<li><a href="https://www.instagram.com/simply_val._/">Instagram</a></li>
				<li><a href="">Mail</a></li>
			</ul>
		</nav>

	</header>
	<aside>
			<ul>
				<li><a href="listadoClientes.jsp">Listado de Clientes</a></li>
				<li><a href="añadirCliente.jsp">Añadir Cliente</a></li>
				<li><a href="">Próximamente</a></li>
			</ul>
	</aside>
	<main>
		<div class="main">
		<h3>Formulario de Cliente</h3>
			<form action="${pageContext.request.contextPath}/servletClientes?action=insertar" method="post">
		            <label for="dni">DNI *</label>
		            <input type="text" class="form-control" id="dni" name="dni" placeholder="Solo números. 6 a 8 dígitos (ej: 12345678)" required>
		            
	                <label for="cuil">CUIL *</label>
	                <input type="text" class="form-control" id="cuil" name="cuil" placeholder="Formato: 11 dígitos (ej: 20333444555)" required>
	      
	                <label for="nombre">Nombre *</label>
	                <input type="text" class="form-control" id="nombre" name="nombre" required>
	    
	                <label for="apellido">Apellido *</label>
	                <input type="text" class="form-control" id="apellido" name="apellido" required>
	      
	                <label for="sexo">Sexo *</label>
	                <select id="sexo" name="sexo" class="form-select" required>
	                    <option value="">-- Seleccione --</option>
	                    <option value="M">Masculino</option>
	                    <option value="F">Femenino</option>
	                </select>
	    
	                <label for="nacionalidad">Nacionalidad</label>
	                <input type="text" class="form-control" id="nacionalidad" name="nacionalidad">
	     
	                <label for="fechaNacimiento">Fecha de nacimiento *</label>
	                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>

	                <label for="direccion">Dirección</label>
	                <input type="text" class="form-control" id="direccion" name="direccion">
	   
	                <label for="localidad">Localidad</label>
	                <input type="text" class="form-control" id="localidad" name="localidad">

	                <label for="provincia">Provincia</label>
	                <input type="text" class="form-control" id="provincia" name="provincia">
	   
	                <label for="correo">Correo electrónico *</label>
	                <input type="email" class="form-control" id="correo" name="correo" placeholder="Ej: nombre@dominio.com" required>

	                <label for="telefono">Teléfono</label>
	                <input type="text" class="form-control" id="telefono" name="telefono">
	
	                <button type="submit">Guardar cliente</button>
	                <%
	                	String mensaje = ""; 
	                	if(request.getAttribute("mensajeExito") != null){
	                		mensaje = request.getAttribute("mensajeExito").toString();
	                	}
	                	if(request.getAttribute("mensajeError") != null){
	                		mensaje = request.getAttribute("mensajeError").toString();
	                	}
	                %>
	                <p><%=mensaje %></p>
			</form>
		</div>
	</main>

	<footer>
		<div class="footer-izq">
			<img src="" alt="logo">
		</div>
		<div class="footer-der">
			<p>Gestión Clientes | Derechos reservados © 2025</p>
		</div>
	</footer>
</div>
</body>
</html>