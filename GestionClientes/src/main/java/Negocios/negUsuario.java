package Negocios;

import Dao.daoUsuario;
import Entidades.usuario;

public class negUsuario {
	
	private daoUsuario du = new daoUsuario();
		
	public usuario login(String mail, String contrasena)
	{
		return du.login(mail, contrasena);
	}
}
