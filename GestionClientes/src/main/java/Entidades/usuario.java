package Entidades;

public class usuario {
	
	private int id;
	private String nombre;
	private String correo_electronico;
	private String contrasena;
	
	public usuario(){}
	
	public usuario(int id, String nombre, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return correo_electronico;
	}
	public void setMail(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
