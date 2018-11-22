package Logico;

import java.util.ArrayList;

public class Proyecto {
	
	private String id;
	private String nombre;
	private Jefe jefeProyecto;
	private Planificador planificador;
	private Programador programador1;
	private Programador programador2;
	private Empleado trabajadorAdicional;
	private float sumaSalarios;
	
	public Proyecto(String id, String nombre, Jefe jefeProyecto, Planificador planificador, Programador programador1, Programador programador2,
			Empleado trabajadorAdicional, float sumaSalarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jefeProyecto = jefeProyecto;
		this.planificador = planificador;
		this.programador1 = programador1;
		this.programador2 = programador2;
		this.trabajadorAdicional = trabajadorAdicional;
		this.sumaSalarios = sumaSalarios;
	}

	/*
	public float getGanancia()
	{
		return
	}*/
	
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
		return trabajadorAdicional;
	}

	public void setTrabajadoresAdicionales(Empleado trabajadorAdicional) {
		this.trabajadorAdicional = trabajadorAdicional;
	}

	public float getSumaSalarios() {
		
		float salaJefe = jefeProyecto.getSalarioDia();
		float salaPlani = planificador.getSalarioDia();
		float salaP1 = programador1.getSalarioDia();
		float salaP2 = programador2.getSalarioDia();
		float salaTrabaAdicional = trabajadorAdicional.getSalarioDia();
		
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
		this.trabajadorAdicional = trabajadorAdicional;
	}
	
		

}
