package day_04;

import java.util.Scanner;

/*
 * Esercizio 01
 * Calcolo del numero di parole in una stringa
 * Scrivi un programma Java che calcola il numero di parole presenti in una
 * stringa data. Si considera una parola come una sequenza di caratteri
 * separati da spazi.
 */

public class NumeroParole {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserisci una frase a tua scelta!: ");
		String input = scanner.nextLine();
		
		// Rimuove eventuali spazi iniziali e finali e divide la stringa
        // in base a uno o più spazi
		String[] parole = input.trim().split("\\s+");
		
		 // Controlla se la stringa era vuota dopo il trim(rimuove gli spazi!!)
		 int numeroParole = (input.trim().isEmpty()) ? 0 : parole.length;
		 
		 System.out.println("Numero di parole: " + numeroParole);
		 
		 scanner.close();
	}
}
