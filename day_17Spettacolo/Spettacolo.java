package day_17Spettacolo;

import java.util.ArrayList;

public class Spettacolo {
	private Cliente[] prenotazioni;
	private ArrayList<Cliente> attesa;

	public Spettacolo(int n) {
		prenotazioni = new Cliente[n];
		attesa = new ArrayList<>();
	}

	public boolean libero() {
		for (Cliente c : prenotazioni) {
			if (c == null)
				return true;
		}
		return false;
	}

	public int trova(String nome, String tel) {
		Cliente cercato = new Cliente(nome, tel);

		// Cerca nelle prenotazioni
		for (Cliente c : prenotazioni) {
			if (c != null && c.equals(cercato)) {
				return 0;
			}
		}

		// Cerca nella lista d'attesa
		for (Cliente c : attesa) {
			if (c.equals(cercato)) {
				return 1;
			}
		}

		return -1;
	}

	public void prenota(String nome, String tel) {
		Cliente nuovo = new Cliente(nome, tel);

		// Evita doppioni
		if (trova(nome, tel) != -1)
			return;

		// Aggiunge a prenotazioni se c'è posto
		for (int i = 0; i < prenotazioni.length; i++) {
			if (prenotazioni[i] == null) {
				prenotazioni[i] = nuovo;
				return;
			}
		}

		attesa.add(nuovo);
	}

	public void disdici(String nome, String tel) {
		Cliente cliente = new Cliente(nome, tel);

		for (int i = 0; i < prenotazioni.length; i++) {
			if (prenotazioni[i] != null && prenotazioni[i].equals(cliente)) {
				prenotazioni[i] = null;

				if (!attesa.isEmpty()) {
					prenotazioni[i] = attesa.remove(0);
				}

				return;
			}
		}

		attesa.remove(cliente);
	}

	public boolean incompleto() {
		for (Cliente p : prenotazioni) {
			if (p == null)
				continue;
			for (Cliente a : attesa) {
				if (a.equals(p)) {
					return true;
				}
			}
		}
		return false;
	}
}