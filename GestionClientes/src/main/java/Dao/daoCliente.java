package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public int añadirCliente(cliente cliente) {
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
		
		int filas = 0;
		String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection cn = DriverManager.getConnection(host, user, pass);
			PreparedStatement ps = cn.prepareStatement(query);){
			
			ps.setString(1, cliente.obtenerDni());
	        ps.setString(2, cliente.getCuil());     
	        ps.setString(3, cliente.getNombre());	        
	        ps.setString(4, cliente.getApellido());	        
	        ps.setString(5, cliente.getSexo());	        
	        ps.setString(6, cliente.getFecha_nacimiento().toString());
	        ps.setString(7, cliente.getDireccion());
	        ps.setString(8, cliente.getNacionalidad());
	        ps.setString(9, cliente.getLocalidad());
	        ps.setString(10, cliente.getProvincia());
	        ps.setString(11, cliente.getCorreo_electronico());
	        ps.setString(12, cliente.getTelefono());
			
	        filas = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			filas=-1;
		}
		
		return filas;
	}
	
	public int modificarCliente(cliente cliente) {
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
		
		int filas = 0;
		String query = "UPDATE clientes SET cuil = ?, nombre = ?, apellido = ?, sexo = ?, fecha_nacimiento = ?, direccion = ?, nacionalidad = ?, localidad = ?, provincia = ?, correo_electronico = ?, telefono = ? WHERE dni = ?";
		
		try(Connection cn = DriverManager.getConnection(host, user, pass);
			PreparedStatement ps = cn.prepareStatement(query);) {
			
			ps.setString(1, cliente.getCuil());
	        ps.setString(2, cliente.getNombre());	        
	        ps.setString(3, cliente.getApellido());	        
	        ps.setString(4, cliente.getSexo());	        
	        ps.setString(5, cliente.getFecha_nacimiento().toString());
	        ps.setString(6, cliente.getDireccion());
	        ps.setString(7, cliente.getNacionalidad());
	        ps.setString(8, cliente.getLocalidad());
	        ps.setString(9, cliente.getProvincia());
	        ps.setString(10, cliente.getCorreo_electronico());
	        ps.setString(11, cliente.getTelefono());	
	        
	        ps.setString(12, cliente.obtenerDni());
	        
	        filas = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			filas=-1;
		}
		return filas;
	}
	
	public int eliminarCliente(String dni) {
		
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
		
		int filas = 0;
		String query = "DELETE FROM clientes WHERE dni = ?";
		
		try(Connection cn = DriverManager.getConnection(host, user, pass);
			PreparedStatement ps = cn.prepareStatement(query);) {
			
			ps.setString(1, dni.trim());
			
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			filas=-1;
		}
		return filas;
	}
}















