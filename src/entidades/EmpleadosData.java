package entidades;

import javax.swing.*;

public class EmpleadosData {

	public static void cargaArregloEmpleados(Empleado[] empleados) {
		
		char q = ' ';
		int dni, totalVentas, hsExtra, hsMes;
		String nombre, apellido, email;
		double sueldoBase, porcenComision;
		
		for (int i = 0; i < empleados.length; i++) {
			dni = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dni", "Empleado " + i, JOptionPane.QUESTION_MESSAGE));
			nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre", "Empleado " + i, JOptionPane.QUESTION_MESSAGE);
			apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido", "Empleado " + i, JOptionPane.QUESTION_MESSAGE);
			email = JOptionPane.showInputDialog(null, "Ingrese el email", "Empleado " + i, JOptionPane.QUESTION_MESSAGE);
			sueldoBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el sueldo base", "Empleado " + i, JOptionPane.QUESTION_MESSAGE));
			do{
				q = JOptionPane.showInputDialog("El empleado" + i + " , es vendedor (V) o administrativo (A)?").charAt(0);
				if (Character.toUpperCase(q) != 'V' && Character.toUpperCase(q) != 'A') 
					JOptionPane.showMessageDialog(null, "Ingrese V o A", "Error", JOptionPane.ERROR_MESSAGE);
			}while(Character.toUpperCase(q) != 'V' && Character.toUpperCase(q) != 'A');
			if(Character.toUpperCase(q) == 'V') {
				porcenComision = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el porcentaje de comision", "Empleado " + i, JOptionPane.QUESTION_MESSAGE));
				totalVentas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el total de ventas", "Empleado " + i, JOptionPane.QUESTION_MESSAGE));
				empleados[i] = new Vendedor(dni, nombre, apellido, email, sueldoBase, porcenComision, totalVentas);
			} else {
				hsExtra = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el horas extra", "Empleado " + i, JOptionPane.QUESTION_MESSAGE));
				hsMes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el horas del mes", "Empleado " + i, JOptionPane.QUESTION_MESSAGE));
				empleados[i] = new Administrativo(dni, nombre, apellido, email, sueldoBase, hsExtra, hsMes);
			}			
		}
	}
	
	public static void listarEmpleados(Empleado[] empleados) {
		
		JTextArea area = new JTextArea();
		JScrollPane roll = new JScrollPane(area);
		area.setText("Empleados\n");
		
		for (Empleado empleado : empleados) {
			area.append(empleado.toString() + "\n");
		}
		
		JOptionPane.showMessageDialog(null, roll);
	}
}