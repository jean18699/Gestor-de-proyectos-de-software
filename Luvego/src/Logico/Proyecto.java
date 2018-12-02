package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5346260584819546609L;
	private String id;
	private static int cont;
	private String nombre;
	private ArrayList<Empleado> grupoTrabajo;
	//private float sumaSalarios;
	private String clasificacion;
	private String estado;
	private boolean realizado;

	public String getEstado() {
		return estado;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Proyecto(String nombre, ArrayList<Empleado> grupoTrabajo, String clasificacion) {

		cont++;
		this.id = Integer.toString(cont);
		this.nombre = nombre;
		this.grupoTrabajo = grupoTrabajo;
		//this.sumaSalarios = getSumaSalarios();
		this.clasificacion = clasificacion;
		this.estado = "Normal";
		this.realizado = false; //atributo que solo se utilizara para saber si se creo un proyecto o no en regProyecto
	}

	/*
	 * public float getGanancia() { return }
	 */

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public ArrayList<Empleado> getGrupoTrabajo() {
		return grupoTrabajo;
	}

	public void setGrupoTrabajo(ArrayList<Empleado> grupoTrabajo) {
		this.grupoTrabajo = grupoTrabajo;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jefe getJefeProyecto() {
		return (Jefe) grupoTrabajo.get(0);
	}

	public Planificador getPlanificador() {
		return (Planificador) grupoTrabajo.get(1);
	}

	public Programador getProgramador1() {
		return (Programador) grupoTrabajo.get(2);
	}

	public Programador getProgramador2() {
		return (Programador) grupoTrabajo.get(3);
	}

	public Empleado getTrabajadorAdicional() {
		Empleado emp = null;
	
		if (grupoTrabajo.get(4) instanceof Jefe) {
			emp = (Programador) grupoTrabajo.get(4);
		}
		if (grupoTrabajo.get(4) instanceof Programador) {
			emp = (Programador) grupoTrabajo.get(4);
		}
		if (grupoTrabajo.get(4) instanceof Planificador) {
			emp = (Planificador) grupoTrabajo.get(4);
		}
		if (grupoTrabajo.get(4) instanceof Disegnador) {
			emp = (Disegnador) grupoTrabajo.get(4);
		}
	
		return emp;	
	}
	
	public float getSumaSalarios() {

		float salaJefe = grupoTrabajo.get(0).getSalarioDia();
		float salaPlani = grupoTrabajo.get(1).getSalarioDia();
		float salaP1 = grupoTrabajo.get(2).getSalarioDia();
		float salaP2 = grupoTrabajo.get(3).getSalarioDia();
		float salaTrabaAdicional = grupoTrabajo.get(4).getSalarioDia();

		return (salaJefe + salaPlani + salaP1 + salaP2 + salaTrabaAdicional);
	}

	public String getId() {
		return id;
	}

}
