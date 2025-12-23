<%@ page import="Entidades.usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entidades.cliente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GESTION CLIENTE</title>
<link rel="stylesheet" href="css/EliminarCliente.css">
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
				<li><a href="modificarCliente.jsp">Modificar Cliente</a></li>
				<li><a href="eliminarCliente.jsp">Eliminar Cliente</a></li>
			</ul>
		</aside>
		
		<main>
			<div class="main">
				<%
					ArrayList<cliente> listaC = null;
					if(request.getAttribute("listaClientes")==null){
						response.sendRedirect("servletClientes?action=listar2");
					} else {
						listaC = (ArrayList<cliente>) request.getAttribute("listaClientes");
					}
				%>
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
                    <th>Correo</th>
                    <th>Teléfono</th>
                </tr>
                </thead>
                <tbody>
                	<%if(listaC != null) {
                		for(cliente c : listaC) {%>
					 <tr>
                        <td><%= c.obtenerDni() %></td>
                        <td><%= c.getCuil() %></td>
                        <td><%= c.getNombre() + " " + c.getApellido() %></td>
                        <td><%= c.getSexo() %></td>
                        <td><%= c.getFecha_nacimiento().toString() %></td>
                        <td><%= c.getDireccion() %></td>
                        <td><%= c.getNacionalidad() %></td>
                        <td><%= c.getLocalidad() %></td>
                        <td><%= c.getProvincia() %></td>
                        <td><%= c.getCorreo_electronico() %></td>
                        <td><%= c.getTelefono() %></td>
                    </tr>
                    <%} } %>
                </tbody>
			</table>
				<form method="post" action="servletClientes?action=eliminar">
					<label for="txtDni">Ingrese el DNI del cliente</label>
					<input type="text" name="txtDni" id="txtDni">
					<button type="submit" name="btnEliminar">ELIMINAR</button>				
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