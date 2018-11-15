package Logico;

public class Disegnador extends Empleado{

	public Disegnador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora,
			String evaluacionAnual) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora, evaluacionAnual);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String identificador() {

		return "DSG-";
	}

}
