package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String>lenguajes = new ArrayList<>();
		lenguajes.add("C++");
		lenguajes.add("Java");
		lenguajes.add("Python");
		
		Date fecha = new Date("11/24/2018");
		
		Empleado programador = new Programador("jean", "carlos", "hombre", 19, "cerro alto",50, lenguajes);
		Empleado jefe = new Jefe("pepe","luis","hombre",23,"tu casa",38);
		Empleado planificador = new Planificador("Kyle","West","Hombre",33,"palillo hondo",200);
		Empresa.getInstance().nuevoEmpleado(programador);
		
		Cliente cliente = new Cliente("123", "jean", "cerro alto");
		Empresa.getInstance().nuevoCliente(cliente);
	
	//System.out.println(programador.getId());
		System.out.println(Empresa.getInstance().getEmpleadoById("PRG-0000001").getApellidos());
		//System.out.println(proyecto.getProgramador1().getEdad());
		
		/*Contrato contrato = new Contrato(proyecto,fecha);
		Empresa.getInstance().nuevoContrato("123", contrato);
		Empresa.getInstance().nuevoContrato("123", contrato);
		Empresa.getInstance().nuevoContrato("123", contrato);
		Empresa.getInstance().nuevoContrato("123", contrato);
		Empresa.getInstance().nuevoContrato("123", contrato);
		Empresa.getInstance().nuevoContrato("123", contrato);
		System.out.println(Empresa.getInstance().nuevoContrato("123", contrato));
		*/
		
	}

}
