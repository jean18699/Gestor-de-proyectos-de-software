package Logico;

import java.util.Date;

public class Contrato {

	private String id;
	private Proyecto proyecto;
	private String nombreCliente;
	private Date fechaInicio;
	private Date fechaEntrega;
	private float precioContrato;
	private float precioFinal;
	private char estado; // F = finalizado, A = Atrasado, I = iniciado 
	private String categoria;
	
	public Contrato(String id, String nombreCliente,Proyecto proyecto, Date fechaEntrega) {
		
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.fechaInicio = new Date();
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.categoria = categoria;
		
	}
	
	public int getDiasRestantes()
	{
		int dias = fechaEntrega.getDate() - fechaInicio.getDate();
		return dias;
	}

	public void aplazar(Date fecha)
	{
		this.fechaEntrega = fecha;
	}
	
	public String getId() {
		return id;
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
	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	

	public void setPrecioContrato(float precioContrato) {
		this.precioContrato = precioContrato;
	}

	public float getPrecioFinal() {
		
		return (8 * getDiasRestantes() * proyecto.getSumaSalarios());
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
	
}
