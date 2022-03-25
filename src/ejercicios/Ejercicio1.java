package ejercicios;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Pares\n");
		for(int i = 0; i < 20; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		System.out.println("\nImpares\n");
		for(int i = 0; i < 20; i++) {
			if(i % 2 != 0) {
				System.out.println(i);
			}
		}	
	}
}