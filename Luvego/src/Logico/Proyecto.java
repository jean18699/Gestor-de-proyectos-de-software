package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private ArrayList<Empleado> grupoTrabajo;
	private float sumaSalarios;
	private String clasificacion;

	public Proyecto(String id, String nombre, ArrayList<Empleado> grupoTrabajo, String clasificacion) {

		this.id = id;
		this.nombre = nombre;
		this.grupoTrabajo = grupoTrabajo;
		this.sumaSalarios = getSumaSalarios();
		this.clasificacion = clasificacion;
	}

	/*
	 * public float getGanancia() { return }
	 */

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
