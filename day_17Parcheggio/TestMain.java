package day_17Parcheggio;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		Parcheggio parcheggio = new Parcheggio(3); // max 3 vetture

		// Creo alcune vetture
		Vettura v1 = new Vettura(12345, (short) 10, (short) 14); // 4 ore
		Vettura v2 = new Vettura(67890, (short) 9, (short) 12); // 3 ore
		Vettura v3 = new Vettura(11223, (short) 11, (short) 16); // 5 ore
		Vettura v4 = new Vettura(44556, (short) 12, (short) 18); // 6 ore

		// Provo ad entrare con 3 vetture (limite raggiunto)
		System.out.println("Entra v1: " + parcheggio.entraVettura(v1)); // true
		System.out.println("Entra v2: " + parcheggio.entraVettura(v2)); // true
		System.out.println("Entra v3: " + parcheggio.entraVettura(v3)); // true
		System.out.println("Entra v4: " + parcheggio.entraVettura(v4)); // false (posto esaurito)

		System.out.println("\nStato parcheggio iniziale:");
		for (Vettura v : parcheggio.getVetture()) {
			System.out.println(v);
		}

		// Aggiorno ora corrente e sposto vetture scadute in zona rimozione
		System.out.println("\nAggiorno ora corrente 5 volte:");
		for (int i = 0; i < 5; i++) {
			parcheggio.aggiornaOra();
			System.out.println("Ora corrente: " + parcheggio.getOraCorrente());
			System.out.println("Vetture parcheggiate: " + parcheggio.getVetture().size());
			System.out.println("Zona rimozione: " + parcheggio.getZonaRimozione().size());
		}

		// Applico promozione: vetture con targa che termina con 90 ricevono 2 ore
		// gratuite
		System.out.println("\nApplico promozione a codice 90 con 2 ore gratuite:");
		parcheggio.promozione(2, 90);

		System.out.println("\nStato parcheggio dopo promozione:");
		for (Vettura v : parcheggio.getVetture()) {
			System.out.println(v + " - Ore parcheggio pagate: " + v.oreParcheggio());
		}

		// Statistiche: vetture con più ore pagate
		ArrayList<Vettura> topVetture = parcheggio.statVetture();
		System.out.println("\nVetture con più ore di parcheggio pagate:");
		for (Vettura v : topVetture) {
			System.out.println(v + " - Ore: " + v.oreParcheggio());
		}
	}
}
