package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		int n, mayoresLength = 0;
		int nums[] = new int[3], mayores[] = new int[3];
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese un numero:");
		n = s.nextInt();
		
		System.out.println("Ingrese " + nums.length + " numeros:");
		for(int i = 0; i < nums.length; i++) {
			System.out.println("Pos. " + i + ": ");
			nums[i] = s.nextInt();
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > n) {
				mayores[mayoresLength++] = nums[i];
			}
		}
		
		if(mayoresLength > 0) {
			System.out.println("Nueva lista:");
			for(int i = 0; i < mayoresLength; i++) {
				System.out.println("Pos." + i + ": " + mayores[i]);
			}
		} else {
			System.out.println("Ningun numero es mayor a: " + n);
		}
	}
}
