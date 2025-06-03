package day_17Proverbio;

import java.util.List;

public class Filastrocca {
	public static void main(String[] args) {
		List<String> soggetti = List.of("topo", "gatto", "cane", "bastone", "fuoco", "acqua", "toro", "macellaio",
				"Angelo della morte", "Signore");
		List<String> azioni = List.of("comprò", "si mangiò il topo", "morse il gatto", "picchiò il cane",
				"bruciò il bastone", "spense il fuoco", "bevve l'acqua", "uccise il toro", "sul macellaio",
				"sull'Angelo della morte");

		// Strofa iniziale fissa
		System.out.println("Alla fiera dell'est, per due soldi");
		System.out.println("un topolino mio padre comprò.\n");

		// Catena
		for (int i = 1; i < soggetti.size() - 1; i++) {
			System.out.println("E venne il " + soggetti.get(i) + ", che " + azioni.get(i) + ",");
		}

		// Chiusura finale
		StringBuilder chiusura = new StringBuilder();
		chiusura.append("che al mercato mio padre comprò.");

		System.out.println("\n" + chiusura);
	}
}
