package Entidades;

public class usuario {
	
	private int id;
	private String nombre;
	private String mail;
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
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
