package day_17PrenotazioniVoli;

import java.util.ArrayList;

public class Volo {
    private Cliente[] posti;
    private ArrayList<Cliente> attesa;
    private int maxPosti;
    private Cliente sentinella;

    public Volo(int maxPosti) {
        this.maxPosti = maxPosti;
        posti = new Cliente[maxPosti];
        attesa = new ArrayList<>();
        sentinella = new Cliente("VUOTO");  // Sentinella per indicare posto libero

        // inizializzo tutti i posti con la sentinella
        for (int i = 0; i < maxPosti; i++) {
            posti[i] = sentinella;
        }
    }

    public boolean prenota(Cliente cliente) {
        for (int i = 0; i < maxPosti; i++) {
            if (posti[i].equals(sentinella)) {
                posti[i] = cliente;
                System.out.println(cliente.getNome() + " ha prenotato il posto " + (i + 1));
                return true;
            }
        }
        // Nessun posto libero, cliente va in attesa
        attesa.add(cliente);
        System.out.println(cliente.getNome() + " messo in lista d'attesa.");
        return false;
    }

    public boolean disdici(Cliente cliente) {
        for (int i = 0; i < maxPosti; i++) {
            if (posti[i].equals(cliente)) {
                posti[i] = sentinella;
                System.out.println(cliente.getNome() + " ha disdetto il posto " + (i + 1));

                // Se c'è qualcuno in attesa, lo sposto in posti
                if (!attesa.isEmpty()) {
                    Cliente primoInAttesa = attesa.remove(0);
                    posti[i] = primoInAttesa;
                    System.out.println(primoInAttesa.getNome() + " è stato spostato dalla lista d'attesa al posto " + (i + 1));
                }
                return true;
            }
        }
        // Cliente non trovato nei posti
        System.out.println(cliente.getNome() + " non aveva un posto prenotato.");
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posti occupati:\n");
        for (int i = 0; i < maxPosti; i++) {
            if (!posti[i].equals(sentinella)) {
                sb.append("Posto ").append(i + 1).append(": ").append(posti[i].getNome()).append("\n");
            } else {
                sb.append("Posto ").append(i + 1).append(": libero\n");
            }
        }
        sb.append("Lista d'attesa:\n");
        if (attesa.isEmpty()) {
            sb.append("Nessuno in attesa.\n");
        } else {
            for (Cliente c : attesa) {
                sb.append(c.getNome()).append("\n");
            }
        }
        return sb.toString();
    }
}