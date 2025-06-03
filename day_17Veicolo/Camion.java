package day_17Veicolo;

public class Camion extends Veicolo {
    private int capacitaMassima;

    public Camion(String targa, String modello, String marca, int numeroPosti, int capacitaMassima) {
        super(targa, modello, marca, numeroPosti);
        this.capacitaMassima = capacitaMassima;
    }

    public int getCapacitaMassima() {
        return capacitaMassima;
    }

    public void setCapacitaMassima(int capacitaMassima) {
        this.capacitaMassima = capacitaMassima;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacità massima: " + capacitaMassima;
    }
}
