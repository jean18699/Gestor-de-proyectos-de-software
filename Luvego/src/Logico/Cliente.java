package Logico;

import java.util.ArrayList;

public class Cliente {

	private String id;
	private String nombre;
	private String direccion;
	private ArrayList<Contrato> contratos;
	
	
	public Cliente(String id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		contratos = new ArrayList<>(5);
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

}
