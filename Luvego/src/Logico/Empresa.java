package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Empresa {

	private ArrayList<Cliente> clientes;
	private ArrayList<Contrato> contratos;
	private ArrayList<Empleado> empleados;
	private ArrayList<Proyecto> proyectos;
	private static Empresa empresa;
	
	private Empresa() {
	
		clientes = new ArrayList<>();
		contratos = new ArrayList<>();
		empleados = new ArrayList<>();
		proyectos = new ArrayList<>();	
		
	}
	
	public static Empresa getInstance()
	{
		if(empresa == null)
		{
			empresa = new Empresa();
		}
		return empresa;	
	}
	
	
	public void nuevoEmpleado(Empleado empleado)
	{
		empleados.add(empleado);
	}
	
	
	public void nuevoCliente(Cliente cliente)
	{
		clientes.add(cliente);
	}
	
	public boolean nuevoContrato(String idContrato, String nombreProyecto, Proyecto proyecto, String idCliente, int cantDias, Jefe jefe,String categoria, Date fechaEntrega)
	{
		boolean estado = true;
		float precioContrato = 8 * cantDias * proyecto.getSumaSalarios();
		if(existeCliente(idCliente) == true)
		{
			if(contratos.size() > 5)
			{
				estado = false;
			}
			//Contrato contrato = new Contrato(idContrato, idCliente, nombreProyecto, jefe, fechaEntrega, estado, categoria);
			//Contrato contrato = new Contrato(idContrato, proyecto, fechaEntrega, proyecto.getSumaSalarios());
			//contratos.add(contrato);		
		}
		return false;
	}
	
	
	public boolean cancelarContrato(String idContrato)
	{
		for(int i = 0; i < clientes.size(); i++)
		{
			if(contratos.get(i).getId().equalsIgnoreCase(idContrato))
			{
				contratos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	private boolean existeCliente(String id)
	{
		for(int i = 0; i < clientes.size(); i++)
		{
			if(clientes.get(i).getId().equalsIgnoreCase(id))
			{
				return true;
			}
		}
		return false;
	}
	
	public Cliente getClienteById(String id)
	{
		Cliente cliente = null;
		boolean encontrado = false;
		for(int i = 0; i < clientes.size() && !encontrado;i++)
		{
			if(clientes.get(i).getId().equalsIgnoreCase(id))
			{
					cliente = clientes.get(i);
					encontrado = true;
			}
		}
		
		return cliente;
	}
			
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public static void setEmpresa(Empresa empresa) {
		Empresa.empresa = empresa;
	}
}