package Logico;

public class Disegnador extends Trabajador {

	public Disegnador(String nombre, String apellidos, String sexo, int edad, String direccion, float salario,
			String evaluacionAnual) {
		super(nombre, apellidos, sexo, edad, direccion, salario, evaluacionAnual);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String identificador() {

		return "DSG-";
	}

}
