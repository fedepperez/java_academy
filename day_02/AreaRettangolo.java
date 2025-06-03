package day_02;

import java.util.Scanner;

/*
* Esercizio 02
* Area di un Rettangolo
* Traccia: Scrivi un programma Java che chieda all'utente di inserire la
* lunghezza e la larghezza di un rettangolo e stampi l'area corrispondente.
*/

public class AreaRettangolo {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci la base del rettangolo");
		double base = input.nextDouble ();
		
		System.out.println("Inserisci l'altezza del rettangolo");
		double altezza = input.nextDouble();
		
		double area = base * altezza;
		System.out.println("L'area del rettangolo è: " + area);
		
		input.close();
	}

}
