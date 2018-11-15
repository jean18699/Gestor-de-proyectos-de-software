package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Luvego {

	private ArrayList<Cliente> clientes;
	private ArrayList<Contrato> contratos;
	private ArrayList<Trabajador> empleados;
	
	
	public Luvego() {
	
		clientes = new ArrayList<>();
		contratos = new ArrayList<>();
		empleados = new ArrayList<>();
	
		
	}
	
	
	
	public void nuevoEmpleado(Trabajador empleado)
	{
		empleados.add(empleado);
	}
	
	public void registrarCliente(Trabajador empleado)
	{
		empleados.add(empleado);
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
			Contrato contrato = new Contrato(idContrato, nombreProyecto, idCliente, proyecto.getJefeProyecto(), fechaEntrega, proyecto.getSumaSalarios(), precioContrato, 'I', categoria);
			contratos.add(contrato);
			
			
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
	

}
