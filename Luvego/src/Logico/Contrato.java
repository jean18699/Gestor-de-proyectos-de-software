package Logico;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private static int cont;
	private Proyecto proyecto;
	private String nombreCliente;
	private Date fechaInicio;
	private Date fechaEntrega;
	private float precioContrato;
	private float precioFinal;
	private Cliente cliente;
	private char estado; // F = finalizado, A = Atrasado, I = iniciado 
	
	
	public Contrato(Proyecto proyecto, Date fechaEntrega) {
		
		cont++;
		this.id = Integer.toString(cont);
		this.proyecto = proyecto;
		this.fechaInicio = new Date();
		this.fechaEntrega = fechaEntrega;
	}
	
	
	public Proyecto getProyecto() {
		return proyecto;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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
