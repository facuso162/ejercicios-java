package ejercicios;

import java.util.LinkedList;
import entidades.*;

public class Ejercicio5b5 {

	public static void main(String[] args) {
		LinkedList<Empleado> empleados= new LinkedList<Empleado>();
		EmpleadosData5b5.cargaArregloEmpleados(empleados);
		EmpleadosData5b5.listarEmpleados(empleados);
	}
}
