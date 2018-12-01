package Logico;

import java.io.Serializable;

public class Disegnador extends Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	private String ocupacion;//Puse esta variable para fines de obtener datos de este empleado de manera facil
	
	public Disegnador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		ocupacion = "Diseñador";
	}

	

	@Override
	public String identificador() {

		return "DSG-";
	}



	@Override
	protected String getOcupacion() {		
		return "Diseñador";
	}

}
