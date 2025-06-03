package day_12;

import java.util.Random;

public class Car {
	private double fuelEfficiency; // km per litro
	private double fuelLevel; // litri nel serbatoio
	private static Random rand = new Random();

	// Costruttore: imposta la resa in km/litro, serbatoio vuoto
	public Car(double fuelEfficiency) {
		/*this.fuelEfficiency = fuelEfficiency;*/
		this.fuelLevel = 0;
	}

	// Metodo per aggiungere carburante
	public void addGas(double amount) {
		if (amount > 0) {
			fuelLevel += amount;
		}
	}
	
	// Metodo per ottenere il livello di carburante
	public double getGas() {
		return fuelLevel;
	}
	
	// Metodo per guidare una certa distanza, consumando carburante
	public void drive(double distance) {
		double fuelNeeded = distance / fuelEfficiency; // litri necessari
		
		if (fuelNeeded <= fuelLevel) {
			fuelLevel -= fuelNeeded;
			System.out.println("Hai percorso " + distance + " km.");
		} else {
			System.out.println("Carburante insufficiente per percorrere " + distance + " km.");
		}
	}
	
	// Metodo per generare un numero casuale double tra min e max
	public static double randomDouble(double min, double max) {
		return min + (max - min) * rand.nextDouble();
	}
	
	// Metodo main per eseguire e testare la classe
	public static void main(String[] args) {
		Car myCar = new Car(15); // 15 km per litro
		
		// Genera un rifornimento casuale tra 5 e 20 litri
		double gasToAdd = randomDouble(5, 20);
		myCar.addGas(gasToAdd);
		System.out.println("Rifornimento: " + String.format("%.2f", gasToAdd) + " litri");
		System.out.println("Carburante nel serbatoio: " + String.format("%.2f", myCar.getGas()) + " litri");
		
		// Genera una distanza casuale tra 10 e 300 km
		double distanceToDrive = randomDouble(10, 300);
		System.out.println("Provo a guidare per " + String.format("%.2f", distanceToDrive) + " km");
		myCar.drive(distanceToDrive);
		
		System.out.println("Carburante residuo: " + String.format("%.2f", myCar.getGas()) + " litri");
	}
}
