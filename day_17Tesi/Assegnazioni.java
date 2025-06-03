package day_17Tesi;

import java.util.ArrayList;

public class Assegnazioni {
	private ArrayList<Tesi> tesi;
	private ArrayList<Studente> laureandi;

	public Assegnazioni() {
		tesi = new ArrayList<>();
		laureandi = new ArrayList<>();
	}

	public void aggiungiTesi(String titoloTesi) {
		for (Tesi t : tesi) {
			if (t.getTitolo().equals(titoloTesi)) {
				return; // tesi già presente
			}
		}
		tesi.add(new Tesi(titoloTesi));
	}

	public void aggiungiStudente(String nomeStudente, String titoloTesi) {
		Tesi tesiAssegnata = null;
		for (Tesi t : tesi) {
			if (t.getTitolo().equals(titoloTesi)) {
				tesiAssegnata = t;
				break;
			}
		}
		if (tesiAssegnata == null) {
			tesiAssegnata = new Tesi(titoloTesi);
			tesi.add(tesiAssegnata);
		}

		for (Studente s : laureandi) {
			if (s.getTesi() != null && s.getTesi().equals(tesiAssegnata)) {
				return; // tesi già assegnata
			}
		}

		laureandi.add(new Studente(nomeStudente, tesiAssegnata));
	}

	public void laureato(String nomeStudente) {
		Studente daRimuovere = null;
		for (Studente s : laureandi) {
			if (s.getNome().equals(nomeStudente)) {
				daRimuovere = s;
				break;
			}
		}
		if (daRimuovere != null) {
			laureandi.remove(daRimuovere);

			Tesi tesiDaRimuovere = daRimuovere.getTesi();
			boolean tesiUsata = false;
			for (Studente s : laureandi) {
				if (s.getTesi() != null && s.getTesi().equals(tesiDaRimuovere)) {
					tesiUsata = true;
					break;
				}
			}
			if (!tesiUsata) {
				tesi.remove(tesiDaRimuovere);
			}
		}
	}

	public void liberaTesi(String titoloTesi) {
		for (Studente s : laureandi) {
			if (s.getTesi() != null && s.getTesi().getTitolo().equals(titoloTesi)) {
				s.setTesi(null);
				break;
			}
		}
	}

	public int disponibili() {
		int count = 0;
		for (Tesi t : tesi) {
			boolean assegnata = false;
			for (Studente s : laureandi) {
				if (s.getTesi() != null && s.getTesi().equals(t)) {
					assegnata = true;
					break;
				}
			}
			if (!assegnata) {
				count++;
			}
		}
		return count;
	}

	// Nuovi metodi getter per accedere alle liste

	public ArrayList<Tesi> getTesi() {
		return tesi;
	}

	public ArrayList<Studente> getLaureandi() {
		return laureandi;
	}

	// Metodi per contare facilmente tesi e studenti

	public int numeroTesi() {
		return tesi.size();
	}

	public int numeroLaureandi() {
		return laureandi.size();
	}
}
