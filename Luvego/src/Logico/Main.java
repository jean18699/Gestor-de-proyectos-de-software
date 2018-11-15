package Logico;

public class Main {

	public static void main(String[] args) {
		
		Empleado jean = new Jefe("jean","george","hombre",19,"cerro alto",80,"Excelente");
		Empresa.getInstance().nuevoEmpleado(jean);
		System.out.println(Empresa.getInstance().getEmpleados().get(0).getApellidos());
		
	}

}
