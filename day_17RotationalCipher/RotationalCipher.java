package day_17RotationalCipher;

import java.util.Scanner;

public class RotationalCipher {

	public static String cifraRotazionale(String testo, int key) {
		StringBuilder risultato = new StringBuilder();

		// Assicuriamoci che la chiave sia tra 0 e 26
		key = key % 26;

		for (char c : testo.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				// minuscole
				char cShifted = (char) ('a' + (c - 'a' + key) % 26);
				risultato.append(cShifted);
			} else if (c >= 'A' && c <= 'Z') {
				// maiuscole
				char cShifted = (char) ('A' + (c - 'A' + key) % 26);
				risultato.append(cShifted);
			} else {
				// caratteri non alfabetici rimangono invariati
				risultato.append(c);
			}
		}

		return risultato.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Inserisci il testo da cifrare: ");
		String testo = input.nextLine();

		System.out.print("Inserisci la chiave (0-26): ");
		int key = input.nextInt();

		if (key < 0 || key > 26) {
			System.out.println("Chiave non valida. Deve essere tra 0 e 26.");
			input.close();
			return;
		}

		String testoCifrato = cifraRotazionale(testo, key);
		System.out.println("Testo cifrato: " + testoCifrato);

		input.close();
	}
}