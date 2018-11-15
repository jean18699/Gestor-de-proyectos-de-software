package Logico;

import java.util.Date;

public class Contrato {

	private String id;
	private String nombreCliente;
	private String nombreProyecto;
	private String idCliente;
	private Jefe jefeProyecto;
	private Date fechaInicio;
	private Date fechaEntrega;
	private float sumaSalarios;
	private float precioContrato;
	private float precioFinal;
	private char estado; // F = finalizado, A = Atrasado, I = iniciado 
	private String categoria;
	
	public Contrato(String id, String nombreProyecto, String idCliente, Jefe jefeProyecto,
			Date fechaEntrega, float sumaSalarios, float precioContrato, char estado,String categoria) {
		super();
		this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.idCliente = idCliente;
		this.jefeProyecto = jefeProyecto;
		this.fechaInicio = new Date();
		this.fechaEntrega = fechaEntrega;
		this.sumaSalarios = sumaSalarios;
		this.precioContrato = precioContrato;
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
	
	
	
	public float getSumaSalarios() {
		
		return sumaSalarios;
	}

	public void setSumaSalarios(float sumaSalarios) {
		this.sumaSalarios = sumaSalarios;
	}

	public float getPrecioContrato() {
		return precioContrato;
	}

	public void setPrecioContrato(float precioContrato) {
		this.precioContrato = precioContrato;
	}

	public float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
