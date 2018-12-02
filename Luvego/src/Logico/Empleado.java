package Logico;

import java.io.Serializable;
import java.util.ArrayList;

 public abstract class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167295889165009446L;
	//para generar el id
	private static int cont;
	private String ceros;

	protected String id;
	protected final String nombre;
	protected final String apellidos;
	protected final String sexo;
	protected final int edad;
	protected final float salarioHora;
	protected final String direccion;
	protected ArrayList<Proyecto> proyectos;
	protected char evaluacionAnual;
	private String ocupacion;
	
	public Empleado(String nombre, String apellidos, String sexo, int edad,String direccion, float salarioHora) {

		
		ceros = "";
		cont++;
		id = Integer.toString(cont);
		generarCeros();
		id = ceros+=id;
		
		this.evaluacionAnual = 'E';
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.edad = edad;
		this.direccion = direccion;
		this.salarioHora = salarioHora;
		proyectos = new ArrayList<>();

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

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void setCont(int cont) {
		Empleado.cont = cont;
	}

	public void setCeros(String ceros) {
		this.ceros = ceros;
	}

	
	public void setProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	public String getCargo()
	{
		return getOcupacion();
	}
	
	protected abstract String getOcupacion();


	
	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	
}
