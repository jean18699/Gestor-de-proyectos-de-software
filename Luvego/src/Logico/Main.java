package Logico;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
	
		ArrayList<String> esp = new ArrayList<>();
		esp.add("Java");
		esp.add("Python");
		
		Empleado pro = new Programador("456","123","j","hombre",19,"8094848","61468464","cerroalto",156,esp);
		Empleado pro2 = new Programador("456","123","j","hombre",19,"8094848","61468464","cerroalto",156,esp);
		Empleado dsg = new Disegnador("111","jeane","j","hombre",19,"684684","64684","cerro alto",15);
		Empleado chef = new Jefe("456","123","j","hombre",19,"8094848","61468464","cerroalto",156);
		

		Empresa.getInstance().nuevoEmpleado(pro);
		Empresa.getInstance().nuevoEmpleado(pro2);
		Empresa.getInstance().nuevoEmpleado(dsg);
		Empresa.getInstance().nuevoEmpleado(chef);
		Empresa.getInstance().nuevoEmpleado(dsg);
		
		ArrayList<Empleado> grupo = new ArrayList<>();
		grupo.add(chef);
		grupo.add(pro);
		grupo.add(pro2);
		grupo.add(dsg);
		grupo.add(dsg);
		
		Date fecha = new Date();
		
		Cliente cliente = new Cliente("123" ,"george","gmail","809","276","cerro alto","Hombre");
		Proyecto proyecto = new Proyecto("prueba",grupo,"Movil");
	
		Contrato contrato = new Contrato(proyecto,fecha);
		
		proyecto.setContrato(contrato);
		proyecto.getContrato().setCliente(cliente);
		Empresa.getInstance().agregarProyecto(proyecto);
		Empresa.getInstance().agregarProyecto(proyecto);
		Empresa.getInstance().nuevoCliente(cliente);
		
		//System.out.println(Empresa.getInstance().getClienteIndex("1"));
		
		//System.out.println(Empresa.getInstance().getContratos().get(0).getCliente().getNombre());
		
		//System.out.println(Empresa.getInstance().getProyectos().size());
		//System.out.println(Empresa.getInstance().getEmpleados().get(0).getProyectosActivos());
		//	System.out.println(Empresa.getInstance().getEmpleados().get(3).getProyectosActivos());
		//System.out.println(Empresa.getInstance().getProyectos().get(0).getGrupoTrabajo().get(0).getApellidos());
		
		
		/*
		Empleado pro2 = new Programador("jeaasdfn","j","hombre",19,"cerro alto",156,esp);
		Empleado dsg = new Disegnador("jeane","j","hombre",19,"cerro alto",15);
		Empleado dsg2 = new Disegnador("jeane","j","hombre",19,"cerro alto",15);
		
		*/
	
		
	/*	Empleado chef = new Jefe("jeanff","j","hombre",19,"cerro alto",1556);
		Empleado p = new Planificador("jeasn","j","hombre",19,"cerro alto",15, 0);
	*/
	/*	System.out.println(pro.getId());
		System.out.println(dsg.getId());
		
		ArrayList<Empleado> grupo = new ArrayList<>();
		grupo.add(chef);
		grupo.add(p);
		grupo.add(pro);
		grupo.add(pro3);
		grupo.add(dsg);
		
*/
		
		 
		//Date date2 = new Date("15/2/2018");
		
		/*Proyecto pr = new Proyecto("523","Globos",grupo,"Web");
		Proyecto pr2 = new Proyecto("123","Globos",grupo,"Movil");
		Proyecto pr3 = new Proyecto("123","Globos",grupo,"Movil");
		
		Contrato contrato = new Contrato(pr,date);
		Contrato contrato2 = new Contrato(pr2,date);
		Contrato contrato3 = new Contrato(pr3,date);
		
		Cliente cl = new Cliente("456","asdasd","fafasf","null");
		
		Empresa.getInstance().nuevoCliente(cl);
		Empresa.getInstance().nuevoContrato("456", contrato);

		//System.out.println(Empresa.getInstance().getContratoByIdProyecto("523").getCliente().getNombre());
		*/
		
		//System.out.println(Empresa.getInstance().getClientes().get(0).getContratos().get(0).getProyecto().getId());
		//System.out.println(Empresa.getInstance().getClienteByIdProyecto("523").getId());
		//System.out.println(Empresa.getInstance().getPr);
		
	//	System.out.println(Empresa.getInstance().getMejorCategoria());
		
		//	System.out.println(Empresa.getInstance().getProyectos().size());
		
		//System.out.println(Empresa.getInstance().getProyectos().size());
		//System.out.println(pr.getSumaSalarios());
		
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
	
		
		
	}

}
