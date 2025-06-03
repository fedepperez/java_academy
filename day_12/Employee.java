package day_12;

public class Employee {
	private String name;
	private double salary;

	// Costruttore senza parametri
	public Employee() {
		this.name = "Dipendente Sconosciuto";
		this.salary = 0.0;
		// Niente stampa qui, lo facciamo nel main
	}

	// Costruttore con nome e stipendio
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		System.out.println("Benvenuta, " + name + "!\n");
	}

	// Getter nome
	public String getName() {
		return name;
	}

	// Getter stipendio
	public double getSalary() {
		return salary;
	}

	// Metodo per aumentare lo stipendio
	public void raiseSalary(double byPercent) {
		if (byPercent > 0) {
			salary += salary * byPercent / 100;
		}
	}

	// Metodo per stampare nome e stipendio
	public void printInfo() {
		System.out.println(name + " | Stipendio: " + String.format("%.2f", salary) + "€");
	}

	public static void main(String[] args) {
		// Primo dipendente (sconosciuto)
		Employee emp1 = new Employee();
		System.out.print("Dipendente 1: ");
		emp1.printInfo();
		System.out.println("\nDipendente sconosciuto...\nCreato con successo!");

		System.out.println(); // Riga vuota per separazione

		// Secondo dipendente (Chiara)
		Employee emp2 = new Employee("Chiara Bergamini", 2500.0);
		emp2.printInfo();

		// Aumento dello stipendio
		double aumento = 10.0;
		emp2.raiseSalary(aumento);
		System.out.println("\nHai ricevuto una promozione del " + aumento + "%.");

		// Stampa finale del nuovo stipendio
		System.out.println("Il tuo stipendio attuale è di " + String.format("%.2f", emp2.getSalary()) + "€!");
	}
}