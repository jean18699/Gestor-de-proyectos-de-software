package Logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> clientes;
	private static Cliente loginUser;
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
	
	
	
	
	
	public static Cliente getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Cliente loginUser) {
		Empresa.loginUser = loginUser;
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
	
	public static Empresa getEmpresa() {
		return empresa;
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

	public void setEmpresa(Empresa empresa) {
		Empresa.empresa = empresa;
	}
	
	public boolean ValidadorNombre(String str) {
		boolean verdad = true;
		
		int i = 0;
		if(str.equalsIgnoreCase("")/* || Integer.valueOf(str.charAt(0)) == 32*/) {
			return false;	
		}
		
		while(i < str.length() && verdad != false) {
			if(!((Integer.valueOf(str.charAt(i)) >= 65 && Integer.valueOf(str.charAt(i)) <= 90) || (Integer.valueOf(str.charAt(i)) >= 97 && Integer.valueOf(str.charAt(i)) <= 122)/*  || Integer.valueOf(str.charAt(i)) == 32*/)) {
				verdad = false;
				return verdad;
			}
			
			i++;
		}
		return verdad;
	}
	
	public boolean ValidadorCaracteres(String str) {
		boolean verdad = true;
		
		int i = 0;
		if(str.equalsIgnoreCase("") || Integer.valueOf(str.charAt(0)) == 32) {
			return false;	
		}
		
		while(i < str.length() && verdad != false) {
			if(!((Integer.valueOf(str.charAt(i)) >= 65 && Integer.valueOf(str.charAt(i)) <= 90) || (Integer.valueOf(str.charAt(i)) >= 97 && Integer.valueOf(str.charAt(i)) <= 122)  || Integer.valueOf(str.charAt(i)) == 32)) {
				verdad = false;
				return verdad;
			}
			
			i++;
		}
		return verdad;
	}
	
	public boolean ValidadorNumeros(String str) {
		boolean verdad = true;
		
		int i = 0;
		if(str.equalsIgnoreCase("")) {
			verdad = false;
		}
		while(i < str.length() && verdad != false) {
			if(Integer.valueOf(str.charAt(i)) < 46 || Integer.valueOf(str.charAt(i)) > 57) {
				verdad = false;
				return verdad;
			}
			i++;

		}
		return verdad;
	}
	
	public boolean ValidadorCedula(String str) {
		boolean verdad = true;
		
		int i = 0;
		int cantGuiones = 0;
		if(str.equalsIgnoreCase("")) {
			return false;
		}
		while(i < str.length() && verdad != false) {
			if(Integer.valueOf(str.charAt(i)) == 45) {
				cantGuiones++;
			}
			if((Integer.valueOf(str.charAt(i)) != 45 && Integer.valueOf(str.charAt(i)) < 48 || Integer.valueOf(str.charAt(i)) > 57) || cantGuiones > 2) {
				verdad = false;
				return verdad;
			}
			i++;

		}
		return verdad;
	}
	
	public boolean ValidadorFlotantes(String str) {
		boolean verdad = true;
		
		int i = 0;
		int cantPuntosDecimales = 0;
		if(str.equalsIgnoreCase("")) {
			verdad = false;
		}
		while(i < str.length() && verdad != false) {
			if(Integer.valueOf(str.charAt(i)) == 46) {
				cantPuntosDecimales++;
			}
			if(Integer.valueOf(str.charAt(i)) < 46 || Integer.valueOf(str.charAt(i)) > 57 || Integer.valueOf(str.charAt(i)) == 47 || cantPuntosDecimales > 1) {
				verdad = false;
				return verdad;
			}
			i++;

		}
		return verdad;
	}
	
	public boolean confirmLogin(String Id, String Contrasena) {
		boolean login = false;
		
		if(loginUser.getId().equals("Admin") && loginUser.getPass().equals("0000")) {
			login = true;
		}
		
		return login;
	}
}