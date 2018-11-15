package Logico;

public class Disegnador extends Trabajador {

	public Disegnador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora,
			char evaluacionAnual) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora, evaluacionAnual);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String identificador() {

		return "DSG-";
	}

}
