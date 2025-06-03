package day_17nEsimoPrimo;

import java.util.Scanner;

public class nEsimoPrimo {

	// Metodo che verifica se un numero è primo
	public static boolean isPrimo(int numero) {
		if (numero < 2) {
			return false;
		}
		// Controlla divisori fino a radice quadrata di numero
		for (int i = 2; i * i <= numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		return true;
	}

	// Metodo che trova l'n-esimo numero primo
	public static int trovaNEsimoPrimo(int n) {
		int count = 0; // Conta quanti numeri primi trovati
		int numero = 1; // Numero da testare

		while (count < n) {
			numero++;
			if (isPrimo(numero)) {
				count++;
			}
		}
		return numero;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Inserisci il valore di n per trovare l'n-esimo numero primo: ");
		int n = input.nextInt();

		if (n <= 0) {
			System.out.println("Inserisci un numero positivo maggiore di zero.");
		} else {
			int nEsimoPrimo = trovaNEsimoPrimo(n);
			System.out.println("L'" + n + "-esimo numero primo è: " + nEsimoPrimo);
		}

		input.close();
	}
}
