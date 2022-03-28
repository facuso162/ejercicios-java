package ejercicios;

import entidades.*;

public class Ejercicio5a {
	
	public static void main(String[] args) {
		
		Empleado empleados[] = new Empleado[3];
		EmpleadosData.cargaArregloEmpleados(empleados);
		EmpleadosData.listarEmpleados(empleados);
	}
}