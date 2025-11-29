package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Entidades.cliente;

public class daoCliente {
	
	// En daoCliente.java, en la declaración de host:
	private String host= "jdbc:mysql://localhost:3306/sistema_clientes?useSSL=false"; // Añadir ?useSSL=false
	private String user= "root";
	private String pass= "root";
	
	public ArrayList<cliente> listaClientes(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		
		String query = "SELECT * FROM clientes";
		ArrayList<cliente> listaC = new ArrayList<cliente>();
		
		try (Connection cn = DriverManager.getConnection(host, user, pass);
			 Statement st = cn.createStatement();
			 ResultSet rs = st.executeQuery(query)){
		
			while(rs.next()) {
				cliente c = new cliente();
				c.setDni(rs.getString("dni"));
	            c.setCuil(rs.getString("cuil"));
	            c.setNombre(rs.getString("nombre"));
	            c.setApellido(rs.getString("apellido"));
	            c.setSexo(rs.getString("sexo"));
	            c.setFecha_nacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
	            c.setDireccion(rs.getString("direccion"));
	            c.setNacionalidad(rs.getString("nacionalidad"));
	            c.setLocalidad(rs.getString("localidad"));
	            c.setProvincia(rs.getString("provincia"));
	            c.setCorreo_electronico(rs.getString("correo_electronico"));
	            c.setTelefono(rs.getString("telefono"));
	            
	            listaC.add(c);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Ocurrió un error al conseguir los clientes");
		}
		
		return listaC;
	}
	
}
