package Logico;

public class Programador extends Trabajador {

	public Programador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora,
			String evaluacionAnual) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora, evaluacionAnual);
		// TODO Auto-generated constructor stub
	}

		@Override
		String identificador() {
			
			return "PRG-";
		}



}
