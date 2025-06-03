package day_17Proverbio;

import java.util.ArrayList;
import java.util.List;

public class Proverbio {
	public static void main(String[] args) {
		List<String> parole = new ArrayList<>();
		parole.add("chiodo");
		parole.add("ferro di cavallo");
		parole.add("cavallo");
		parole.add("cavaliere");
		parole.add("messaggio");
		parole.add("battaglia");
		parole.add("regno");

		generaProverbio(parole);
	}

	public static void generaProverbio(List<String> parole) {
		if (parole == null || parole.size() < 2) {
			System.out.println("La lista deve contenere almeno due parole.");
			return;
		}

		for (int i = 0; i < parole.size() - 1; i++) {
			System.out.println("Per mancanza di un " + parole.get(i) + ", si perse il " + parole.get(i + 1) + ".");
		}

		System.out.println("E tutto questo per la mancanza di un " + parole.get(0) + ".");
	}
}
