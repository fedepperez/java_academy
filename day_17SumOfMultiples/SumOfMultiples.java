package day_17SumOfMultiples;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfMultiples {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Input del livello completato
		System.out.print("Inserisci il livello completato: ");
		int livello = scanner.nextInt();

		// Input del numero di oggetti magici trovati
		System.out.print("Quanti oggetti magici hai trovato? ");
		int numOggetti = scanner.nextInt();

		int[] valoriBase = new int[numOggetti];
		for (int i = 0; i < numOggetti; i++) {
			System.out.print("Inserisci il valore base dell'oggetto " + (i + 1) + ": ");
			valoriBase[i] = scanner.nextInt();
		}

		int puntiEnergia = calcolaPuntiEnergia(livello, valoriBase);
		System.out.println("Hai guadagnato " + puntiEnergia + " punti energia!");

		scanner.close();
	}

	public static int calcolaPuntiEnergia(int livello, int[] valoriBase) {
		Set<Integer> multipliUnici = new HashSet<>();

		for (int base : valoriBase) {
			for (int i = base; i < livello; i += base) {
				multipliUnici.add(i); // niente duplicati grazie al Set!
			}
		}

		int somma = 0;
		for (int numero : multipliUnici) {
			somma += numero;
		}

		return somma;
	}
}