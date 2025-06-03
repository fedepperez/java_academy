package day_04;

import java.util.Scanner;

/*
 * Esercizio 05
 * Calcolo della potenza di un numero
 * Scrivi un programma Java che calcola la potenza di un numero base elevato
 * a un esponente dato.
 */

public class CalcoloPotenza {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserisci il numero di base: ");
		double base = scanner.nextDouble();
		
		System.out.print("Inserisci l'esponente: ");
		double esponente = scanner.nextDouble();
				
		double risultato = Math.pow(base, esponente);
		
		System.out.println(base + " elevato alla " + esponente + " è uguale a: " + risultato);

		scanner.close();
	}

}
