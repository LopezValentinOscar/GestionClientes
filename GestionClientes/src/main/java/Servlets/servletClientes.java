package Servlets;

import java.io.IOException;
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
		
		request.setCharacterEncoding("UTF-8");
	}

}
