package day_17PrenotazioniVoli;

public class TestVolo {
    public static void main(String[] args) {
        Volo volo = new Volo(3);  // volo con 3 posti

        Cliente c1 = new Cliente("Alice");
        Cliente c2 = new Cliente("Bob");
        Cliente c3 = new Cliente("Carla");
        Cliente c4 = new Cliente("Davide");

        volo.prenota(c1);
        volo.prenota(c2);
        volo.prenota(c3);
        volo.prenota(c4);  // dovrebbe andare in attesa

        System.out.println(volo);

        volo.disdici(c2);  // Bob disdice, Davide si sposta in posti

        System.out.println(volo);
    }
}
