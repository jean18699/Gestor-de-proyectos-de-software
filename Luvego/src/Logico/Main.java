package Logico;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
	
		ArrayList<String> esp = new ArrayList<>();
		esp.add("Java");
		esp.add("Python");
		
		Empleado pro2 = new Programador("123","j","hombre",19,"cerro alto",156,esp);
		System.out.println(pro2.getId());
		Empresa.getInstance().nuevoEmpleado(pro2);
		Empleado pro3 = Empresa.getInstance().getEmpleadoById("PRG-0000001");
		
		Empleado pro = new Programador("jeaasdfn","j","hombre",19,"cerro alto",156,esp);
		Empleado dsg = new Disegnador("jeane","j","hombre",19,"cerro alto",15);
		Empleado dsg2 = new Disegnador("jeane","j","hombre",19,"cerro alto",15);
		
		Empleado chef = new Jefe("jeanff","j","hombre",19,"cerro alto",1556);
		Empleado p = new Planificador("jeasn","j","hombre",19,"cerro alto",15);
		
		ArrayList<Empleado> grupo = new ArrayList<>();
		grupo.add(chef);
		grupo.add(p);
		grupo.add(pro);
		grupo.add(pro3);
		grupo.add(dsg);
		

		
		 
		
		Date date = new Date("12/2/2018");
		Proyecto pr = new Proyecto("123","Globos",grupo,"Web");
		Contrato contrato = new Contrato(pr,date);
		System.out.println(contrato.getDiasRestantes());
		
		
		//System.out.println(pr.getSumaSalarios());
		
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
		//Empresa.getInstance().asignarProyecto(grupo, pr);
	
	}

}
