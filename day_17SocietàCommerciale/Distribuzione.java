package day_17SocietàCommerciale;

import java.util.ArrayList;
import java.util.HashMap;

public class Distribuzione {
	private Magazzino[] magazzini;
	private int numeroMagazzini;

	public Distribuzione(int maxNumeroMagazzini) {
		magazzini = new Magazzino[maxNumeroMagazzini];
		numeroMagazzini = 0;
	}

	public boolean aggiungiMagazzino(String unaCitta) {
		if (numeroMagazzini >= magazzini.length) {
			return false; // spazio finito
		}
		// controllo duplicati
		for (int i = 0; i < numeroMagazzini; i++) {
			if (magazzini[i].getCitta().equals(unaCitta)) {
				return false; // già presente
			}
		}
		magazzini[numeroMagazzini++] = new Magazzino(unaCitta);
		return true;
	}

	public boolean eliminaMagazzino(String unaCitta) {
		for (int i = 0; i < numeroMagazzini; i++) {
			if (magazzini[i].getCitta().equals(unaCitta)) {
				// shift a sinistra
				for (int j = i; j < numeroMagazzini - 1; j++) {
					magazzini[j] = magazzini[j + 1];
				}
				magazzini[--numeroMagazzini] = null;
				return true;
			}
		}
		return false; // non trovato
	}

	public int totaleArticolo(String unCodice) {
		int totale = 0;
		for (int i = 0; i < numeroMagazzini; i++) {
			for (Articolo a : magazzini[i].getArticoli()) {
				if (a.getCodice().equals(unCodice)) {
					totale += a.getQuantitativo();
				}
			}
		}
		return totale;
	}

	public ArrayList<Magazzino> daRifornire() {
		ArrayList<Magazzino> lista = new ArrayList<>();
		for (int i = 0; i < numeroMagazzini; i++) {
			for (Articolo a : magazzini[i].getArticoli()) {
				if (a.getQuantitativo() == 0) {
					lista.add(magazzini[i]);
					break; // basta uno zero per aggiungere il magazzino
				}
			}
		}
		return lista;
	}

	public void rifornisciMagazzino(String unaCitta, String unCodice, int quant) {
		Magazzino daRifornire = null;
		for (int i = 0; i < numeroMagazzini; i++) {
			if (magazzini[i].getCitta().equals(unaCitta)) {
				daRifornire = magazzini[i];
				break;
			}
		}
		if (daRifornire == null) {
			return; // magazzino non trovato
		}

		int quantDaPrelevare = quant;
		for (int i = 0; i < numeroMagazzini; i++) {
			if (magazzini[i] != daRifornire) {
				int disponibili = 0;
				for (Articolo a : magazzini[i].getArticoli()) {
					if (a.getCodice().equals(unCodice)) {
						disponibili = a.getQuantitativo();
						break;
					}
				}
				int preleva = Math.min(disponibili, quantDaPrelevare);
				if (preleva > 0) {
					magazzini[i].rimuoviArticolo(unCodice, preleva);
					daRifornire.aggiungiArticolo(unCodice, preleva);
					quantDaPrelevare -= preleva;
					if (quantDaPrelevare <= 0) {
						break;
					}
				}
			}
		}
	}

	public Articolo stat() {
		HashMap<String, Integer> quantitaTotali = new HashMap<>();
		for (int i = 0; i < numeroMagazzini; i++) {
			for (Articolo a : magazzini[i].getArticoli()) {
				quantitaTotali.put(a.getCodice(), quantitaTotali.getOrDefault(a.getCodice(), 0) + a.getQuantitativo());
			}
		}

		String codiceMax = null;
		int maxQuant = -1;
		for (var entry : quantitaTotali.entrySet()) {
			if (entry.getValue() > maxQuant) {
				maxQuant = entry.getValue();
				codiceMax = entry.getKey();
			}
		}
		if (codiceMax == null) {
			return null;
		}

		return new Articolo(codiceMax, maxQuant);
	}

	public Magazzino getMagazzino(String citta) {
		for (int i = 0; i < numeroMagazzini; i++) {
			if (magazzini[i].getCitta().equals(citta)) {
				return magazzini[i];
			}
		}
		return null;
	}

	public void stampaStatoDistribuzione() {
		for (int i = 0; i < numeroMagazzini; i++) {
			Magazzino m = magazzini[i];
			System.out.println("Magazzino: " + m.getCitta());
			for (Articolo a : m.getArticoli()) {
				System.out.println("  Articolo: " + a.getCodice() + " Quantità: " + a.getQuantitativo());
			}
		}
	}

}