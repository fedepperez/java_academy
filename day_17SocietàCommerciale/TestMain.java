package day_17SocietàCommerciale;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		Distribuzione d = new Distribuzione(3);

		// Aggiungi i magazzini (città)
		d.aggiungiMagazzino("Roma");
		d.aggiungiMagazzino("Milano");
		d.aggiungiMagazzino("Palermo");

		// Recupera i magazzini con getMagazzino e aggiungi articoli
		Magazzino magRoma = d.getMagazzino("Roma");
		Magazzino magMilano = d.getMagazzino("Milano");
		Magazzino magPalermo = d.getMagazzino("Palermo");

		magRoma.aggiungiArticolo("A001", 100);
		magRoma.aggiungiArticolo("A002", 50);
		magRoma.aggiungiArticolo("A003", 0);

		magMilano.aggiungiArticolo("A001", 70);
		magMilano.aggiungiArticolo("A004", 30);

		magPalermo.aggiungiArticolo("A002", 80);
		magPalermo.aggiungiArticolo("A001", 20);

		// Stampa stato iniziale
		System.out.println("=== STATO INIZIALE ===");
		d.stampaStatoDistribuzione();

		// Test totale articolo
		System.out.println("\nTotale A001: " + d.totaleArticolo("A001")); // 190
		System.out.println("Totale A002: " + d.totaleArticolo("A002")); // 130
		System.out.println("Totale A003: " + d.totaleArticolo("A003")); // 0

		// Magazzini da rifornire (articoli con quantità 0)
		System.out.println("\n=== MAGAZZINI DA RIFORNIRE ===");
		ArrayList<Magazzino> daRifornire = d.daRifornire();
		if (daRifornire.isEmpty()) {
			System.out.println("Nessun magazzino da rifornire.");
		} else {
			for (Magazzino m : daRifornire) {
				System.out.println(m.getCitta());
			}
		}

		// Articolo più presente
		System.out.println("\n=== ARTICOLO PIÙ PRESENTE ===");
		Articolo artMax = d.stat();
		if (artMax != null) {
			System.out.println("Codice: " + artMax.getCodice() + " | Quantità: " + artMax.getQuantitativo());
		}

		// Prova a rifornire A003 a Roma (ma nessun magazzino ha A003 con quantità > 0)
		System.out.println("\nRifornimento A003 a Roma (10 unità)...");
		d.rifornisciMagazzino("Roma", "A003", 10);
		d.stampaStatoDistribuzione();

		// Aggiungo A003 a Milano per permettere il rifornimento
		magMilano.aggiungiArticolo("A003", 25);
		System.out.println("\nAggiunto A003 (25 unità) a Milano");
		d.stampaStatoDistribuzione();

		// Ora rifornisco A003 a Roma (10 unità)
		System.out.println("\nRifornimento A003 a Roma (10 unità)...");
		d.rifornisciMagazzino("Roma", "A003", 10);
		d.stampaStatoDistribuzione();

		// Rifornimento A001 a Palermo (50 unità)
		System.out.println("\nRifornimento A001 a Palermo (50 unità)...");
		d.rifornisciMagazzino("Palermo", "A001", 50);
		d.stampaStatoDistribuzione();

		// Elimina magazzino Milano
		System.out.println("\nEliminazione magazzino Milano: " + d.eliminaMagazzino("Milano"));
		d.stampaStatoDistribuzione();

		// Stat dopo eliminazione
		System.out.println("\n=== ARTICOLO PIÙ PRESENTE (dopo eliminazione) ===");
		artMax = d.stat();
		if (artMax != null) {
			System.out.println("Codice: " + artMax.getCodice() + " | Quantità: " + artMax.getQuantitativo());
		}
	}
}