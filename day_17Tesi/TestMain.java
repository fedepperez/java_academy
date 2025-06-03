package day_17Tesi;

public class TestMain {
	public static void main(String[] args) {
		Assegnazioni sistema = new Assegnazioni();

		// Aggiungo alcune tesi (4 tesi)
		sistema.aggiungiTesi("Tesi su IA");
		sistema.aggiungiTesi("Tesi su Robotica");
		sistema.aggiungiTesi("Tesi su Blockchain");
		sistema.aggiungiTesi("Tesi su Sicurezza Informatica");

		System.out.println("Tesi totali nel sistema: " + sistema.numeroTesi()); // 4
		System.out.println("Tesi disponibili iniziali: " + sistema.disponibili()); // 4 perché nessuna è assegnata

		// Assegno due tesi a due studenti
		sistema.aggiungiStudente("Mario Rossi", "Tesi su IA");
		sistema.aggiungiStudente("Anna Verdi", "Tesi su Robotica");

		System.out.println("\nDopo aver assegnato due tesi:");
		System.out.println("Tesi disponibili: " + sistema.disponibili()); // 2 tesi libere (Blockchain, Sicurezza
																			// Informatica)
		System.out.println("Studenti con tesi assegnata: " + sistema.numeroLaureandi()); // 2

		// Assegno una tesi nuova a un altro studente (crea tesi nuova)
		sistema.aggiungiStudente("Luca Bianchi", "Tesi su Cloud Computing");

		System.out.println("\nDopo aver aggiunto Luca con una nuova tesi:");
		System.out.println("Tesi totali nel sistema: " + sistema.numeroTesi()); // 5
		System.out.println("Tesi disponibili: " + sistema.disponibili()); // 2 (Blockchain, Sicurezza Informatica)
		System.out.println("Studenti con tesi assegnata: " + sistema.numeroLaureandi()); // 3

		// Anna si laurea (la sua tesi "Tesi su Robotica" viene rimossa se nessuno la
		// usa)
		sistema.laureato("Anna Verdi");

		System.out.println("\nDopo la laurea di Anna Verdi:");
		System.out.println("Tesi totali nel sistema: " + sistema.numeroTesi()); // 4 o 5 dipende se tesi Robotica
																				// rimossa
		System.out.println("Tesi disponibili: " + sistema.disponibili()); // dipende se Robotica rimossa o libera
		System.out.println("Studenti con tesi assegnata: " + sistema.numeroLaureandi()); // 2

		// Luca libera la sua tesi senza laurearsi
		sistema.liberaTesi("Tesi su Cloud Computing");

		System.out.println("\nDopo che Luca ha liberato la sua tesi:");
		System.out.println("Tesi totali nel sistema: " + sistema.numeroTesi()); // 4 o 5 (tesi ancora presente)
		System.out.println("Tesi disponibili: " + sistema.disponibili()); // una in più libera
		System.out.println("Studenti con tesi assegnata: " + sistema.numeroLaureandi()); // 2 (Luca c'è ancora ma senza
																							// tesi)

		// Stampa finale dei dettagli studenti e tesi
		System.out.println("\n-- Stato finale --");
		System.out.println("Tesi totali: " + sistema.numeroTesi());
		System.out.println("Studenti totali: " + sistema.numeroLaureandi());
	}
}