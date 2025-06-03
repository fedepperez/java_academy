package day_04;

import java.util.Scanner;

/*
 * Esercizio 11
 * Verifica se un numero è primo
 * Scrivi un programma java per verificare se un numero è primo con il metodo
 * del crivello di eratostene.
 */

public class CrivelloEratostene {
	
	//Metodo che genera un array booleano dove true indica che l'indice è primo
	public static boolean[] crivello(int n) {
		boolean[] primi = new boolean[n + 1];
		
		// Inizializza tutti come true (possibili primi), tranne 0 e 1
		for (int i = 2; i <= n; i++) {
			primi[i] = true;
		}
		
		// Per ogni numero da 2 a radice di n, elimina i multipli
		for (int i = 2; i * i <= n; i++) {
			if (primi[i]) {
				// Marca tutti i multipli di i come non primi
				for (int j = i * i; j <= n; j += i) {
					primi[j] = false;
				}
			}
		}
		
		return primi;

	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci un numero positivo da verificare se è primo:");
		
		int numero = input.nextInt();
		
		if (numero < 2) {
			System.out.println(numero + " non è un numero primo.");
			input.close();
			return;
		}
		
		// Calcoliamo il crivello fino a numero
		boolean[] primi = crivello(numero);
		
		if (primi[numero]) {
			System.out.println(numero + " è un numero primo.");
		} else {
			System.out.println(numero + " non è un numero primo.");
		}
		
		input.close();
	}

}
