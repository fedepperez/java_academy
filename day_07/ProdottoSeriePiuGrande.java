/*package day_07;

import java.util.Scanner;

public class ProdottoSeriePiuGrande {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserisci la sequenza di cifre: ");
		String input = scanner.nextLine();
		
		System.out.print("Inserisci la lunghezza della serie (span): ");
		int span = scanner.nextInt();
		
		if (span > input.length() || span <= 0) {
			System.out.println("Span non valido rispetto alla lunghezza della sequenza.");
			scanner.close();
			return;
			
		}
		
		int maxProdotto = 0;
		String serieMassima = "";
		//1234 con serie 2
		//le sequenze saranno 1*2*3, 2*3*4
		// Ciclo per scorrere tutte le sottostringhe di lunghezza span
		for (int i = 0; i <= input.length() - span; i++) {
			String serie = input.substring(i, input.length() - i - 1); //i + span);
			int prodotto = calcolaProdotto(serie);
			
			if (prodotto > maxProdotto) {
				maxProdotto = prodotto;
				serieMassima = serie;
			}
			System.out.println("serie" + serie);
		}
		
		System.out.println("Serie con prodotto massimo: " + serieMassima);
		System.out.println("Prodotto massimo: " + maxProdotto);
		
		scanner.close();

	}
	
	// Metodo per calcolare il prodotto delle cifre di una stringa
	public static int calcolaProdotto(String serie) {
		int prodotto = 1;
		for (int i = 0; i < serie.length(); i++) {
			int cifra = serie.charAt(i) - '0'; // converte char a int
			prodotto *= cifra;
		}
		
		return prodotto;
	}

}*/

package day_07;

import java.util.Scanner;

public class ProdottoSeriePiuGrande {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Inserisci la sequenza di cifre: ");
		String input = scanner.nextLine().trim();

		// controllo che la stringa non sia vuota
		if (input.isEmpty()) {
			System.out.println("Errore: la sequenza è vuota.");
			scanner.close();
			return;
		}

		System.out.print("Inserisci la lunghezza della sottostringa (span): ");
		int span = scanner.nextInt();

		// controllo che lo span sia valido
		if (span <= 0 || span > input.length()) {
			System.out.println("Errore: lo span deve essere positivo e non superiore alla lunghezza della sequenza.");
			scanner.close();
			return;
		}

		int maxProdotto = 0;
		int prodotto = 1;
		String serieTrovata = "";
		String serie = "";

		// 12345
		// es. numero di span 2 = 1*2, 2*3, 3*4, 4*5
		// se 3 = 1*2*3, 2*3*4, 3*4*5
		// sono i numeri 63915, quindi quello sopra con span 3: 6*3*9, 3*9*1, 9*1*5
		// primo blocco: 639
		// secondo blocco: 391
		// terzo blocco: 915
		// totale: 63915

		for (int i = 0; i <= input.length() - span; i++) {
			serie = input.substring(i, i + span); // 632
			prodotto = 1;
			for (char c : serie.toCharArray()) { // [6][3][9]
				if (!Character.isDigit(c)) { // c = 6 (controlla)
					throw new IllegalArgumentException("Contiene caratteri non numerici.");
				}
				prodotto = prodotto * (c - '0'); // tira fuori l'aritmetica ASCII
				// prodotto = prodotto * Integer.parseInt(serie, i);
			}
			if (maxProdotto < prodotto) {
				maxProdotto = prodotto;
				serieTrovata = serie;
			}
			
			scanner.close();
		}

		// primo risultato: serie con prodotto più grande
		// secondo risultato: il suo prodotto
		System.out.println("Serie con prodotto più grande: " + serieTrovata);
		System.out.println("Prodotto più grande della serie: " + maxProdotto);
		scanner.close();
	}

}
