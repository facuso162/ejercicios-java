package ejercicios;

import java.util.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		String palabras[] = new String[3];
		Scanner s = new Scanner(System.in);
		int esta = 0;
		
		System.out.println("Ingrese 10 palabras.\n");
		
		for(int i = 0 ; i < palabras.length; i++) {
			palabras[i] = s.nextLine();
		}
		
		System.out.println("\nIngrese una palabra.\n");
		
		String pal = s.nextLine();
		for(int i = 0 ; i < palabras.length; i++) {
			if(palabras[i].equals(pal)) {
				esta = 1;
				break;
			}
		}
		
		if(esta == 1) {
			System.out.println("La palabra: " + pal + " fue hallada en el arreglo");
		} else {
			System.out.println("No se pudo encontrar la palabra: " + pal + " en el arreglo");
		}
	}
}
