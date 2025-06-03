package day_17Veicolo;

public class Auto extends Veicolo {
    private int numeroPorte;

    public Auto(String targa, String modello, String marca, int numeroPosti, int numeroPorte) {
        super(targa, modello, marca, numeroPosti);
        this.numeroPorte = numeroPorte;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero porte: " + numeroPorte;
    }
}
