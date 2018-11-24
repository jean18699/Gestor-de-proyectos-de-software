package Logico;

import java.util.ArrayList;

public class Proyecto {
	
	private String id;
	private String nombre;
	private Jefe jefeProyecto;
	private Planificador planificador;
	private Programador programador1;
	private Programador programador2;
	private Empleado adicional;
	private float sumaSalarios;
	private String clasificacion;
	
	public Proyecto(String id, String nombre, Empleado jefe, Empleado planificador, Empleado programador, Empleado programador2,
			Empleado adicional, String clasificacion) {
		
		this.id = id;
		this.nombre = nombre;
		this.jefeProyecto = (Jefe) jefe;
		this.planificador = (Planificador) planificador;
		this.programador1 = (Programador) programador;
		this.programador2 = (Programador) programador2;
		this.adicional = adicional;
		this.sumaSalarios = getSumaSalarios();
		this.clasificacion = clasificacion;
	}

	/*
	public float getGanancia()
	{
		return
	}*/
	
	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Jefe getJefeProyecto() {
		return jefeProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setJefeProyecto(Jefe jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	public Planificador getPlanificador() {
		return planificador;
	}

	public void setPlanificador(Planificador planificador) {
		this.planificador = planificador;
	}

	public Programador getProgramador1() {
		return programador1;
	}

	public void setProgramador1(Programador programador1) {
		this.programador1 = programador1;
	}

	public Programador getProgramador2() {
		return programador2;
	}

	public void setProgramador2(Programador programador2) {
		this.programador2 = programador2;
	}

	public Empleado getTrabajadorAdicional() {
		return adicional;
	}

	public void setTrabajadoresAdicionales(Empleado trabajadorAdicional) {
		this.adicional = trabajadorAdicional;
	}

	public float getSumaSalarios() {
		
		float salaJefe = jefeProyecto.getSalarioDia();
		float salaPlani = planificador.getSalarioDia();
		float salaP1 = programador1.getSalarioDia();
		float salaP2 = programador2.getSalarioDia();
		float salaTrabaAdicional = adicional.getSalarioDia();
		
		return (salaJefe + salaPlani + salaP1 + salaP2 + salaTrabaAdicional);
	}

	public void setSumaSalarios(float sumaSalarios) {
		this.sumaSalarios = sumaSalarios;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTrabajadorAdicional(Empleado trabajadorAdicional) {
		this.adicional = trabajadorAdicional;
	}
	
		

}
