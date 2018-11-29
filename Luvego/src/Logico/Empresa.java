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
	
	public boolean nuevoContrato(String id, Contrato contrato)
	{

		if(existeCliente(id))
		{
			for(int i = 0; i < clientes.size();i++)
			{
				if(clientes.get(i).getId().equalsIgnoreCase(id))
				{
					if(clientes.get(i).setContrato(contrato))
					{
						contrato.setCliente(clientes.get(i));
						return true;	
					}else
					{
					return false;
				
					}
				}
			}
		}else
		{
			return false;
		}
		
		return false;
	}
	
	public void nuevoProyecto(Proyecto proyecto)
	{
		proyectos.add(proyecto);
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
		
	public Empleado getEmpleadoById(String id)
	{
		Empleado emp = null;
		boolean encontrado = false;
		for(int i = 0; i < empleados.size() && !encontrado;i++)
		{
			if(empleados.get(i).getId().equalsIgnoreCase(id))
			{
				emp = empleados.get(i);
				encontrado = true;
			}
		}
		return emp;
	}
	
	//Funcion que recibira una lista de empleados para asignarles el mismo proyecto
	public void asignarProyecto(ArrayList<Empleado> empleado, Proyecto proyecto)
	{
		for(int i = 0; i < empleado.size();i++)
		{
			
			if(empleado.get(i).getProyectos().size() < 3)
			{
				
				empleado.get(i).setProyecto(proyecto);
			}else
			{
				System.out.println("excedido");
			}
		}	
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