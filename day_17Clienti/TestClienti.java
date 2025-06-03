package day_17Clienti;

public class TestClienti {

	public static void calcolaBollette(Clienti cliente) {
		if (cliente instanceof ClientiLuce) {
			((ClientiLuce) cliente).calcolaPrezzo();
		} else if (cliente instanceof ClientiGas) {
			((ClientiGas) cliente).calcolaPrezzo();
		} else if (cliente instanceof ClientiFissi) {
			// Per ClientiFissi il prezzo è già settato nel costruttore
		} else if (cliente instanceof ClientiMobile) {
			((ClientiMobile) cliente).calcolaPrezzo();
		}
	}

	public static void main(String[] args) {
		Clienti[] clienti = new Clienti[10];

		clienti[0] = new ClientiLuce("Mario", "Rossi", 250);
		clienti[1] = new ClientiLuce("Anna", "Bianchi", 600);
		clienti[2] = new ClientiLuce("Luca", "Verdi", 750);

		clienti[3] = new ClientiGas("Paolo", "Neri", 40);
		clienti[4] = new ClientiGas("Sara", "Gialli", 65);
		clienti[5] = new ClientiGas("Elena", "Blu", 90);

		clienti[6] = new ClientiFissi("Marco", "Bruno", "STANDARD");
		clienti[7] = new ClientiFissi("Laura", "Viola", "SPECIAL");
		clienti[8] = new ClientiFissi("Giulia", "Rosa", "SUPERSPECIAL");

		clienti[9] = new ClientiMobile("Fabio", "Grigio", 85);

		for (Clienti cliente : clienti) {
			calcolaBollette(cliente);
			System.out.println(cliente);
		}
	}
}
