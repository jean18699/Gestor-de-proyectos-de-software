package Logico;

import java.util.ArrayList;

public class Programador extends Empleado {
	
	private ArrayList<String> especialidades;

	public Programador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora, ArrayList<String> especialidades) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		this.especialidades = especialidades;
		// TODO Auto-generated constructor stub
	}

		@Override
		String identificador() {
			
			return "PRG-";
		}



}
