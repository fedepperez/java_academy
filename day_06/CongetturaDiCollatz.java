package day_06;

import java.util.Scanner;

/*
 * Esercizio 01
 * Congettura di Collatz
 */

public class CongetturaDiCollatz {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci un numero intero positivo:");
		int n = input.nextInt();
		
		int steps = 0;  // Contatore dei passaggi
		
		// Applichiamo la congettura finché n non diventa 1
		while (n != 1) {
			if (n % 2 == 0) {
				// Se n è pari
				n = n / 2;
			} else {
				// Se n è dispari
				n = 3 * n + 1;
			}
			
			steps++;  // Incrementa i passaggi
		}
		
		System.out.println("Numero di passaggi per arrivare a 1: " + steps);
		input.close();

	}
}
