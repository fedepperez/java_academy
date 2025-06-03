package day_17SocietàCommerciale;

import java.util.ArrayList;

public class Magazzino {
	private String citta;
	private ArrayList<Articolo> articoli;

	public Magazzino(String citta) {
		this.citta = citta;
		this.articoli = new ArrayList<>();
	}

	public String getCitta() {
		return citta;
	}

	public void aggiungiArticolo(String unCodice, int quant) {
		for (Articolo a : articoli) {
			if (a.getCodice().equals(unCodice)) {
				a.setQuantitativo(a.getQuantitativo() + quant);
				return;
			}
		}
		// Non trovato, aggiungo nuovo articolo
		articoli.add(new Articolo(unCodice, quant));
	}

	public boolean rimuoviArticolo(String unCodice, int quant) {
		for (Articolo a : articoli) {
			if (a.getCodice().equals(unCodice)) {
				int q = a.getQuantitativo();
				if (q >= quant) {
					a.setQuantitativo(q - quant);
					return true;
				} else {
					return false; // quantità insufficiente
				}
			}
		}
		return false; // articolo non trovato
	}

	public ArrayList<Articolo> getArticoli() {
		return articoli;
	}
}
