package day_12ArchivioAutomobile;

// Classe principale con metodo main per testare le altre classi
public class ArchivioMain {
	public static void main(String[] args) {
		// Creo un cliente
		Cliente cliente1 = new Cliente("Laura Polizzi");

		// Creo un'automobile associata a quel cliente
		Automobile auto1 = new Automobile("12ABC34", cliente1);

		// Stampo informazioni
		System.out.println("Dati Automobile:");
		System.out.println("Targa: " + auto1.getTarga());
		System.out.println("Proprietario: " + auto1.getProprietario().getNome());
	}
}