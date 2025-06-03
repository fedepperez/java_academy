package day_04;

/*
 * Esercizio 06
 * Calcolo della media di un array
 * Scrivi un programma Java che calcola la media dei valori presenti in un
 * array di numeri in virgola mobile (double).
 */

public class MediaArray {

	public static void main(String[] args) {
		// Definizione dell'array di numeri double
		double[] numeri = {1.5, 2.0, 3.5, 4.0, 5.5};
		
		// Calcolo della somma degli elementi
		double somma = 0;
		for (double numero : numeri) {
			somma += numero;
		}

		// Calcolo della media
		double media = somma / numeri.length;
		
		// Visualizzazione del risultato
		System.out.println("La media dei numeri è: " + media);
	}

}
