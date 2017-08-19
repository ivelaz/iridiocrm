package com.ivelaz.iridiocrm.models;


/**
 * Modelo que representa a un cliente.
 */
public class ClienteModel {
	
	
	private int id;	
	private String nombre;	
	private String dni;	
	private String tipoCliente;		// Particular o Empresa
	private String telefono;	
	private String email;	
	private String direccion;	
	private String notas;
	
	/**
	 * Constructor vacío.
	 */
	public ClienteModel() {}

	/**
	 * Constructor parametrizado.	
	 * @param id el identificador del cliente.
	 * @param nombre 
	 * @param dni 
	 * @param tipoCliente particular o empresa
	 * @param telefono 
	 * @param email 
	 * @param direccion 
	 * @param notas 
	 */
	public ClienteModel(int id, String nombre, String dni, String tipoCliente, String telefono, String email,
			String direccion, String notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.tipoCliente = tipoCliente;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.notas = notas;
	}

	/**
	 * Devuelve el id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el id.
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre.
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre.
	 * @param nombre 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el dni.
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el dni.
	 * @param dni 
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el tipo cliente.
	 * @return  tipoCliente
	 */
	public String getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * Establece el tipo de cliente.*
	 * @param tipoCliente 
	 */
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	/**
	 * Devuelve el telefono.
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el telefono.
	 * @param telefono 
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve el email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el email.
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve la direccion.
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la direccion.
	 * @param direccion 
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve las notas.
	 * @return notas
	 */
	public String getNotas() {
		return notas;
	}

	/**
	 * Establece las notas.
	 * @param notas 
	 */
	public void setNotas(String notas) {
		this.notas = notas;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClienteModel [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", tipoCliente=" + tipoCliente
				+ ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", notas=" + notas + "]";
	}
	
	

}
