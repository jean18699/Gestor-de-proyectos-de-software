package Logico;

public class Planificador extends Empleado {

	private int frecuencia;
	
	public Planificador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		// TODO Auto-generated constructor stub
	}

	@Override
	String identificador() {
		// TODO Auto-generated method stub
		return "PLN-";
	}

}
