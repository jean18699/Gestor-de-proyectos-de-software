package Logico;

public class Jefe extends Empleado {


	public Jefe(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		
	}

	public String getOcupacion() {
		return "Jefe de proyectos";
	}

	@Override
	String identificador() {
		
		return "JFE-";
	}

	
}
