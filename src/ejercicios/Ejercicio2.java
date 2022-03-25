package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		String palabras[] = new String[10];
		Scanner s = new Scanner(System.in);
		for(int i = 0; i < palabras.length; i++) {
			palabras[i] = s.nextLine();
		}
		for(int i = palabras.length - 1; i >= 0; i--) {
			System.out.println(palabras[i]);
		}
	}

}
