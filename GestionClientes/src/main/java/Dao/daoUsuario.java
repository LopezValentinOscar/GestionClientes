package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.usuario;

public class daoUsuario {
	
	private String host= "jdbc:mysql://localhost:3306/sistema_clientes";
	private String user= "root";
	private String pass= "root";
	
	public usuario login(String mail, String contrasena)
	{
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
		
		String query = "SELECT * FROM sistema_clientes.usuarios WHERE correo_electronico = ? AND contrasena = ?";
		usuario u = null;
		
		try(Connection cn = DriverManager.getConnection(host, user, pass);
			PreparedStatement ps = cn.prepareStatement(query);){
			
			ps.setString(1, mail);
			ps.setString(2, contrasena);
		
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				u = new usuario();
				u.setId(rs.getInt("id_usuario"));
				System.out.println("ENCONTRADO: ID = " + u.getId());
				u.setNombre(rs.getString("usuario"));
				u.setMail(rs.getString("correo_electronico"));
				u.setContrasena(rs.getString("contrasena"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("NO SE ENCONTRÓ USUARIO");
		}
		return u;
	}
}
