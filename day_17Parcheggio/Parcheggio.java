package day_17Parcheggio;

import java.util.ArrayList;

public class Parcheggio {
	private int numPosti;
	private int oraCorrente;
	private ArrayList<Vettura> vetture;
	private ArrayList<Vettura> zonaRimozione;

	public Parcheggio(int numPosti) {
		this.numPosti = numPosti;
		this.oraCorrente = 0;
		vetture = new ArrayList<>();
		zonaRimozione = new ArrayList<>();
	}

	public boolean entraVettura(Vettura v) {
		if (vetture.size() < numPosti) {
			vetture.add(v);
			return true;
		}
		return false;
	}

	public boolean esceVettura(Vettura v) {
		return vetture.remove(v);
	}

	public void aggiornaOra() {
		oraCorrente = (oraCorrente + 1) % 24;

		// Sposta in zona rimozione tutte le vetture con oraScadenza <= oraCorrente
		ArrayList<Vettura> daRimuovere = new ArrayList<>();
		for (Vettura v : vetture) {
			if (v.getOraScadenza() == oraCorrente) {
				daRimuovere.add(v);
			}
		}
		vetture.removeAll(daRimuovere);
		zonaRimozione.addAll(daRimuovere);
	}

	public void promozione(int oreGratuite, int codice) {
		// codice è un numero di 2 cifre, bisogna controllare ultime 2 cifre della targa
		for (Vettura v : vetture) {
			int ultimeDue = v.getTarga() % 100;
			if (ultimeDue == codice) {
				// aumenta oraScadenza di oreGratuite, gestendo passaggio giorno
				int nuovaScadenza = v.getOraScadenza() + oreGratuite;
				if (nuovaScadenza >= 24) {
					nuovaScadenza -= 24;
				}
				v.setOraScadenza((short) nuovaScadenza);
			}
		}
	}

	public ArrayList<Vettura> statVetture() {
		ArrayList<Vettura> maxOre = new ArrayList<>();
		int max = -1;
		for (Vettura v : vetture) {
			int ore = v.oreParcheggio();
			if (ore > max) {
				max = ore;
				maxOre.clear();
				maxOre.add(v);
			} else if (ore == max) {
				maxOre.add(v);
			}
		}
		return maxOre;
	}

	// Getters per test e info
	public int getOraCorrente() {
		return oraCorrente;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public ArrayList<Vettura> getVetture() {
		return vetture;
	}

	public ArrayList<Vettura> getZonaRimozione() {
		return zonaRimozione;
	}
}
