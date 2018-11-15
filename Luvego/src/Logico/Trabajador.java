package Logico;

import java.util.ArrayList;

abstract class Trabajador {

	//Para genera el id
	protected String id;
	private static int cont;
	private String ceros;

	
	protected final String nombre;
	protected final String apellidos;
	protected final String sexo;
	protected final int edad;
	protected final float salarioHora;
	protected final String direccion;
	protected ArrayList<String> proyectos;
	protected char evaluacionAnual;
	
	
	
	public Trabajador(String nombre, String apellidos, String sexo, int edad,String direccion, float salarioHora, char evaluacionAnual) {

		super();
		ceros = "";
		cont++;
		id = Integer.toString(cont);
		generarCeros();
		id = ceros+=id;
		
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.edad = edad;
		this.evaluacionAnual = evaluacionAnual;
		this.direccion = direccion;
		this.salarioHora = salarioHora;
	}

	
	public float getSalarioDia()
	{
		return salarioHora * 8;
	}
	
	
	public String getApellidos() {
		return apellidos;
	}


	public String getDireccion() {
		return direccion;
	}

	

	public char getEvaluacionAnual() {
		return evaluacionAnual;
	}


	public void setEvaluacionAnual(char evaluacionAnual) {
		this.evaluacionAnual = evaluacionAnual;
	}


	private void generarCeros()
	{
		for (int i = 0; i < 7 - id.length(); i++) {
			ceros = ceros + "0";
		}	
	}
	
	public String getId() {
		return identificador() + id;
	}

	
	abstract String identificador();

	
	public static int getCont() {
		return cont;
	}

	public String getCeros() {
		return ceros;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public int getEdad() {
		return edad;
	}

	public float getSalarioHora() {
		return salarioHora;
	}

	public ArrayList<String> getProyectos() {
		return proyectos;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void setCont(int cont) {
		Trabajador.cont = cont;
	}

	public void setCeros(String ceros) {
		this.ceros = ceros;
	}

	
	public void setProyectos(ArrayList<String> proyectos) {
		this.proyectos = proyectos;
	}
	

}
