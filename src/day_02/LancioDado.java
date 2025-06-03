package day_02;

import java.util.Random;

/*
* Esercizio 03
* Lancio del Dado
* Traccia:Scrivi un programma Java che simuli il lancio di un dado a sei facce.
* Il programma dovrà generare casualmente un numero compreso tra 1 e 6 e
* stamparlo a schermo.
*/

public class LancioDado {
	public static void main(String[] args) {
		Random random = new Random();
		
		//  Genera un numero casuale da 1 a 6
		int dado = random.nextInt(6) + 1;
		
		  System.out.println("Il risultato del lancio del dado è: " + dado);
	}

}
