package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String direccion;
	private ArrayList<Contrato> contratos;
	private int totalContratos;
	private String pass;
	
	
	public Cliente(String id, String nombre, String direccion, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pass = pass;
		contratos = new ArrayList<>(5);
		totalContratos = 0;
	}


	public int getTotalContratos() {
		return totalContratos;
	}


	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}


	public void setTotalContratos(int totalContratos) {
		this.totalContratos = totalContratos;
	}


	public String getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ArrayList<Contrato> getContratos() {
		return contratos;
	}


	public boolean setContrato(Contrato contrato) {
		if(contratos.size() <= 5)
		{
			contratos.add(contrato);
			totalContratos++;
			return true;
		}
		return false;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Cliente() {
		
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

}
