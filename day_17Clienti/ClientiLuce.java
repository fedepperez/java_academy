package day_17Clienti;

public class ClientiLuce extends Clienti {
	private double kwh;

	public ClientiLuce(String nome, String cognome, double kwh) {
		super(nome, cognome);
		this.kwh = kwh;
	}

	public double getKwh() {
		return kwh;
	}

	public void setKwh(double kwh) {
		this.kwh = kwh;
	}

	public void calcolaPrezzo() {
		double costoKwh;
		if (kwh < 300) {
			costoKwh = 0.25;
		} else if (kwh < 700) {
			costoKwh = 0.18;
		} else {
			costoKwh = 0.15;
		}
		this.prezzoDaPagare = kwh * costoKwh;
	}

	@Override
	public String toString() {
		return super.toString() + ", Kwh consumati: " + kwh;
	}
}