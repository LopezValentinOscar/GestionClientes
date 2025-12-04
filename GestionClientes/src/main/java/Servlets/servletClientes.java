package Servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.cliente;
import Negocios.negCliente;

@WebServlet("/servletClientes")
public class servletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private negCliente nc = new negCliente();
	private String msjName = "mensajeError";
	private String msjError = "Error: Formato de fecha de nacimiento incorrecto (use AAAA-MM-DD).";
	private String msjError2 = "Error al procesar la solicitud.";
	
	private String msjName2 = "mensajeExito";

    public servletClientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getParameter("action");

	        if (action == null) {
	            action = "listar";
	        }
	        
	        ArrayList<cliente> lista = nc.listaClientes();
	        request.setAttribute("listaClientes", lista);
	        RequestDispatcher rd = request.getRequestDispatcher("/listadoClientes.jsp");
	        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action == null) action = "";
		
		if (action.equalsIgnoreCase("insertar")) {
			cliente c = new cliente();
			
			try {
				c.setDni(request.getParameter("dni"));
                c.setCuil(request.getParameter("cuil"));
                c.setNombre(request.getParameter("nombre"));
                c.setApellido(request.getParameter("apellido"));
                c.setSexo(request.getParameter("sexo"));
                c.setFecha_nacimiento(LocalDate.parse(request.getParameter("fechaNacimiento")));
                c.setDireccion(request.getParameter("direccion"));
                c.setNacionalidad(request.getParameter("nacionalidad"));
                c.setLocalidad(request.getParameter("localidad"));
                c.setProvincia(request.getParameter("provincia"));
                c.setCorreo_electronico(request.getParameter("correo"));
                c.setTelefono(request.getParameter("telefono"));
                
                int filas = nc.añadirCliente(c);
                
                if (filas > 0) {
                	request.setAttribute("mensajeExito", "Cliente agregado exitosamente.");
                } else {
                	request.setAttribute(msjName, "No se pudo cargar el cliente.");
                }
                
			} catch (java.time.format.DateTimeParseException e) {
			    e.printStackTrace();
			    request.setAttribute(msjName, msjError);
			}
			 catch (Exception e) {
				e.printStackTrace();
				request.setAttribute(msjName, msjError2);
			}
			
			ArrayList<cliente> listaC = nc.listaClientes();
			request.setAttribute("listaClientes", listaC);
			RequestDispatcher rd = request.getRequestDispatcher("/añadirCliente.jsp");
			rd.forward(request, response);
		} else if (action.equalsIgnoreCase("modificar")) {
			cliente c = new cliente();
			
			try {
				
				c.setDni(request.getParameter("dni"));
				c.setCuil(request.getParameter("cuil"));
				c.setNombre(request.getParameter("nombre"));
				c.setApellido(request.getParameter("apellido"));
				c.setSexo(request.getParameter("sexo"));
				c.setNacionalidad(request.getParameter("nacionalidad"));
				c.setFecha_nacimiento(java.time.LocalDate.parse(request.getParameter("fechaNacimiento")));
				c.setDireccion(request.getParameter("direccion"));
				c.setLocalidad(request.getParameter("localidad"));
				c.setProvincia(request.getParameter("provincia"));
				c.setCorreo_electronico(request.getParameter("correo"));
				c.setTelefono(request.getParameter("telefono"));
				
				int filas = nc.modificarCliente(c);
				
				if (filas > 0) {
					request.setAttribute(msjName2, "Cliente modificado con exito");
				} else {
					request.setAttribute(msjName, "No se pudo modificar al cliente");
				}
			
			} catch (java.time.format.DateTimeParseException e) {
				e.printStackTrace();
				request.setAttribute(msjName, msjError);
			}
			 catch (Exception e) {
				 e.printStackTrace();
				 request.setAttribute(msjName, msjError2);
			 }
			
			RequestDispatcher rd = request.getRequestDispatcher("modificarCliente.jsp");
			rd.forward(request, response);
		}
	}

}
