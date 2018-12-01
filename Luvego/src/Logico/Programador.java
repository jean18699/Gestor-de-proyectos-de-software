package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Programador extends Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> especialidades;
	
	public Programador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora, ArrayList<String> especialidades) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		this.especialidades = especialidades;
		
	}

		public ArrayList<String> getEspecialidades() {
		return especialidades;
	}

	public String getOcupacion() {
		return "Programador";
	}

	public void setEspecialidades(ArrayList<String> especialidades) {
		this.especialidades = especialidades;
	}

		@Override
		String identificador() {
			
			return "PRG-";
		}



}
