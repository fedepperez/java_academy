package day_17AziendaSanitaria;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		AziendaSanitaria azienda = new AziendaSanitaria();

		// Aggiungo pazienti con i loro medici
		azienda.aggPaziente(12345, "Dr. Rossi");
		azienda.aggPaziente(67890, "Dr. Bianchi");
		azienda.aggPaziente(11111, "Dr. Rossi");
		azienda.aggPaziente(22222, "Dr. Verdi");
		azienda.aggPaziente(33333, "Dr. Rossi");

		// Provo a inserire un paziente duplicato (non dovrebbe aggiungerlo)
		azienda.aggPaziente(12345, "Dr. Rossi");

		// Stampo la lista dei pazienti per il Dr. Rossi
		ArrayList<Paziente> pazientiRossi = azienda.listaMedico("Dr. Rossi");
		System.out.println("Pazienti del Dr. Rossi:");
		for (Paziente p : pazientiRossi) {
			System.out.println("Tessera: " + p.getNumeroTessera());
		}

		// Trovo il medico con più pazienti
		Medico topMedico = azienda.statMedico();
		if (topMedico != null) {
			System.out.println("\nMedico con più pazienti: " + topMedico.getNominativo());
		} else {
			System.out.println("Nessun medico trovato.");
		}
	}
}