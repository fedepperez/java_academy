package day_17Veicolo;

public class TestVeicoli {
    public static void main(String[] args) {
        Veicolo[] veicoli = new Veicolo[6];

        veicoli[0] = new Veicolo("AB123CD", "Panda", "Fiat", 4);
        veicoli[1] = new Auto("EF456GH", "Ka", "Ford", 5, 4);
        veicoli[2] = new Camion("IJ789KL", "Actros", "Mercedes", 2, 10000);
        veicoli[3] = new Auto("MN012OP", "Golf", "Volkswagen", 5, 5);
        veicoli[4] = new Camion("QR345ST", "Fuso", "Mitsubishi", 3, 8000);
        veicoli[5] = new Veicolo("UV678WX", "Yaris", "Toyota", 5);

        for (Veicolo v : veicoli) {
            System.out.println(v.toString());
        }
    }
}