package Logico;

public class Planificador extends Empleado {

	private int frecuencia;
	
	public Planificador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora,
			String evaluacionAnual) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora, evaluacionAnual);
		// TODO Auto-generated constructor stub
	}

	@Override
	String identificador() {
		// TODO Auto-generated method stub
		return "PLN-";
	}

}
