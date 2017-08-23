package com.ivelaz.iridiocrm.models;

public class Busqueda {
	
	private boolean registrarLlamada;
	
	private String campoBusqueda;
	
	private String palabraClave;
	
	public Busqueda() {}

	public Busqueda(boolean registrarLlamada, String campoBusqueda, String palabraClave) {
		super();
		this.registrarLlamada = registrarLlamada;
		this.campoBusqueda = campoBusqueda;
		this.palabraClave = palabraClave;
	}

	public boolean isRegistrarLlamada() {
		return registrarLlamada;
	}

	public void setRegistrarLlamada(boolean registrarLlamada) {
		this.registrarLlamada = registrarLlamada;
	}

	public String getCampoBusqueda() {
		return campoBusqueda;
	}

	public void setCampoBusqueda(String campoBusqueda) {
		this.campoBusqueda = campoBusqueda;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}
	
	
}
