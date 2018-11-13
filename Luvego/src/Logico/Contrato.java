package Logico;

import java.util.Date;

public class Contrato {

	private String id;
	private String nombreProyecto;
	private String idCliente;
	private Jefe jefeProyecto;
	private Date fechaInicio;
	private Date fechaEntrega;
	private boolean estado;
	private String categoria;
	
	public Contrato(String id, String idCliente,String nombreProyecto, Jefe jefeProyecto, Date fechaEntrega, boolean estado,
			String categoria) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.idCliente = idCliente;
		this.jefeProyecto = jefeProyecto;
		this.fechaInicio = new Date();
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.categoria = categoria;
	}
	
	public void aplazar(Date fecha)
	{
		this.fechaEntrega = fecha;
	}
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getId() {
		return id;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public Jefe getJefeProyecto() {
		return jefeProyecto;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public boolean isEstado() {
		return estado;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public void setJefeProyecto(Jefe jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}
	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
