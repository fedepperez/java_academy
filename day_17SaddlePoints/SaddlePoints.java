package day_17SaddlePoints;

public class SaddlePoints {

	public static void main(String[] args) {
		int[][] matrice = { { 9, 8, 7, 8 }, { 5, 3, 2, 4 }, { 6, 6, 7, 1 } };

		// 1. Stampa la matrice
		System.out.println("Matrice degli alberi (altezze):");
		for (int[] riga : matrice) {
			for (int valore : riga) {
				System.out.print(valore + "\t");
			}
			System.out.println();
		}

		boolean trovato = false;

		// 2. Cerca i punti sella
		for (int i = 0; i < matrice.length; i++) {
			int maxRiga = matrice[i][0];
			int colMax = 0;

			// Trova il massimo nella riga
			for (int j = 1; j < matrice[i].length; j++) {
				if (matrice[i][j] > maxRiga) {
					maxRiga = matrice[i][j];
					colMax = j;
				}
			}

			// Verifica se è anche il minimo nella colonna
			boolean èMinimoInColonna = true;
			for (int k = 0; k < matrice.length; k++) {
				if (matrice[k][colMax] < maxRiga) {
					èMinimoInColonna = false;
					break;
				}
			}

			if (èMinimoInColonna) {
				System.out.println(
						"→ Punto sella trovato in posizione: [" + i + ", " + colMax + "] con valore " + maxRiga);
				trovato = true;
			}
		}

		if (!trovato) {
			System.out.println("Nessun punto sella trovato nella mappa.");
		}
	}
}