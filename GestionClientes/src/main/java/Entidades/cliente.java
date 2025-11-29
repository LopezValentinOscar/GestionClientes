package Entidades;

import java.time.LocalDate;

public class cliente {
	
	private String id_cliente;
	private String dni;
	private String cuil;
	private String nombre;
	private String apellido;
	private String sexo;
	private LocalDate fecha_nacimiento;
	private String direccion;
	private String nacionalidad;
	private String localidad;
	private String provincia;
	private String correo_electronico;
	private String telefono;
	
	public cliente() {}
	
	public cliente(String id_cliente, String dni, String cuil, String nombre, String apellido, String sexo,
			LocalDate fecha_nacimiento, String direccion, String nacionalidad, String localidad, String provincia,
			String correo_electronico, String telefono) {
		this.id_cliente = id_cliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.localidad = localidad;
		this.provincia = provincia;
		this.correo_electronico = correo_electronico;
		this.telefono = telefono;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String obtenerDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
