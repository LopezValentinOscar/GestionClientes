package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.usuario;
import Negocios.negUsuario;

@WebServlet("/servletUsuarios")
public class servletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private negUsuario nu = new negUsuario();

    public servletUsuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("txtMail");
		String contrasena = request.getParameter("txtContra");
		usuario u =  nu.login(mail, contrasena);
		
		if(u!=null && u.getId() > 0) {
			request.getSession().setAttribute("usuario", u);
			response.sendRedirect("listadoClientes.jsp");
		} else {
			request.setAttribute("mensaje_error", "mail o contraseña incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
