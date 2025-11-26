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
}
