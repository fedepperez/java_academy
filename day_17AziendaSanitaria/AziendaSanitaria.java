package day_17AziendaSanitaria;

import java.util.ArrayList;

public class AziendaSanitaria {
	private ArrayList<Medico> medici;
	private ArrayList<Paziente> pazienti;

	public AziendaSanitaria() {
		medici = new ArrayList<>();
		pazienti = new ArrayList<>();
	}

	public void aggPaziente(int numeroTessera, String nomeMedico) {
		// Cerco se il medico esiste già, altrimenti lo aggiungo
		Medico medicoCurante = null;
		for (Medico m : medici) {
			if (m.getNominativo().equals(nomeMedico)) {
				medicoCurante = m;
				break;
			}
		}
		if (medicoCurante == null) {
			medicoCurante = new Medico(nomeMedico);
			medici.add(medicoCurante);
		}

		// Controllo che il paziente non sia duplicato
		Paziente nuovoPaziente = new Paziente(numeroTessera, medicoCurante);
		if (!pazienti.contains(nuovoPaziente)) {
			pazienti.add(nuovoPaziente);
		}
	}

	public ArrayList<Paziente> listaMedico(String nomeMedico) {
		ArrayList<Paziente> lista = new ArrayList<>();
		for (Paziente p : pazienti) {
			if (p.getMedicoCurante().getNominativo().equals(nomeMedico)) {
				lista.add(p);
			}
		}
		return lista;
	}

	public Medico statMedico() {
		Medico topMedico = null;
		int maxPazienti = -1;
		for (Medico m : medici) {
			int count = 0;
			for (Paziente p : pazienti) {
				if (p.getMedicoCurante().equals(m)) {
					count++;
				}
			}
			if (count > maxPazienti) {
				maxPazienti = count;
				topMedico = m;
			}
		}
		return topMedico;
	}
}
