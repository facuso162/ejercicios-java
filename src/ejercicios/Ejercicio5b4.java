package ejercicios;

import java.util.LinkedList;
import javax.swing.*;

public class Ejercicio5b4 {

	public static void main(String[] args) {
		
		int n;
		LinkedList<Integer> numeros = new LinkedList<Integer>();
		JTextArea area = new JTextArea();
		JScrollPane roll = new JScrollPane(area);
		
		for(int i = 0; i < 20; i++) {
			numeros.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero")));
		}
		
		n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero para filtrar"));
		
		for(int i = 0; i < numeros.size(); i++) {
			if(numeros.get(i) <= n) {
				numeros.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < numeros.size(); i++) {
			area.append(numeros.get(i).toString() + "\n");
		}
		
		JOptionPane.showMessageDialog(null, roll);		
	}
}
