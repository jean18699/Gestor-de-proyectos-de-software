package Logico;

import java.util.ArrayList;

public class Proyecto {
	
	private Jefe jefeProyecto;
	private Planificador planificador;
	private Programador programador1;
	private Programador programador2;
	private Trabajador trabajadorAdicional;
	private float sumaSalarios;
	
	public Proyecto(Jefe jefeProyecto, Planificador planificador, Programador programador1, Programador programador2,
			Trabajador trabajadorAdicional, float sumaSalarios) {
		super();
		this.jefeProyecto = jefeProyecto;
		this.planificador = planificador;
		this.programador1 = programador1;
		this.programador2 = programador2;
		this.trabajadorAdicional = trabajadorAdicional;
		this.sumaSalarios = sumaSalarios;
	}

	public Jefe getJefeProyecto() {
		return jefeProyecto;
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

	public Trabajador getTrabajadorAdicional() {
		return trabajadorAdicional;
	}

	public void setTrabajadoresAdicionales(Trabajador trabajadorAdicional) {
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
	
		

}
