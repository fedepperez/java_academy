package day_06;

import java.util.Scanner;

/*
 * Esercizio 04
 * Verificatore ISBN 
 */

public class VerificaISBN {

	public static boolean isValidISBN(String isbn) {
		// Rimuoviamo i trattini
		isbn = isbn.replace("-", "");

		// Deve essere lungo esattamente 10 caratteri
		if (isbn.length() != 10) {
			return false;
		}

		int somma = 0;

		for (int i = 0; i < 10; i++) {
			char c = isbn.charAt(i);
			int valore;

			// Se è l'ultima cifra ed è 'X', vale 10
			if (i == 9 && c == 'X') {
				valore = 10;
			} else if (Character.isDigit(c)) {
				valore = Character.getNumericValue(c);
			} else {
				return false; // Carattere non valido
			}

			somma += valore * (10 - i);
		}

		// Valido se la somma è divisibile per 11
		return somma % 11 == 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci un codice ISBN-10:");
		String codice = scanner.nextLine();

		if (isValidISBN(codice)) {
			System.out.println("Il codice è un ISBN-10 valido.");
		} else {
			System.out.println("Il codice NON è un ISBN-10 valido.");
		}

		scanner.close();
	}
}
