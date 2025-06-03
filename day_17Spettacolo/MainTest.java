package day_17Spettacolo;

public class MainTest {

	public static void main(String[] args) {
		Spettacolo concerto = new Spettacolo(2);

		concerto.prenota("Anna", "123");
		concerto.prenota("Luca", "456");
		concerto.prenota("Marta", "789");

		stampaStatoPrenotazione(concerto, "Anna", "123");
		stampaStatoPrenotazione(concerto, "Marta", "789");
		stampaStatoPrenotazione(concerto, "Paolo", "000"); // cliente non prenotato

		concerto.disdici("Anna", "123");

		stampaStatoPrenotazione(concerto, "Marta", "789");
		System.out.println("Ci sono posti liberi? " + (concerto.libero() ? "Sì" : "No"));
	}

	private static void stampaStatoPrenotazione(Spettacolo spettacolo, String nome, String tel) {
		int stato = spettacolo.trova(nome, tel);
		if (stato == 0) {
			System.out.println(nome + " ha un posto prenotato. (0)");
		} else if (stato == 1) {
			System.out.println(nome + " è in lista d'attesa. (1)");
		} else if (stato == -1) {
			System.out.println(nome + " non è prenotato né in lista d'attesa. (-1)");
		}
	}
}
