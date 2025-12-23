package Negocios;

import java.util.ArrayList;
import Entidades.cliente;
import Dao.daoCliente;

public class negCliente {
	
	private daoCliente dc = new daoCliente();
	
	public ArrayList<cliente> listaClientes()
	{
		return dc.listaClientes();
	}
	
	public int añadirCliente(cliente cliente)
	{
		return dc.añadirCliente(cliente);
	}
	
	public int modificarCliente(cliente cliente)
	{
		return dc.modificarCliente(cliente);
	}
	
	public int eliminarCliente(String dni) {
	    return dc.eliminarCliente(dni);
	}
}
